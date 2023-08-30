-- Insertions pour la table "equipement"
INSERT INTO equipement (id_equipement, nom, date_achat, etat, configuration)
VALUES
(1, 'Ordinateur portable', '2023-01-15', 'En service', 'Intel i5, 8 Go RAM, 256 Go SSD'),
(2, 'Imprimante Laser', '2022-06-20', 'En service', 'Modèle XYZ123'),
(3, 'Serveur de données', '2021-03-10', 'En maintenance', 'Xeon E3, 16 Go RAM, 1 To HDD'),
(4, 'Écran LCD 24 pouces', '2023-04-05', 'En service', 'Résolution 1920x1080'),
(5, 'Scanner USB', '2022-09-12', 'En service', 'Modèle ABC456'),
(6, 'Souris sans fil', '2023-02-28', 'En service', 'Modèle QWERTY'),
(7, 'Tablette graphique', '2023-07-10', 'En service', 'Marque Wacom, 1024 niveaux de pression'),
(8, 'Projecteur HD', '2021-11-20', 'Hors service', 'Résolution 1280x720'),
(9, 'Casque audio', '2022-05-15', 'En service', 'Annulation de bruit, Bluetooth'),
(10, 'Clavier mécanique', '2023-06-08', 'En service', 'Switches Cherry MX Red');

-- Insertions pour la table "logiciel"
INSERT INTO logiciel (id_logiciel, nom, version, editeur, date_installation)
VALUES
(1, 'Microsoft Office', '2021', 'Microsoft Corporation', '2023-02-10'),
(2, 'Adobe Photoshop', '2023', 'Adobe Inc.', '2023-03-05'),
(3, 'MySQL Database', '8.0', 'Oracle Corporation', '2023-01-30'),
(4, 'AutoCAD', '2022', 'Autodesk Inc.', '2022-07-15'),
(5, 'Visual Studio Code', '1.60', 'Microsoft Corporation', '2023-08-01'),
(6, 'Adobe Illustrator', '2023', 'Adobe Inc.', '2023-04-20'),
(7, 'Google Chrome', '94.0', 'Google LLC', '2023-05-10'),
(8, 'Eclipse IDE', '2021', 'Eclipse Foundation', '2022-02-28'),
(9, 'MATLAB', 'R2021b', 'MathWorks Inc.', '2022-10-18'),
(10, 'VMware Workstation', '16', 'VMware Inc.', '2021-12-05');

-- Insertions pour la table "utilisateur"
INSERT INTO utilisateur (id_utilisateur, nom)
VALUES
(1, 'Alice Johnson'),
(2, 'Bob Smith'),
(3, 'Eva Martinez'),
(4, 'David Lee'),
(5, 'Sophie Williams'),
(6, 'Michael Brown'),
(7, 'Linda Davis'),
(8, 'James Wilson'),
(9, 'Emma Taylor'),
(10, 'John Miller');

-- Insertions pour la table "departement"
INSERT INTO departement (id_departement, nom, localisation, type)
VALUES
(1, 'Service Informatique', 'Bâtiment A, Étage 2', 'Technique'),
(2, 'Ressources Humaines', 'Bâtiment B, Étage 1', 'Administratif'),
(3, 'Recherche et Développement', 'Bâtiment C, Étage 3', 'Technique'),
(4, 'Comptabilité', 'Bâtiment B, Étage 2', 'Administratif'),
(5, 'Marketing', 'Bâtiment D, Étage 1', 'Commercial'),
(6, 'Production', 'Bâtiment E, Étage 1', 'Opérationnel'),
(7, 'Ventes', 'Bâtiment D, Étage 2', 'Commercial'),
(8, 'Support Technique', 'Bâtiment A, Étage 1', 'Technique'),
(9, 'Service Clients', 'Bâtiment D, Étage 3', 'Commercial'),
(10, 'Formation', 'Bâtiment C, Étage 1', 'Administratif');
