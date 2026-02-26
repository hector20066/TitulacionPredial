SELECT code,
       id,
       full_name,
       phone,
       cadastral_reference,
       municipality,
       marital_status,
       address
FROM beneficiary
ORDER BY code DESC LIMIT 1000;