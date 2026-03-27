SELECT r.code,
       r.num_resolution,
       r.notification,
       r.executory,
       r.fmi,
       r.act,
       r.public_writing,
       r.notary,
       r.beneficiary_name
FROM resolution r
JOIN property p ON r.property_code = p.code
WHERE p.municipality = ?
ORDER BY r.code DESC LIMIT 1000;
