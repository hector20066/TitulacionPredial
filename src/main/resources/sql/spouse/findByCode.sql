SELECT id,
       full_name,
       expedition_location,
       phone,
       beneficiary_code
FROM spouse
WHERE id = ? LIMIT 1;