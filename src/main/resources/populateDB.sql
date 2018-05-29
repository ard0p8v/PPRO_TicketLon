INSERT IGNORE INTO Event_Type VALUES
  (1, 'Fotbalové utkání', 'Utkání ve fotbale v prestižní soutěži'),
  (2, 'Pěvecký koncert', 'Koncert známých zpěvaček a zpěváků'),
  (3, 'Motokrosová exhibice', 'Exhibice v motokrosu s parádními triky'),
  (4, 'Hokejové utkání', 'Utkání v hokeji v prestižní soutěži'),
  (5, 'Ostatní', 'popis');

INSERT IGNORE INTO News VALUES
  (1, 'Do Pelhřimova zavítají Božejáci', '2017-02-02', 'popis'),
  (2, 'Pelhřimov přetlačil Žďár a dále živí naději na play-off', '2017-02-02', 'popis'),
  (3, 'Prohra hokejistů Humpolce ukončila sezonu', '2017-02-02', 'popis'),
  (4, 'Kamenici k obratu v zápase pomohl vlastní gól leštinského Pajera', '2017-02-02', 'popis'),
  (5, 'Hudba i adrenalin, to je majáles v Pelhřimově', '2017-02-02', 'popis');

INSERT IGNORE INTO Place VALUES
  (1, 'Sauna Music Bar', 'U Sauny 1418', N'Pelhřimov', '393 01', 1000),
  (2, 'Hotel Slávie', 'Masarykovo náměstí 29', 'Pelhřimov', '393 01', 400),
  (3, 'Fotbalový stadion Pelhřimov', 'U Nádraží 1411', 'Pelhřimov', '393 01', 500),
  (4, 'Hokejový stadion Pelhřimov', 'U Nádraží 1499', 'Pelhřimov', '393 01', 650),
  (5, 'Městské sady Pelhřimov', 'U Sadů 73', 'Pelhřimov', '393 01', 5000);

INSERT IGNORE INTO Event VALUES
  (1, 'Pelhřimov vs Božejov', '2017-02-02', 50, 'popis', 500, 20, 1, 5),
  (2, 'HC Lední Medvědi Pelhřimov vs HC Tábor', '2017-02-02',50, 'popis', 650, 50, 4, 5),
  (3, 'Základní vzdělání', '2017-02-02',50, 'popis', 1000, 100, 2, 3),
  (4, 'Wajt', '2017-02-02',50, 'popis', 1000, 139, 2, 3),
  (5, 'RedBull Moto', '2017-02-02',50, 'popis', 5000, 300, 3, 7),
  (6, 'HC Lední Medvědi Pelhřimov vs HC Divocí Lvi Sokolov', '2017-02-02',50, 'popis', 650, 50, 4, 5),
  (7, 'FC Pelhřimov vs FC Ústrašín', '2017-02-02',50, 'popis', 500, 20, 1, 5),
  (8, 'Božejáci, dýchánek o páté', '2017-02-02',50, 'popis', 400, 400, 2, 4);

INSERT IGNORE INTO User VALUES
  (1, 'test', 'test', 'Pavel', 'Ardolf'),
  (2, 'testUser', 'test', 'Test', 'User'),
  (3, 'testManager', 'test', 'Test', 'Manager'),
  (4, 'testAdmin', 'test', 'Test', 'Admin');

INSERT IGNORE INTO Role VALUES
  (1, 'ROLE_ADMIN', 'test'),
  (2, 'ROLE_USER', 'test'),
  (3, 'ROLE_MANAGER', 'test');

INSERT IGNORE INTO Role_has_User VALUES
  (2, 1),
  (2, 2),
  (3, 3),
  (1, 3);

INSERT IGNORE INTO User_Events VALUES
  (1, 1, 1, 5),
  (2, 2, 2, 10),
  (3, 3, 3, 2),
  (4, 1, 3, 4);