SELECT COUNT(DISTINCT b.code) AS total_records
FROM beneficiary b
INNER JOIN property p ON b.property_code = p.code
WHERE b.property_code IS NOT NULL;