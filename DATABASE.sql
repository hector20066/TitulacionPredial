-- =========================
-- TABLA: property
-- =========================
CREATE TABLE property (
     code INT AUTO_INCREMENT PRIMARY KEY,
     cadastral_id VARCHAR(40) NOT NULL,
     area DOUBLE NOT NULL
);

-- =========================
-- TABLA: beneficiary
-- =========================
CREATE TABLE beneficiary (
     code INT AUTO_INCREMENT PRIMARY KEY,
     id BIGINT NOT NULL UNIQUE,
     full_name VARCHAR(150) NOT NULL,
     departament VARCHAR(100),
     municipality VARCHAR(40) NOT NULL,
     address VARCHAR(40) NOT NULL,
     cadastral_reference BIGINT UNIQUE,
     marital_status VARCHAR(15) NOT NULL,
     affectation VARCHAR(500),
     phone BIGINT NOT NULL,
     crossing VARCHAR(500),
     publication VARCHAR(20),
     neighborhood VARCHAR(100) NOT NULL,
     expedition_location VARCHAR(100) NOT NULL,
     property_code INT,

     CONSTRAINT fk_beneficiary_property
         FOREIGN KEY (property_code)
             REFERENCES property(code)
             ON DELETE CASCADE
);

-- =========================
-- TABLA: spouse
-- =========================
CREATE TABLE spouse (
    id BIGINT PRIMARY KEY,
    full_name VARCHAR(150) NOT NULL,
    expedition_location VARCHAR(100) NOT NULL,
    address VARCHAR(40),
    phone BIGINT NOT NULL,
    beneficiary_code INT NOT NULL,

    CONSTRAINT fk_spouse_beneficiary
        FOREIGN KEY (beneficiary_code)
            REFERENCES beneficiary(code)
            ON DELETE CASCADE
);

-- =========================
-- TABLA: point
-- =========================
CREATE TABLE point (
    code INT AUTO_INCREMENT PRIMARY KEY,
    number INT NOT NULL,
    north_coordinate DOUBLE NOT NULL,
    east_coordinate DOUBLE NOT NULL,
    distance DOUBLE NOT NULL,
    hillside VARCHAR(90) NOT NULL,
    property_code INT NOT NULL,

    CONSTRAINT fk_point_property
        FOREIGN KEY (property_code)
            REFERENCES property(code)
            ON DELETE CASCADE
);

-- =========================
-- TABLA: resolution
-- =========================
CREATE TABLE resolution (
    code INT AUTO_INCREMENT PRIMARY KEY,
    num_resolution BIGINT NOT NULL,
    notification DATE,
    executory DATE,
    fmi VARCHAR(20),
    act VARCHAR(600),
    public_writing VARCHAR(800),
    notary VARCHAR(100) NOT NULL,
    beneficiary_name VARCHAR(150) NOT NULL,
    property_code INT NOT NULL,

    CONSTRAINT fk_resolution_property
        FOREIGN KEY (property_code)
            REFERENCES property(code)
            ON DELETE RESTRICT
);