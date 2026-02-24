SELECT
    YEAR(entry_date) AS year_value,
    MONTH(entry_date) AS month_value,
    COUNT(*) AS total_count
FROM beneficiary
WHERE entry_date IS NOT NULL
  AND entry_date >= DATE_SUB(CURDATE(), INTERVAL ? MONTH)
GROUP BY YEAR(entry_date), MONTH(entry_date)
ORDER BY year_value, month_value;