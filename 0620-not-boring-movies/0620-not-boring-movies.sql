# Write your MySQL query statement below
select *
from cinema
where id%2 = 1 and cinema.description != 'boring'
order by cinema.rating desc;