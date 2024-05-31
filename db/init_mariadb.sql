DROP DATABASE IF EXISTS DaddelDiscussion;
CREATE DATABASE IF NOT EXISTS DaddelDiscussion
DEFAULT CHARACTER SET utf8mb4
COLLATE utf8mb4_general_ci;

USE DaddelDiscussion;

-- Nutzer
DROP TABLE if EXISTS user;
CREATE TABLE if NOT EXISTS user
(
    userID	INT	    			NOT NULL	AUTO_INCREMENT
    ,username   	VARCHAR(20)	NOT NULL
    ,mail         	VARCHAR(30)	NOT NULL
    ,password      	VARCHAR(20)	NOT NULL
    ,registrationDate	DATE	NOT NULL
    ,role ENUM('Admin','Nutzer') NOT NULL
    ,onlineFlag BOOLEAN         NOT NULL    DEFAULT FALSE

    -- Primärschlüssel
    ,CONSTRAINT user_pk		  PRIMARY KEY (userID)
    ,CONSTRAINT username_un   UNIQUE (username)
    ,CONSTRAINT mail_un       UNIQUE(mail)
    );

-- Entwickler
DROP TABLE if EXISTS developer;
CREATE TABLE if NOT EXISTS developer
(
    developerID INT NOT NULL AUTO_INCREMENT
    ,developerName VARCHAR (100) NOT NULL

    -- Primärschlüssel
    ,CONSTRAINT developer_pk PRIMARY KEY (developerID)
    );

-- Spiele
DROP TABLE if EXISTS games;
CREATE TABLE if NOT EXISTS games
(
    gameID INT NOT NULL AUTO_INCREMENT
    ,title VARCHAR(100) NOT NULL
    ,description VARCHAR(1000) NOT NULL
    ,releaseDate DATE NOT NULL
    ,developerID INT NOT NULL
    ,genre VARCHAR(100) NOT NULL
    ,imagePath VARCHAR(100) NOT NULL
    ,upVotes INT NOT NULL
    ,downVotes INT NOT NULL

    -- Primärschlüssel
    ,CONSTRAINT games_pk PRIMARY KEY (gameID)

    -- Fremdschlüssel
    ,CONSTRAINT games_developer_fk FOREIGN KEY (developerID) REFERENCES developer(developerID)
    );

-- Beiträge
DROP TABLE if EXISTS posts;
CREATE TABLE if NOT EXISTS posts
(
    postID INT NOT NULL auto_increment
    ,postReference VARCHAR (100) NOT NULL
    ,postText VARCHAR (500) NOT NULL
    ,datePosted DATE NOT NULL
    ,userID INT NOT NULL
    ,gameID INT NOT NULL

    -- Primärschlüssel
    ,CONSTRAINT posts_pk PRIMARY KEY (postID)

    -- Fremdschlüssel
    ,CONSTRAINT posts_user_fk FOREIGN KEY (userID) REFERENCES user(userID)
    ,CONSTRAINT posts_games_fk FOREIGN KEY (gameID) REFERENCES games(gameID)
    );


-- Kommentare
DROP TABLE if EXISTS comments;
CREATE TABLE if NOT EXISTS comments
(
    commentID INT NOT NULL AUTO_INCREMENT
    ,commentText VARCHAR(500) NOT NULL
    ,datePosted DATE NOT NULL
    ,userID INT NOT NULL
    ,postID INT NOT NULL

    -- Primärschlüssel
    ,CONSTRAINT comments_pk PRIMARY KEY (commentID)

    -- Fremdschlüssel
    ,CONSTRAINT comments_user_fk FOREIGN KEY (userID) REFERENCES user(userID)
    ,CONSTRAINT comments_posts_fk FOREIGN KEY (postID) REFERENCES posts(postID)
    );

-- Fragen
DROP TABLE if EXISTS questions;
CREATE TABLE if NOT EXISTS questions
(
    questionID INT NOT NULL AUTO_INCREMENT
    ,title VARCHAR(200) NOT NULL
    ,text VARCHAR(600) NOT NULL
    ,answer VARCHAR(600) NULL

    -- Primärschlüssel
    ,CONSTRAINT questions_pk PRIMARY KEY (questionID)
    );

