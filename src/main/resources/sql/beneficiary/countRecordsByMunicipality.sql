SELECT COUNT(*) AS total_records
FROM beneficiary b
INNER JOIN property p ON b.property_code = p.code
WHERE p.municipality = ?;
