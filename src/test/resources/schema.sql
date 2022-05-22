create table if not exists STATION
(
    id   bigint auto_increment not null,
    name varchar(255)          not null unique,
    primary key (id)
    );

create table if not exists LINE
(
    id    bigint auto_increment not null,
    name  varchar(255)          not null unique,
    color varchar(20)           not null,
    extraFare int,
    primary key (id)
    );

create table if not exists SECTION
(
    id              bigint auto_increment not null,
    line_id         bigint                not null,
    up_station_id   bigint                not null,
    down_station_id bigint                not null,
    distance        int,
    primary key (id)
    );

TRUNCATE TABLE station RESTART IDENTITY;
ALTER TABLE station ALTER COLUMN id RESTART WITH 1;

TRUNCATE TABLE line RESTART IDENTITY;
ALTER TABLE line ALTER COLUMN id RESTART WITH 1;

TRUNCATE TABLE section RESTART IDENTITY;
ALTER TABLE section ALTER COLUMN id RESTART WITH 1;

insert into station (name) values ('강남역');
insert into station (name) values ('왕십리역');
insert into line (name, color) values ('신분당선','red');
insert into line (name, color) values ('2호선','green');
insert into section (line_id, up_station_id, down_station_id, distance) values (1, 2, 1, 5);
