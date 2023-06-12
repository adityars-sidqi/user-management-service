CREATE TABLE MASTER_USER (
    id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nik VARCHAR(16) NOT NULL,
    full_name VARCHAR(50) NOT NULL,
    gender ENUM('M', 'F') NOT NULL,
    birth_date DATE NOT NULL,
    religion ENUM('I', 'K', 'P', 'H', 'B', 'KH') NOT NULL,
    occupation ENUM('PNS', 'WS', 'PS', 'BH', 'TNI', 'POLRI', 'MHS', 'IRT', 'BB') NOT NULL,
    marital_status ENUM('BK', 'K', 'CH', 'CM') NOT NULL,
    address VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    neighbourhood_id INT(11) NOT NULL
)

CREATE TABLE MASTER_USER_AUTHENTICATION (
    id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(60) NOT NULL,
    user_id INT(11) NOT NULL
)