DELETE FROM premium_purchase;
DELETE FROM player_weapon;
DELETE FROM partycharacter;
DELETE FROM stat_weapon;
DELETE FROM player_chestitem;
DELETE FROM stat_class;
DELETE FROM stat_affiliation;
DELETE FROM weapon_chest;
DELETE FROM weapon_reward;
DELETE FROM material_reward;
DELETE FROM Player_Role;
DELETE FROM gacha.role;
DELETE FROM materialweaponclass;
DELETE FROM character_chest;
DELETE FROM characteratrefact;
DELETE FROM player_artefact;
DELETE FROM materialclass;
DELETE FROM materialaffilation;
DELETE FROM materialelement;
DELETE FROM player_material;
DELETE FROM player_character;
DELETE FROM gacha.character;
DELETE FROM weapon;
DELETE FROM stat_artifact;
DELETE FROM stat_artefactSet;
DELETE FROM gacha.class;
DELETE FROM player_purchase;
DELETE FROM ingamecurrencyPurchase;
DELETE FROM paymentmethod;
DELETE FROM element;
DELETE FROM weaponClass;
DELETE FROM statistic;
DELETE FROM material;
DELETE FROM chest;
DELETE FROM collection;
DELETE FROM artefact_set;
DELETE FROM gacha.set;
DELETE FROM player_dungeonfloor;
DELETE FROM Artefact_Reward;
DELETE FROM dungeonfloor;
DELETE FROM party;
DELETE FROM player;
DELETE FROM Dungeon;
DELETE FROM artefact;
DELETE FROM rarity;
DELETE FROM affilation;



