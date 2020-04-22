select count(member.id) as 'total'
from  member where member.id not in (
select checkout_item.member_id from checkout_item
);