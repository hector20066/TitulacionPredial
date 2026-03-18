SELECT p.code AS property_code,
       p.cadastral_reference,
       p.area,
       b.id AS beneficiary_code,
       b.full_name AS beneficiary_fullname,
       p.municipality,
       p.address,
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
FROM (SELECT code
      FROM property
      ORDER BY code DESC) last_properties
         JOIN property p ON p.code = last_properties.code
         JOIN point pt ON pt.property_code = p.code
         LEFT JOIN beneficiary b ON b.property_code = p.code
         LEFT JOIN resolution r ON r.property_code = p.code
ORDER BY p.code DESC, pt.number;