-- affilation
INSERT INTO affilation (id,name,requirement) VALUES (1,'Elf',1);
INSERT INTO affilation (id,name,requirement) VALUES (2,'Barbarian',2);
INSERT INTO affilation (id,name,requirement) VALUES (3,'Gensokyo',3);
INSERT INTO affilation (id,name,requirement) VALUES (4,'Wrocław',4);
INSERT INTO affilation (id,name,requirement) VALUES (5,'Warszawa',5);
INSERT INTO affilation (id,name,requirement) VALUES (6,'Podlasie',6);
INSERT INTO affilation (id,name,requirement) VALUES (7,'Uć',7);
INSERT INTO affilation (id,name,requirement) VALUES (8,'Porażka życiowa',8);
INSERT INTO affilation (id,name,requirement) VALUES (9,'Chad',9);
--rarity
INSERT INTO rarity (id,name,shortcut,weight) values (1,'Mythic','MYT',4);
INSERT INTO rarity (id,name,shortcut,weight) values (2,'Legendary','LEG',1);
INSERT INTO rarity (id,name,shortcut,weight) values (3,'Epic','EPC',10);
INSERT INTO rarity (id,name,shortcut,weight) values (4,'Uncommon','UCM',25);
INSERT INTO rarity (id,name,shortcut,weight) values (5,'Common','CMN',60);
--artefact
INSERT INTO artefact (id,name,type,rarity_id) values (1,'Projektor',1,1);
INSERT INTO artefact (id,name,type,rarity_id) values (2,'Wskaznik',1,2);
INSERT INTO artefact (id,name,type,rarity_id) values (3,'Was Tomaszewa',0,3);
--player !!! ADMIN MA ZAWSZE MIEC ID 1 !!!
INSERT INTO player (id_player,nick,birth_date,join_date,active_party,player_balance,hashed_password,pity_roll_status,pvpwins,pvplooses,elopoints, premium_left, stamina) values (1,'admin','1900-01-01 00:00:00','2022-01-01 00:00:00',1,10000,'$2a$12$qmuu8mn/qN1D.ykSKYMJp.JNWJzL2fL77VHtd7/uzlpzOWv8r5dBC',1,1,1,1,99999, 100);
INSERT INTO player (id_player,nick,birth_date,join_date,active_party,player_balance,hashed_password,pity_roll_status,pvpwins,pvplooses,elopoints, premium_left, stamina) values (2,'user','1900-01-01 00:00:00','2022-01-01 00:00:00',2,9999,'$2a$12$X2jrACo9ErTffy3JKUTZFuSr/fndHEIEkle5btouwO25TYv14cgQe',1,1,1,1,0, 100);
INSERT INTO player (id_player,nick,birth_date,join_date,active_party,player_balance,hashed_password,pity_roll_status,pvpwins,pvplooses,elopoints, premium_left, stamina) values (3,'autist','1900-01-01 00:00:00','2022-01-01 00:00:00',3,9999,'$2a$12$X2jrACo9ErTffy3JKUTZFuSr/fndHEIEkle5btouwO25TYv14cgQe',1,1,1,1,0, 100);
--Dungeon
INSERT INTO Dungeon (id,name,released_at,expires_at) values (1,'jurna wieza','2022-01-01 00:00:00',null);
INSERT INTO Dungeon (id,name,released_at,expires_at) values (2,'piwnica','2000-01-01 00:00:00','2002-01-01 00:00:00');
INSERT INTO Dungeon (id,name,released_at,expires_at) values (3,'cyberpunk','2037-01-01 00:00:00',null);
INSERT INTO Dungeon (id,name,released_at,expires_at) values (4,'PJATK','2018-01-01 00:00:00','2025-01-01 00:00:00');
--set
INSERT INTO gacha.set (id,name) values (1,'choker set');
INSERT INTO gacha.set (id,name) values (2,'test set');
INSERT INTO gacha.set (id,name) values (3,'maid suit set');
INSERT INTO gacha.set (id,name) values (4,'lecturer set');
--artefact_set
INSERT INTO artefact_set (set_id,artefact_id) values (1,1);
INSERT INTO artefact_set (set_id,artefact_id) values (2,2);
INSERT INTO artefact_set (set_id,artefact_id) values (3,3);
--collection
INSERT INTO collection (idcollection,name) values (1,'Winter collection');
INSERT INTO collection (idcollection,name) values (2,'Summer collection');
INSERT INTO collection (idcollection,name) values (3,'Special collection');
INSERT INTO collection (idcollection,name) values (4,'Pay2Win collection');
--chest
INSERT INTO chest (id_chest,name,collection_idcollection,released_at,expires_at,price) values (1,'basic chest',1,'2022-01-01 00:00:00','2030-01-01 00:00:00',1);
INSERT INTO chest (id_chest,name,collection_idcollection,released_at,expires_at,price) values (2,'rare chest',2,'2024-01-01 00:00:00','2030-01-01 00:00:00',2);
INSERT INTO chest (id_chest,name,collection_idcollection,released_at,expires_at,price) values (3,'super rare chest',3,'2022-01-01 00:00:00','2030-01-01 00:00:00',3);
INSERT INTO chest (id_chest,name,collection_idcollection,released_at,expires_at,price) values (4,'pay2win chest',4,'2023-01-01 00:00:00','2137-01-06 00:00:00',4);
--material
INSERT INTO material (id,name) values (1, 'Wood');
INSERT INTO material (id,name) values (2, 'Iron');
INSERT INTO material (id,name) values (3, 'Leather');
--statistic
INSERT INTO statistic (stat_id,name,short_name) values (1, 'Health','HP');
INSERT INTO statistic (stat_id,name,short_name) values (2, 'Attack','ATK');
INSERT INTO statistic (stat_id,name,short_name) values (3, 'Initiative','INI');
--weaponClass
INSERT INTO weaponClass(id,name,short_name) values (1, 'cleric','CLR');
INSERT INTO weaponClass(id,name,short_name) values (2, 'archer','ARH');
INSERT INTO weaponClass(id,name,short_name) values (3, 'warrior','WAR');
INSERT INTO weaponClass(id,name,short_name) values (4, 'tank','TNK');
INSERT INTO weaponClass(id,name,short_name) values (5, 'assasin','ASS');
--element
INSERT INTO element (id,name) values (1, 'Fire');
INSERT INTO element (id,name) values (2, 'Ice');
INSERT INTO element (id,name) values (3, 'Wind');
INSERT INTO element (id,name) values (4, 'Earth');
INSERT INTO element (id,name) values (5, 'Pysznepl');
--paymentmethod
INSERT INTO paymentmethod (IDPayment_Method,Name) values (1,'PayPal');
INSERT INTO paymentmethod (IDPayment_Method,Name) values (2,'SMS');
INSERT INTO paymentmethod (IDPayment_Method,Name) values (3,'social credits');
INSERT INTO paymentmethod (IDPayment_Method,Name) values (4,'BLIK');
--ingamecurrencyPurchase
INSERT INTO ingamecurrencyPurchase (idigcp,volume,price) VALUES (1,100,4.99);
INSERT INTO ingamecurrencyPurchase (idigcp,volume,price) VALUES (2,500,18.99);
INSERT INTO ingamecurrencyPurchase (idigcp,volume,price) VALUES (3,2137,42.00);
--player_purchase
INSERT INTO player_purchase (id,player_id_player,payment_method_idpayment_method,in_game_currency_purchase_idigcp,bought_at) values (1,1,1,1,curdate());
INSERT INTO player_purchase (id,player_id_player,payment_method_idpayment_method,in_game_currency_purchase_idigcp,bought_at) values (2,2,2,2,curdate());
INSERT INTO player_purchase (id,player_id_player,payment_method_idpayment_method,in_game_currency_purchase_idigcp,bought_at) values (3,3,3,3,curdate());
--class
INSERT INTO gacha.class (id,name,weapon_class,shortcut) VALUES (1,'cleric',1,'CLR');
INSERT INTO gacha.class (id,name,weapon_class,shortcut) VALUES (2,'archer',2,'ARH');
INSERT INTO gacha.class (id,name,weapon_class,shortcut) VALUES (3,'warrior',3,'WAR');
INSERT INTO gacha.class (id,name,weapon_class,shortcut) VALUES (4,'tank',4,'TNK');
INSERT INTO gacha.class (id,name,weapon_class,shortcut) VALUES (5,'assasin',5,'ASS');
--stat_artefactSet
INSERT INTO stat_artefactSet (id,value,set_id,statistic_stat_id) values (1,200,1,1);
INSERT INTO stat_artefactSet (id,value,set_id,statistic_stat_id) values (2,500,2,2);
INSERT INTO stat_artefactSet (id,value,set_id,statistic_stat_id) values (3,800,3,3);
--stat_artifact
INSERT INTO stat_artifact (id,statistic_stat_id,artefact_id,value) values (1,1,1,100);
INSERT INTO stat_artifact (id,statistic_stat_id,artefact_id,value) values (2,2,2,200);
INSERT INTO stat_artifact (id,statistic_stat_id,artefact_id,value) values (3,3,3,300);
--weapon
INSERT INTO weapon (id,name,element_id,rarity_id,weapon_class_id) VALUES (1,'Sword',1,1,1);
INSERT INTO weapon (id,name,element_id,rarity_id,weapon_class_id) VALUES (2,'Bow',2,2,2);
INSERT INTO weapon (id,name,element_id,rarity_id,weapon_class_id) VALUES (3,'Almanac',3,3,3);
INSERT INTO weapon (id,name,element_id,rarity_id,weapon_class_id) VALUES (4,'Shield',4,4,4);
INSERT INTO weapon (id,name,element_id,rarity_id,weapon_class_id) VALUES (5,'Fork',5,5,5);
--character
INSERT INTO gacha.character (id,name,affilation_id,ability,class_id,rarity_id) VALUES (1,'weeb',1,1,1,1);
INSERT INTO gacha.character (id,name,affilation_id,ability,class_id,rarity_id) VALUES (2,'warrior',2,2,2,2);
INSERT INTO gacha.character (id,name,affilation_id,ability,class_id,rarity_id) VALUES (3,'waifu',3,2,3,3);
INSERT INTO gacha.character (id,name,affilation_id,ability,class_id,rarity_id) VALUES (4,'Ed',4,3,4,4);
INSERT INTO gacha.character (id,name,affilation_id,ability,class_id,rarity_id) VALUES (5,'Bob',5,4,5,5);
INSERT INTO gacha.character (id,name,affilation_id,ability,class_id,rarity_id) VALUES (6,'Greg',6,1,2,2);
INSERT INTO gacha.character (id,name,affilation_id,ability,class_id,rarity_id) VALUES (7,'George',7,4,4,5);
INSERT INTO gacha.character (id,name,affilation_id,ability,class_id,rarity_id) VALUES (8,'Krzysztof Woś',8,3,3,4);
INSERT INTO gacha.character (id,name,affilation_id,ability,class_id,rarity_id) VALUES (9,'Stefan',9,2,1,3);
--Player_Character
INSERT INTO player_character (id,player_id_player,character_id,ascention,lvl) VALUES (1,1,1,1,1);
INSERT INTO player_character (id,player_id_player,character_id,ascention,lvl) VALUES (2,2,2,2,2);
INSERT INTO player_character (id,player_id_player,character_id,ascention,lvl) VALUES (3,3,3,3,3);
INSERT INTO player_character (id,player_id_player,character_id,ascention,lvl) VALUES (4,1,4,3,2);
INSERT INTO player_character (id,player_id_player,character_id,ascention,lvl) VALUES (5,1,5,7,3);
INSERT INTO player_character (id,player_id_player,character_id,ascention,lvl) VALUES (6,1,6,3,1);
INSERT INTO player_character (id,player_id_player,character_id,ascention,lvl) VALUES (7,2,7,7,2);
INSERT INTO player_character (id,player_id_player,character_id,ascention,lvl) VALUES (8,2,8,3,4);
INSERT INTO player_character (id,player_id_player,character_id,ascention,lvl) VALUES (9,2,9,3,3);
--player_material
INSERT INTO player_material (id,material_id,player_id_player,amount) VALUES (1,1,1,10);
INSERT INTO player_material (id,material_id,player_id_player,amount) VALUES (2,2,2,10);
INSERT INTO player_material (id,material_id,player_id_player,amount) VALUES (3,3,3,10);
--materialelement
INSERT INTO materialelement (id,material_id,element_id,base_amount,per_lvl_amount) VALUES (1,1,1,1,1);
INSERT INTO materialelement (id,material_id,element_id,base_amount,per_lvl_amount) VALUES (2,2,2,20,20);
INSERT INTO materialelement (id,material_id,element_id,base_amount,per_lvl_amount) VALUES (3,3,3,300,300);
--materialaffilation
INSERT INTO materialaffilation (id,material_id,affilation_id,base_amount,per_lvl_amount) VALUES (1,1,1,1,1);
INSERT INTO materialaffilation (id,material_id,affilation_id,base_amount,per_lvl_amount) VALUES (2,2,2,20,20);
INSERT INTO materialaffilation (id,material_id,affilation_id,base_amount,per_lvl_amount) VALUES (3,3,3,300,300);
--materialclass
INSERT INTO materialclass (id,material_id,class_id,base_amount,per_lvl_amount) VALUES (1,1,1,1,1);
INSERT INTO materialclass (id,material_id,class_id,base_amount,per_lvl_amount) VALUES (2,2,2,20,20);
INSERT INTO materialclass (id,material_id,class_id,base_amount,per_lvl_amount) VALUES (3,3,3,300,300);
--player_artefact
INSERT INTO player_artefact (id,player_id_player,artefact_id,lvl) VALUES (1,1,1,1);
INSERT INTO player_artefact (id,player_id_player,artefact_id,lvl) VALUES (2,2,2,2);
INSERT INTO player_artefact (id,player_id_player,artefact_id,lvl) VALUES (3,3,3,3);
--characterartefact
INSERT INTO characteratrefact (player_character_id,player_artefact_id) VALUES (1,1);
INSERT INTO characteratrefact (player_character_id,player_artefact_id) VALUES (1,2);
INSERT INTO characteratrefact (player_character_id,player_artefact_id) VALUES (2,3);
--character_chest
INSERT INTO character_chest (chest_id_chest,character_id) VALUES (1,1);
INSERT INTO character_chest (chest_id_chest,character_id) VALUES (1,2);
INSERT INTO character_chest (chest_id_chest,character_id) VALUES (2,3);
--materialweaponclass
INSERT INTO materialweaponclass (id,material_id,weapon_class_id,base_amount,per_lvl_amount) VALUES (1,1,1,1,1);
INSERT INTO materialweaponclass (id,material_id,weapon_class_id,base_amount,per_lvl_amount) VALUES (2,2,2,20,20);
INSERT INTO materialweaponclass (id,material_id,weapon_class_id,base_amount,per_lvl_amount) VALUES (3,3,3,30,300);
--role
INSERT INTO gacha.role (id,name) VALUES (1,'ADMIN');
INSERT INTO gacha.role (id,name) VALUES (2,'USER');
INSERT INTO gacha.role (id,name) VALUES (3,'PREMIUM');
--Player_Role
INSERT INTO Player_Role (Player_player_id,role_id ) VALUES (1,1);
INSERT INTO Player_Role (Player_player_id,role_id ) VALUES (1,2);
INSERT INTO Player_Role (Player_player_id,role_id ) VALUES (2,2);
INSERT INTO Player_Role (Player_player_id,role_id ) VALUES (3,2);
INSERT INTO Player_Role (Player_player_id,role_id ) VALUES (1,3);
--party NAME
INSERT INTO party (id,player_id_player,name,move_order) VALUES (1,1,1,1234);
INSERT INTO party (id,player_id_player,name,move_order) VALUES (2,2,2,4321);
INSERT INTO party (id,player_id_player,name,move_order) VALUES (3,3,3,3214);
--dungeonfloor
INSERT INTO dungeonfloor (id,dungeon_id,depth,party_id) values (1,1,1,1);
INSERT INTO dungeonfloor (id,dungeon_id,depth,party_id) values (2,1,2,1);
INSERT INTO dungeonfloor (id,dungeon_id,depth,party_id) values (3,2,1,1);
INSERT INTO dungeonfloor (id,dungeon_id,depth,party_id) values (4,4,10,1);
--player_dungeonfloor
INSERT INTO player_dungeonfloor (id,dungeon_floor_id,player_id_player,clear_date) VALUES (1,1,1,curdate());
INSERT INTO player_dungeonfloor (id,dungeon_floor_id,player_id_player,clear_date) VALUES (2,2,2,'2022-01-01 00:00:00');
INSERT INTO player_dungeonfloor (id,dungeon_floor_id,player_id_player,clear_date) VALUES (3,3,1,curdate());
--Artefact_Reward_
INSERT INTO Artefact_Reward(id,quantity,artefact_id,dungeon_floor_id) values (1,1,1,1);
INSERT INTO Artefact_Reward(id,quantity,artefact_id,dungeon_floor_id) values (2,2,2,2);
INSERT INTO Artefact_Reward(id,quantity,artefact_id,dungeon_floor_id) values (3,3,3,3);
--material_reward
INSERT INTO material_reward (id, material_id,dungeon_floor_id,quantity) VALUES (1,1,1,1);
INSERT INTO material_reward (id,material_id ,dungeon_floor_id,quantity) VALUES (2,2,2,20);
INSERT INTO material_reward (id,material_id ,dungeon_floor_id,quantity) VALUES (3,3,3,300);
--weapon_reward
INSERT INTO weapon_reward (id, weapon_id,dungeon_floor_id,quantity) VALUES (1,1,1,1);
INSERT INTO weapon_reward (id,weapon_id ,dungeon_floor_id,quantity) VALUES (2,2,2,20);
INSERT INTO weapon_reward (id,weapon_id ,dungeon_floor_id,quantity) VALUES (3,3,3,300);
--weapon_chest
INSERT INTO weapon_chest (weapon_id,chest_id_chest) VALUES (1,1);
INSERT INTO weapon_chest (weapon_id,chest_id_chest) VALUES (2,2);
INSERT INTO weapon_chest (weapon_id,chest_id_chest) VALUES (3,1);
--stat_affiliation
INSERT INTO stat_affiliation (id,value,affiliation_id,statistic_stat_id) VALUES (1,1,1,1);
INSERT INTO stat_affiliation (id,value,affiliation_id,statistic_stat_id) VALUES (2,2,2,2);
INSERT INTO stat_affiliation (id,value,affiliation_id,statistic_stat_id) VALUES (3,3,3,3); 	
--stat_class
INSERT INTO stat_class (id,value, class_id, statistic_stat_id) VALUES (1,1,1,1);
INSERT INTO stat_class (id,value, class_id, statistic_stat_id) VALUES (2,2,2,2);
INSERT INTO stat_class (id,value, class_id, statistic_stat_id) VALUES (3,3,3,3);

