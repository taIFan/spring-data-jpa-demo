INSERT INTO CLIENT_JDBC
VALUES (1, 'CLIENT_1');
INSERT INTO CLIENT_JDBC
VALUES (2, 'CLIENT_2');

INSERT INTO CLIENT_PORTFOLIO_JDBC
VALUES (1, 1, 'CLIENT_1 PORTFOLIO');
INSERT INTO CLIENT_PORTFOLIO_JDBC
VALUES (2, 2, 'CLIENT_2 PORTFOLIO');

INSERT INTO PORTFOLIO_POSITIONS_JDBC
VALUES (1, 1, 50);
INSERT INTO PORTFOLIO_POSITIONS_JDBC
VALUES (1, 2, 5);
INSERT INTO PORTFOLIO_POSITIONS_JDBC
VALUES (1, 3, 5);

INSERT INTO PORTFOLIO_POSITIONS_JDBC
VALUES (2, 1, 150);
INSERT INTO PORTFOLIO_POSITIONS_JDBC
VALUES (2, 3, -50);


INSERT INTO ASSET_MAPPING_JDBC
VALUES (1, 'EQUITY', 'APPLE');
INSERT INTO ASSET_MAPPING_JDBC
VALUES (2, 'EQUITY', 'AMAZON');
INSERT INTO ASSET_MAPPING_JDBC
VALUES (3, 'EQUITY', 'META');