-- Feedback
DROP TABLE if EXISTS feedback;
CREATE TABLE if NOT EXISTS feedback
(
    feedbackID INT NOT NULL AUTO_INCREMENT
    ,name VARCHAR(50) NOT NULL
    ,mail VARCHAR(100) NOT NULL
    ,game_suggestion VARCHAR(500) NOT NULL
    ,technicalimprovement VARCHAR(500) NOT NULL
    ,functions VARCHAR(500) NOT NULL

    -- Primärschlüssel
    ,CONSTRAINT feedback_pk PRIMARY KEY (feedbackID)
    );

DROP TABLE if EXISTS permissions;
CREATE TABLE if NOT EXISTS permissions
(
    permissionID INT NOT NULL AUTO_INCREMENT
    , permissionName VARCHAR(50) NOT NULL UNIQUE
    , admin BOOLEAN NOT NULL
    , user BOOLEAN NOT NULL
    , visitor BOOLEAN NOT NULL

    ,CONSTRAINT permission_pk PRIMARY KEY (permissionID)

    ,CONSTRAINT permission_un   UNIQUE (permissionName)
    );

-- Importskript Beispieldatensätze

-- Daten Nutzer
INSERT INTO user(username,mail,password,registrationDate,role)
VALUES
    ('ShadowGamerX', 'ShadowGamerX@gmail.com', 'jfgfgfghgfg', '2023-05-05', 'Admin'),
    ('MysticPhoenix', 'MysticPhoenix@web.de', 'shdhvdhv', '2023-05-05', 'Nutzer'),
    ('PixelProwler', 'PixelProwler@gmail.com', '12345676543', '2023-05-05', 'Nutzer'),
    ('BattleVortex', 'BattleVortex@web.de', 'shinzowosasageyo', '2023-05-05', 'Nutzer'),
    ('ThunderStriker', 'ThunderStriker@web.de', '1234', '2023-05-05', 'Nutzer'),
    ('GameChaosMaster', 'GameChaosMaster@gmail.com', '12345678', '2023-05-05', 'Nutzer'),
    ('StealthWraith', 'StealthWraith@web.de', 'passwort', '2023-05-05', 'Nutzer'),
    ('QuantumSniper', 'QuantumSniper@gmail.com', 'rfghzghlkjnb9876', '2023-05-05', 'Nutzer'),
    ('NexusReaper', 'NexusReaper@gmail.com', 'passw0rt', '2023-05-05', 'Nutzer'),
    ('BlazeRanger', 'BlazeRanger@web.de', 'kiuztgj', '2023-05-05', 'Nutzer'),
    ('ApexPredatorX', 'ApexPredatorX@web.de', 'rtzhbvfrtz', '2023-05-05', 'Nutzer'),
    ('CyberSorcerer', 'CyberSorcerer@gmail.com', 'ihuzhtgd', '2023-05-05', 'Admin'),
    ('ValkyrieVortex', 'ValkyrieVortex@web.de', 'sdfghjk', '2023-05-05', 'Nutzer'),
    ('QuantumFurry', 'QuantumFury@web.de', '0815', '2023-05-05', 'Nutzer'),
    ('NebulaNomad', 'NebulaNomad@gmail.com', 'p4ssw0rd', '2023-05-05', 'Nutzer'),
    ('RaptorRogue', 'RaptorRogue@web.de', '00001234', '2023-05-05', 'Admin'),
    ('GalacticGlitch', 'GalacticGlitch@gmail.com', '7456t72656', '2023-05-05', 'Nutzer'),
    ('TitanThunderbolt', 'TitanThunderbolt@gmail.com', 'srtzftgzhuefjdsg', '2023-05-05', 'Nutzer'),
    ('FrostbitePhantom', 'FrostbitePhantom@web.de', 'edczhnu876', '2023-05-05', 'Nutzer'),
    ('EclipseEnigma', 'EclipseEnigma@web.de', '746358', '2023-05-05', 'Nutzer'),
    ('Nutzer', 'Nutzer@web.de', 'nutzer', '2024-01-28', 'Nutzer'),
    ('Admin', 'Admin@web.de', 'admin', '2024-01-28', 'Admin');

