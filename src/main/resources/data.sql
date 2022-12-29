SET
foreign_key_checks = 0;
DELETE
FROM premium_purchase;
DELETE
FROM partycharacter;
DELETE
FROM characteratrefact;
DELETE
FROM player_artefact;
DELETE
FROM player_character;
DELETE
FROM player_weapon;
DELETE
FROM stat_weapon;
DELETE
FROM player_chestitem;
DELETE
FROM stat_class;
DELETE
FROM stat_affiliation;
DELETE
FROM weapon_chest;
DELETE
FROM weapon_reward;
DELETE
FROM material_reward;
DELETE
FROM Player_Role;
DELETE
FROM gacha.role;
DELETE
FROM materialweaponclass;
DELETE
FROM character_chest;
DELETE
FROM materialclass;
DELETE
FROM materialaffilation;
DELETE
FROM materialelement;
DELETE
FROM player_material;
DELETE
FROM gacha.character;
DELETE
FROM weapon;
DELETE
FROM stat_artifact;
DELETE
FROM stat_artefactSet;
DELETE
FROM gacha.class;
DELETE
FROM player_purchase;
DELETE
FROM ingamecurrencyPurchase;
DELETE
FROM paymentmethod;
DELETE
FROM element;
DELETE
FROM weaponClass;
DELETE
FROM statistic;
DELETE
FROM material;
DELETE
FROM chest;
DELETE
FROM collection;
DELETE
FROM artefact_set;
DELETE
FROM gacha.set;
DELETE
FROM player_dungeonfloor;
DELETE
FROM Artefact_Reward;
DELETE
FROM dungeonfloor;
DELETE
FROM party;
DELETE
FROM player;
DELETE
FROM Dungeon;
DELETE
FROM artefact;
DELETE
FROM rarity;
DELETE
FROM affilation;
DELETE
FROM ability;
SET
foreign_key_checks = 1;


-- affilation
INSERT INTO affilation (id, name, requirement)
VALUES (1, 'POLSKA', 1);
INSERT INTO affilation (id, name, requirement)
VALUES (2, 'Weeb', 2);
INSERT INTO affilation (id, name, requirement)
VALUES (3, 'Gensokyo', 3);
INSERT INTO affilation (id, name, requirement)
VALUES (4, 'Furry', 4);

--rarity
INSERT INTO rarity (id, name, shortcut, weight)
values (1, 'Mythic', 'MYT', 4);
INSERT INTO rarity (id, name, shortcut, weight)
values (2, 'Legendary', 'LEG', 1);
INSERT INTO rarity (id, name, shortcut, weight)
values (3, 'Epic', 'EPC', 10);
INSERT INTO rarity (id, name, shortcut, weight)
values (4, 'Uncommon', 'UCM', 25);
INSERT INTO rarity (id, name, shortcut, weight)
values (5, 'Common', 'CMN', 60);
--artefact
INSERT INTO artefact (id, name, type, rarity_id)
values (1, 'Ring of Choking', 0, 3);
INSERT INTO artefact (id, name, type, rarity_id)
values (2, 'Fentanyl Detectors', 1, 3);
INSERT INTO artefact (id, name, type, rarity_id)
values (3, 'White Knee', 2, 3);
INSERT INTO artefact (id, name, type, rarity_id)
values (4, 'Creatine Injector', 0, 1);
INSERT INTO artefact (id, name, type, rarity_id)
values (5, 'Pixelated Shades', 1, 1);
INSERT INTO artefact (id, name, type, rarity_id)
values (6, 'Hachimaki', 2, 1);
INSERT INTO artefact (id, name, type, rarity_id)
values (7, 'Ring of Thots', 0, 2);
INSERT INTO artefact (id, name, type, rarity_id)
values (8, 'Pink HeartShaped Glasses', 1, 2);
INSERT INTO artefact (id, name, type, rarity_id)
values (9, 'Cat Ears', 2, 2);
--player !!! ADMIN MA ZAWSZE MIEC ID 1 !!!
INSERT INTO player (id_player, nick, birth_date, join_date, active_party, player_balance, hashed_password,
                    pity_roll_status, pvpwins, pvplooses, elopoints, premium_left, stamina)
