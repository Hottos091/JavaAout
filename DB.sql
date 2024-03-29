

-- Database Section
-- ________________

create database bazar;
use bazar;


-- Tables Section
-- _____________

create table SupplyOrder (
     code int not null auto_increment,
     supply_date timestamp not null,
     phonenumber_supplier varchar(64) not null,
     constraint SUPPLYORDER_PK primary key (code));

create table OrderLine (
     code int not null,
     label_ingredient varchar(64) not null,
     quantity int not null,
     constraint ORDERLINE_PK primary key(code, label_ingredient));

create table Ingredient (
     label_ingredient varchar(64) not null,
     in_stock_quantity int,
     constraint INGREDIENT_PK primary key (label_ingredient));

create table Composition (
     label_ingredient varchar(64) not null,
     recipe_label varchar(64) not null,
     required_quantity int not null,
     constraint COMPOSITION_PK primary key (label_ingredient, recipe_label));

create table Supplier (
     phonenumber varchar(64) not null,
     name varchar(64) not null,
     firstname varchar(64) not null,
     email varchar(255) not null,
     house_number integer not null,
     street_name varchar(64) not null,
     zipcode int not null,
     label_city varchar(64) not null,
     constraint Supplier_PK primary key (phonenumber));

create table City (
     zipcode integer not null,
     label_city varchar(120) not null,
     constraint City_PK primary key (zipcode, label_city));

create table Recipe (
     recipe_label varchar(64) not null,
     preparation_time integer not null,
     nb_people integer not null,
     constraint Recipe_PK primary key (recipe_label));

create table RecipeStep (
     step_id int auto_increment,
     step_number integer not null,
     step_description varchar (255) not null,
     recipe_label varchar(64),
     constraint RecipeStep_PK primary key(step_id));

create table PreparationOrder (
     code integer not null auto_increment,
     recipe_label varchar(64) not null,
     cook_id int not null,
     price_portion double not null,
     production_date timestamp not null,
     expiry_date timestamp not null,
     sale_date timestamp not null,
     nb_portion integer not null,
     chief_comm varchar(255),
     cook_comm varchar(255),
     is_urgent boolean not null,
     constraint PreparationOrder_PK primary key (code));

create table Cook (
     id int not null,
     name varchar(64) not null,
     firstname varchar(64) not null,
     chief_id int,
     constraint Cook_PK primary key (id));


-- Constraints Section
-- ___________________

-- Not implemented
-- alter table SupplyOrder add constraint SUPPLYORDER_PK_CHK
--     check(exists(select * from Achat
--                  where Achat.Code = Code));

alter table SupplyOrder add constraint SUPPLYORDER_SUPPLIER_FK
     foreign key (phonenumber_supplier)
     references Supplier (phonenumber);

alter table PreparationOrder add constraint PREPARATIONORDER_RECIPE_FK
     foreign key (recipe_label)
     references Recipe (recipe_label);

alter table PreparationOrder add constraint PREPARATIONORDER_COOK_FK
     foreign key (cook_id)
     references Cook (id);

alter table Supplier add constraint SUPPLIER_CITY_FK
     foreign key (zipcode, label_city)
     references City (zipcode, label_city);


-- Not implemented
-- alter table Recipe add constraint Recipe_PK_CHK
--     check(exists(select * from Composition
--                  where Composition.recipe_label = recipe_label));

alter table OrderLine add constraint ORDERLINE_INGREDIENT_FK
     foreign key (label_ingredient)
     references Ingredient (label_ingredient);

alter table OrderLine add constraint ORDERLINE_SUPPLYORDER_FK
     foreign key (code)
     references SupplyOrder (code);

alter table Composition add constraint COMPOSITION_RECIPE_FK
     foreign key (recipe_label)
     references Recipe (recipe_label);

alter table Composition add constraint COMPOSITION_INGREDIENT_FK
     foreign key (label_ingredient)
     references Ingredient (label_ingredient);

alter table RecipeStep add constraint RECIPESTEP_RECIPE_FK
     foreign key (recipe_label)
    references Recipe (recipe_label);

-- Index Section
-- _____________

create unique index SUPPLYORDER_PK_IND
     on SupplyOrder (code);

create index SUPPLYORDER_SUPPLIER_FK_IND
     on SupplyOrder (phonenumber_supplier);

create unique index INGREDIENT_PK_IND
     on Ingredient (label_ingredient);

create unique index PREPARATIONORDER_PK_IND
     on PreparationOrder (code);

create unique index PREPARATIONORDER_FK_IND
    on PreparationOrder(cook_id, production_date);

create unique index SUPPLIER_PK_IND
     on Supplier (phonenumber);

create index SUPPLIER_CITY_FK_IND
     on Supplier (zipcode, label_city);

