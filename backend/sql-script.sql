-- Insert Users
INSERT INTO user (username, name)
VALUES ('alice_smith', 'Alice Smith');

INSERT INTO user (username, name)
VALUES ('bob_jones', 'Bob Jones');

INSERT INTO user (username, name)
VALUES ('emily_davis', 'Emily Davis');

INSERT INTO user (username, name)
VALUES ('james_wilson', 'James Wilson');

INSERT INTO user (username, name)
VALUES ('linda_anderson', 'Linda Anderson');

INSERT INTO user (username, name)
VALUES ('michael_clark', 'Michael Clark');

select * from trade;

-- Insert Trades for Users
-- Alice Smith's trades
INSERT INTO trade (user_id, stock_ticker, stock_price, volume, buy_or_sell, status_code)
VALUES (1, 'AAPL', 150.25, 100, 'buy', 1);

INSERT INTO trade (user_id, stock_ticker, stock_price, volume, buy_or_sell, status_code)
VALUES (1, 'GOOG', 2800.50, 50, 'sell', 2);

-- Bob Jones's trades
INSERT INTO trade (user_id, stock_ticker, stock_price, volume, buy_or_sell, status_code)
VALUES (2, 'TSLA', 700.75, 75, 'buy', 1);

INSERT INTO trade (user_id, stock_ticker, stock_price, volume, buy_or_sell, status_code)
VALUES (2, 'AMZN', 3500.00, 25, 'sell', 2);

-- Emily Davis's trades
INSERT INTO trade (user_id, stock_ticker, stock_price, volume, buy_or_sell, status_code)
VALUES (3, 'MSFT', 300.50, 150, 'buy', 1);

INSERT INTO trade (user_id, stock_ticker, stock_price, volume, buy_or_sell, status_code)
VALUES (3, 'AAPL', 160.00, 80, 'buy', 1);

-- James Wilson's trades
INSERT INTO trade (user_id, stock_ticker, stock_price, volume, buy_or_sell, status_code)
VALUES (4, 'GOOG', 2900.75, 60, 'buy', 1);

INSERT INTO trade (user_id, stock_ticker, stock_price, volume, buy_or_sell, status_code)
VALUES (4, 'TSLA', 750.00, 40, 'sell', 2);

-- Linda Anderson's trades
INSERT INTO trade (user_id, stock_ticker, stock_price, volume, buy_or_sell, status_code)
VALUES (5, 'AMZN', 3400.25, 30, 'sell', 2);

INSERT INTO trade (user_id, stock_ticker, stock_price, volume, buy_or_sell, status_code)
VALUES (5, 'MSFT', 305.00, 100, 'buy', 1);

-- Michael Clark's trades
INSERT INTO trade (user_id, stock_ticker, stock_price, volume, buy_or_sell, status_code)
VALUES (6, 'AAPL', 155.50, 120, 'buy', 1);

INSERT INTO trade (user_id, stock_ticker, stock_price, volume, buy_or_sell, status_code)
VALUES (6, 'TSLA', 780.00, 50, 'buy', 1);


SELECT
    u.id AS user_id,
    u.username,
    u.name AS user_name,
    t.id AS trade_id,
    t.stock_ticker,
    t.stock_price,
    t.volume,
    t.buy_or_sell,
    t.status_code
FROM
    user u
JOIN
    trade t ON u.id = t.user_id;