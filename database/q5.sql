select member.name from member, 
(
select checkout_item.member_id as 'temp_id', count(checkout_item.member_id) as 'temp_count' from checkout_item
GROUP BY checkout_item.member_id
) 
where temp_count>1 and member.id = temp_id