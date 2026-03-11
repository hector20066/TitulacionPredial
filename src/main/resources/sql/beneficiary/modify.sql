UPDATE beneficiary
SET
    id = ?,
    full_name = ?,
    department = ?,
    municipality = ?,
    address = ?,
    cadastral_references = ?,
    marital_status = ?,
    affectation = ?,
    phone = ?,
    crossing = ?,
    publication = ?,
    neighborhood = ?,
    expedition_location = ?
WHERE code = ?;