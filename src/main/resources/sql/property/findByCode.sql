SELECT p.code AS property_code,
       p.cadastral_id,
       p.area,
       b.id AS beneficiary_code,
       b.full_name AS beneficiary_fullname,
       b.municipality AS beneficiary_municipality,
       b.address AS beneficiary_address,
       pt.number,
       pt.north_coordinate,
       pt.east_coordinate,
       pt.distance,
       pt.hillside,
       r.num_resolution,
       r.notification,
       r.executory,
       r.fmi,
       r.act,
       r.public_writing,
       r.notary
FROM property p
         JOIN point pt ON pt.property_code = p.code
         LEFT JOIN beneficiary b ON b.property_code = p.code
         LEFT JOIN resolution r ON r.property_code = p.code
WHERE p.cadastral_id = ?
ORDER BY pt.number;