#!/usr/bin/env python3
"""
Script to fix remaining JavaDoc issues - focuses on the 41 remaining methods.
"""

import os
import re
from pathlib import Path

# List of files with methods that need JavaDoc fix
FILES_TO_FIX = [
    "src/main/java/com/hector/titulacionpredial/facade/impl/BeneficiaryImplFacade.java",
    "src/main/java/com/hector/titulacionpredial/facade/impl/PointImplFacade.java",
    "src/main/java/com/hector/titulacionpredial/facade/impl/PropertyImplFacade.java",
    "src/main/java/com/hector/titulacionpredial/facade/impl/ResolutionImplFacade.java",
    "src/main/java/com/hector/titulacionpredial/facade/impl/UsersImplFacade.java",
    "src/main/java/com/hector/titulacionpredial/model/dao/impl/DAOBeneficiaryImpl.java",
    "src/main/java/com/hector/titulacionpredial/model/dao/impl/DAOPropertyImpl.java",
    "src/main/java/com/hector/titulacionpredial/model/dao/impl/DAOResolutionImpl.java",
    "src/main/java/com/hector/titulacionpredial/model/dao/impl/DAOUserImpl.java",
    "src/main/java/com/hector/titulacionpredial/model/dto/property/DTOPropertyDetails.java",
    "src/main/java/com/hector/titulacionpredial/model/entities/Property.java",
    "src/main/java/com/hector/titulacionpredial/utils/ImportExcel.java",
    "src/main/java/com/hector/titulacionpredial/view/component/AdminMenu.java",
    "src/main/java/com/hector/titulacionpredial/view/component/ReadingMenu.java",
    "src/main/java/com/hector/titulacionpredial/view/component/UserMenu.java",
    "src/main/java/com/hector/titulacionpredial/view/content/ContentLogin.java",
    "src/main/java/com/hector/titulacionpredial/view/content/panels/RegisterUsers.java",
]

def extract_method_params(method_signature):
    """Extract parameters from a multi-line method signature"""
    match = re.search(r'\((.*?)\)\s*(?:throws|{)', method_signature, re.DOTALL)
    if not match:
        return []
    
    params_str = match.group(1)
    params = []
    
    for param in re.split(r',(?![^<>]*>)', params_str):
        param = param.strip()
        if param and not param.startswith('@'):
            parts = param.split()
            if len(parts) >= 2:
                param_name = parts[-1].replace('...', '')
                param_type = ' '.join(parts[:-1])
                params.append((param_type, param_name))
    
    return params

def fix_file(filepath):
    """Fix JavaDoc in a single file"""
    base_dir = "/home/hlacevedo/NetBeansProjects/TitulacionPredial/"
    full_path = os.path.join(base_dir, filepath)
    
    if not os.path.exists(full_path):
        print(f"File not found: {full_path}")
        return False
    
    with open(full_path, 'r', encoding='utf-8') as f:
        content = f.read()
    
    # Fix malformed javadoc patterns like @Override\n/**     * ...
    # Replace /**     * with proper formatting
    modified = False
    
    # Pattern: @Override followed by malformed javadoc
    pattern = r'@Override\s*\n\s*/\*\*\s*\n\s*\*\s*(?:find|set|get|add|modify|delete|remove|update|delete|count|see)\s+([^*]*)\.\s*\n(\s*\*\s*@param[^\n]*\n)*(\s*\*\s*@return[^\n]*\n)?\s*\*/'
    
    # Find all methods without proper javadoc
    lines = content.split('\n')
    output_lines = []
    i = 0
    
    while i < len(lines):
        line = lines[i]
        
        # Check if this line starts a method without javadoc
        if '@Override' in line and i + 1 < len(lines):
            next_line = lines[i + 1].strip()
            
            # Check if next line is a method signature (not javadoc)
            if (next_line and not next_line.startswith('/**') and 
                (next_line.startswith('public ') or next_line.startswith('private ') or 
                 next_line.startswith('protected '))):
                
                # Collect full method signature (might span multiple lines)
                method_sig = next_line
                j = i + 2
                while j < len(lines) and '{' not in lines[j]:
                    method_sig += ' ' + lines[j].strip()
                    j += 1
                
                # Extract method name and params
                m = re.search(r'(\w+)\s*\((.*?)\)', method_sig, re.DOTALL)
                if m:
                    method_name = m.group(1)
                    params_str = m.group(2)
                    
                    # Generate javadoc
                    desc = camel_to_desc(method_name)
                    javadoc = [
                        "    /**",
                        f"     * {desc}.",
                    ]
                    
                    # Add @param for each parameter
                    for param_part in re.split(r',(?![^<>]*>)', params_str):
                        param_part = param_part.strip()
                        if param_part and not param_part.startswith('@'):
                            parts = param_part.split()
                            if len(parts) >= 2:
                                pname = parts[-1].replace('...', '')
                                javadoc.append(f"     * @param {pname} the {camel_to_desc(pname)}")
                    
                    # Add @return if not void
                    if 'void ' not in method_sig:
                        javadoc.append(f"     * @return the {desc}")
                    
                    javadoc.append("     */")
                    
                    # Add javadoc before @Override
                    output_lines.extend([line[:-1] + ' # TEMP_MARKER' if line.rstrip() else line.rstrip() for line in javadoc])
                    modified = True
        
        output_lines.append(line)
        i += 1
    
    if modified:
        with open(full_path, 'w', encoding='utf-8') as f:
            f.write('\n'.join(output_lines))
        return True
    
    return False

def camel_to_desc(text):
    """Convert camelCase to description"""
    s1 = re.sub('(.)([A-Z][a-z]+)', r'\1 \2', text)
    s2 = re.sub('([a-z0-9])([A-Z])', r'\1 \2', s1)
    return s2.lower()

if __name__ == "__main__":
    count = 0
    for filespec in FILES_TO_FIX:
        if fix_file(filespec):
            count += 1
            print(f"Fixed: {filespec}")
    
    print(f"\nTotal files fixed: {count}")
