insert into security_db.users (id, username, password)
values  (1, 'admin', '$2a$12$C.H2nV5E9dBUXzxmCFXEU.3kDM/k0O.o0uQSS.Ym.yflZItDnrXAa'),
        (2, 'user', '$2a$12$WIfITQSiAJUUWAKKdZ1WHOxMcKlVFbJthwKaPLBiSDU5xGKU7HTfu'),
        (3, 'user1', '$2a$12$pIzFHhCwTmAJa/RS.yXVIe8JcZutxqU3YcCyJTjNwdqdqv8EKHRU.');
        
insert into security_db.roles (id, name)
values  (1, 'ROLE_USER'),
        (2, 'ROLE_ADMIN');
        
insert into security_db.users_roles (user_id, role_id)
values  (1, 2),
        (2, 1),
        (3, 1);        
