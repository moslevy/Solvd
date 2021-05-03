# Find out how much a property owner owes his taxes.

SELECT t.id AS 'Taxes ID', t.description AS 'Taxes Description', t.exp_date AS 'Expiration Date', t.amount AS 'USD', p.owner 'Owner' FROM Taxes as t
JOIN Tax_Bills as tb
    ON t.tax_bills_id = tb.id
JOIN Properties as p
    ON p.id = tb.id
WHERE t.amount > 1000
GROUP BY tb.exp_date






