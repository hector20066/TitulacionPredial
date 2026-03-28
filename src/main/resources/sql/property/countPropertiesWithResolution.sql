SELECT COUNT(*) AS properties_with_resolution
FROM property
         INNER JOIN resolution
             ON resolution.property_code = property.code;