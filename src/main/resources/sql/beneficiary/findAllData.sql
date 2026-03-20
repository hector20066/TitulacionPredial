SELECT b.code,
       b.id,
       b.full_name,
       p.department,
       p.municipality,
       p.address,
       p.cadastral_reference,
       b.marital_status,
       b.affectation,
       b.phone,
       p.crossing,
       p.publication,
       p.neighborhood,
       b.expedition_location,
       s.id AS spouse_id,
       s.full_name AS spouse_full_name,
       s.expedition_location AS spouse_expedition_location,
       s.phone AS spouse_phone
FROM beneficiary b
JOIN property p ON b.property_code = p.code
JOIN spouse s ON b.code = s.beneficiary_code
WHERE b.code = ?;