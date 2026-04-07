SELECT COUNT(DISTINCT p.code) AS properties_with_resolution
FROM property p
INNER JOIN beneficiary b ON p.code = b.property_code
INNER JOIN resolution r ON p.code = r.property_code
WHERE b.property_code IS NOT NULL;