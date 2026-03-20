SELECT b.code_beneficiaries,
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
       b.expedition_location
FROM beneficiary b
JOIN property p ON b.property_code = p.code
ORDER BY b.code DESC;