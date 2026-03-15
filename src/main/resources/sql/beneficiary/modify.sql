UPDATE beneficiary
SET
    code_beneficiaries = ?,
    id = ?,
    full_name = ?,
    marital_status = ?,
    affectation = ?,
    phone = ?,
    expedition_location = ?
WHERE code = ?;