values (1, 'admin', '1900-01-01 00:00:00', '2022-01-01 00:00:00', 1, 10000,
        '$2a$12$qmuu8mn/qN1D.ykSKYMJp.JNWJzL2fL77VHtd7/uzlpzOWv8r5dBC', 1, 1, 1, 1, 99999, 100);
INSERT INTO player (id_player, nick, birth_date, join_date, active_party, player_balance, hashed_password,
                    pity_roll_status, pvpwins, pvplooses, elopoints, premium_left, stamina)
values (2, 'user', '1900-01-01 00:00:00', '2022-01-01 00:00:00', 2, 9999,
        '$2a$12$X2jrACo9ErTffy3JKUTZFuSr/fndHEIEkle5btouwO25TYv14cgQe', 1, 1, 1, 1, 0, 100);
INSERT INTO player (id_player, nick, birth_date, join_date, active_party, player_balance, hashed_password,
                    pity_roll_status, pvpwins, pvplooses, elopoints, premium_left, stamina)
values (3, 'autist', '1900-01-01 00:00:00', '2022-01-01 00:00:00', 3, 9999,
        '$2a$12$X2jrACo9ErTffy3JKUTZFuSr/fndHEIEkle5btouwO25TYv14cgQe', 1, 1, 1, 1, 0, 100);
