# Write your MySQL query statement below
with cte as (select item_category, ifnull(sum(quantity),0) total , dayname(order_date) weekday
from orders
right join items
on orders.item_id=items.item_id
group by 1,3)

select item_category as Category 
,ifnull(sum(case when weekday='Monday' then total end),0) as Monday  
,ifnull(sum(case when weekday='Tuesday' then total end),0) as Tuesday
,ifnull(sum(case when weekday='Wednesday' then total end),0) as Wednesday
,ifnull(sum(case when weekday='Thursday' then total end),0) as Thursday
,ifnull(sum(case when weekday='Friday' then total end),0) as Friday
,ifnull(sum(case when weekday='Saturday' then total end),0) as Saturday
,ifnull(sum(case when weekday='Sunday' then total end),0) as Sunday

from cte
group by 1
order by category