-- insert into book (id, title) values (11, 'The Pragmatic Programmer');
-- 
-- insert into member values (43, 'yuecheng');
-- 
-- insert into  checkout_item values (43, 11,null);

select member.name from book, checkout_item, member where book.title = 'The Pragmatic Programmer' and book.id = checkout_item.book_id and member.id=checkout_item.member_id