--Dungeon
INSERT INTO Dungeon (id, name, released_at, expires_at)
values (1, 'jurna wieza', '2022-01-01 00:00:00', null);
INSERT INTO Dungeon (id, name, released_at, expires_at)
values (2, 'piwnica', '2000-01-01 00:00:00', '2002-01-01 00:00:00');
INSERT INTO Dungeon (id, name, released_at, expires_at)
values (3, 'cyberpunk', '2037-01-01 00:00:00', null);
INSERT INTO Dungeon (id, name, released_at, expires_at)
values (4, 'PJATK', '2018-01-01 00:00:00', '2025-01-01 00:00:00');
--set
INSERT INTO gacha.set (id, name)
values (1, 'George Floyd Set');
INSERT INTO gacha.set (id, name)
values (2, 'Barbarian Testosterone Set');
INSERT INTO gacha.set (id, name)
values (3, 'EGirl Set');
--artefact_set
INSERT INTO artefact_set (set_id, artefact_id)
values (1, 1);
INSERT INTO artefact_set (set_id, artefact_id)
values (1, 2);
INSERT INTO artefact_set (set_id, artefact_id)
values (1, 3);
INSERT INTO artefact_set (set_id, artefact_id)
values (2, 4);
INSERT INTO artefact_set (set_id, artefact_id)
values (2, 5);
INSERT INTO artefact_set (set_id, artefact_id)
values (2, 6);
INSERT INTO artefact_set (set_id, artefact_id)
values (3, 7);
INSERT INTO artefact_set (set_id, artefact_id)
values (3, 8);
INSERT INTO artefact_set (set_id, artefact_id)
values (3, 9);
INSERT INTO artefact_set (set_id, artefact_id)
values (3, 6);
INSERT INTO artefact_set (set_id, artefact_id)
values (3, 1);
--collection
INSERT INTO collection (idcollection, name)
values (1, 'Winter collection');
INSERT INTO collection (idcollection, name)
values (2, 'Summer collection');
INSERT INTO collection (idcollection, name)
values (3, 'Special collection');
INSERT INTO collection (idcollection, name)
values (4, 'Pay2Win collection');
--chest
INSERT INTO chest (id_chest, name, collection_idcollection, released_at, expires_at, price)
values (1, 'basic chest', 1, '2022-01-01 00:00:00', '2030-01-01 00:00:00', 1);
INSERT INTO chest (id_chest, name, collection_idcollection, released_at, expires_at, price)
values (2, 'rare chest', 2, '2024-01-01 00:00:00', '2030-01-01 00:00:00', 2);
INSERT INTO chest (id_chest, name, collection_idcollection, released_at, expires_at, price)
values (3, 'super rare chest', 3, '2022-01-01 00:00:00', '2030-01-01 00:00:00', 3);
INSERT INTO chest (id_chest, name, collection_idcollection, released_at, expires_at, price)
values (4, 'pay2win chest', 4, '2023-01-01 00:00:00', '2137-01-06 00:00:00', 4);
--material
INSERT INTO material (id, name)
values (1, 'Wood');
INSERT INTO material (id, name)
values (2, 'Iron');
INSERT INTO material (id, name)
values (3, 'Leather');
INSERT INTO material (id, name)
values (4, 'Gold');
INSERT INTO material (id, name)
values (5, 'Crystals');
INSERT INTO material (id, name)
values (6, 'Frost Core');
INSERT INTO material (id, name)
values (7, 'Magma Core');
INSERT INTO material (id, name)
values (8, 'Typhoon Core');
--statistic
INSERT INTO statistic (stat_id, name, short_name)
values (1, 'Health Points', 'HP');
INSERT INTO statistic (stat_id, name, short_name)
values (2, 'Attack', 'ATK');
INSERT INTO statistic (stat_id, name, short_name)
values (3, 'Initiative', 'INI');
INSERT INTO statistic (stat_id, name, short_name)
values (4, 'Defence', 'DEF');
INSERT INTO statistic (stat_id, name, short_name)
values (5, 'Crit Rate', 'CRT');
INSERT INTO statistic (stat_id, name, short_name)
values (6, 'Crit Damage', 'CDM');
--weaponClass
INSERT INTO weaponClass(id, name, short_name)
values (1, 'Sword', 'SWD');
INSERT INTO weaponClass(id, name, short_name)
values (2, 'Crossbow', 'CRS');
INSERT INTO weaponClass(id, name, short_name)
values (3, 'Almanac', 'ALM');
INSERT INTO weaponClass(id, name, short_name)
values (4, 'Shield', 'SHI');
INSERT INTO weaponClass(id, name, short_name)
values (5, 'Lute', 'LTE');
--element
INSERT INTO element (id, name)
values (1, 'Fire');
INSERT INTO element (id, name)
values (2, 'Ice');
INSERT INTO element (id, name)
values (3, 'Wind');
--paymentmethod
INSERT INTO paymentmethod (IDPayment_Method, Name)
values (1, 'PayPal');
INSERT INTO paymentmethod (IDPayment_Method, Name)
values (2, 'SMS');
INSERT INTO paymentmethod (IDPayment_Method, Name)
values (3, 'social credits');
INSERT INTO paymentmethod (IDPayment_Method, Name)
values (4, 'BLIK');
--ingamecurrencyPurchase
INSERT INTO ingamecurrencyPurchase (idigcp, volume, price)
VALUES (1, 100, 4.99);
INSERT INTO ingamecurrencyPurchase (idigcp, volume, price)
VALUES (2, 500, 18.99);
INSERT INTO ingamecurrencyPurchase (idigcp, volume, price)
VALUES (3, 2137, 42.00);
--player_purchase
INSERT INTO player_purchase (id, player_id_player, payment_method_idpayment_method, in_game_currency_purchase_idigcp,
                             bought_at)
values (1, 1, 1, 1, curdate());
INSERT INTO player_purchase (id, player_id_player, payment_method_idpayment_method, in_game_currency_purchase_idigcp,
                             bought_at)
values (2, 2, 2, 2, curdate());
INSERT INTO player_purchase (id, player_id_player, payment_method_idpayment_method, in_game_currency_purchase_idigcp,
                             bought_at)
