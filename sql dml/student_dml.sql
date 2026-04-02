create table Myself(
    SI_no int unique,
    name varchar(50),
    area varchar(20),
    age int check(age>18)
);

create table match_player(
    RL_no int,
    name varchar(50),
    area varchar(20),
    age int check(age>18), -- [Inga comma (,) kandippa 
    FOREIGN key (RL_no) references Myself(SI_no)
);