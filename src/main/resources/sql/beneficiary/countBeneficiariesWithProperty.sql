SELECT COUNT(DISTINCT b.code) AS beneficiaries_with_property
FROM beneficiary b
INNER JOIN property p ON b.property_code = p.code
WHERE b.property_code IS NOT NULL;