-- Daten Entwickler
INSERT INTO developer(developerName)
VALUES
    ('Epic Games'),
    ('Blizzard Entertainment'),
    ('EA'),
    ('Nintendo'),
    ('Riot Games'),
    ('Steel Wool Games'),
    ('Rockstar Games'),
    ('Mojang'),
    ('Ubisoft'),
    ('Supergiant Games'),
    ('CD Project Red'),
    ('Prof. Dr. Jörg Sahm');

-- Daten Spiele
INSERT INTO games(title,description,releaseDate,developerID,genre,imagePath, upVotes, downVotes)
VALUES
    ('Fortnite','Fortnite, ein bahnbrechendes Battle-Royale-Videospiel von Epic Games, kombiniert Schieß-Action, strategisches Bauen und kreative Elemente. Auf einer schrumpfenden Karte kämpfen 100 Spieler ums Überleben, während sie Strukturen aus Ressourcen errichten. Der bunte Grafikstil und regelmäßige Updates halten das Spiel frisch. Fortnite hat nicht nur eine riesige Spielerbasis, sondern ist auch zu einem kulturellen Phänomen geworden, das die Grenzen zwischen Gaming und Mainstream-Unterhaltung verwischt.','2017-07-21',1,'Battle Royale, Rennspiel, Jump ’n’ Run','../dwp_ws2324_later/static/images/fortniteVorschaubild.png', 1000, 142),
    ('Overwatch','Overwatch, das teambasierte Shooter-Spektakel von Blizzard, vereint diverse Helden in futuristischen Schlachten. Mit einzigartigen Fähigkeiten und atemberaubenden Maps führt das Game Spieler rund um den Globus. Die strategische Teamarbeit zwischen Support, Tank und DPS bringt epische Matches hervor. Visuell beeindruckend, bietet Overwatch nicht nur actiongeladene Gameplay, sondern auch stylishe Skins und Emotes. Die Vielfalt an Helden und die kreative Grafik machen es zu einem Gaming-Lifestyle, der die Community weltweit fesselt. Overwatch ist mehr als nur ein Shooter – es ist ein globales Gaming-Phänomen, das für Spannung und Stil steht.', '2016-05-03',2,'Shooter, Kampfspiel','../dwp_ws2324_later/static/images/overwatchVorschaubild.png', 241, 21),
    ('The Legend Of Zelda','The Legend of Zelda, eine legendäre Videospielreihe von Nintendo, fesselt Spieler mit einer einzigartigen Mischung aus Abenteuer, Rätseln und Fantasy. Der Protagonist, Link, erkundet die faszinierende Welt von Hyrule, kämpft gegen mächtige Bosse und löst herausfordernde Rätsel. Die Spiele zeichnen sich durch einen zeitlosen visuellen Stil aus, insbesondere das charakteristische grüne Outfit von Link. Beyond Gaming ist The Legend of Zelda zu einem kulturellen Symbol geworden und hat eine breite Fangemeinde inspiriert. Die Reihe hebt sich durch epische Fantasie und packende Geschichten hervor und bleibt eine bedeutende künstlerische Reise für Spieler weltweit.','2017-04-03',4,'Actionspiel','../dwp_ws2324_later/static/images/zeldaVorschaubild.png', 14,31),
    ('League Of Legends','League of Legends (LoL) von Riot Games ist ein einflussreiches Multiplayer Online Battle Arena (MOBA)-Spiel. Teams von einzigartigen Champions kämpfen in intensiven Schlachten um den Sieg. Mit ständigen Updates bleibt LoL frisch, während die globale Community wächst. Das strategische Gameplay erfordert Teamarbeit und individuelle Fähigkeiten. LoL ist nicht nur ein führendes E-Sport-Phänomen, sondern beeinflusst auch die Gaming-Kultur weltweit.','2009-10-27',5,' Multiplayer, Rollenspiel','../dwp_ws2324_later/static/images/leagueoflegendsVorschaubild.png', 2000,1500 ),
    ('FnaF Security Breach','Five Nights at Freddys (FNaF) ist eine populäre Horrorspielserie, entwickelt von Scott Cawthon. Der Spieler übernimmt die Rolle eines Nachtwächters, der in einem gruseligen Animatronic-verwalteten Freizeitpark arbeitet. Die Herausforderung besteht darin, in verschiedenen Nächten zu überleben, während man die Bewegungen der animierten Roboter überwacht. Die Atmosphäre ist von Anfang an unheimlich, und das Spiel nutzt geschickt Jump-Scares, um Spieler zu erschrecken. FNaF hat aufgrund seiner einzigartigen Spielmechanik und fesselnden Handlung eine treue Fangemeinde gewonnen und trägt dazu bei, das Horrorgenre im Indie-Gaming zu prägen.','2021-12-16',6,'Survival Horror, Simulation, Rollenspiel','../dwp_ws2324_later/static/images/fnafVorschaubild.png',412,31),
    ('Die Siedler 7','Herr Sahm war dabei und das finden wir super.','2010-03-23',12,' Strategie, Städtebau','../dwp_ws2324_later/static/images/siedlerVorschaubild.png', 1000, 0),
    ('World Of Warcraft','World of Warcraft (WoW), entwickelt von Blizzard Entertainment, ist ein bahnbrechendes Massively Multiplayer Online Role-Playing Game (MMORPG). Seit seiner Veröffentlichung hat WoW Millionen von Spielern in seine epische Fantasywelt Azeroth gezogen. Das Spiel bietet eine faszinierende Handlung und ermöglicht es Spielern, in die Rolle von verschiedenen Rassen und Klassen zu schlüpfen. Die offene Spielwelt von WoW ist riesig und voller Abenteuer, von gefährlichen Dungeons bis zu epischen Schlachten. Soziale Interaktionen spielen eine entscheidende Rolle, sei es beim Gruppenspiel oder in Gilden. Mit ständigen Erweiterungen bleibt WoW frisch und relevant, wobei es als ein Pionier im MMORPG-Genre weiterhin Maßstäbe setzt.','2004-11-23',2,'Rollenspiel, Actionspiel, Unterhaltung','../dwp_ws2324_later/static/images/wowVorschaubild.png', 123, 42),
    ('Minecraft','Minecraft, ein kreatives Sandbox-Spiel, eroberte die Gaming-Welt im Sturm. Entwickelt von Mojang, ermöglicht es Spielern, in einer offenen Welt aus Blöcken zu bauen, zu erkunden und zu überleben. Die pixelige Grafik verleiht dem Spiel einen einzigartigen Charme, während die schier endlosen Möglichkeiten für Kreationen die Fantasie anregen. Vom Bau einfacher Holzhütten bis zu monumentalen Strukturen ist die Gestaltung der Umgebung nahezu grenzenlos. Minecraft fördert kreatives Denken und Zusammenarbeit, sei es im Einzelspieler- oder im Multiplayer-Modus. Durch regelmäßige Updates bleibt das Spiel lebendig und inspiriert eine leidenschaftliche Community weltweit.','2011-11-18',8,'Simulation, Sandbox-Spiel','../dwp_ws2324_later/static/images/minecraftVorschaubild.png', 142, 4),
    ('Grand Theft Auto V','Grand Theft Auto V (GTA V) von Rockstar Games ist ein Meisterwerk der Open-World-Action. Mit drei einzigartigen Protagonisten, nämlich Michael, Trevor und Franklin, bietet es eine fesselnde Handlung voller Verbrechen und Intrigen. Die detaillierte Spielwelt von Los Santos ist atemberaubend und lädt zu zahlreichen Aktivitäten ein, von Missionen bis hin zu Nebenbeschäftigungen wie Rennen und Sport. Die scharfe Satire auf die moderne Gesellschaft verleiht dem Spiel eine einzigartige Note. Dank ständiger Updates bleibt GTA V relevant, während es mit seiner immersiven Erfahrung und seinem dynamischen Gameplay weiterhin die Messlatte für Open-World-Actionspiele setzt.','2013-09-17',7,'Open-World-Spiel, Actionspiel, Shooter','../dwp_ws2324_later/static/images/gta5Vorschaubild.png',756 ,345),
    ('Mario Kart 8','Mario Kart 8, ein Rennspiel, begeistert Spieler weltweit. Das Spiel, bekannt für seine farbenfrohe Grafik und dynamische Strecken, bietet ein einzigartiges Rennerlebnis im beliebten Mario-Universum. Mit einer Auswahl an bekannten Charakteren, jeder mit individuellen Fähigkeiten, liefern die Rennen auf kunstvoll gestalteten Pisten einen Adrenalinkick. Power-Ups und Items wie die ikonischen Bananenschalen und roten Panzer sorgen für Chaos und strategische Manöver. Der Mehrspielermodus ermöglicht Freunden, sich in spannenden Wettkämpfen zu messen. Mario Kart 8 verkörpert die perfekte Mischung aus Geschwindigkeit, Spaß und Wettbewerb, was es zu einem zeitlosen Favoriten in der Gaming-Welt macht.','2014-05-29',4,'Rennspiel, Actionspiel','../dwp_ws2324_later/static/images/mariokartVorschaubild.png', 765,46),
    ('Hades','Hades, ein mitreißendes Action-Roguelike-Spiel, hat sich in der Gaming-Szene einen Namen gemacht. In diesem düsteren Abenteuer, das von den Göttern der griechischen Mythologie inspiriert ist, übernimmt der Spieler die Rolle von Zagreus, dem Sohn des Totengottes Hades. Der Fokus liegt auf intensiven Kämpfen, während sich der Spieler durch die Tiefen der Unterwelt kämpft. Die dynamische Erzählung, gepaart mit charmanten Charakteren und einer beeindruckenden Ästhetik, verleiht Hades eine besondere Anziehungskraft. Durch den innovativen Roguelike-Aspekt mit permanenten Upgrades bleibt das Spiel herausfordernd und motivierend, wodurch es zu einem herausragenden Vertreter seines Genres wird.','2018-12-06',10,'Kampfspiel, Rollenspiel, Shooter','../dwp_ws2324_later/static/images/hadesVorschaubild.png',344,256),
    ('Cyberpunk 2077','Cyberpunk ist ein dystopisches Science-Fiction-Genre, das eine Zukunftswelt präsentiert, in der Technologie und Megakonzerne die Gesellschaft beherrschen. Geprägt von einer düsteren Atmosphäre, Hackern, KI und biomechanischen Implantaten, beleuchtet das Genre soziale Ungleichheit, Korruption und den Einfluss von Technologie auf das Individuum. Charakteristisch sind neonbeleuchtete Metropolen, in denen rebellische Anti-Helden gegen die Obrigkeit kämpfen. Bekannte Werke wie William Gibsons Neuromancer oder das Videospiel Cyberpunk 2077 bieten faszinierende Einblicke in eine futuristische Welt voller Hightech und Schattenseiten der Technologisierung.','2020-12-10',11,'Rollenspiel, Kampfspiel, Shooter, ','../dwp_ws2324_later/static/images/cyberpunkVorschaubild.png',453,677);

