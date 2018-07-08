-- store
INSERT INTO `store`(`store_name`)
VALUES ('music_store'), ('sports_store');

-- category
INSERT INTO `store_category`(`category_name`, `store_id`)
VALUES ('instruments', 1), ('headphones', 1),
       ('inventory', 2), ('supplies', 2);

-- goods
INSERT INTO `goods`(`title`, `price`, `status`, `category_id`)
VALUES ('guitar', 100, 'AVAILABLE', 1),
       ('drum', 10, 'AVAILABLE', 1),
       ('accordeon', 50, 'AVAILABLE', 1),
       ('bass', 75, 'AVAILABLE', 1),

       ('sony', 100, 'AVAILABLE', 2),
       ('samsung', 10, 'AVAILABLE', 2),
       ('lg', 50, 'AVAILABLE', 2),
       ('sennheiser', 75, 'AVAILABLE', 2),

       ('gloves', 100, 'AVAILABLE', 3),
       ('bicycle', 1000, 'AVAILABLE', 3),
       ('belt', 50, 'AVAILABLE', 3),
       ('glasses', 75, 'AVAILABLE', 3),

       ('socks', 100, 'AVAILABLE', 4),
       ('shorts', 10, 'AVAILABLE', 4),
       ('gear', 50, 'AVAILABLE', 4),
       ('rope', 75, 'AVAILABLE', 4);
