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
FROM player_role;
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
FROM stat_artefactset;
DELETE
FROM gacha.class;
DELETE
FROM player_purchase;
DELETE
FROM ingamecurrencypurchase;
DELETE
FROM paymentmethod;
DELETE
FROM element;
DELETE
FROM weaponclass;
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
FROM artefact_reward;
DELETE
FROM dungeonfloor;
DELETE
FROM party;
DELETE
FROM player;
DELETE
FROM dungeon;
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
                    pity_roll_status, elopoints, premium_left, stamina, level)
values (1, 'admin', '1900-01-01 00:00:00', '2022-01-01 00:00:00', 1, 10000,
        '$2a$12$qmuu8mn/qN1D.ykSKYMJp.JNWJzL2fL77VHtd7/uzlpzOWv8r5dBC', 1, 0, 99999, 100, 80);
INSERT INTO player (id_player, nick, birth_date, join_date, active_party, player_balance, hashed_password,
                    pity_roll_status, elopoints, premium_left, stamina, level)
values (2, 'user', '1900-01-01 00:00:00', '2022-01-01 00:00:00', 2, 9999,
        '$2a$12$X2jrACo9ErTffy3JKUTZFuSr/fndHEIEkle5btouwO25TYv14cgQe', 1, 1500, 0, 100, 80);
INSERT INTO player (id_player, nick, birth_date, join_date, active_party, player_balance, hashed_password,
                    pity_roll_status, elopoints, premium_left, stamina, level)
values (3, 'autist', '1900-01-01 00:00:00', '2022-01-01 00:00:00', 3, 9999,
        '$2a$12$X2jrACo9ErTffy3JKUTZFuSr/fndHEIEkle5btouwO25TYv14cgQe', 1, 1500, 0, 100, 80);
--Dungeon

INSERT INTO `dungeon` (`id`, `expires_at`, `name`, `released_at`, `type`)
VALUES (7, '2123-01-06 00:00:00', 'Main Dungeon', '2022-05-16 00:00:00', 3),
       (8, '2023-03-10 00:00:00', 'Winter Event Dungeon', '2022-12-01 00:00:00', 0),
       (9, '2133-01-06 00:00:00', 'Great Riches Dungeon', '2023-01-01 00:00:00', 1),
       (10, '2123-01-06 00:00:00', 'Moriya Shrine', '2023-01-01 00:00:00', 2),
       (11, '2123-01-06 00:00:00', 'Dwarven Mine', '2022-12-01 00:00:00', 4),
       (12, '2022-09-02 00:00:00', 'Summer 2022 Dungeon', '2022-05-21 00:00:00', 0),
       (13, '2023-09-06 00:00:00', 'Summer 2023 Dungeon', '2023-05-31 00:00:00', 0);
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

INSERT INTO `chest` (`id_chest`, `expires_at`, `name`, `price`, `released_at`, `collection_idcollection`)
VALUES (5, '2032-10-20 00:00:00', 'Weapon Chest', 30, '2022-12-02 00:00:00', 4),
       (6, '2035-11-15 00:00:00', 'Poland Stronk Chest', 30, '2021-02-10 00:00:00', 4),
       (7, '2031-11-13 00:00:00', 'Character Chest', 30, '2022-07-14 00:00:00', 2),
       (8, '2023-12-23 00:00:00', 'Gensokyo Chest', 30, '2022-05-05 00:00:00', 3),
       (9, '2022-12-15 00:00:00', 'Old Chest', 30, '2022-08-11 00:00:00', 1),
       (10, '2025-04-17 00:00:00', 'New Chest', 30, '2024-01-17 00:00:00', 3);

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
INSERT INTO weaponclass(id, name, short_name)
values (1, 'Sword', 'SWD');
INSERT INTO weaponclass(id, name, short_name)
values (2, 'Crossbow', 'CRS');
INSERT INTO weaponclass(id, name, short_name)
values (3, 'Almanac', 'ALM');
INSERT INTO weaponclass(id, name, short_name)
values (4, 'Shield', 'SHI');
INSERT INTO weaponclass(id, name, short_name)
values (5, 'Lute', 'LTE');
--element
INSERT INTO element (id, name)
values (1, 'FIRE');
INSERT INTO element (id, name)
values (2, 'ICE');
INSERT INTO element (id, name)
values (3, 'WIND');
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
INSERT INTO ingamecurrencypurchase (idigcp, volume, price)
VALUES (1, 100, 4.99);
INSERT INTO ingamecurrencypurchase (idigcp, volume, price)
VALUES (2, 500, 18.99);
INSERT INTO ingamecurrencypurchase (idigcp, volume, price)
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
INSERT INTO stat_artefactset (value, set_id, statistic_stat_id)
values (30, 1, 1);
INSERT INTO stat_artefactset (value, set_id, statistic_stat_id)
values (25, 2, 3);
INSERT INTO stat_artefactset (value, set_id, statistic_stat_id)
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
       (14, 'Mexican Music', 3, 100, null),
       (15, 'Absolute Territory', 1, 100, 2);

