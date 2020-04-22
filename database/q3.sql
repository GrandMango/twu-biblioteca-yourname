select book.title 
from  book where book.id not in (
select checkout_item.book_id
from checkout_item where checkout_item.book_id is not null
);

select movie.title
from  movie where movie.id not in (
select checkout_item.movie_id
from checkout_item where checkout_item.movie_id is not null
);
