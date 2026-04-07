SELECT COUNT(DISTINCT p.code) AS total_records
FROM property p
INNER JOIN beneficiary b ON p.code = b.property_code
INNER JOIN resolution r ON p.code = r.property_code
WHERE p.municipality = ? AND b.property_code IS NOT NULL;
