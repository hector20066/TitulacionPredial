SELECT
    property.cadastral_reference,
    property.address,
    property.code
FROM property
    JOIN beneficiary
        ON property.code = beneficiary.property_code
WHERE beneficiary.code_beneficiaries = ? LIMIT 1;