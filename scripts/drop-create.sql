

create table TB_FORNECEDOR (
CD_FORNECEDOR int primary key auto_increment
,NM_FORNECEDOR VARCHAR(255) not null
,DS_EMAIL VARCHAR(255) null
,DS_RAZAO_SOCIAL VARCHAR(255) not null
,DS_CNPJ VARCHAR(255) not null
);
