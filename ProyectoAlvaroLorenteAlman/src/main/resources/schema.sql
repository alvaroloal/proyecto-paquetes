CREATE TABLE IF NOT EXISTS ADDRESSES (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    CITY VARCHAR(32),
    COUNTRY VARCHAR(32),
    EMAIL VARCHAR(32),
    FIRST_NAME VARCHAR(32),
    LAST_NAME VARCHAR(32),
    STREET VARCHAR(255),
    ZIP_CODE VARCHAR(32)
);

CREATE TABLE IF NOT EXISTS USERS (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    USERNAME VARCHAR(32) UNIQUE NOT NULL,
    PASSWORD VARCHAR(32) NOT NULL,
    ROLE VARCHAR(16) NOT NULL,
    ADDRESS_ID BIGINT,
    CONSTRAINT FK_ADDRESS FOREIGN KEY (ADDRESS_ID) REFERENCES ADDRESSES(ID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS INVOICES (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    CUSTOMER_INFO_ID BIGINT,
    DATE TIMESTAMP,
    DUE_DATE TIMESTAMP,
    PRICE FLOAT,
    TAX FLOAT,
    TOTAL FLOAT,
    SERVICE_INFO VARCHAR(511),
    CONSTRAINT FK_INVOICE_CUSTOMER_INFO FOREIGN KEY (CUSTOMER_INFO_ID) REFERENCES ADDRESSES(ID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS DELIVERIES (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    SOURCE_ID BIGINT,
    DESTINATION_ID BIGINT,
    PACKET_TYPE VARCHAR(10),
    PACKET_WEIGHT FLOAT,
    PACKET_HEIGHT FLOAT,
    PACKET_LENGTH FLOAT,
    PACKET_WIDTH FLOAT,
    DELIVERY_DATE TIMESTAMP,
    ESTIMATED_ARRIVAL_DATE TIMESTAMP,
    INVOICE_ID BIGINT,
    STATUS VARCHAR(15),
    TRANSPORTATION VARCHAR(15),
    CONSTRAINT FK_DELIVERY_SOURCE FOREIGN KEY (SOURCE_ID) REFERENCES ADDRESSES(ID) ON DELETE CASCADE,
    CONSTRAINT FK_DELIVERY_DESTINATION FOREIGN KEY (DESTINATION_ID) REFERENCES ADDRESSES(ID) ON DELETE CASCADE,
    CONSTRAINT FK_DELIVERY_INVOICE FOREIGN KEY (INVOICE_ID) REFERENCES INVOICES(ID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS COMMENTS (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    USER_ID BIGINT,
    DESCRIPTION VARCHAR(255),
    RATING FLOAT,
    DATE TIMESTAMP,
    CONSTRAINT FK_COMMENT_USER FOREIGN KEY (USER_ID) REFERENCES USERS(ID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS REPORTS (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    DATE TIMESTAMP,
    TOTAL_INCOME FLOAT,
    AVERAGE_RATING FLOAT,
    NUMBER_OF_DELIVERIES BIGINT
);