values (3, 3, 3, 3, curdate());
--class
INSERT INTO gacha.class (id, name, weapon_class, shortcut)
VALUES (1, 'Knight', 1, 'KNI');
INSERT INTO gacha.class (id, name, weapon_class, shortcut)
VALUES (2, 'Ranger', 2, 'RNG');
INSERT INTO gacha.class (id, name, weapon_class, shortcut)
VALUES (3, 'Mage', 3, 'MGE');
INSERT INTO gacha.class (id, name, weapon_class, shortcut)
VALUES (4, 'Vanguard', 4, 'VNG');
INSERT INTO gacha.class (id, name, weapon_class, shortcut)
VALUES (5, 'Bard', 5, 'BRD');
--stat_artefactSet
INSERT INTO stat_artefactSet (value, set_id, statistic_stat_id)
values (30, 1, 1);
INSERT INTO stat_artefactSet (value, set_id, statistic_stat_id)
values (25, 2, 3);
INSERT INTO stat_artefactSet (value, set_id, statistic_stat_id)
values (50, 3, 2);
--stat_artifact
INSERT INTO stat_artifact (id, statistic_stat_id, artefact_id, value)
values (1, 1, 1, 15);
INSERT INTO stat_artifact (id, statistic_stat_id, artefact_id, value)
values (2, 1, 2, 20);
INSERT INTO stat_artifact (id, statistic_stat_id, artefact_id, value)
values (3, 1, 3, 25);
INSERT INTO stat_artifact (id, statistic_stat_id, artefact_id, value)
values (4, 5, 4, 10);
INSERT INTO stat_artifact (id, statistic_stat_id, artefact_id, value)
values (5, 5, 5, 10);
INSERT INTO stat_artifact (id, statistic_stat_id, artefact_id, value)
values (6, 6, 6, 20);
INSERT INTO stat_artifact (id, statistic_stat_id, artefact_id, value)
values (7, 4, 7, 20);
INSERT INTO stat_artifact (id, statistic_stat_id, artefact_id, value)
values (8, 1, 8, 69);
INSERT INTO stat_artifact (id, statistic_stat_id, artefact_id, value)
values (9, 2, 9, 20);
--weapon
INSERT INTO weapon (id, name, element_id, rarity_id, weapon_class_id)
VALUES (1, 'Iron Sword', 2, 5, 1);
INSERT INTO weapon (id, name, element_id, rarity_id, weapon_class_id)
VALUES (2, 'Fiery Sword', 1, 3, 1);
INSERT INTO weapon (id, name, element_id, rarity_id, weapon_class_id)
VALUES (3, 'Weeb Slayer 5000', 3, 2, 1);

INSERT INTO weapon (id, name, element_id, rarity_id, weapon_class_id)
VALUES (4, 'Wooden Bow', 2, 5, 2);
INSERT INTO weapon (id, name, element_id, rarity_id, weapon_class_id)
VALUES (5, 'Ivory Bow', 1, 1, 2);
INSERT INTO weapon (id, name, element_id, rarity_id, weapon_class_id)
VALUES (6, 'StormBringer', 3, 2, 2);

INSERT INTO weapon (id, name, element_id, rarity_id, weapon_class_id)
VALUES (7, 'Japanese Notebook', 3, 5, 3);
INSERT INTO weapon (id, name, element_id, rarity_id, weapon_class_id)
VALUES (8, 'Frozen Spellbook', 2, 4, 3);
INSERT INTO weapon (id, name, element_id, rarity_id, weapon_class_id)
VALUES (9, 'Encyclopedia of Flames', 1, 2, 3);

INSERT INTO weapon (id, name, element_id, rarity_id, weapon_class_id)
VALUES (10, 'Simple Shield', 1, 5, 4);
INSERT INTO weapon (id, name, element_id, rarity_id, weapon_class_id)
VALUES (11, 'Vortex Shield', 3, 1, 4);
INSERT INTO weapon (id, name, element_id, rarity_id, weapon_class_id)
VALUES (12, 'Shield of True Ice', 2, 2, 4);

