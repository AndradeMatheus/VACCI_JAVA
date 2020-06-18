SET FOREIGN_KEY_CHECKS = 0;
DROP DATABASE IF EXISTS vac;
SET FOREIGN_KEY_CHECKS = 1;
CREATE DATABASE vac;

CREATE TABLE vac.vacinas(
  id_vacina BIGINT NOT NULL AUTO_INCREMENT,
  nm_vacina VARCHAR(255),
  tp_carteira BIGINT,
  PRIMARY KEY (id_vacina)
);

CREATE TABLE vac.usuario (
  id_usuario BIGINT NOT NULL AUTO_INCREMENT,
  nm_usuario VARCHAR(255),
  nm_login VARCHAR(255),
  nm_senha VARCHAR(255),
  tp_genero BIGINT,
  nm_cep VARCHAR(255),
  id_idade BIGINT,
  PRIMARY KEY (id_usuario)
);

CREATE TABLE vac.carteira(
	id_carteira BIGINT NOT NULL AUTO_INCREMENT,
	id_usuario BIGINT,
    tp_carteira BIGINT,
    PRIMARY KEY (id_carteira)
);

CREATE TABLE vac.dom_genero(
	tp_genero BIGINT NOT NULL AUTO_INCREMENT,
    nm_genero VARCHAR(255),
    PRIMARY KEY (tp_genero)
);

CREATE TABLE vac.dom_carteira(
	tp_carteira BIGINT NOT NULL AUTO_INCREMENT,
    nm_carteira VARCHAR(255),
    PRIMARY KEY (tp_carteira)
);

CREATE TABLE vac.carteira_vacina(
	id_carteira BIGINT,
    id_vacina BIGINT
);

INSERT INTO `vac`.`vacinas` (`id_vacina`, `nm_vacina`, `tp_carteira`) VALUES (1, 'BCG + VHB (Ao nascer)', 1);
INSERT INTO `vac`.`vacinas` (`id_vacina`, `nm_vacina`, `tp_carteira`) VALUES (2, 'VHB (1 mês)', 1);
INSERT INTO `vac`.`vacinas` (`id_vacina`, `nm_vacina`, `tp_carteira`) VALUES (3, 'DPT-Hib + SABIN + ROTA (2 meses)', 1);
INSERT INTO `vac`.`vacinas` (`id_vacina`, `nm_vacina`, `tp_carteira`) VALUES (4, 'DPT-Hib + SABIN + VHB (6 meses)', 1);
INSERT INTO `vac`.`vacinas` (`id_vacina`, `nm_vacina`, `tp_carteira`) VALUES (5, 'FA (9 meses)', 1);
INSERT INTO `vac`.`vacinas` (`id_vacina`, `nm_vacina`, `tp_carteira`) VALUES (6, 'Tríplice Viral (12 meses)', 1);
INSERT INTO `vac`.`vacinas` (`id_vacina`, `nm_vacina`, `tp_carteira`) VALUES (7, 'DPTT + SABIN (15 meses)', 1);
INSERT INTO `vac`.`vacinas` (`id_vacina`, `nm_vacina`, `tp_carteira`) VALUES (8, 'DPT + Trípiplice Viral (4-6 anos)', 1);
INSERT INTO `vac`.`vacinas` (`id_vacina`, `nm_vacina`, `tp_carteira`) VALUES (9, 'dT + FA (10-11 anos)', 1);
INSERT INTO `vac`.`vacinas` (`id_vacina`, `nm_vacina`, `tp_carteira`) VALUES (10, 'Papilomavírus Humano (HPV) (11 a 14 - meninos)', 2);
INSERT INTO `vac`.`vacinas` (`id_vacina`, `nm_vacina`, `tp_carteira`) VALUES (11, 'Meningocócica C (11 a 14 meninos e meninas', 2);
INSERT INTO `vac`.`vacinas` (`id_vacina`, `nm_vacina`, `tp_carteira`) VALUES (12, 'Hepatite B (recombinante)', 2);
INSERT INTO `vac`.`vacinas` (`id_vacina`, `nm_vacina`, `tp_carteira`) VALUES (13, 'Dupla bacteriana adulto (dT)', 2);
INSERT INTO `vac`.`vacinas` (`id_vacina`, `nm_vacina`, `tp_carteira`) VALUES (14, 'Tríplice Viral (SCR)', 2);
INSERT INTO `vac`.`vacinas` (`id_vacina`, `nm_vacina`, `tp_carteira`) VALUES (15, 'Hepatite B', 3);
INSERT INTO `vac`.`vacinas` (`id_vacina`, `nm_vacina`, `tp_carteira`) VALUES (16, 'Febre Amarela', 3);
INSERT INTO `vac`.`vacinas` (`id_vacina`, `nm_vacina`, `tp_carteira`) VALUES (17, 'Tríplice Viral (VTV)', 3);
INSERT INTO `vac`.`vacinas` (`id_vacina`, `nm_vacina`, `tp_carteira`) VALUES (18, 'Dupla Adulto (dT)', 3);

INSERT INTO `vac`.`usuario` (`id_usuario`, `nm_usuario`, `nm_login`, `nm_senha`, `tp_genero`, `nm_cep`, `id_idade`) VALUES (1, 'admin', 'admin', 'admin', 1, '012345-010', 21);

INSERT INTO `vac`.`dom_genero` (`tp_genero`, `nm_genero`) VALUES (1, 'Masculino');
INSERT INTO `vac`.`dom_genero` (`tp_genero`, `nm_genero`) VALUES (2, 'Feminino');
INSERT INTO `vac`.`dom_genero` (`tp_genero`, `nm_genero`) VALUES (3, 'Outros');

INSERT INTO `vac`.`dom_carteira` (`tp_carteira`, `nm_carteira`) VALUES (1, 'Criança');
INSERT INTO `vac`.`dom_carteira` (`tp_carteira`, `nm_carteira`) VALUES (2, 'Adolescente');
INSERT INTO `vac`.`dom_carteira` (`tp_carteira`, `nm_carteira`) VALUES (3, 'Adulto/Idoso');

ALTER TABLE vac.vacinas ADD CONSTRAINT FK_VACINA_CARTEIRA_TP FOREIGN KEY (tp_carteira) REFERENCES vac.dom_carteira(tp_carteira);
ALTER TABLE vac.usuario ADD CONSTRAINT FK_USUARIO_GENERO_TP FOREIGN KEY (tp_genero) REFERENCES vac.dom_genero(tp_genero);
ALTER TABLE vac.carteira ADD CONSTRAINT FK_USUARIO_CARTEIRA_ID FOREIGN KEY (id_usuario ) REFERENCES vac.usuario(id_usuario);
ALTER TABLE vac.carteira ADD CONSTRAINT FK_CARTEIRA_CARTEIRA_TP FOREIGN KEY (tp_carteira) REFERENCES vac.dom_carteira(tp_carteira);

/*
SELECT
		u.id_usuario 'Usuario',
        u.nm_usuario 'Nome',
        dg.nm_genero 'Genero',
        u.nm_cep 'CEP',
        u.id_idade 'Idade'
FROM 
		vac.usuario u
        JOIN
			vac.dom_genero dg
			ON
				u.tp_genero = dg.tp_genero
WHERE 
		nm_usuario like 'admin'
*/