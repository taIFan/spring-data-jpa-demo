CREATE TABLE CLIENT_JDBC
(
    ID          INT         NOT NULL,
    CLIENT_NAME VARCHAR(50) NOT NULL
);

CREATE TABLE CLIENT_PORTFOLIO_JDBC
(
    ID             INT         NOT NULL,
    CLIENT_ID      INT         NOT NULL,
    PORTFOLIO_NAME VARCHAR(50) NOT NULL
);

CREATE TABLE PORTFOLIO_POSITIONS_JDBC
(
    PORTFOLIO_ID INT NOT NULL,
    ASSET_ID     INT NOT NULL,
    QUANTITY     INT NOT NULL
);

CREATE TABLE ASSET_MAPPING_JDBC
(
    ASSET_ID   INT         NOT NULL,
    ASSET_TYPE VARCHAR(50) NOT NULL,
    ASSET_NAME VARCHAR(50) NOT NULL
)