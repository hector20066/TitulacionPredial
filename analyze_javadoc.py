#!/usr/bin/env python3
import os
import re
from pathlib import Path
from typing import List, Tuple

def analyze_java_file(filepath: str) -> List[Tuple[str, int, str, str]]:
    """
    Analyze a Java file to find methods without JavaDoc.
    Returns: [(filename, line_number, method_signature, visibility)]
    """
    results = []
    
    try:
        with open(filepath, 'r', encoding='utf-8', errors='ignore') as f:
            lines = f.readlines()
    except Exception as e:
        print(f"Error reading {filepath}: {e}")
        return results
    
    i = 0
    while i < len(lines):
        line = lines[i]
        
        # Skip if this line is inside a multi-line comment (basic check)
        stripped = line.strip()
        
        # Check if this line contains a method definition
        # Pattern: (public|private|protected) [(static|synchronized)] [returnType] methodName(
        method_pattern = r'^\s*(public|private|protected)\s+(?:static\s+)?(?:synchronized\s+)?' \
                        r'(?:[\w<>\[\],\s.?*&]+)\s+(\w+)\s*\('
        
        match = re.search(method_pattern, line)
        if match:
            visibility = match.group(1)
            method_name = match.group(2)
            line_number = i + 1
            
            # Skip if it's a constructor (method name matches class-like pattern)
            # Constructors are typically PascalCase, but we'll check if they have JavaDoc anyway
            
            # Check if there's JavaDoc immediately before this method
            # Look backwards for /** comment block
            has_javadoc = False
            
            # Check previous lines for JavaDoc
            j = i - 1
            javadoc_start = -1
            
            # Skip any blank lines first
            while j >= 0 and lines[j].strip() == '':
                j -= 1
            
            # Check if there's a */ (end of JavaDoc block)
            if j >= 0 and '*/' in lines[j]:
                # Found end of comment block, check if it's JavaDoc
                javadoc_start = j
                # Look backwards to find the start of the comment block
                while j >= 0:
                    if '/**' in lines[j]:
                        has_javadoc = True
                        break
                    if '/*' in lines[j]:
                        has_javadoc = False
                        break
                    j -= 1
            
            # If no JavaDoc found, add to results
            if not has_javadoc:
                # Get full method signature
                full_sig = line.strip()
                # Continue reading if method signature spans multiple lines
                k = i + 1
                while k < len(lines) and ')' not in full_sig:
                    full_sig += ' ' + lines[k].strip()
                    k += 1
                
                results.append((filepath, line_number, full_sig, visibility))
        
        i += 1
    
    return results

def main():
    java_dir = Path('/home/hlacevedo/NetBeansProjects/TitulacionPredial/src/main/java')
    
    # Find all Java files
    java_files = sorted(java_dir.rglob('*.java'))
    
    all_results = []
    
    for java_file in java_files:
        results = analyze_java_file(str(java_file))
        all_results.extend(results)
    
    # Sort results: controllers first, then by filename
    controller_results = []
    other_results = []
    
    for result in all_results:
        filepath = result[0]
        if 'controller' in filepath.lower() and 'panel' not in filepath.lower():
            controller_results.append(result)
        elif 'controller' in filepath and 'panel' in filepath:
            controller_results.append(result)
        else:
            other_results.append(result)
    
    # Sort each group by filename
    controller_results.sort(key=lambda x: (x[0], x[1]))
    other_results.sort(key=lambda x: (x[0], x[1]))
    
    # Combine results
    sorted_results = controller_results + other_results
    
    # Print results
    print(f"Found {len(sorted_results)} methods without JavaDoc\n")
    print("=" * 120)
    print(f"{'File':<80} {'Line':<6} {'Visibility':<12} {'Method Signature':<40}")
    print("=" * 120)
    
    current_file = None
    for filepath, line_number, method_sig, visibility in sorted_results:
        # Get relative path
        rel_path = filepath.replace('/home/hlacevedo/NetBeansProjects/TitulacionPredial/src/main/java/', '')
        
        if current_file != rel_path:
            print(f"\n{rel_path}")
            current_file = rel_path
        
        # Truncate method signature if too long
        sig_truncated = method_sig[:60] + '...' if len(method_sig) > 60 else method_sig
        print(f"  Line {line_number:<4} | {visibility:<10} | {sig_truncated}")
    
    print("\n" + "=" * 120)
    print(f"\nTotal methods without JavaDoc: {len(sorted_results)}")
    
    # Print summary by file
    file_counts = {}
    for filepath, _, _, _ in sorted_results:
        rel_path = filepath.replace('/home/hlacevedo/NetBeansProjects/TitulacionPredial/src/main/java/', '')
        file_counts[rel_path] = file_counts.get(rel_path, 0) + 1
    
    print("\nSummary by file:")
    for filename in sorted(file_counts, key=lambda x: (-file_counts[x], x)):
        print(f"  {filename}: {file_counts[filename]} methods")

if __name__ == '__main__':
    main()
