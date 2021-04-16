insert into Team(`name`) values('team1');
insert into Team(`name`) values('team2');
insert into Team(`name`) values('team3');
insert into Team(`name`) values('team4');
insert into Team(`name`) values('team5');


insert into Book(`name`) values('book1');
insert into Book(`name`) values('book2');
insert into Book(`name`) values('book3');
insert into Book(`name`) values('book4');

insert into Member(`name`, `age`, `team_id`) values('jino', 24,1);
insert into Member(`name`, `age`, `team_id`) values('seoungbum', 24,1);
insert into Member(`name`, `age`, `team_id`) values('wiji', 24,2);
insert into Member(`name`, `age`, `team_id`) values('dosik', 24,2);
insert into Member(`name`, `age`, `team_id`) values('mingi', 24,3);
insert into Member(`name`, `age`, `team_id`) values('youngjin', 24,3);

insert into Like_book(`member_id`, `book_id`) values(1,3);
insert into Like_book(`member_id`, `book_id`) values(1,2);
insert into Like_book(`member_id`, `book_id`) values(2,4);
insert into Like_book(`member_id`, `book_id`) values(3,4);
insert into Like_book(`member_id`, `book_id`) values(5,1);