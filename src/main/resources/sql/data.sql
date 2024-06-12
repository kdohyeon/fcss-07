INSERT IGNORE INTO `spring`.`users` VALUES ('1', 'danny.kim', '$2a$10$KcE2ZV52mbpV3q4eikTXXe320oZy0v9agU8lfQTJUj6HyWE41BRqi', 'BCRYPT');
INSERT IGNORE INTO `spring`.`users` VALUES ('2', 'steve.kim', '$2a$10$KcE2ZV52mbpV3q4eikTXXe320oZy0v9agU8lfQTJUj6HyWE41BRqi', 'BCRYPT');

INSERT IGNORE INTO `spring`.`authorities` VALUES ('1', 'READ', '1');
INSERT IGNORE INTO `spring`.`authorities` VALUES ('2', 'WRITE', '1');
INSERT IGNORE INTO `spring`.`authorities` VALUES ('3', 'READ', '2');

INSERT IGNORE INTO `spring`.`products` VALUES ('1', 'Chocolate', '10', 'USD');