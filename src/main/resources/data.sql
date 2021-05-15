/*CREATE TABLE IF NOT EXISTS 'Product' (
    'id' INTEGER PRIMARY KEY AUTO_INCREMENT,
    'type' VARCHAR(20) NOT NULL,
    'name' VARCHAR(50) NOT NULL,
    'description' VARCHAR(100) NOT NULL,
    'availability' INTEGER NOT NULL
    );

CREATE TABLE IF NOT EXISTS 'Order' (
    'id' INTEGER PRIMARY KEY AUTO_INCREMENT,
    'orderState' VARCHAR(20) NOT NULL,
    'productId' INTEGER PRIMARY KEY,
    'quantity' INTEGER NOT NULL,
    'orderCreation' DATE NOT NULL,
    'orderDeletion' DATE,
    'orderDelivery' DATE
    );*/

INSERT INTO Product(
                      id,
                      type,
                      name,
                      description,
                      availability
) VALUES (
    1,
    'MOUSE',
    'Logitech wireless',
    'Wireless mouse by logitech, 8 programmable keys',
    5
    );


INSERT INTO Orders(
    id,
    state,
    product_id,
    quantity,
    order_creation,
    order_deletion,
    order_delivery
) VALUES (
    1,
    'RUNNING',
    '1',
    2,
    TO_DATE('15/05/2021', 'dd/MM/yyyy'),
    null,
    null
    )