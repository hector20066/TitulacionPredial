#!/usr/bin/env python3
"""
Script to automatically add JavaDoc to methods without documentation.
Reads Java files and inserts JavaDoc based on method signatures.
"""

import os
import re
import sys
from pathlib import Path

class JavaDocAdder:
    def __init__(self, src_dir):
        self.src_dir = src_dir
        self.java_files = []
        self.find_java_files()
    
    def find_java_files(self):
        """Find all Java files in src/main/java"""
        for root, dirs, files in os.walk(self.src_dir):
            for file in files:
                if file.endswith('.java'):
                    self.java_files.append(os.path.join(root, file))
        print(f"Found {len(self.java_files)} Java files")
    
    def has_javadoc(self, lines, line_idx):
        """Check if the method at line_idx has JavaDoc"""
        if line_idx == 0:
            return False
        
        # Check previous non-empty line
        prev_idx = line_idx - 1
        while prev_idx >= 0 and lines[prev_idx].strip() == '':
            prev_idx -= 1
        
        if prev_idx < 0:
            return False
        
        # Check if previous line is */ (end of javadoc)
        if '*/' in lines[prev_idx]:
            return True
        
        if '{' in lines[prev_idx]:
            return False
        
        return False
    
    def extract_method_info(self, method_line):
        """Extract method name, return type, and parameters"""
        # Remove comments
        method_line = method_line.split('//')[0]
        
        # Extract return type and method name
        match = re.search(r'(\w+[\[\]]*)\s+(\w+)\s*\((.*?)\)', method_line)
        if not match:
            return None, None, []
        
        return_type = match.group(1)
        method_name = match.group(2)
        params_str = match.group(3)
        
        # Parse parameters
        params = []
        if params_str.strip():
            for param in params_str.split(','):
                param = param.strip()
                if param:
                    parts = param.split()
                    if len(parts) >= 2:
                        param_name = parts[-1]
                        param_type = ' '.join(parts[:-1])
                        params.append((param_type, param_name))
        
        return method_name, return_type, params
    
    def generate_javadoc(self, method_name, return_type, params):
        """Generate JavaDoc for a method"""
        # Convert camelCase to description
        description = self.camel_to_description(method_name)
        
        javadoc = [
            "    /**",
            f"     * {description}.",
        ]
        
        # Add @param tags
        for param_type, param_name in params:
            javadoc.append(f"     * @param {param_name} the {self.camel_to_description(param_name)}")
        
        # Add @return tag if not void
        if return_type.lower() != 'void':
            javadoc.append(f"     * @return the {self.camel_to_description(method_name)}")
        
        javadoc.append("     */")
        return javadoc
    
    def camel_to_description(self, text):
        """Convert camelCase to description"""
        # Insert space before uppercase letters
        s1 = re.sub('(.)([A-Z][a-z]+)', r'\1 \2', text)
        s2 = re.sub('([a-z0-9])([A-Z])', r'\1 \2', s1)
        return s2.lower()
    
    def is_method_line(self, line):
        """Check if line is a method signature"""
        line = line.strip()
        if not line or line.startswith('//') or line.startswith('*'):
            return False
        
        # Must have parentheses and modifiers or return type
        if '(' not in line or ')' not in line:
            return False
        
        # Skip annotations, class declarations, etc
        if line.startswith('@') or 'class ' in line or 'interface ' in line:
            return False
        
        # Must have method signature pattern
        if re.search(r'(public|private|protected|static)\s+', line):
            return True
        
        return False
    
    def process_file(self, filepath):
        """Process a single Java file"""
        try:
            with open(filepath, 'r', encoding='utf-8') as f:
                lines = f.readlines()
            
            modified = False
            output_lines = []
            i = 0
            
            while i < len(lines):
                line = lines[i]
                
                # Check if this is a method line that needs JavaDoc
                if self.is_method_line(line) and not self.has_javadoc(lines, i):
                    method_name, return_type, params = self.extract_method_info(line)
                    
                    if method_name and return_type:
                        javadoc = self.generate_javadoc(method_name, return_type, params)
                        output_lines.extend(javadoc)
                        output_lines.append('\n')
                        modified = True
                
                output_lines.append(line)
                i += 1
            
            if modified:
                with open(filepath, 'w', encoding='utf-8') as f:
                    f.writelines(output_lines)
                return True
            
            return False
        
        except Exception as e:
            print(f"Error processing {filepath}: {e}")
            return False
    
    def run(self):
        """Process all Java files"""
        modified_count = 0
        
        # Sort to prioritize controllers
        self.java_files.sort(key=lambda x: (
            0 if 'controller' in x else 1,
            x
        ))
        
        for filepath in self.java_files:
            if self.process_file(filepath):
                modified_count += 1
                print(f"Modified: {filepath}")
        
        print(f"\nTotal files modified: {modified_count}")

if __name__ == "__main__":
    src_dir = "/home/hlacevedo/NetBeansProjects/TitulacionPredial/src/main/java"
    
    if not os.path.exists(src_dir):
        print(f"Source directory not found: {src_dir}")
        sys.exit(1)
    
    adder = JavaDocAdder(src_dir)
    adder.run()
