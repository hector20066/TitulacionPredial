SELECT
    p.code,
    b.code_beneficiaries,
    p.cadastral_reference,
    p.area,
    GROUP_CONCAT(DISTINCT b.id ORDER BY b.full_name SEPARATOR ', ') AS beneficiary_code,
    GROUP_CONCAT(DISTINCT b.full_name ORDER BY b.full_name SEPARATOR ', ') AS beneficiary_fullname,
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
      WHERE municipality = ?
      ORDER BY code DESC LIMIT 1000) last_properties
         JOIN property p ON p.code = last_properties.code
         JOIN point pt ON pt.property_code = p.code
         LEFT JOIN beneficiary b ON b.property_code = p.code
         LEFT JOIN resolution r ON r.property_code = p.code
WHERE p.municipality = ?
GROUP BY p.code,
         b.code_beneficiaries,
         p.cadastral_reference,
         p.area,
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
ORDER BY p.code DESC, pt.number;