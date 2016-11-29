insert into USERS (login, surname, password, level, statistics_id) values ("aaa", "aaa", "aaa", 1, 1);
insert into USERS (login, surname, password, level) values ("bbb", "bbb", "aaa", 1, 2);
insert into USERS (login, surname, password, level) values ("ccc", "ccc", "aaa", 2);
insert into USERS (login, surname, password, level) values ("ddd", "ddd", "aaa", 3);
insert into USERS (login, surname, password, level) values ("eee", "eee", "aaa", 4);
insert into USERS (login, surname, password, level) values ("fff", "fff", "aaa", 5);

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

