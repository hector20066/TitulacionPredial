SELECT
    ROUND(
            COUNT(property_code) * 100.0 / COUNT(*), 0
    ) AS percent
FROM beneficiary;