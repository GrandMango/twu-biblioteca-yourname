select count(distinct member.name)
from checkout_item, member where member.id=checkout_item.member_id