INSERT INTO weapon (id, name, element_id, rarity_id, weapon_class_id)
VALUES (13, 'Battle Lute', 1, 5, 5);
INSERT INTO weapon (id, name, element_id, rarity_id, weapon_class_id)
VALUES (14, 'Lute of Cold Songs', 2, 4, 5);
INSERT INTO weapon (id, name, element_id, rarity_id, weapon_class_id)
VALUES (15, 'Whispers of the Wind', 3, 2, 5);

--ability
INSERT INTO `ability` (`id`, `name`, `type`, `potency`, `stat_id`)
VALUES (1, 'buła mieczem', 0, 100, null),
       (2, 'Myk szabelką', 0, 100, null),
       (3, 'AWOOO', 0, 100, null),
       (4, 'Steady Shot', 0, 100, null),
       (5, 'Bad Day', 2, 100, 2),
       (6, 'uwu shot', 0, 100, null),
       (7, 'Uwodzenie Wieśmina', 2, 100, 2),
       (8, 'owo bolt', 0, 100, null),
       (9, 'Frog Freezing', 2, 100, 2),
       (10, 'No idea', 2, 100, 2),
       (11, 'Dark push', 0, 100, null),
       (12, 'Shield Bash', 0, 100, null),
       (13, 'Anime Noises', 1, 100, 2),
       (14, 'Mexican Music', 1, 100, 2),
       (15, 'Absolute Territory', 1, 100, 2);

--character
INSERT INTO `character` (`id`, `ability_id`, `name`, `affilation_id`, `class_id`, `rarity_id`)
VALUES (1, 1, 'Sebix', 1, 1, 5),
       (2, 2, 'Jacek Soplica', 1, 1, 3),
       (3, 3, 'Inubarashi Momiji', 3, 1, 2),
       (4, 4, 'Samurai Wannabe', 2, 2, 3),
       (5, 5, 'School Shooter', 1, 2, 4),
       (6, 6, 'Krzysztof', 4, 2, 5),
       (7, 7, 'Triss', 1, 3, 2),
       (8, 8, 'Woś', 4, 3, 4),
       (9, 9, 'Cirno', 3, 3, 1),
       (10, 10, 'Shield Hero', 2, 4, 5),
       (11, 11, 'Rumia', 3, 4, 1),
       (12, 12, 'Zawisza Czarny', 1, 4, 3),
       (13, 13, 'Wołyń', 2, 5, 2),
       (14, 14, 'Remilia', 3, 5, 2),
       (15, 15, 'Ken Ashcorp', 4, 5, 2);



--Player_Character
INSERT INTO player_character (id, player_id_player, character_id, ascention, lvl)
VALUES (1, 1, 1, 1, 1);
INSERT INTO player_character (id, player_id_player, character_id, ascention, lvl)
VALUES (2, 2, 2, 2, 2);
INSERT INTO player_character (id, player_id_player, character_id, ascention, lvl)
VALUES (3, 3, 3, 3, 3);
INSERT INTO player_character (id, player_id_player, character_id, ascention, lvl)
VALUES (4, 1, 4, 3, 2);
INSERT INTO player_character (id, player_id_player, character_id, ascention, lvl)
VALUES (5, 1, 5, 7, 3);
INSERT INTO player_character (id, player_id_player, character_id, ascention, lvl)
VALUES (6, 1, 6, 3, 1);
INSERT INTO player_character (id, player_id_player, character_id, ascention, lvl)
VALUES (7, 2, 7, 7, 2);
INSERT INTO player_character (id, player_id_player, character_id, ascention, lvl)
VALUES (8, 2, 8, 3, 4);
INSERT INTO player_character (id, player_id_player, character_id, ascention, lvl)
VALUES (9, 2, 9, 3, 3);
--player_material
INSERT INTO player_material (id, material_id, player_id_player, amount)
VALUES (1, 1, 1, 10);
INSERT INTO player_material (id, material_id, player_id_player, amount)
VALUES (2, 2, 2, 10);
INSERT INTO player_material (id, material_id, player_id_player, amount)
VALUES (3, 3, 3, 10);
--materialelement
INSERT INTO `materialelement` (`id`, `base_amount`, `per_lvl_amount`, `element_id`, `material_id`)
VALUES (5, 2, 1, 1, 7),
       (6, 2, 1, 2, 6),
       (7, 2, 1, 3, 8);