create unique index CITY_PK_IND
     on City (zipcode, label_city);

create unique index RECIPE_PK_IND
     on Recipe (recipe_label);

create unique index ORDERLINE_PK_IND
     on OrderLine (label_ingredient, code);

create index ORDERLINE_SUPPLYORDER_FK_IND
     on OrderLine (code);

create unique index COMPOSITION_PK_IND
     on Composition (recipe_label, label_ingredient);

create index COMPOSITION_INGREDIENT_FK_IND
     on Composition (label_ingredient);

create unique index COOK_PK_IND
     on Cook (id);

create index PREPARATION_FK_IND
     on PreparationOrder (cook_id);

create index CREATION_FK_IND
     on PreparationOrder (recipe_label);



     ######QUERIES
##Ingredient
insert into Ingredient values
('Abricot', 0),
('Agneau', 0),
('Airelle', 0),
('Algue', 0),
('Amande', 0),
('Ananas', 0),
('Anchois', 0),
('Aneth', 0),
('Anguille', 0),
('Armagnac', 0),
('Artichaut', 0),
('Asperge', 0),
('Aubergine', 0),
('Autruche', 0),
('Avocat', 0),
('Bacon', 0),
('Baguette', 0),
('Banane', 0),
('Bar', 0),
('Basilic', 0),
('Batavia', 0),
('Beaufort', 0),
('Béchamel', 0),
('Betterave', 0),
('Beurre', 0),
('Bière', 0),
('Biscotte', 0),
('Biscuit', 0),
('Blé', 0),
('Blette', 0),
('Bleu', 0),
('Boeuf', 0),
('Bonbon', 0),
('Boudin', 0),
('Bourbon', 0),
('Boursin', 0),
('Brandy', 0),
('Brioche', 0),
('Brocoli', 0),
('Cabillaud', 0),
('Cacahuète', 0),
('Cacao', 0),
('Café', 0),
('Caille', 0),
('Calamar', 0),
('Calvados', 0),
('Camembert', 0),
('Canard', 0),
('Cannelle', 0),
('Cantal', 0),
('Câpre', 0),
('Caramel', 0),
('Carotte', 0),
('Carpe', 0),
('Cassis', 0),
('Céleri', 0),
('Cèpe', 0),
('Cerfeuil', 0),
('Cerise', 0),
('Champagne', 0),
('Champignon', 0),
('Chanterelle', 0),
('Chapon', 0),
('Châtaigne', 0),
('Chèvre', 0),
('Chocolat', 0),
('Chorizo', 0),
('Chou', 0),
('Chou-Fleur', 0),
('Ciboulette', 0),
('Cidre', 0),
('Citron', 0),
('Citrouille', 0),
('Clémentine', 0),
('Clou De Girofle', 0),
('Coca-Cola', 0),
('Coeur De Palmier', 0),
('Cognac', 0),
('Coing', 0),
('Cointreau', 0),
('Colin', 0),
('Compote', 0),
('Comté', 0),
('Concombre', 0),
('Confiture', 0),
('Coquelet', 0),
('Coquille Saint-Jacques', 0),
('Coquillettes', 0),
('Coriandre', 0),
('Corn Flakes', 0),
('Cornichon', 0),
('Courge', 0),
('Courgette', 0),
('Couscous', 0),
('Crabe', 0),
('Crème Fraîche', 0),
('Crème Fraîche épaisse', 0),
('Crêpe', 0),
('Cresson', 0),
('Crevette', 0),
('Crosne', 0),
('Crottin De Chèvre', 0),
('Cumin', 0),
('Curcuma', 0),
('Curry', 0),
('Datte', 0),
('Dinde', 0),
('Dorade', 0),
('Eau De Vie', 0),
('Échalote', 0),
('Emmental', 0),
('Endive', 0),
('Épinards', 0),
('Escalope', 0),
('Escargot', 0),
('Estragon', 0),
('Farine', 0),
('Fenouil', 0),
('Feta', 0),
('Feuille De Brick', 0),
('Fève', 0),
('Figue', 0),
('Foie Gras', 0),
('Fraise', 0),
('Framboise', 0),
('Feuille de Laurier', 0),
('Fromage', 0),
('Fromage Blanc', 0),
('Fruit De La Passion', 0),
('Fruits De Mer', 0),
('Gamba', 0),
('Gibier', 0),
('Gigot', 0),
('Gin', 0),
('Gingembre', 0),
('Girolle', 0),
('Glace', 0),
("Gousse d'ail", 0),
('Goyave', 0),
('Grand Marnier', 0),
('Grenadine', 0),
('Grenouille', 0),
('Griotte Au Sirop', 0),
('Groseille', 0),
('Gruyère', 0),
('Gruyère râpé', 0),
('Haddock', 0),
('Hareng', 0),
('Haricot', 0),
('Harissa', 0),
('Herbes De Provence', 0),
('Homard', 0),
("Huile d'olive", 0),
('Huître', 0),
('Jambon', 0),
('Jambonneau', 0),
('Jus', 0),
('Kiwi', 0),
('Lait', 0),
('Lait De Coco', 0),
('Laitue', 0),
('Langouste', 0),
('Langoustine', 0),
('Lapin', 0),
('Lard', 0),
('Lardon', 0),
('Lasagne', 0),
('Lentille', 0),
('Lieu', 0),
('Lièvre', 0),
('Limonade', 0),
('Liqueur', 0),
('Litchi', 0),
('Lotte', 0),
('Loup', 0),
('Macaron', 0),
('Macaroni', 0),
('Mâche', 0),
('Magret', 0),
('Maïs', 0),
('Malibu', 0),
('Mangue', 0),
('Maquereau', 0),
('Marron', 0),
('Marshmallow', 0),
('Martini', 0),
('Melon', 0),
('Menthe', 0),
('Merguez', 0),
('Merlan', 0),
('Merlu', 0),
('Miel', 0),
('Mirabelle', 0),
('Morue', 0),
('Moules', 0),
('Mouton', 0),
('Mozzarella', 0),
('Munster', 0),
('Mûre', 0),
('Muscade', 0),
('Myrtille', 0),
('Navet', 0),
('Nectar', 0),
('Noisette', 0),
('Noix', 0),
('Noix De Cajou', 0),
('Noix De Coco', 0),
('Nougat', 0),
('Oeuf', 0),
('Oie', 0),
('Oignon', 0),
('Olive', 0),
('Orange', 0),
('Origan', 0),
('Oseille', 0),
('Pain', 0),
('Pamplemousse', 0),
('Papaye', 0),
('Paprika', 0),
('Parmesan', 0),
('Pastis', 0),
('Pâte', 0),
('Pâtes', 0),
('Pêche', 0),
('Persil', 0),
('Petit Suisse', 0),
('Petits Pois', 0),
('Pigeon', 0),
('Pignon', 0),
('Piment', 0),
('Pineau', 0),
('Pintade', 0),
('Poire', 0),
('Poireau', 0),
('Pois', 0),
('Poisson', 0),
('Poitrine Fumée', 0),
('Poivre', 0),
('Poivron', 0),
('Pomme', 0),
('Pomme De Terre', 0),
('Porc', 0),
('Porto', 0),
('Potimarron', 0),
('Poulet', 0),
('Poulpe', 0),
('Pousse De Bambou', 0),
('Prune', 0),
('Pruneau', 0),
('Purée', 0),
('Radis', 0),
('Raie', 0),
('Raisin', 0),
('Rascasse', 0),
('Ratatouille', 0),
('Raviolis', 0),
('Reblochon', 0),
('Rhubarbe', 0),
('Rhum', 0),
('Ricotta', 0),
('Risotto', 0),
('Riz', 0),
('Romarin', 0),
('Roquefort', 0),
('Rouget', 0),
('Rumsteak', 0),
('Safran', 0),
('Saint-Moret', 0),
('Saint-Nectaire', 0),
('Saké', 0),
('Salade', 0),
('Sardine', 0),
('Saucisse', 0),
('Saucisson', 0),
('Saumon', 0),
('Seiche', 0),
('Sel', 0),
('Semoule', 0),
('Sésame', 0),
('Soda', 0),
('Soja', 0),
('Sole', 0),
('Sorbet', 0),
('Spaghetti', 0),
('Spéculos', 0),
('Steak', 0),
('Sucre', 0),
('Surimi', 0),
('Tagliatelle', 0),
('Tapenade', 0),
('Tequila', 0),
('Thé', 0),
('Thon', 0),
('Thym', 0),
('Tofu', 0),
('Tomate', 0),
('Topinambour', 0),
('Tournedos', 0),
('Truffe', 0),
('Truite', 0),
('Turbot', 0),
('Vanille', 0),
('Veau', 0),
('Vermouth', 0),
('Vin', 0),
('Vodka', 0),
('Volaille', 0),
('Whisky', 0),
('Yaourt', 0);

