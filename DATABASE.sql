-- =========================
-- TABLA: property
-- =========================
CREATE TABLE property (
     code INT AUTO_INCREMENT PRIMARY KEY,
     cadastral_reference VARCHAR(30),
     area DOUBLE,
     department VARCHAR(100),
     municipality VARCHAR(40) NOT NULL,
     address VARCHAR(40) NOT NULL,
     neighborhood VARCHAR(100) NOT NULL,
     crossing VARCHAR(500),
     publication VARCHAR(20),
);

-- =========================
-- TABLA: beneficiary
-- =========================
CREATE TABLE beneficiary (
     code INT AUTO_INCREMENT PRIMARY KEY,
     code_beneficiaries VARCHAR(10) NOT NULL,
     id BIGINT NOT NULL UNIQUE,
     full_name VARCHAR(150) NOT NULL,
     marital_status VARCHAR(15) NOT NULL,
     affectation VARCHAR(500),
     phone BIGINT NOT NULL,
     expedition_location VARCHAR(100) NOT NULL,
     property_code INT,
     entry_date DATE,

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
    full_name VARCHAR(150),
    expedition_location VARCHAR(100),
    address VARCHAR(40),
    phone BIGINT,
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

-- =========================
-- TABLA: resolution
-- =========================
CREATE TABLE users(
    id INT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    user VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(500) NOT NULL,
    role VARCHAR(15) NOT NULL
);

CREATE INDEX idx_beneficiary_full_name ON beneficiary(full_name);
CREATE INDEX idx_beneficiary_municipality ON beneficiary(municipality);
CREATE INDEX idx_property_cadastral_id ON property(cadastral_id);