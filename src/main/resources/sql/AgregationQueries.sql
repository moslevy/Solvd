-- Find out how much a property owner owes his taxes.

SELECT t.id AS 'Taxes ID', t.description AS 'Taxes Description', t.exp_date AS 'Expiration Date', t.amount AS 'USD', p.owner 'Owner' FROM Taxes as t
JOIN Tax_Bills as tb
    ON t.tax_bills_id = tb.id
JOIN Properties as p
    ON p.id = tb.id
WHERE t.amount > 1000
GROUP BY tb.exp_date

-- Sum total property taxes owned in the state of California.

SELECT SUM as 'Property Taxes owned in California' (amount)
FROM Taxes AS t
WHERE t.id > 100
RIGHT JOIN Tax_Bills as tb
ON tb.id = t.id
RIGHT JOIN Properties as p
ON p.id = tb.id
RIGHT JOIN Cities as c
ON c.id = p.id
RIGHT JOIN State as st
ON st.id = c.id
GROUP BY st.id
WHERE st.name = 'CA'


-- Count the amount of cities found in the state of Florida.
SELECT COUNT as 'Number of cities in the state of Florida' (name) FROM Cities AS c
INNER JOIN States AS st
ON st.id = c.id
WHERE st.name = 'FL'


