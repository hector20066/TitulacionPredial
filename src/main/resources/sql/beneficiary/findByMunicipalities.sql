SELECT
    b.code,
    b.code_beneficiaries,
    b.id,
    b.full_name,
    b.phone,
    p.cadastral_reference,
    p.municipality,
    b.marital_status,
    p.address
FROM beneficiary b
JOIN property p ON b.property_code = p.code
WHERE p.municipality = ?;