CREATE TABLE IF NOT EXISTS member
(
    name    VARCHAR(30)     NOT NULL PRIMARY KEY,
    balance DECIMAL(8,2)    NOT NULL
);

CREATE TABLE IF NOT EXISTS chalet
(
    chaletName          VARCHAR(30) NOT NULL PRIMARY KEY,
    ratePerNight        DECIMAL(8,2)
);

CREATE TABLE IF NOT EXISTS chaletbooking
(
    chaletName          VARCHAR(30) NOT NULL,
    bookedBy            VARCHAR(30) NOT NULL PRIMARY KEY,
    startDate           DATE        NOT NULL,
    endDate             DATE        NOT NULL,
    actualCheckInDate   DATE,
    actualCheckOutDate  DATE,
    roomInspected       BIT,
    bill                DECIMAL(8,2),
    billPaid            BIT,
FOREIGN KEY (chaletName) REFERENCES chalet(chaletName)
);

INSERT INTO chalet VALUES ('chaletA', 200);
INSERT INTO chalet VALUES ('chaletB', 200);
INSERT INTO chalet VALUES ('chaletC', 200);
INSERT INTO chalet VALUES ('chaletD', 200);

CREATE TABLE IF NOT EXISTS manager
(
    userid      VARCHAR(30)     NOT NULL PRIMARY KEY,
    password    VARCHAR(8)      NOT NULL
);

INSERT INTO manager VALUES ('resMgr', 'Tina');
INSERT INTO manager VALUES ('logMgr', 'Tracy');