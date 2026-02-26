SELECT code,
       id,
       full_name,
       phone,
       cadastral_reference,
       municipality,
       marital_status,
       address
FROM beneficiary
WHERE full_name = ? LIMIT 1;