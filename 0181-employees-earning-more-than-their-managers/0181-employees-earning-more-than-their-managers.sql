# Write your MySQL query statement below
select E.name as Employee
from Employee E join Employee F
on E.managerId = F.id
where E.salary > F.salary