--materialaffilation
INSERT INTO `materialaffilation` (`id`, `base_amount`, `per_lvl_amount`, `affilation_id`, `material_id`)
VALUES (4, 2, 2, 1, 1),
       (5, 2, 2, 2, 4),
       (6, 2, 2, 3, 5),
       (7, 2, 2, 4, 3);

--materialclass
INSERT INTO `materialclass` (`id`, `base_amount`, `per_lvl_amount`, `class_id`, `material_id`)
VALUES (4, 2, 2, 1, 2),
       (5, 3, 2, 1, 3),
       (6, 2, 2, 2, 1),
       (7, 2, 2, 2, 3),
       (8, 2, 2, 3, 5),
       (9, 3, 2, 3, 4),
       (10, 2, 2, 4, 2),
       (11, 3, 2, 4, 4),
       (12, 2, 2, 5, 3),
       (13, 2, 2, 5, 5);

--player_artefact
INSERT INTO player_artefact (id, player_id_player, artefact_id, lvl)
VALUES (1, 1, 1, 1);
INSERT INTO player_artefact (id, player_id_player, artefact_id, lvl)
VALUES (2, 2, 2, 2);
INSERT INTO player_artefact (id, player_id_player, artefact_id, lvl)
VALUES (3, 3, 3, 3);
INSERT INTO player_artefact (player_id_player, artefact_id, lvl)
VALUES (1, 1, 1);
INSERT INTO player_artefact (player_id_player, artefact_id, lvl)
VALUES (1, 1, 1);
INSERT INTO player_artefact (player_id_player, artefact_id, lvl)
VALUES (1, 1, 1);
--characterartefact
INSERT INTO characteratrefact (player_character_id, player_artefact_id)
VALUES (1, 1);
INSERT INTO characteratrefact (player_character_id, player_artefact_id)
VALUES (1, 2);
INSERT INTO characteratrefact (player_character_id, player_artefact_id)
VALUES (2, 3);
--character_chest
INSERT INTO character_chest (chest_id_chest, character_id)
VALUES (1, 1);
INSERT INTO character_chest (chest_id_chest, character_id)
VALUES (1, 2);
INSERT INTO character_chest (chest_id_chest, character_id)
VALUES (2, 3);
--materialweaponclass
INSERT INTO `materialweaponclass` (`id`, `base_amount`, `per_lvl_amount`, `material_id`, `weapon_class_id`)
VALUES (5, 1, 2, 2, 1),
       (6, 1, 1, 1, 1),
       (7, 3, 2, 1, 2),
       (8, 1, 1, 4, 2),
       (10, 1, 1, 3, 3),
       (11, 2, 2, 5, 3),
       (12, 1, 1, 3, 4),
       (13, 1, 1, 2, 4),
       (14, 1, 1, 3, 4),
       (15, 1, 2, 1, 5),
       (16, 3, 1, 4, 5);
