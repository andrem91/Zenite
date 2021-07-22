CREATE TABLE `tb_postagem` (
	`id_post` bigint NOT NULL,
	`id_usuario` bigint NOT NULL,
	`id_cat` int NOT NULL,
	`titulo` varchar(255) NOT NULL,
	`subtitulo` varchar NOT NULL,
	`texto` TEXT NOT NULL,
	`data` TIMESTAMP NOT NULL,
	PRIMARY KEY (`id_post`)
);

CREATE TABLE `tb_categoria` (
	`id` int NOT NULL AUTO_INCREMENT,
	`categoria` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_usuario` (
	`nome` varchar(255) NOT NULL,
	`email` varchar(255) NOT NULL,
	`senha` varchar(25) NOT NULL,
	`id` bigint NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id`)
);

ALTER TABLE `tb_postagem` ADD CONSTRAINT `tb_postagem_fk0` FOREIGN KEY (`id_usuario`) REFERENCES `tb_usuario`(`id`);

ALTER TABLE `tb_postagem` ADD CONSTRAINT `tb_postagem_fk1` FOREIGN KEY (`id_cat`) REFERENCES `tb_categoria`(`id`);

ALTER TABLE `tb_categoria` ADD CONSTRAINT `tb_categoria_fk0` FOREIGN KEY (`id`) REFERENCES `tb_subcategoria`(`nome`);




