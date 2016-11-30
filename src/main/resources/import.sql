insert into USER_STATISTICS (number_of_games_lost,number_of_games_played,number_of_games_won) values (22,22,33);

insert into USERS (login, surname, password, level, statistics_id) values ("login", "Kowalski", "passwd", 1, 1);
insert into USERS (login, surname, password, level, statistics_id) values ("bbb", "Nowak", "aaa", 1, 1);
insert into USERS (login, surname, password, level, statistics_id) values ("ccc", "ccc", "aaa", 2, 1);
insert into USERS (login, surname, password, level, statistics_id) values ("somelogin", "ddd", "aaa", 3, 1);
insert into USERS (login, surname, password, level, statistics_id) values ("eee", "eee", "aaa", 4, 1);
insert into USERS (login, surname, password, level, statistics_id) values ("fff", "fff", "aaa", 5, 1);

insert into TEAMS (team_name) values ("111");
insert into TEAMS (team_name) values ("222");
insert into TEAMS (team_name) values ("333");
insert into TEAMS (team_name) values ("444");
insert into TEAMS (team_name) values ("555");

insert into team_members (user_id, team_id) values (1,1);
insert into team_members (user_id, team_id) values (1,2);
insert into team_members (user_id, team_id) values (1,3);
insert into team_members (user_id, team_id) values (2,1);
insert into team_members (user_id, team_id) values (2,2);
insert into team_members (user_id, team_id) values (2,3);

insert into user_statistics (number_of_games_played, number_of_games_won, number_of_games_lost) values (2,1,1);

