-- *********************************************
-- * SQL MySQL generation                      
-- *--------------------------------------------
-- * DB-MAIN version: 11.0.0              
-- * Generator date: Sep  6 2018              
-- * Generation date: Fri Jul 19 17:46:18 2019 
-- * LUN file: C:\Users\Utilisateur\OneDrive\IESN\B2\Q2\AOO\Aout\DB.lun 
-- * Schema: DB_MLD/1 
-- ********************************************* 


-- Database Section
-- ________________ 

create database DB_JAVA;
use DB_JAVA;


-- Tables Section
-- _____________ 

create table Commande (
     Code char(1) not null,
     DateTransaction char(1) not null,
     Ingredient char(1) not null,
     DLC char(1) not null,
     NumTel char(1) not null,
     constraint COMMANDE_PK_ID primary key (Code));

create table Ingredient (
     IngredientLabel char(1) not null,
     constraint INGREDIENT_PK_ID primary key (IngredientLabel));

create table Fournisseur (
     NumTel char(1) not null,
     Nom char(1) not null,
     Prenom char(1) not null,
     Email char(1) not null,
     NumeroRue char(1) not null,
     NomRue char(1) not null,
     CodePostal char(1) not null,
     LocaliteLabel char(1) not null,
     constraint FOURNISSEUR_PK_ID primary key (NumTel));

create table Localite (
     CodePostal char(1) not null,
     LocaliteLabel char(1) not null,
     constraint LOCALITE_PK_ID primary key (CodePostal, LocaliteLabel));

create table Recette (
     RecetteLabel char(1) not null,
     TempsPreparation char(1) not null,
     NbCalories char(1) not null,
     EtapesRecette char(1) not null,
     constraint RECETTE_PK_ID primary key (RecetteLabel));

create table Achat (
     Code char(1) not null,
     IngredientLabel char(1) not null,
     Quantite char(1) not null,
     constraint ACHAT_PK_ID primary key (IngredientLabel, Code));

create table Composition (
     IngredientLabel char(1) not null,
     RecetteLabel char(1) not null,
     constraint COMPOSITION_PK_ID primary key (RecetteLabel, IngredientLabel));


-- Constraints Section
-- ___________________ 

-- Not implemented
-- alter table Commande add constraint COMMANDE_PK_CHK
--     check(exists(select * from Achat
--                  where Achat.Code = Code)); 

alter table Commande add constraint COMMANDE_FOURNISSEUR_FK_FK
     foreign key (NumTel)
     references Fournisseur (NumTel);

alter table Fournisseur add constraint FOURNISSEUR_LOCALITE_FK_FK
     foreign key (CodePostal, LocaliteLabel)
     references Localite (CodePostal, LocaliteLabel);

-- Not implemented
-- alter table Recette add constraint RECETTE_PK_CHK
--     check(exists(select * from Composition
--                  where Composition.RecetteLabel = RecetteLabel)); 

alter table Achat add constraint ACHAT_INGREDIENT_FK
     foreign key (IngredientLabel)
     references Ingredient (IngredientLabel);

alter table Achat add constraint ACHAT_COMMANDE_FK_FK
     foreign key (Code)
     references Commande (Code);

alter table Composition add constraint COMPOSITION_RECETTE_FK
     foreign key (RecetteLabel)
     references Recette (RecetteLabel);

alter table Composition add constraint COMPOSITION_INGREDIENT_FK_FK
     foreign key (IngredientLabel)
     references Ingredient (IngredientLabel);


-- Index Section
-- _____________ 

create unique index COMMANDE_PK_IND
     on Commande (Code);

create index COMMANDE_FOURNISSEUR_FK_IND
     on Commande (NumTel);

create unique index INGREDIENT_PK_IND
     on Ingredient (IngredientLabel);

create unique index FOURNISSEUR_PK_IND
     on Fournisseur (NumTel);

create index FOURNISSEUR_LOCALITE_FK_IND
     on Fournisseur (CodePostal, LocaliteLabel);

create unique index LOCALITE_PK_IND
     on Localite (CodePostal, LocaliteLabel);

create unique index RECETTE_PK_IND
     on Recette (RecetteLabel);

create unique index ACHAT_PK_IND
     on Achat (IngredientLabel, Code);

create index ACHAT_COMMANDE_FK_IND
     on Achat (Code);

create unique index COMPOSITION_PK_IND
     on Composition (RecetteLabel, IngredientLabel);

create index COMPOSITION_INGREDIENT_FK_IND
     on Composition (IngredientLabel);

