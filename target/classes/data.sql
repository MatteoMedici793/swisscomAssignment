INSERT INTO Product(
                      id,
                      type,
                      name,
                      description,
                      availability
) VALUES (1, 'MOUSE', 'Logitech wireless', 'Wireless mouse by logitech, 8 programmable keys', 5),
         (2, 'RAM', '16Gb RAM', '16Gb RAM', 10),
         (3, 'MOTHERBOARD', 'Motherboard', 'Incredible Motherboard', 20),
         (4, 'KEYBOARD', 'Razor keyboard', 'A keyboard with a lot of coulours', 23),
         (5, 'CPU', 'Intel i7 10th', 'Super ppowerful', 7);


INSERT INTO Orders(
    order_id,
    state,
    product_id,
    product_type,
    product_name,
    quantity,
    order_creation,
    order_deletion,
    order_delivery
) VALUES (1, 'RUNNING', '1', 'MOUSE', 'Logitech wireless', 2, TO_DATE('16/05/2021', 'dd/MM/yyyy'), null, null)