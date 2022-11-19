INSERT INTO chat.users (login, password)
VALUES
    ('man1', 'NuWFQwtH'),
    ('man2', '8jCFK35A'),
    ('man3', 'GwdkE4qc'),
    ('man4', 'StmxpQ64'),
    ('man5', 'Mwd92P9g');

INSERT INTO chat.chatrooms (name, owner)
VALUES
    ('general', 1),
    ('random', 2),
    ('services', 3),
    ('volunteers', 4),
    ('adm', 5);

INSERT INTO chat.messages (author, chatroom, text, datetime)
VALUES
    (1, 1, 'This is general channel.', (SELECT NOW()::timestamp)),
    (2, 2, 'This is random channel.', (SELECT NOW()::timestamp)),
    (3, 3, 'This is services channel.', (SELECT NOW()::timestamp)),
    (4, 4, 'This is volunteers channel.', (SELECT NOW()::timestamp)),
    (5, 5, 'This is adm channel.', (SELECT NOW()::timestamp));