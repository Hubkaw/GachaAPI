-- affilation
INSERT INTO affilation (id,name,requirement) VALUES (1,'test1',1);
INSERT INTO affilation (id,name,requirement) VALUES (2,'test2',2);
INSERT INTO affilation (id,name,requirement) VALUES (3,'test3',3);
--rarity
INSERT INTO rarity (id,name,shortcut,weight) values (1,'rarity1','rar',1);
INSERT INTO rarity (id,name,shortcut,weight) values (2,'rarity2','uwu',2);
INSERT INTO rarity (id,name,shortcut,weight) values (3,'rarity3','owo',3);
--artefact
INSERT INTO artefact (id,name,type,rarity_id) values (1,'art1','zrob z',1);
INSERT INTO artefact (id,name,type,rarity_id) values (2,'art2','tego',2);
INSERT INTO artefact (id,name,type,rarity_id) values (3,'art3','tabele',3);
--player id z party?
INSERT INTO player (id_player,nick,birth_date,join_date,active_party,player_balance,hashed_password,pity_roll_status,pvpwins,pvplooses,elopoints) values (1,'testplayer1','1900-01-01 00:00:00','2022-01-01 00:00:00',1,10000,'xDDDDDDDDD',1,1,1,1);
INSERT INTO player (id_player,nick,birth_date,join_date,active_party,player_balance,hashed_password,pity_roll_status,pvpwins,pvplooses,elopoints) values (2,'testplayer2','1900-01-01 00:00:00','2022-01-01 00:00:00',2,1,'xDDDDDDDDD',1,1,1,1);
INSERT INTO player (id_player,nick,birth_date,join_date,active_party,player_balance,hashed_password,pity_roll_status,pvpwins,pvplooses,elopoints) values (3,'testplayer3','1900-01-01 00:00:00','2022-01-01 00:00:00',3,0,'xDDDDDDDDD',1,1,1,1);
--Dungeon
INSERT INTO Dungeon (id,name,released_at,expires_at) values (1,'jurna wieza','2022-01-01 00:00:00',null);
INSERT INTO Dungeon (id,name,released_at,expires_at) values (2,'piwnica','2000-01-01 00:00:00','2002-01-01 00:00:00');
INSERT INTO Dungeon (id,name,released_at,expires_at) values (3,'cyberpunk','2037-01-01 00:00:00',null);
--dungeonfloor
INSERT INTO dungeonfloor (id,dungeon_id,depth) values (1,1,1);
INSERT INTO dungeonfloor (id,dungeon_id,depth) values (2,1,2);
INSERT INTO dungeonfloor (id,dungeon_id,depth) values (3,2,1);
--player_dungeonfloor
INSERT INTO player_dungeonfloor (id,dungeon_floor_id,player_id_player,clear_date) VALUES (1,1,1,curdate());
INSERT INTO player_dungeonfloor (id,dungeon_floor_id,player_id_player,clear_date) VALUES (2,2,2,'2022-01-01 00:00:00');
INSERT INTO player_dungeonfloor (id,dungeon_floor_id,player_id_player,clear_date) VALUES (3,3,1,curdate());
--Artefact_Reward_
INSERT INTO Artefact_Reward(id,quantity,artefact_id,dungeon_floor_id) values (1,1,1,1);
INSERT INTO Artefact_Reward(id,quantity,artefact_id,dungeon_floor_id) values (2,2,2,2);
INSERT INTO Artefact_Reward(id,quantity,artefact_id,dungeon_floor_id) values (3,3,3,3);
--set
INSERT INTO gacha.set (id,name) values (1,'choker set');
INSERT INTO gacha.set (id,name) values (2,'test set');
INSERT INTO gacha.set (id,name) values (3,'maid suit set');
--artefact_set
INSERT INTO artefact_set (set_id,artefact_id) values (1,1);
INSERT INTO artefact_set (set_id,artefact_id) values (2,2);
INSERT INTO artefact_set (set_id,artefact_id) values (3,3);
--collection
INSERT INTO collection (idcollection,name) values (1,'coll1');
INSERT INTO collection (idcollection,name) values (2,'coll2');
INSERT INTO collection (idcollection,name) values (3,'coll3');
--chest
INSERT INTO chest (id_chest,name,collection_idcollection,released_at,expires_at,price) values (1,'chest1',1,'2022-01-01 00:00:00',null,1);
INSERT INTO chest (id_chest,name,collection_idcollection,released_at,expires_at,price) values (2,'chest2',2,'2024-01-01 00:00:00',null,2);
INSERT INTO chest (id_chest,name,collection_idcollection,released_at,expires_at,price) values (3,'chest3',3,'2022-01-01 00:00:00','2030-01-01 00:00:00',3);
--material
INSERT INTO material (id,name) values (1, 'material1');
INSERT INTO material (id,name) values (2, 'material2');
INSERT INTO material (id,name) values (3, 'material3');
--statistic
INSERT INTO statistic (stat_id,name,short_name) values (1, 'strength','STR');
INSERT INTO statistic (stat_id,name,short_name) values (2, 'agility','AGI');
INSERT INTO statistic (stat_id,name,short_name) values (3, 'inteligence','INT');
--weaponClass
INSERT INTO weaponClass(id,name,short_name) values (1, 'cleric','CLR');
INSERT INTO weaponClass(id,name,short_name) values (2, 'vtuber','VTB');
INSERT INTO weaponClass(id,name,short_name) values (3, 'furry','fur');
--element
INSERT INTO element (id,name) values (1, 'element1');
INSERT INTO element (id,name) values (2, 'element2');
INSERT INTO element (id,name) values (3, 'element3');
--paymentmethod
INSERT INTO paymentmethod (IDPayment_Method,Name) values (1,'PayPal');
INSERT INTO paymentmethod (IDPayment_Method,Name) values (2,'SMS');
INSERT INTO paymentmethod (IDPayment_Method,Name) values (3,'social credits');
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
INSERT INTO gacha.class (id,name,weapon_class,shortcut) VALUES (2,'ginger',2,'GIN');
INSERT INTO gacha.class (id,name,weapon_class,shortcut) VALUES (3,'walter white',3,'WHT');
--stat_artefactSet
INSERT INTO stat_artefactSet (id,value,set_id,statistic_stat_id) values (1,200,1,1);
INSERT INTO stat_artefactSet (id,value,set_id,statistic_stat_id) values (2,500,2,2);
INSERT INTO stat_artefactSet (id,value,set_id,statistic_stat_id) values (3,800,3,3);
--stat_artifact
INSERT INTO stat_artifact (id,statistic_stat_id,artefact_id,value) values (1,1,1,100);
INSERT INTO stat_artifact (id,statistic_stat_id,artefact_id,value) values (2,2,2,200);
INSERT INTO stat_artifact (id,statistic_stat_id,artefact_id,value) values (3,3,3,300);
--weapon
INSERT INTO weapon (id,name,element_id,rarity_id,weapon_class_id) VALUES (1,'club',1,1,1);
INSERT INTO weapon (id,name,element_id,rarity_id,weapon_class_id) VALUES (2,'club',2,2,2);
INSERT INTO weapon (id,name,element_id,rarity_id,weapon_class_id) VALUES (3,'club',3,3,3);
--character
INSERT INTO gacha.character (id,name,affilation_id,ability,class_id,rarity_id) VALUES (1,'weeb',1,1,1,1);
INSERT INTO gacha.character (id,name,affilation_id,ability,class_id,rarity_id) VALUES (2,'warrior',2,2,2,2);
INSERT INTO gacha.character (id,name,affilation_id,ability,class_id,rarity_id) VALUES (3,'waifu',3,3,3,3);
--Player_Character
INSERT INTO player_character (id,player_id_player,character_id,ascention,lvl) VALUES (1,1,1,1,1);
INSERT INTO player_character (id,player_id_player,character_id,ascention,lvl) VALUES (2,2,2,2,2);
INSERT INTO player_character (id,player_id_player,character_id,ascention,lvl) VALUES (3,3,3,3,3);
--player_material
INSERT INTO player_material (id,material_id,player_id_player,amount) VALUES (1,1,1,1);
INSERT INTO player_material (id,material_id,player_id_player,amount) VALUES (2,2,2,2);
INSERT INTO player_material (id,material_id,player_id_player,amount) VALUES (3,3,3,3);
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
INSERT INTO gacha.role (id,name) VALUES (3,'autist');
--Player_Role
INSERT INTO Player_Role (Player_player_id,role_id ) VALUES (1,1);
INSERT INTO Player_Role (Player_player_id,role_id ) VALUES (1,2);
INSERT INTO Player_Role (Player_player_id,role_id ) VALUES (2,2);
INSERT INTO Player_Role (Player_player_id,role_id ) VALUES (3,2);
INSERT INTO Player_Role (Player_player_id,role_id ) VALUES (3,3);
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
--party NAME IS INT, TO UPDATE
INSERT INTO party (id,player_id_player,name,move_order) VALUES (1,1,1,123456);
INSERT INTO party (id,player_id_player,name,move_order) VALUES (2,2,2,654321);
INSERT INTO party (id,player_id_player,name,move_order) VALUES (3,3,3,615243);
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
INSERT INTO partycharacter (party_id,player_character_id) VALUES (2,1);
--party_dungeonfloor
INSERT INTO party_dungeonfloor (party_id,dungeon_floor_ID) VALUES (1,1);
INSERT INTO party_dungeonfloor (party_id,dungeon_floor_ID) VALUES (2,2);
--player_weapon
INSERT INTO player_weapon (id, wielding_character, player_id_player, weapon_id, ascension, lvl) VALUES (1,1,1,1,1,1);
INSERT INTO player_weapon (id, wielding_character, player_id_player, weapon_id, ascension, lvl) VALUES (2,2,2,2,2,2);
INSERT INTO player_weapon (id, wielding_character, player_id_player, weapon_id, ascension, lvl) VALUES (3,3,3,3,3,3);