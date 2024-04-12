INSERT INTO coupon (coupon_name, applicable_amount, applicable_number_of_items, discount_amount, discount_percent, apply_either, created_date, updated_date)
VALUES
    ('Coupon FIXED10', 50.00, 1, 10.00, 0.0, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Coupon PERCENT10', 100.00, 2, 0.00, 10.0, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Coupon MIXED10', 200.00, 3, 10.0, 10.0, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Coupon REJECTED10', 1000.00, 0, 10.0, 10.0, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);