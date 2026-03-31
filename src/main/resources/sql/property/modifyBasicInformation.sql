UPDATE property
SET
    department = ?,
    municipality = ?,
    neighborhood = ?,
    address = ?,
    crossing = ?,
    publication = ?
WHERE cadastral_reference = ?;