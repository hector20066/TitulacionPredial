SELECT ROUND(
               COUNT(DISTINCT resolution.property_code) * 100.0 / COUNT(DISTINCT property.code), 0) AS percent
FROM property
         LEFT JOIN resolution ON resolution.property_code = property.code;