--role
INSERT INTO gacha.role (id, name)
VALUES (1, 'ADMIN');
INSERT INTO gacha.role (id, name)
VALUES (2, 'USER');
INSERT INTO gacha.role (id, name)
VALUES (3, 'PREMIUM');
--Player_Role
INSERT INTO Player_Role (Player_player_id, role_id)
VALUES (1, 1);
INSERT INTO Player_Role (Player_player_id, role_id)
VALUES (1, 2);
INSERT INTO Player_Role (Player_player_id, role_id)
VALUES (2, 2);
INSERT INTO Player_Role (Player_player_id, role_id)
VALUES (3, 2);
INSERT INTO Player_Role (Player_player_id, role_id)
VALUES (1, 3);
--party NAME
INSERT INTO party (id, player_id_player, name, move_order)
VALUES (1, 1, 1, 1234);
INSERT INTO party (id, player_id_player, name, move_order)
VALUES (2, 2, 2, 4321);
INSERT INTO party (id, player_id_player, name, move_order)
VALUES (3, 3, 3, 3214);
--dungeonfloor
INSERT INTO dungeonfloor (id, dungeon_id, depth, party_id)
values (1, 1, 1, 1);
INSERT INTO dungeonfloor (id, dungeon_id, depth, party_id)
values (2, 1, 2, 1);
INSERT INTO dungeonfloor (id, dungeon_id, depth, party_id)
values (3, 2, 1, 1);
INSERT INTO dungeonfloor (id, dungeon_id, depth, party_id)
values (4, 4, 10, 1);
--player_dungeonfloor
INSERT INTO player_dungeonfloor (id, dungeon_floor_id, player_id_player, clear_date)
VALUES (1, 1, 1, curdate());
INSERT INTO player_dungeonfloor (id, dungeon_floor_id, player_id_player, clear_date)
VALUES (2, 2, 2, '2022-01-01 00:00:00');
INSERT INTO player_dungeonfloor (id, dungeon_floor_id, player_id_player, clear_date)
VALUES (3, 3, 1, curdate());
--Artefact_Reward_
INSERT INTO Artefact_Reward(id, quantity, artefact_id, dungeon_floor_id)
values (1, 1, 1, 1);
INSERT INTO Artefact_Reward(id, quantity, artefact_id, dungeon_floor_id)
values (2, 2, 2, 2);
INSERT INTO Artefact_Reward(id, quantity, artefact_id, dungeon_floor_id)
values (3, 3, 3, 3);
--material_reward
INSERT INTO material_reward (id, material_id, dungeon_floor_id, quantity)
VALUES (1, 1, 1, 1);
INSERT INTO material_reward (id, material_id, dungeon_floor_id, quantity)
VALUES (2, 2, 2, 20);
INSERT INTO material_reward (id, material_id, dungeon_floor_id, quantity)
VALUES (3, 3, 3, 300);
--weapon_reward
INSERT INTO weapon_reward (id, weapon_id, dungeon_floor_id, quantity)
VALUES (1, 1, 1, 1);
INSERT INTO weapon_reward (id, weapon_id, dungeon_floor_id, quantity)
VALUES (2, 2, 2, 20);
INSERT INTO weapon_reward (id, weapon_id, dungeon_floor_id, quantity)
VALUES (3, 3, 3, 300);
--weapon_chest
INSERT INTO weapon_chest (weapon_id, chest_id_chest)
VALUES (1, 1);
INSERT INTO weapon_chest (weapon_id, chest_id_chest)
VALUES (2, 2);
INSERT INTO weapon_chest (weapon_id, chest_id_chest)
VALUES (3, 1);
--stat_affiliation
INSERT INTO `stat_affiliation` (`id`, `value`, `affiliation_id`, `statistic_stat_id`)
VALUES (2, 2, 2, 2),
       (4, 15, 1, 4),
       (5, 15, 2, 5),
       (6, 10, 3, 2),
       (7, 50, 4, 1);
