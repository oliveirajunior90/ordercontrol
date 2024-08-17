CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO product (id, name, description, price, ingredient) VALUES
    (gen_random_uuid(), 'Bolo de Chocolate', 'Um delicioso bolo de chocolate', 25.00,
     JSON '[{"id": 1, "name": "Farinha", "quantity_in_stock": 1.5, "unity": "kg"},
       {"id": 2, "name": "Açúcar", "quantity_in_stock": 1.0, "unity": "kg"},
       {"id": 3, "name": "Manteiga", "quantity_in_stock": 0.5, "unity": "kg"},
       {"id": 4, "name": "Ovos", "quantity_in_stock": 4, "unity": "unidades"},
       {"id": 5, "name": "Cacau em Pó", "quantity_in_stock": 0.3, "unity": "kg"}]');

-- Inserção de dados para o produto "Sorvete de Morango"
INSERT INTO product (id, name, description, price, ingredient) VALUES
    (gen_random_uuid(),
     'Sorvete de Morango',
     'Sorvete cremoso com pedaços de morango', 15.00,
     JSON '[{"id": 11, "name": "Creme", "quantity_in_stock": 2.0, "unity": "litros"},
       {"id": 12, "name": "Morangos", "quantity_in_stock": 1.5, "unity": "kg"},
       {"id": 2, "name": "Açúcar", "quantity_in_stock": 0.5, "unity": "kg"}]');