-- Daten Beiträge
INSERT INTO posts(postReference,postText,datePosted,userID,gameID)
VALUES
    ('TotK', 'Wie findet ihr das neue Zelda?', '2023-01-10', 1, 3),
    ('Hilfe', 'Hat jemand Lust mal ne Runde zu zocken?', '2023-02-20', 2, 4),
    ('Neue Skins', 'Was ist eure Meinung zu den neuen Fortnite Skins?', '2023-12-15', 3, 1),
    ('Hilfe', 'Komme hier nicht weiter. Hat jemand Tipps?', '2023-04-05', 1, 3),
    ('Blizzard', 'Nieder mit Blizzard.', '2023-04-05', 20, 2),
    ('Trommelgewehr Fortnite','Weiß jemand wann das Trommelgewehr wieder ins Game kommt?','2024-01-19',5,1),
    ('Fortnite Shop','Warum wird der Shop nicht mehr aktualisiert?','2024-01-19',9,1),
    ('Pferd in BotW','Wo kriegt man dieses Riesenpferd her?','2024-01-19',17,3),
    ('Lol Season','Wie findet ihr die neue League Season? Ich finde Kassadin sollte generfed werden..','2024-01-19',12,4),
    ('Für Fortnite','Für Fortnite!','2024-01-19',1,1),
    ('Heartsteel','Habt ihr den schon den Song Paranoia von Heartsteel gehört. Der ist so gut und ich finde das Musikvideo so cool.','2024-01-19',4,4),
    ('FnaF Film','Die Meinungen zu dem FnaF Film sind ziemlich gespalten. Wie fandet ihr den so?','2024-01-19',5,5),
    ('Jörg Sahm','Hatte mal jemanden als Professor der mit daran gearbeitet hat. Cool oder?','2024-01-19',5,6),
    ('Mal spielen?','Hab das noch nie gespielt. Soll ich mal?','2024-01-19',12,7),
    ('Schafe','Finde nie genug Schafe in der ersten Nacht, so nervig schwöre.','2024-01-19',8,8),
    ('GTA 6','Mir reißt bald der Geduldsfaden. Ich kann nicht mehr auf das neue GTA warten..','2024-01-19',17,9),
    ('Regenbogenstrecke','Regenbogenstrecke größter Abfuck, ich bin ehrlich. Was sagt ihr dazu?','2024-01-19',15,10),
    ('Gutes Game?','Lohnt es sich das zu spielen?','2024-01-19',14,11),
    ('Bugs','Finde es gut, dass die immer ihre Bugs zu einem Feature machen. Wenn ich mal in der Position bin mach ich das auch so.','2024-01-19',9,12);