##Recipe
insert into Recipe values ("Dorade au four", 35, 4);
insert into Recipe values ("Pâtes Carbonara", 30, 2);
insert into Recipe values ("Riz aux lardons et courgettes", 20, 3);


##Cook
insert into Cook values(001, "Seb", "Pat", null); #chef

insert into Cook values (002, "Asap", "Rocky", 001);

insert into Cook values(003, "Spahyd", "Erman", 001);


##RecipeStep

insert into RecipeStep values(1, 1, "Préchauffez le four à 180°C", "Dorade au four");

insert into RecipeStep values(2, 2, "Rincez le poisson", "Dorade au four");

insert into RecipeStep values(3, 3, "Epluchez l\'oignon et émincez le finement. Déposez le dans le fond d'un plat à four", "Dorade au four");

insert into RecipeStep values(4, 4, "Déposez les dorades par dessus", "Dorade au four");

insert into RecipeStep values(5, 5, "Disposez dans les dorades l\'ail haché, les herbes de provence ou le thym et les feuilles de laurier, puis garnissez les également de tranches de citron", "Dorade au four");

insert into RecipeStep values(6, 6, "Salez et poivrez", "Dorade au four");

insert into RecipeStep values(7, 7, "Arrosez d'un filet d'huile d'olive", "Dorade au four");

