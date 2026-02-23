SELECT
    YEAR(entry_date) AS anio,
    MONTH(entry_date) AS mes,
    COUNT(*) AS total
FROM beneficiary
WHERE entry_date IS NOT NULL
  AND entry_date >= DATE_SUB(CURDATE(), INTERVAL ? MONTH)
GROUP BY YEAR(entry_date), MONTH(entry_date)
ORDER BY anio, mes;