--character
INSERT INTO `character` (`id`, `ability_id`, `name`, `affilation_id`, `class_id`, `rarity_id`)
VALUES (1, 1, 'Sebix', 1, 1, 5),
       (2, 2, 'Jacek Soplica', 1, 1, 3),
       (3, 3, 'Inubashiri Momiji', 3, 1, 2),
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
SET
foreign_key_checks = 0;
INSERT INTO `player_character` (`id`, `ascention`, `lvl`, `character_id`, `player_id_player`, `wielded_weapon`)
VALUES (1, 1, 1, 1, 1, NULL),
       (2, 2, 2, 2, 2, NULL),
       (3, 3, 3, 3, 3, NULL),
       (4, 3, 2, 4, 1, NULL),
       (5, 7, 3, 5, 1, NULL),
       (6, 3, 1, 6, 1, NULL),
       (7, 7, 2, 7, 2, NULL),
       (8, 3, 4, 8, 2, NULL),
       (9, 3, 3, 9, 2, NULL),
       (10, 1, 11, 3, 2, 4),
       (11, 1, 11, 9, 2, 5),
       (12, 1, 11, 11, 2, 6),
       (13, 1, 11, 14, 2, 7),
       (14, 1, 11, 2, 3, NULL),
       (15, 1, 11, 5, 3, 9),
       (16, 1, 11, 7, 3, 10),
       (17, 1, 11, 12, 3, 11),
       (18, 1, 69, 5, 2, NULL),
       (19, 1, 1, 1, 1, 37),
       (20, 1, 1, 4, 1, 38),
       (21, 1, 1, 10, 1, 39),
       (22, 1, 1, 7, 1, 40),
       (23, 1, 2, 4, 1, 41),
       (24, 1, 1, 2, 1, 42),
       (25, 1, 1, 3, 1, 43),
       (26, 1, 1, 5, 1, 44),
       (27, 1, 1, 5, 1, 45),
       (28, 1, 1, 6, 1, 46),
       (29, 1, 1, 7, 1, 47),
       (30, 1, 1, 8, 1, 48),
       (31, 1, 1, 9, 1, 49),
       (32, 1, 1, 10, 1, 50),
       (33, 1, 1, 11, 1, 51),
       (34, 1, 1, 12, 1, 52),
       (35, 1, 1, 13, 1, 53),
       (36, 1, 1, 14, 1, 54),
       (37, 1, 1, 15, 1, 55),
       (38, 1, 2, 1, 1, 56),
       (39, 1, 2, 2, 1, 57),
       (40, 1, 2, 3, 1, 58),
       (41, 1, 2, 4, 1, 59),
       (42, 1, 2, 5, 1, 60),
       (43, 1, 2, 6, 1, 61),
       (44, 1, 2, 7, 1, 62),
       (45, 1, 2, 8, 1, 63),
       (46, 1, 2, 9, 1, 64),
       (47, 1, 2, 10, 1, 65),
       (48, 1, 2, 11, 1, 66),
       (49, 1, 2, 12, 1, 67),
       (50, 1, 2, 13, 1, 68),
       (51, 1, 2, 14, 1, 69),
       (52, 1, 3, 1, 1, 70),
       (53, 1, 3, 2, 1, 71),
       (54, 1, 3, 3, 1, 72),
       (55, 1, 3, 4, 1, 73),
       (56, 1, 3, 5, 1, 74),
       (57, 1, 3, 6, 1, 75),
       (58, 1, 3, 7, 1, 76),
       (59, 1, 3, 8, 1, 77),
       (60, 1, 3, 9, 1, 78),
       (61, 1, 3, 10, 1, 79),
       (62, 1, 3, 11, 1, 80),
       (63, 1, 3, 12, 1, 81),
       (64, 1, 3, 13, 1, 82),
       (65, 1, 3, 14, 1, 83),
       (66, 1, 3, 15, 1, 84);