insert into RecipeStep values(8, 8, "Déposez un fond d'eau dans le plat à four", "Dorade au four");

insert into RecipeStep values(9, 9, "Enfournez 30 minutes", "Dorade au four");


insert into RecipeStep values(10, 1, "Cuire les pâtes dans un grand volume d'eau bouillante salée.", "Pâtes Carbonara");

insert into RecipeStep values(11, 2, "Pendant ce temps, faire dorer les lardons dans une poêle à sec.", "Pâtes Carbonara");

insert into RecipeStep values(12, 3, "Lorsqu'ils sont dorés, ajouter la crème et laisser mijoter durant 10 minutes.", "Pâtes Carbonara");

insert into RecipeStep values(13, 4, "Egouter les pâtes, les verser dans la sauce, ajouter l'oeuf battu, mélanger et servir saupoudrer de fromage.", "Pâtes Carbonara");


insert into RecipeStep values(14, 1, "Emincer les oignons et les faire revenir à la poêle.", "Riz aux lardons et courgettes");

insert into RecipeStep values(15, 2, "Rajouter les lardons aux oignons et laisser cuire.", "Riz aux lardons et courgettes");

insert into RecipeStep values(16, 3, "Laver la courgette, la couper en petits dés et la faire rajouter au mélange précédent.", "Riz aux lardons et courgettes");

insert into RecipeStep values(17, 4, "Lorsque les courgettes sont cuites, ajouter 2 grosses cuillères à soupe de crème fraîche épaisse", "Riz aux lardons et courgettes");

insert into RecipeStep values(18, 5, "Couper le fromage de chèvre frais en petits dés et les ajouter au mélange oignons/lardons/courgette/crème, puis saler et poivrer", "Riz aux lardons et courgettes");

insert into RecipeStep values(19, 6, "faire cuire le riz dans de l'eau bouillante salée", "Riz aux lardons et courgettes");

insert into RecipeStep values(20, 7, "Une fois le riz cuit, l'égoutter et l'ajouter à la préparation.", "Riz aux lardons et courgettes");

insert into RecipeStep values(21, 8, "Faire cuire quelques minutes à feux doux pour que le riz absorbe bien toutes les saveurs.", "Riz aux lardons et courgettes");

##City
insert into City values (6890, "Kelkpar");


##Supplier
insert into Supplier values ("0477265478", "Bush", "Buisson", "bushbuisson@gmail.com", 47, "Rue de la Forêt", 6890, "Kelkpar");

insert into Supplier values ("0495874123", "Shopkip", "Apu", "apushop@hotmail.com", 8, "Rue des Commercants", 6890, "Kelkpar");

##Composition

insert into Composition values
('Pâtes', 'Pâtes Carbonara', 350),
('Lardon', 'Pâtes Carbonara', 90),
('Oeuf', 'Pâtes Carbonara', 1),
('Crème fraîche', 'Pâtes Carbonara', 15),
('Gruyère râpé', 'Pâtes Carbonara', 50),
('Poivre', 'Pâtes Carbonara', 15),
('Sel', 'Pâtes Carbonara', 10);

insert into Composition values
('Dorade', 'Dorade au four', 2),
('Citron', 'Dorade au four', 1),
('Herbes De Provence', 'Dorade au four', 20),
('Feuille de Laurier', 'Dorade au four', 5),
("Gousse d'ail", 'Dorade au four', 3),
('Oignon', 'Dorade au four', 2),
('Sel', 'Dorade au four', 20),
('Poivre', 'Dorade au four', 25);

insert into Composition values
('Crème Fraiche épaisse', 'Riz aux lardons et courgettes', 50),
('Riz', 'Riz aux lardons et courgettes', 400),
('Chèvre', 'Riz aux lardons et courgettes', 60),
('Courgette', 'Riz aux lardons et courgettes', 1),
('Lardon', 'Riz aux lardons et courgettes', 100),
('Oignon', 'Riz aux lardons et courgettes', 1);


