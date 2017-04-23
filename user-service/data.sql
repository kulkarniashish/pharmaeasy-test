CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `enabled` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO test.user(enabled, username, password, name, user_type) values (1, 'doctor', 'doctor', 'Doctor', 'ROLE_DOCTOR');
INSERT INTO test.user(enabled, username, password, name, user_type) values (1, 'patient', 'patient', 'Patient', 'ROLE_PATIENT');
INSERT INTO test.user(enabled, username, password, name, user_type) values (1, 'pharmacist', 'pharmacist', 'Pharmacist', 'ROLE_PHARMACIST');