SET
foreign_key_checks = 1;
--player_material
INSERT INTO player_material (id, material_id, player_id_player, amount)
VALUES (1, 1, 1, 10);
INSERT INTO player_material (id, material_id, player_id_player, amount)
VALUES (4, 2, 2, 10);
INSERT INTO player_material (id, material_id, player_id_player, amount)
VALUES (5, 1, 2, 10);
INSERT INTO player_material (id, material_id, player_id_player, amount)
VALUES (6, 7, 2, 10);
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

INSERT INTO `player_artefact` (`id`, `lvl`, `artefact_id`, `player_id_player`)
VALUES (1, 1, 1, 1),
       (2, 2, 2, 2),
       (3, 3, 3, 3),
       (8, 10, 1, 2),
       (9, 10, 2, 2),
       (10, 10, 3, 2),
       (11, 10, 4, 2),
       (12, 10, 5, 2),
       (13, 10, 6, 2),
       (833, 1, 1, 1),
       (834, 1, 1, 1),
       (835, 1, 1, 1),
       (836, 1, 9, 1),
       (837, 1, 1, 1),
       (838, 1, 5, 1),
       (839, 1, 1, 1),
       (840, 1, 1, 1),
       (841, 1, 2, 1),
       (842, 2, 4, 1),
       (843, 1, 1, 1),
       (844, 1, 2, 1),
       (845, 1, 7, 1),
       (846, 1, 8, 1),
       (847, 1, 9, 1),
       (848, 1, 7, 1),
       (849, 1, 4, 1),
       (850, 1, 5, 1),
       (851, 1, 4, 1),
       (852, 1, 5, 1),
       (853, 1, 6, 1),
       (854, 1, 4, 1),
       (855, 0, 6, 1),
       (856, 2, 1, 1),
       (857, 2, 7, 1),
       (858, 2, 2, 1);

--characterartefact

INSERT INTO `characteratrefact` (`player_character_id`, `player_artefact_id`)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (10, 8),
       (10, 9),
       (10, 10),
       (11, 11),
       (12, 12),
       (19, 836),
       (19, 837),
       (20, 838),
       (20, 839),
       (21, 840),
       (22, 841),
       (23, 842),
       (24, 843),
       (25, 844),
       (25, 845),
       (27, 846),
       (27, 847),
       (27, 848),
       (28, 849),
       (29, 850),
       (30, 851),
       (31, 852),
       (32, 853),
       (33, 854),
       (36, 855),
       (37, 856),
       (38, 857),
       (39, 858);

--character_chest

INSERT INTO `character_chest` (`chest_id_chest`, `character_id`)
VALUES (6, 1),
       (7, 1),
       (6, 2),
       (7, 2),
       (8, 3),
       (7, 4),
       (7, 5),
       (7, 6),
       (6, 7),
       (7, 7),
       (7, 8),
       (8, 9),
       (7, 10),
       (8, 11),
       (6, 12),
       (7, 12),
       (6, 13),
       (7, 13),
       (8, 14),
       (7, 15);
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
INSERT INTO player_role (Player_player_id, role_id)
VALUES (1, 1);
INSERT INTO player_role (Player_player_id, role_id)
VALUES (1, 2);
INSERT INTO player_role (Player_player_id, role_id)
VALUES (2, 2);
INSERT INTO player_role (Player_player_id, role_id)
VALUES (3, 2);
INSERT INTO player_role (Player_player_id, role_id)
VALUES (1, 3);
--party NAME
INSERT INTO `party` (`id`, `name`, `player_id_player`)
VALUES (1, 'test', 1),
       (2, 'Super party', 2),
       (3, 'Extra Party', 3),
       (7, 'First Trial', 1),
       (8, 'Second Trial', 1),
       (9, 'Third Trial', 1),
       (10, 'Fentanyl Cave', 1),
       (11, 'EGirl Lair', 1),
       (12, 'Pudzian Gym', 1),
       (21, 'Winter Fun', 1),
       (22, 'Suwako Guard', 1),
       (23, 'Carpenters', 1),
       (24, 'Iron Mine', 1),
       (25, 'Gold Mine', 1),
       (26, 'Crystal Mine', 1),
       (27, 'Cow Farm', 1),
       (28, 'Elemental Mine', 1);

