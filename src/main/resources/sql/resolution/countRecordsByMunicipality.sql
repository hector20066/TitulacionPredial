SELECT COUNT(DISTINCT r.code) AS total_records
FROM resolution r
INNER JOIN property p ON r.property_code = p.code
INNER JOIN beneficiary b ON p.code = b.property_code
WHERE p.municipality = ? AND b.property_code IS NOT NULL;
