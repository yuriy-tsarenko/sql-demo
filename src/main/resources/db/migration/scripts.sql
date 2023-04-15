SELECT * FROM user_account;
SELECT * FROM contact;
SELECT * FROM user_account WHERE username='user1';
SELECT id, phone FROM contact;
SELECT id, phone FROM contact LIMIT 2;
SELECT id, phone FROM contact OFFSET 2;
SELECT id, phone FROM contact  ORDER BY id DESC LIMIT 2;
SELECT id, phone FROM contact  ORDER BY id ASC LIMIT 2;
SELECT id, phone FROM contact  ORDER BY id DESC;
SELECT id, phone FROM contact  ORDER BY id ASC;
SELECT id, phone FROM contact LIMIT 1 OFFSET;
SELECT DISTINCT phone FROM contact;

SELECT * FROM user_account WHERE username='testUserName'
UNION
SELECT * FROM user_account WHERE id=10;

SELECT firstName, count(id) as amount FROM contact GROUP BY firstName;


DELETE FROM user_account WHERE id=8;
DELETE FROM user_account WHERE id IN (5,6,7);

UPDATE contact SET phone='+3093167281111' WHERE id=15;
UPDATE contact SET phone='+3093167281111', firstName='updatedName' WHERE id=14;

INSERT INTO contact(firstName,lastName,phone,user_account_id)
VALUES
('contact without account','lastName2','+3811111111',null);

INSERT INTO user_account(username, user_pass)
VALUES
('user without contact', '12345');

SELECT u.id, u.username, u.user_pass, c.phone FROM user_account as u
 INNER JOIN contact as c
  ON u.id=c.user_account_id;

SELECT u.id, u.username, u.user_pass, c.phone FROM user_account as u
 LEFT JOIN contact as c
  ON u.id=c.user_account_id;

SELECT u.id, u.username, u.user_pass, c.phone, c.firstName FROM user_account as u
 RIGHT JOIN contact as c
  ON u.id=c.user_account_id;


ALTER TABLE contact ADD column email varchar;
ALTER TABLE contact ALTER column email RENAME to email1;