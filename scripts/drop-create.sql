CREATE SEQUENCE USUARIO_SEQ
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;

CREATE SEQUENCE CONTA_SEQ
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;

CREATE SEQUENCE TAG_SEQ
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;

CREATE SEQUENCE CATEGORIA_SEQ
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;

CREATE SEQUENCE RECEITAS_SEQ
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;

CREATE TABLE TB_USUARIO(
 CODIGO_USUARIO   NUMBER(10,0)  PRIMARY KEY
,NOME_USUARIO     VARCHAR(255)  NOT NULL
,EMAIL_USUARIO    VARCHAR(255)  NOT NULL
,SENHA_USUARIO    VARCHAR(255)  NOT NULL
);

CREATE TABLE TB_CONTA(
 CODIGO_CONTA      NUMBER(10,0)  PRIMARY KEY
,CODIGO_USUARIO    NUMBER(10,0)  NOT NULL
,NOME_CONTA        VARCHAR(255)  NOT NULL
,TIPO_CONTA        VARCHAR(255)  NOT NULL
,VALOR_INICIAL     NUMBER(12,2)  NOT NULL
,CONSTRAINT FK_TB_USUSARIO_E_TB_CONTA FOREIGN KEY (CODIGO_USUARIO) REFERENCES TB_USUARIO (CODIGO_USUARIO)
);

CREATE TABLE TB_TAG(
 ID_TAG            NUMBER(10,0)  PRIMARY KEY
,CODIGO_CONTA      NUMBER(10,0)  NOT NULL
,NOME_TAG          VARCHAR(255)  NOT NULL
,CONSTRAINT FK_TB_CONTA_E_TB_TAG FOREIGN KEY (CODIGO_CONTA) REFERENCES TB_CONTA (CODIGO_CONTA)
);

CREATE TABLE TB_CATEGORIA(
 ID_CATEGORIA      NUMBER(10,0)  PRIMARY KEY
,CODIGO_CONTA      NUMBER(10,0)  NOT NULL
,NOME_CATEGORIA    VARCHAR(255)  NOT NULL
,CONSTRAINT FK_TB_CONTA_E_TB_CATEGORIA FOREIGN KEY (CODIGO_CONTA) REFERENCES TB_CONTA (CODIGO_CONTA)
);

CREATE TABLE TB_TRANSFERENCIAS(
 ID_TRANSF         NUMBER(10,0)  PRIMARY KEY
,CODIGO_CONTA      NUMBER(10,0)  NOT NULL
,NOME_TAG          VARCHAR(255)  NOT NULL
,DE_CONTA          VARCHAR(255)  NOT NULL
,PARA_CONTA        VARCHAR(255)  NOT NULL
,DT_EXECUCAO       NUMBER(8)     NOT NULL
,DESCRICAO_TRANSF  VARCHAR(255)  NOT NULL
,VALOR_TRANSF      NUMBER(12,2)  NOT NULL
,CONSTRAINT FK_TB_CONTA_E_TB_TRANSF FOREIGN KEY (CODIGO_CONTA) REFERENCES TB_CONTA (CODIGO_CONTA)
);

CREATE TABLE TB_RECEITAS(
 ID_RECEITA         NUMBER(10,0)  PRIMARY KEY
,CODIGO_CONTA       NUMBER(10,0)  NOT NULL
,TIPO_CONTA         VARCHAR(255)  NOT NULL
,NOME_TAG           VARCHAR(255)  NOT NULL
,NOME_CATEGORIA     VARCHAR(255)  NOT NULL
,DT_INCLUSAO_REC    NUMBER(8)     NOT NULL
,DESCRICAO_RECEITA  VARCHAR(255)  NOT NULL
,VALOR_RECEITA      NUMBER(12,2)  NOT NULL
,CONSTRAINT FK_TB_CONTA_E_TB_RECEITAS FOREIGN KEY (CODIGO_CONTA) REFERENCES TB_CONTA (CODIGO_CONTA)
);

CREATE TABLE TB_DESPESAS(
 ID_DESPESA          NUMBER(10,0)  PRIMARY KEY
,CODIGO_CONTA        NUMBER(10,0)  NOT NULL
,TIPO_CONTA          VARCHAR(255)  NOT NULL
,NOME_TAG            VARCHAR(255)  NOT NULL
,NOME_CATEGORIA      VARCHAR(255)  NOT NULL
,DT_INCLUSAO_DES     NUMBER(8)     NOT NULL
,DESCRICAO_DESPESAS  VARCHAR(255)  NOT NULL
,VALOR_DESPESAS      NUMBER(12,2)  NOT NULL
,CONSTRAINT FK_TB_CONTA_E_TB_DESPESAS FOREIGN KEY (CODIGO_CONTA) REFERENCES TB_CONTA (CODIGO_CONTA)
);

CREATE TABLE TB_CARTAO(
 ID_CATAO            NUMBER(10,0)  PRIMARY KEY
,CODIGO_CONTA        NUMBER(10,0)  NOT NULL
,TIPO_CONTA          VARCHAR(255)  NOT NULL
,NOME_TAG            VARCHAR(255)  NOT NULL
,NOME_CATEGORIA      VARCHAR(255)  NOT NULL
,QTD_PARCELAS        NUMBER(10)    NOT NULL
,PARCELA_ATUAL       NUMBER(10)    NOT NULL
,DT_INCLUSAO_CAR     NUMBER(8)     NOT NULL
,DESCRICAO_CARTAO    VARCHAR(255)  NOT NULL
,VALOR_CARTAO        NUMBER(12,2)  NOT NULL
,CONSTRAINT FK_TB_CONTA_E_TB_CARTAO FOREIGN KEY (CODIGO_CONTA) REFERENCES TB_CONTA (CODIGO_CONTA)
);