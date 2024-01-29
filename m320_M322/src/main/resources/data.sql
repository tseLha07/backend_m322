--USERS
insert into users (id, email, firstname, lastname, password)
values ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'admin@example.com', 'James', 'Bond',
        '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6'), -- Password: 1234
       ('0d8fa44c-54fd-4cd0-ace9-2a7da57992de', 'user@example.com', 'Tyler', 'Durden',
        '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6')  -- Password: 1234
    ON CONFLICT DO NOTHING;

--ROLES
INSERT INTO role(id, name)
VALUES ('ab505c92-7280-49fd-a7de-258e618df074', 'ADMIN'),
       ('c6aee32d-8c35-4481-8b3e-a876a39b0c02', 'USER') ON CONFLICT DO NOTHING;

--AUTHORITIES
INSERT INTO authority(id, name)
VALUES ('2ebf301e-6c61-4076-98e3-2a38b31daf86', 'DEFAULT'),
       ('d5866d24-d7d2-4b1e-9b4c-dc8b0c8d4bd7', 'USER_READ'),
       ('76d2cbf6-5845-470e-ad5f-2edb9e09a868', 'USER_MODIFY'),
       ('21c942db-a275-43f8-bdd6-d048c21bf5ab', 'USER_DELETE'),
       ('64030c3a-c260-453c-847f-a46950a6ac21', 'MOVIE_READ'),
       ('aa04799f-35c7-48bc-94b0-c156b8802969', 'MOVIE_READ_ALL'),
       ('82e779f6-21fd-49df-84b4-c01f00766eff', 'MOVIE_CREATE'),
       ('45ba7560-8459-4ae6-8edf-ffe204c7ddc3', 'MOVIE_MODIFY'),
       ('430f4ad9-55cc-4cc4-a182-24a829de36e0', 'MOVIE_DELETE') ON CONFLICT DO NOTHING;

--assign roles to users
insert into users_role (users_id, role_id)
values ('0d8fa44c-54fd-4cd0-ace9-2a7da57992de', 'c6aee32d-8c35-4481-8b3e-a876a39b0c02'),
       ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'ab505c92-7280-49fd-a7de-258e618df074'),
       ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'c6aee32d-8c35-4481-8b3e-a876a39b0c02') ON CONFLICT DO NOTHING;

--assign authorities to roles
INSERT INTO role_authority(role_id, authority_id)
VALUES ('c6aee32d-8c35-4481-8b3e-a876a39b0c02', 'aa04799f-35c7-48bc-94b0-c156b8802969'), -- USER    - MOVIE_READ_ALL
       ('ab505c92-7280-49fd-a7de-258e618df074', '76d2cbf6-5845-470e-ad5f-2edb9e09a868'), -- ADMIN   - USER_MODIFY
       ('ab505c92-7280-49fd-a7de-258e618df074', '21c942db-a275-43f8-bdd6-d048c21bf5ab'), -- ADMIN   - USER_DELETE
       ('ab505c92-7280-49fd-a7de-258e618df074', 'd5866d24-d7d2-4b1e-9b4c-dc8b0c8d4bd7'), -- ADMIN   - USER_READ
       ('ab505c92-7280-49fd-a7de-258e618df074', '45ba7560-8459-4ae6-8edf-ffe204c7ddc3'), -- ADMIN   - MOVIE_MODIFY
       ('ab505c92-7280-49fd-a7de-258e618df074', '64030c3a-c260-453c-847f-a46950a6ac21'), -- ADMIN   - MOVIE_READ
       ('ab505c92-7280-49fd-a7de-258e618df074', 'aa04799f-35c7-48bc-94b0-c156b8802969'), -- ADMIN   - MOVIE_READ_ALL
       ('ab505c92-7280-49fd-a7de-258e618df074', '82e779f6-21fd-49df-84b4-c01f00766eff'), -- ADMIN   - MOVIE_CREATE
       ('ab505c92-7280-49fd-a7de-258e618df074', '430f4ad9-55cc-4cc4-a182-24a829de36e0')  -- ADMIN   - MOVIE_DELETE
    ON CONFLICT DO NOTHING;
