-- =========================
-- Initial Telecom Data Seed
-- =========================

-- =========================
-- USERS / CUSTOMERS
-- =========================
INSERT INTO users (id, username, email, full_name, created_at)
VALUES
(1, 'ivan.petrov', 'ivan.petrov@example.com', 'Ivan Petrov', NOW()),
(2, 'maria.georgieva', 'maria.georgieva@example.com', 'Maria Georgieva', NOW()),
(3, 'georgi.georgiev', 'georgi.georgiev@example.com', 'Georgi Georgiev', NOW());

-- =========================
-- PLANS
-- =========================
INSERT INTO plans (id, code, name, monthly_fee, data_limit_mb, voice_minutes, sms_limit, active)
VALUES
(1, 'SMART_S', 'Smart S', 19.99, 5000, 1200, 1000, true),
(2, 'SMART_M', 'Smart M', 29.99, 10000, 3000, 3000, true),
(3, 'UNLIMITED', 'Unlimited Max', 49.99, NULL, NULL, NULL, true);

-- =========================
-- SUBSCRIPTIONS
-- =========================
INSERT INTO subscriptions (id, user_id, plan_id, start_date, status)
VALUES
(1, 1, 2, '2025-01-15', 'ACTIVE'),
(2, 2, 1, '2025-02-10', 'ACTIVE'),
(3, 3, 3, '2025-01-01', 'ACTIVE');

-- =========================
-- USAGE RECORDS (optional)
-- =========================
INSERT INTO usage_records (id, subscription_id, used_data_mb, used_voice_min, used_sms)
VALUES
(1, 1, 8500, 2000, 500),
(2, 2, 4000, 1000, 800),
(3, 3, 12000, 4000, 3000);

-- =========================
-- INVOICES
-- =========================
INSERT INTO invoices (id, subscription_id, invoice_month, total_amount, status, created_at)
VALUES
(1, 1, '2025-03', 29.99, 'ISSUED', NOW()),
(2, 2, '2025-03', 19.99, 'PAID', NOW()),
(3, 3, '2025-03', 49.99, 'PAID', NOW());

-- =========================
-- PAYMENT RECORDS
-- =========================
INSERT INTO payments (id, invoice_id, payment_date, amount, method)
VALUES
(1, 2, '2025-03-08', 19.99, 'CARD'),
(2, 3, '2025-03-05', 49.99, 'BANK_TRANSFER');

