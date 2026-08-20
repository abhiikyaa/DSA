
SELECT email AS Email
FROM Person
GROUP BY email
Having Count(id) > 1
