/* Insert Admin User with password Test123*/
INSERT INTO USER (id, email, password, role) VALUES (null, 'test@mail.com', '$2a$10$VpzL/nkTYnOXPjww/ibsPeB6fvWe5NJbVVw2Xt3LBUf144rf.Trwe', 'ROLE_ADMIN');

/* Insert Animals
INSERT INTO ANIMAL (id, name, space_needed, time_needed, potential_noise, hair_alergy, feather_alergy, money_needed, pettable, absence_from_home, activities, learning_tricks, result) VALUES (id, name, space_needed, time_needed, potential_noise, hair_alergy, feather_alergy, money_needed, pettable, absence_from_home, activities, learning_tricks, result)
*/
INSERT INTO ANIMAL (id, name, space_needed, time_needed, potential_noise, hair_alergy, feather_alergy, money_needed, pettable, absence_from_home, activities, learning_tricks, result) VALUES (100, 'Cat', 'MEDIUM_APARTMENT', 'ONE_HOUR', 'SOME_NOISE', TRUE, FALSE, 'A_BIT_MORE_MONEY', TRUE, 'RARE', FALSE, TRUE, 0L);
INSERT INTO ANIMAL (id, name, space_needed, time_needed, potential_noise, hair_alergy, feather_alergy, money_needed, pettable, absence_from_home, activities, learning_tricks, result) VALUES (101, 'Dog', 'LARGE_APARTMENT', 'TWO_HOURS', 'A_LOT_OF_NOISE', TRUE, FALSE, 'A_BIT_MORE_MONEY', TRUE, 'RARE', TRUE, TRUE, 0L);
INSERT INTO ANIMAL (id, name, space_needed, time_needed, potential_noise, hair_alergy, feather_alergy, money_needed, pettable, absence_from_home, activities, learning_tricks, result) VALUES (102, 'Parrot', 'SMALL_APARTMENT', 'HALF_HOUR', 'A_LOT_OF_NOISE', FALSE, TRUE, 'A_LITTLE_BIT_OF_MONEY', FALSE, 'OCCASIONAL', FALSE, TRUE, 0L);
INSERT INTO ANIMAL (id, name, space_needed, time_needed, potential_noise, hair_alergy, feather_alergy, money_needed, pettable, absence_from_home, activities, learning_tricks, result) VALUES (103, 'Turtle', 'SMALL_APARTMENT', 'HALF_HOUR', 'NO_NOISE', FALSE, FALSE, 'A_LITTLE_BIT_OF_MONEY', FALSE, 'FREQUENT', FALSE, FALSE, 0L);
INSERT INTO ANIMAL (id, name, space_needed, time_needed, potential_noise, hair_alergy, feather_alergy, money_needed, pettable, absence_from_home, activities, learning_tricks, result) VALUES (104, 'Hamster', 'SMALL_APARTMENT', 'HALF_HOUR', 'NO_NOISE', TRUE, FALSE, 'A_LITTLE_BIT_OF_MONEY', TRUE, 'FREQUENT', FALSE, FALSE, 0L);
INSERT INTO ANIMAL (id, name, space_needed, time_needed, potential_noise, hair_alergy, feather_alergy, money_needed, pettable, absence_from_home, activities, learning_tricks, result) VALUES (105, 'Cactus', 'SMALL_APARTMENT', 'HALF_HOUR', 'NO_NOISE', FALSE, FALSE, 'NO_MONEY', FALSE, 'FREQUENT', FALSE, FALSE, 0L);
INSERT INTO ANIMAL (id, name, space_needed, time_needed, potential_noise, hair_alergy, feather_alergy, money_needed, pettable, absence_from_home, activities, learning_tricks, result) VALUES (106, 'Snake', 'SMALL_APARTMENT', 'ONE_HOUR', 'NO_NOISE', FALSE, FALSE, 'A_BIT_MORE_MONEY', FALSE, 'RARE', FALSE, FALSE, 0L);
INSERT INTO ANIMAL (id, name, space_needed, time_needed, potential_noise, hair_alergy, feather_alergy, money_needed, pettable, absence_from_home, activities, learning_tricks, result) VALUES (107, 'Fish', 'SMALL_APARTMENT', 'HALF_HOUR', 'NO_NOISE', FALSE, FALSE, 'A_LITTLE_BIT_OF_MONEY', FALSE, 'RARE', FALSE, FALSE, 0L);






