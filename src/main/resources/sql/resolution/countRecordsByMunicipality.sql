SELECT COUNT(*) AS total_records
FROM resolution r
INNER JOIN property p ON r.property_code = p.code
WHERE p.municipality = ?;
