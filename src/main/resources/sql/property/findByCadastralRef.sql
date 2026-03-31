SELECT
    department,
    municipality,
    neighborhood,
    address,
    crossing,
    publication
FROM property
WHERE cadastral_reference = ?;