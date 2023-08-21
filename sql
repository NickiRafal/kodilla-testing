
CREATE TABLE ISSUESLISTS (
                        ID INT AUTO_INCREMENT PRIMARY KEY,
                        NAME VARCHAR(255) NOT NULL
);

CREATE TABLE ISSUES (
                        ID INT AUTO_INCREMENT PRIMARY KEY,
                        ISSUESLIST_ID INT,
                        SUMMARY VARCHAR(255) NOT NULL,
                        DESCRIPTION TEXT,
                        USER_ID_ASSIGNEDTO INT,
                        FOREIGN KEY (ISSUESLIST_ID) REFERENCES ISSUESLISTS(ID),
                        FOREIGN KEY (USER_ID_ASSIGNEDTO) REFERENCES USERS(ID)
);

INSERT INTO ISSUESLISTS (ID, NAME) VALUES
                                       (1, 'ToDo'),
                                       (2, 'In progress'),
                                       (3, 'Done');

INSERT INTO ISSUES (ID, ISSUESLIST_ID, SUMMARY, DESCRIPTION, USER_ID_ASSIGNEDTO) VALUES
                                                                                     (1, 1, 'Zadanie 1 ToDo', 'Opis zadania 1 ToDo', 1),
                                                                                     (2, 1, 'Zadanie 2 ToDo', 'Opis zadania 2 ToDo', 2),
                                                                                     (3, 1, 'Zadanie 3 ToDo', 'Opis zadania 3 ToDo', 3),
                                                                                     (4, 1, 'Zadanie 4 ToDo', 'Opis zadania 4 ToDo', 1),
                                                                                     (5, 1, 'Zadanie 5 ToDo', 'Opis zadania 5 ToDo', 2),
                                                                                     (6, 2, 'Zadanie 1 In progress', 'Opis zadania 1 In progress', 3),
                                                                                     (7, 2, 'Zadanie 2 In progress', 'Opis zadania 2 In progress', 1),
                                                                                     (8, 2, 'Zadanie 3 In progress', 'Opis zadania 3 In progress', 2),
                                                                                     (9, 2, 'Zadanie 4 In progress', 'Opis zadania 4 In progress', 3),
                                                                                     (10, 2, 'Zadanie 5 In progress', 'Opis zadania 5 In progress', 1),
                                                                                     (11, 3, 'Zadanie 1 Done', 'Opis zadania 1 Done', 2),
                                                                                     (12, 3, 'Zadanie 2 Done', 'Opis zadania 2 Done', 3),
                                                                                     (13, 3, 'Zadanie 3 Done', 'Opis zadania 3 Done', 1),
                                                                                     (14, 3, 'Zadanie 4 Done', 'Opis zadania 4 Done', 2);
