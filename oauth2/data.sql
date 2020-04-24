INSERT INTO oauth_client_details (client_id, client_secret, web_server_redirect_uri, scope, access_token_validity, refresh_token_validity, resource_ids, authorized_grant_types, additional_information) VALUES
 ('admin', '{bcrypt}$2a$04$cqo7VAcAsZQd0NVATJmrXuizWpoYDsuA3Kg4QoS.D9ltwtJ5QQWQS', 'http://localhost:8080/code', 'READ,WRITE', '3600', '10000', 'inventory,payment', 'client_credentials,authorization_code,password,refresh_token,implicit', '{}');

 INSERT INTO PERMISSION (ID,NAME) VALUES
 (1,'create_profile'),
 (2,'read_profile'),
 (3,'update_profile'),
 (4,'delete_profile');

 INSERT INTO role (ID,NAME) VALUES
		(1,'ROLE_admin');
 INSERT INTO role (ID,NAME) VALUES
		(2,'ROLE_operator');
		
 INSERT INTO PERMISSION_ROLE (PERMISSION_ID, ROLE_ID) VALUES
     (1,1), /*create-> admin */
     (2,1), /* read admin */
     (3,1), /* update admin */
     (4,1), /* delete admin */
     (2,2),  /* read operator */
     (3,2);  /* update operator */
insert into user (id, username,password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked) VALUES ('1', 'admin','{bcrypt}$2a$04$cqo7VAcAsZQd0NVATJmrXuizWpoYDsuA3Kg4QoS.D9ltwtJ5QQWQS', 'k@krishantha.com', '1', '1', '1', '1');
 insert into  user (id, username,password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked) VALUES ('2', 'suranga', '{bcrypt}$2a$04$cqo7VAcAsZQd0NVATJmrXuizWpoYDsuA3Kg4QoS.D9ltwtJ5QQWQS','k@krishantha.com', '1', '1', '1', '1');

INSERT INTO ROLE_USER (ROLE_ID, USER_ID)
    VALUES
    (1, 1) /* krish-admin */,
    (2, 2) /* suranga-operatorr */ ;