-- player_chestitem
INSERT INTO player_chestitem (id,player_id_player,chest_id_chest,bought_at) VALUES (1,1,1,curdate());
INSERT INTO player_chestitem (id,player_id_player,chest_id_chest,bought_at) VALUES (2,2,2,curdate());
INSERT INTO player_chestitem (id,player_id_player,chest_id_chest,bought_at) VALUES (3,2,2,'2000-01-01 00:00:00');
--stat_weapon
INSERT INTO stat_weapon(id,statistic_stat_id,weapon_id,value) values (1,1,1,1);
INSERT INTO stat_weapon(id,statistic_stat_id,weapon_id,value) values (2,2,2,20);
INSERT INTO stat_weapon(id,statistic_stat_id,weapon_id,value) values (3,3,3,300);
--partycharacter
INSERT INTO partycharacter (party_id,player_character_id) VALUES (1,1);
INSERT INTO partycharacter (party_id,player_character_id) VALUES (1,2);
INSERT INTO partycharacter (party_id,player_character_id) VALUES (2,8);
INSERT INTO partycharacter (party_id,player_character_id) VALUES (1,3);
INSERT INTO partycharacter (party_id,player_character_id) VALUES (1,4);
INSERT INTO partycharacter (party_id,player_character_id) VALUES (2,5);
INSERT INTO partycharacter (party_id,player_character_id) VALUES (2,6);
INSERT INTO partycharacter (party_id,player_character_id) VALUES (2,7);
--player_weapon
INSERT INTO player_weapon (id,  player_id_player, weapon_id, ascension, lvl) VALUES (1,1,1,1,1);
INSERT INTO player_weapon (id, wielding_character, player_id_player, weapon_id, ascension, lvl) VALUES (2,2,2,2,2,2);
INSERT INTO player_weapon (id, wielding_character, player_id_player, weapon_id, ascension, lvl) VALUES (3,3,3,3,3,3);