--dungeonfloor

INSERT INTO `dungeonfloor` (`id`, `balance_reward`, `depth`, `dungeon_id`, `party_id`)
VALUES (5, 150, 1, 7, 7),
       (6, 300, 2, 7, 8),
       (7, 450, 3, 7, 9),
       (8, 5, 1, 9, 10),
       (9, 5, 2, 9, 11),
       (10, 5, 3, 9, 12),
       (19, 150, 1, 8, 21),
       (20, 150, 1, 10, 22),
       (21, 0, 1, 11, 23),
       (22, 0, 2, 11, 24),
       (23, 0, 3, 11, 25),
       (24, 0, 4, 11, 26),
       (25, 0, 5, 11, 27),
       (26, 0, 6, 11, 28);

--player_dungeonfloor

--Artefact_Reward_
INSERT INTO `artefact_reward` (`id`, `quantity`, `artefact_id`, `dungeon_floor_id`)
VALUES (10, 15, 9, 19),
       (11, 15, 8, 19),
       (12, 15, 7, 19),
       (13, 2, 1, 8),
       (14, 2, 2, 8),
       (15, 2, 3, 8),
       (16, 2, 7, 9),
       (17, 2, 8, 9),
       (18, 2, 9, 9),
       (19, 2, 4, 10),
       (20, 2, 5, 10),
       (21, 2, 6, 10);
-- --material_reward
INSERT INTO `material_reward` (`id`, `quantity`, `dungeon_floor_id`, `material_id`)
VALUES (2, 69, 19, 8),
       (3, 69, 19, 7),
       (4, 69, 19, 1),
       (5, 69, 19, 2),
       (7, 69, 19, 4),
       (8, 69, 19, 5),
       (9, 69, 19, 3),
       (10, 96, 19, 6),
       (11, 10, 25, 3),
       (12, 10, 23, 4),
       (13, 10, 21, 1),
       (14, 10, 22, 2),
       (15, 10, 24, 5),
       (16, 10, 26, 6),
       (17, 10, 26, 7),
       (18, 10, 26, 8);
-- --weapon_reward
INSERT INTO `weapon_reward` (`id`, `quantity`, `dungeon_floor_id`, `weapon_id`)
VALUES (4, 1, 19, 6),
       (5, 3, 19, 14),
       (6, 1, 19, 11),
       (7, 1, 5, 15),
       (8, 1, 6, 3),
       (9, 1, 7, 12);
--weapon_chest

INSERT INTO `weapon_chest` (`weapon_id`, `chest_id_chest`)
VALUES (1, 5),
       (2, 5),
       (3, 5),
       (4, 5),
       (5, 5),
       (6, 5),
       (7, 5),
       (8, 5),
       (9, 5),
       (10, 5),
       (11, 5),
       (12, 5),
       (13, 5),
       (14, 5),
       (15, 5),
       (1, 6),
       (13, 6),
       (15, 6),
       (1, 8),
       (2, 8),
       (8, 8),
       (10, 8),
       (14, 8);
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
       (17, 26, 3, 3),
       (18, 50, 1, 3),
       (19, 30, 4, 3),
       (20, 80, 5, 3),
       (21, 35, 5, 1),
       (22, 10, 5, 4);

-- player_chestitem

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


