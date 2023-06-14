DROP TABLE IF EXISTS customers;
CREATE TABLE transaction (id int not null auto_increment primary key,
                        type VARCHAR(255),
                        date DATE,
                        account_number INT,
                        currency VARCHAR(255),
                        amount DECIMAL,
                        merchant_name VARCHAR(255),
                        merchant_logo VARCHAR(255));

insert into transaction (type,date,account_number,currency,amount,merchant_name,merchant_logo)
    values ('CASH',CURRENT_DATE,12345,'dollar',25,'1 dollar Shop','Logo')
