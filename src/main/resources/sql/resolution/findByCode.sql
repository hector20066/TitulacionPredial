SELECT code,
       num_resolution,
       notification,
       executory,
       fmi,
       act,
       public_writing,
       notary,
       beneficiary_name
FROM resolution
WHERE num_resolution = ? LIMIT 1;