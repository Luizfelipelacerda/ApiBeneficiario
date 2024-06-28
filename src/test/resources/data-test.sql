--insert ignore into db.roles (role_id, name) values (1, 'admin');
--insert ignore into db.roles (role_id, name) values (2, 'basic');

--MERGE INTO roles KEY(role_id) VALUES (1, 'admin');
--MERGE INTO roles KEY(role_id) VALUES (2, 'basic');

--MERGE INTO roles USING dual ON role_id = 1
--WHEN NOT MATCHED THEN
--MERGE INTO roles USING dual ON role_id = 2
--WHEN NOT MATCHED THEN

--  INSERT (role_id, name) VALUES (1, 'admin');
--INSERT INTO roles (role_id, name) VALUES (1, 'admin') ON DUPLICATE KEY UPDATE name='admin';
--  INSERT (role_id, name) VALUES (2, 'basic');
--INSERT INTO roles (role_id, name) VALUES (2, 'basic') ON DUPLICATE KEY UPDATE name='basic';