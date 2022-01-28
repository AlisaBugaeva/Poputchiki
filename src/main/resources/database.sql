
create table users
(
    id           serial
        primary key,
    name         varchar(150)                        not null,
    surname      varchar(150)                        not null,
    phone_number varchar(150)                        not null,
    email        varchar(150)                        not null,
    password     varchar(150)                        not null,
    created_at   timestamp default CURRENT_TIMESTAMP not null,
    modified_at  timestamp default CURRENT_TIMESTAMP not null
);

create table travels
(
    id                serial
        primary key,
    user_id           integer                                        not null
        constraint travels_id_user_fkey
            references users
            on delete cascade,
    departure_point   varchar(150)                                   not null,
    destination_point varchar(150)                                   not null,
    departure_date    date                                           not null,
    destination_date  date                                           not null,
    created_at        timestamp    default CURRENT_TIMESTAMP         not null,
    modified_at       timestamp    default CURRENT_TIMESTAMP         not null,
    status            varchar(150) default 'OPEN'::character varying not null
);

create table poputchiki
(
    id           serial
        primary key,
    poputchik_id integer                                       not null
        constraint poputchiki_id_poputchik_fkey
            references users
            on delete cascade,
    travel_id    integer                                       not null
        constraint poputchiki_id_travel_fkey
            references travels
            on delete cascade,
    status       varchar(150) default 'NEW'::character varying not null,
    created_at   timestamp    default CURRENT_TIMESTAMP        not null,
    modified_at  timestamp    default CURRENT_TIMESTAMP        not null
);

create table user_tokens
(
    id            serial
        primary key,
    user_id       integer                             not null,
    access_token  varchar(150)                        not null,
    refresh_token varchar(150)                        not null,
    created_at    timestamp default CURRENT_TIMESTAMP not null,
    expired_at    timestamp default CURRENT_TIMESTAMP not null
);

create table places
(
    id          serial
        primary key,
    city        varchar(150)                        not null,
    description text,
    photo       varchar(150),
    created_at  timestamp default CURRENT_TIMESTAMP not null,
    modified_at timestamp default CURRENT_TIMESTAMP not null
);