-- Daten Kommentare
INSERT INTO comments(commentText,datePosted,userID,postID)
VALUES
    ('finds mega geil!','2024-01-19',12,1),
    ('ja schon ziemlich fresh','2024-01-19',14,1),
    ('ist ultra heftig','2024-01-19',18,1),
    ('ja, adde mich auf discord: @CyberSorcerer','2024-01-19',12,2),
    ('finde die neuen skins sehr cool, viele verschiedene skins gibts.','2024-01-19',16,3),
    ('nein','2024-01-19',18,4),
    ('facts','2024-01-19',19,5),
    ('nächste season','2024-01-19',5,6),
    ('leider nicht, habe es mich auch schon gefragt','2024-01-19',9,7),
    ('gibts auf dieser großen wiese','2024-01-19',20,9),
    ('finds auch funny','2024-01-19',4,19);

-- Daten Fragen
INSERT INTO questions(title,text,answer)
VALUES
    ('Benutzernamen ändern','Ich würde gern meinen Nutzername ändern. Gibt es dafür eine Möglichkeit?','Der Benutzername ist unveränderbar.'),
    ('Kommentar als Spam markiert','Mir wurde gerade angezeigt, dass mein Kommentar als Spam markiert wurde und deshalb nicht angezeigt wird. Warum ist das passiert?','Kommentare mit Beleidigungen werden als Spam markiert.
        Wenn Sie zu viele Kommentare unter einen Beitrag schreiben, wird dies ebenfalls als Spam markiert.'),
    ('Feedback','Ich habe eine Idee für eine neue Funktion. Wo kann ich sie teilen?','Feedbacks können Sie auf der Hilfeseite abgeben! Einfach runter scrollen.'),
    ('Serverprobleme','Die Seite lädt langsam. Gibt es Probleme mit dem Server?','Die Seite wurde schlecht programmiert, könnte daran liegen..'),
    ('Neue Spiele','Kann man irgendwo Vorschläge für Games einreichen, die man noch mit auf die Seite machen könnte?','Ja das geht über das Feedback-Formular. Es gibt extra eine Frage dafür?');


INSERT INTO permissions(permissionName, admin, user, visitor)
VALUES
    ('PostPosts', true, true, false),
    ('PostComments', true, true, false),
    ('RemovePosts', true, false, false),
    ('RemoveComments', true, false, false);

