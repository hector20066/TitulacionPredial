SELECT code,
       id,
       full_name,
       department,
       municipality,
       address,
       cadastral_reference,
       marital_status,
       affectation,
       phone,
       crossing,
       publication,
       neighborhood,
       expedition_location
FROM beneficiary
ORDER BY code DESC;