--stat_class
INSERT INTO `stat_class` (`id`, `value`, `class_id`, `statistic_stat_id`)
VALUES (4, 50, 1, 1),
       (6, 40, 1, 4),
       (7, 20, 2, 1),
       (8, 90, 2, 3),
       (9, 20, 2, 4),
       (10, 20, 3, 1),
       (11, 20, 3, 4),
       (13, 65, 4, 1),
       (14, 60, 4, 4),
       (17, 26, 3, 1),
       (18, 50, 1, 3),
       (19, 30, 4, 3),
       (20, 80, 5, 3),
       (21, 35, 5, 1),
       (22, 10, 5, 4);

-- player_chestitem
INSERT INTO player_chestitem (id, player_id_player, chest_id_chest, bought_at)
VALUES (1, 1, 1, curdate());
INSERT INTO player_chestitem (id, player_id_player, chest_id_chest, bought_at)
VALUES (2, 2, 2, curdate());
INSERT INTO player_chestitem (id, player_id_player, chest_id_chest, bought_at)
VALUES (3, 2, 2, '2000-01-01 00:00:00');
--stat_weapon
INSERT INTO `stat_weapon` (`id`, `value`, `statistic_stat_id`, `weapon_id`)
VALUES (4, 3, 2, 1),
       (5, 5, 5, 1),
       (6, 15, 6, 1),
       (8, 8, 2, 2),
       (9, 12, 5, 2),
       (10, 40, 6, 2),
       (11, 10, 2, 3),
       (12, 30, 5, 3),
       (13, 60, 6, 3),
       (14, 5, 3, 3),
       (15, 5, 2, 4),
       (16, 9, 5, 4),
       (17, 19, 6, 4),
       (18, 6, 2, 5),
       (19, 20, 5, 5),
       (20, 50, 6, 5),
       (21, 12, 2, 6),
       (22, 50, 5, 6),
       (23, 80, 6, 6),
       (24, 8, 2, 7),
       (25, 2, 5, 7),
       (26, 100, 6, 7),
       (27, 14, 2, 8),
       (28, 6, 5, 8),
       (29, 140, 6, 8),
       (30, 30, 2, 9),
       (31, 10, 5, 9),
       (32, 220, 6, 9),
       (33, 2, 2, 10),
       (34, 20, 5, 10),
       (35, 20, 6, 10),
       (36, 7, 2, 11),
       (37, 12, 5, 11),
       (38, 44, 6, 11),
       (39, 14, 2, 12),
       (40, 40, 5, 12),
       (41, 40, 6, 12),
       (42, 40, 4, 12),
       (43, 10, 2, 13),
       (44, 16, 5, 13),
       (45, 66, 6, 13),
       (46, 12, 2, 14),
       (47, 13, 5, 14),
       (48, 43, 6, 14),
       (49, 20, 2, 15),
       (50, 14, 5, 15),
       (51, 77, 6, 15),
       (52, 20, 3, 15);
--partycharacter
INSERT INTO partycharacter (party_id, player_character_id)
VALUES (1, 1);
INSERT INTO partycharacter (party_id, player_character_id)
VALUES (1, 2);
INSERT INTO partycharacter (party_id, player_character_id)
VALUES (2, 8);
INSERT INTO partycharacter (party_id, player_character_id)
VALUES (1, 3);
INSERT INTO partycharacter (party_id, player_character_id)
VALUES (1, 4);
INSERT INTO partycharacter (party_id, player_character_id)
VALUES (2, 5);
INSERT INTO partycharacter (party_id, player_character_id)
VALUES (2, 6);
INSERT INTO partycharacter (party_id, player_character_id)
VALUES (2, 7);
--player_weapon
INSERT INTO player_weapon (id, player_id_player, weapon_id, ascension, lvl)
VALUES (1, 1, 1, 1, 1);
INSERT INTO player_weapon (id, wielding_character, player_id_player, weapon_id, ascension, lvl)
VALUES (2, 2, 2, 2, 2, 2);
INSERT INTO player_weapon (id, wielding_character, player_id_player, weapon_id, ascension, lvl)
VALUES (3, 3, 3, 3, 3, 3);