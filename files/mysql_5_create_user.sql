/*
 * CREATE A NEW USER ON MySQL.
 */
CREATE USER 'wpattern'@'localhost' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON *.* TO 'wpattern'@'localhost' WITH GRANT OPTION;
