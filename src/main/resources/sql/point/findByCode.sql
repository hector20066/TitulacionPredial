SELECT number,
       north_coordinate,
       east_coordinate,
       distance,
       hillside
FROM point
WHERE property_code = ? LIMIT 1;