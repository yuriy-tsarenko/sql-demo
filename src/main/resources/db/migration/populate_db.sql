INSERT INTO user_account(username, user_pass)
VALUES
('testUser'||'Name', '12345'),
('user1',  '12345'),
('user2',  '12345'),
('user3',  '12345');

INSERT INTO contact(firstName,lastName,phone,user_account_id)
VALUES
('firstName1','lastName1','+380901345623',1),
('firstName2','lastName2','+380901345623',2),
('firstName3','lastName3','+380901345623',3),
('firstName4','lastName4','+380901345623',4);