SELECT cadastral_reference, address
FROM property
JOIN beneficiary
ON property.code = beneficiary.property_code
WHERE beneficiary.code_beneficiaries = ?;