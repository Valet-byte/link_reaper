start transaction;

insert into user_authority(id, name) VALUES
    (1, 'USER'),
    (2, 'ADMIN');

insert into users(id, username, password) VALUES
    ('676c3086-a5fb-4d4a-ad18-a8b65f7f1bfe', 'user', '$2a$12$qVmtaaWVunBel1XQgsOSD.al8RKNKfX4wzVVzAKAG./9kyEg8kAq2' /* user */),
    ('bb1305f5-9c67-492d-9b0a-8a7940ad154e', 'admin', '$2a$12$C5DQ0sFkFEngSTNGKkpNduYKvyxvnv1rvMF1i6SFH/FuRf9nwpzf2' /* admin */);

insert into users_authorities (user_id, authorities_id) VALUES
    ('676c3086-a5fb-4d4a-ad18-a8b65f7f1bfe', 1),
    ('bb1305f5-9c67-492d-9b0a-8a7940ad154e', 2);

commit;