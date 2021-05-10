-- Find out how much a property owner owes his taxes.

SELECT t.id AS 'Taxes ID', t.description AS 'Taxes Description', t.exp_date AS 'Expiration Date', t.amount AS 'USD', p.owner 'Owner' FROM Taxes as t
JOIN Tax_Bills as tb
    ON t.tax_bills_id = tb.id
JOIN Properties as p
    ON p.id = tb.id
WHERE t.amount > 1000
GROUP BY tb.exp_date

-- Sum total property taxes owned in the state of California.
SELECT SUM(amount) as 'Total amount of taxes by State'
FROM Taxes AS t
INNER JOIN Tax_Bills as tb
ON t.id = tb.id
INNER JOIN Properties as p
ON p.id = tb.id
INNER JOIN Cities as c
ON c.id = p.id
Right JOIN States as st
ON st.id = c.id
Group By st.stateCode = 'FL'


-- Count the amount of cities per State.
SELECT c.stateCode as 'Number of Cities per State', COUNT(*)
FROM Cities as c
Group by c.stateCode

-- Average of Taxes paid by citizens with id = 3
SELECT Avg(amount) AS 'Average taxes paid by Citizen with id = 3', p.owner as 'Owner'
from Taxes as t
INNER JOIN Tax_Bills as tb
ON t.id = tb.id
Inner Join Properties as p
On tb.id = p.id
Inner Join Citizens as c
On p.id = c.id
Where c.id = 3

-- Max amount of taxes paid by citizens that live in California.
SELECT MAX(amount) AS 'Maximum taxes paid by Floridan citizens'
from Taxes as t
INNER JOIN Tax_Bills as tb
ON t.id = tb.id
Inner Join Properties as p
On tb.id = p.id
Inner Join Cities as c
On p.id = c.id
Inner Join States as st
on c.id = st.id
Where st.stateName = 'FL'