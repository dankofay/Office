INSERT INTO `Role` (`id`,`name`) VALUES (1,"Administrator"),(2,"Manager"),(3,"Developer"),(4,"Accountant"),(5,"Newsmaker"),(6,"Developer");


INSERT INTO `office`.`role_has_user` (`id_user`, `id_role`) VALUES ('1', '2');
INSERT INTO `office`.`role_has_user` (`id_user`, `id_role`) VALUES ('1', '3');
INSERT INTO `office`.`role_has_user` (`id_user`, `id_role`) VALUES ('2', '3');
INSERT INTO `office`.`role_has_user` (`id_user`, `id_role`) VALUES ('3', '3');
INSERT INTO `office`.`role_has_user` (`id_user`, `id_role`) VALUES ('4', '4');