INSERT INTO `partycharacter` (`player_character_id`, `party_id`)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (10, 2),
       (11, 2),
       (12, 2),
       (13, 2),
       (14, 3),
       (15, 3),
       (16, 3),
       (17, 3),
       (19, 7),
       (20, 7),
       (22, 7),
       (32, 7),
       (23, 8),
       (40, 8),
       (47, 8),
       (50, 8),
       (53, 9),
       (56, 9),
       (58, 9),
       (63, 9),
       (4, 10),
       (22, 10),
       (37, 10),
       (52, 10),
       (40, 11),
       (46, 11),
       (48, 11),
       (51, 11),
       (53, 12),
       (56, 12),
       (58, 12),
       (63, 12),
       (54, 21),
       (56, 21),
       (60, 21),
       (66, 21),
       (54, 22),
       (60, 22),
       (62, 22),
       (65, 22),
       (1, 23),
       (6, 23),
       (30, 23),
       (61, 23),
       (20, 24),
       (21, 24),
       (24, 24),
       (64, 24),
       (5, 25),
       (22, 25),
       (25, 25),
       (62, 25),
       (24, 26),
       (57, 26),
       (62, 26),
       (65, 26),
       (1, 27),
       (6, 27),
       (30, 27),
       (32, 27),
       (21, 28),
       (23, 28),
       (24, 28),
       (60, 28);

--player_weapon

INSERT INTO `player_weapon` (`id`, `ascension`, `lvl`, `player_id_player`, `weapon_id`)
VALUES (1, 1, 1, 1, 1),
       (2, 2, 2, 2, 2),
       (3, 3, 3, 3, 3),
       (4, 1, 11, 2, 2),
       (5, 1, 11, 2, 9),
       (6, 1, 11, 2, 11),
       (7, 1, 11, 2, 14),
       (9, 1, 11, 3, 5),
       (10, 1, 11, 3, 7),
       (11, 1, 11, 3, 12),
       (37, 1, 1, 1, 1),
       (38, 1, 1, 1, 4),
       (39, 1, 1, 1, 10),
       (40, 1, 1, 1, 7),
       (41, 1, 2, 1, 4),
       (42, 1, 1, 1, 1),
       (43, 1, 1, 1, 2),
       (44, 1, 1, 1, 4),
       (45, 1, 1, 1, 6),
       (46, 1, 1, 1, 5),
       (47, 1, 1, 1, 7),
       (48, 1, 1, 1, 8),
       (49, 1, 1, 1, 8),
       (50, 1, 1, 1, 10),
       (51, 1, 1, 1, 11),
       (52, 1, 1, 1, 12),
       (53, 1, 1, 1, 15),
       (54, 1, 1, 1, 14),
       (55, 1, 1, 1, 13),
       (56, 1, 2, 1, 1),
       (57, 1, 2, 1, 1),
       (58, 1, 2, 1, 2),
       (59, 1, 2, 1, 5),
       (60, 1, 2, 1, 6),
       (61, 1, 2, 1, 5),
       (62, 1, 2, 1, 8),
       (63, 1, 2, 1, 9),
       (64, 1, 2, 1, 8),
       (65, 1, 2, 1, 12),
       (66, 1, 2, 1, 10),
       (67, 1, 2, 1, 11),
       (68, 1, 2, 1, 15),
       (69, 1, 2, 1, 14),
       (70, 1, 3, 1, 2),
       (71, 1, 3, 1, 3),
       (72, 1, 3, 1, 2),
       (73, 1, 3, 1, 5),
       (74, 1, 3, 1, 6),
       (75, 1, 3, 1, 4),
       (76, 1, 3, 1, 7),
       (77, 1, 3, 1, 7),
       (78, 1, 3, 1, 9),
       (79, 1, 3, 1, 12),
       (80, 1, 3, 1, 11),
       (81, 1, 3, 1, 12),
       (82, 1, 3, 1, 15),
       (83, 1, 3, 1, 15),
       (84, 1, 3, 1, 13);


UPDATE player_character
SET wielded_weapon = 4
WHERE id = 10;

UPDATE player_character
SET wielded_weapon = 5
WHERE id = 11;

UPDATE player_character
SET wielded_weapon = 6
WHERE id = 12;

UPDATE player_character
SET wielded_weapon = 7
WHERE id = 13;

UPDATE player_character
SET wielded_weapon = 9
WHERE id = 15;

UPDATE player_character
SET wielded_weapon = 10
WHERE id = 16;

UPDATE player_character
SET wielded_weapon = 11
WHERE id = 17;