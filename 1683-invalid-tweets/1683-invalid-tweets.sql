-- Write your PostgreSQL query statement below
select tweet_id
from tweets
where Length(content) > 15;