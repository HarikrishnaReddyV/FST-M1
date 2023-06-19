--Activity 7
SELECT SUM(purchase_amount) AS "total_ammount" FROM orders;
SELECT AVG(purchase_amount) AS "average_amount" from orders;
SELECT MAX(purchase_amount) AS "hihest_amount" from orders;
SELECT MIN(purchase_amount) AS "lowest_amount" from orders;
SELECT COUNT(DISTINCT salesman_id ) AS "total_salesmen" from orders;