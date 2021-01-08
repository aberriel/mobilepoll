create database if not exists enquetemobile;

use enquetemobile;

set FOREIGN_KEY_CHECKS = 0;
drop table if exists Pessoa;
drop table if exists EstadoCivil;
drop table if exists TipoPessoa;
drop table if exists Sexo;
drop table if exists RG;
drop table if exists TituloEleitoral;
drop table if exists Endereco;
drop table if exists TipoEndereco;
drop table if exists Cidade;
drop table if exists UnidadeFederativa;
drop table if exists Telefone;
drop table if exists TipoTelefone;
drop table if exists Usuario;
drop table if exists Cliente;
drop table if exists TipoUsuario;
drop table if exists Sistema;
drop table if exists AssuntoMensagem;
drop table if exists ConfiguracaoCliente;
drop table if exists LogBD;
drop table if exists TipoOperacaoBD;
drop table if exists LogApp;
drop table if exists TipoObjeto;
drop table if exists TipoAcaoAplicacao;
drop table if exists TipoObjetoPermissao;
drop table if exists Recurso;
drop table if exists TipoRecurso;
drop table if exists TipoObjeto_Recurso;
drop table if exists ControleComunicacao;
drop table if exists GerenciadorSessao;
drop table if exists GrupoUsuario;
drop table if exists Usuario_GrupoUsuario;
drop table if exists EscopoPermissao;
drop table if exists Permissao;
drop table if exists ConfiguracaoGlobal;
drop table if exists TipoEnderecoServidor;
drop table if exists DadosCorreioEletronico;
drop table if exists CorreioClienteEntrevistador;
drop table if exists TipoDispositivoMovel;
drop table if exists DispositivoMovel;
drop table if exists FabricanteDispositivoMovel;
drop table if exists Marca;
drop table if exists Modelo;
drop table if exists FornecedorDispositivoMovel;
drop table if exists Fornecedor_Fabricante;
drop table if exists AutorizadaDispositivoMovel;
drop table if exists AutorizadaFabricante;
drop table if exists NotaFiscal;
drop table if exists DispositivoMovel_NotaFiscal;
drop table if exists TipoOrigemGarantia;
drop table if exists GarantiaDispositivoMovel;
drop table if exists DadosManutencao;
drop table if exists DadosRemocao;
drop table if exists DadosAuditoria;
drop table if exists DadosSaidaEnquete;
drop table if exists EstadoDM;
drop table if exists TipoUsoDispositivoMovel;
drop table if exists TipoAcaoRemota;
drop table if exists UsoRemotoDM;
drop table if exists ControleUsoDM;
drop table if exists SeguradoraDispositivoMovel;
drop table if exists ContratoSeguro;
drop table if exists SeguroDispositivoMovel;
drop table if exists OperadoraTelefonia;
drop table if exists SimCard;
drop table if exists AreaAtuacao;
drop table if exists Atividade;
drop table if exists Entrevistado;
drop table if exists CategoriaPesquisa;
drop table if exists Pesquisa;
drop table if exists TipoResposta;
drop table if exists Questao;
drop table if exists Alternativa;
drop table if exists Resposta;
drop table if exists AlternativaResposta;
drop table if exists MotivoTerminoPesquisa;
drop table if exists Enquete;
drop table if exists TipoSinistroCoberturaSeguro;
drop table if exists AutorizacaoUsuarioPesquisa;
drop table if exists PesquisaDispositivoMovel;
drop table if exists GPS_Data;
drop table if exists StatusMensagemCorreio;
set FOREIGN_KEY_CHECKS = 1;

/* Dados das pessoas */
create table Pessoa
(
    /* Identificadorunico do registro no banco */
    Id bigint not null primary key auto_increment,
    /** Nome completo da pessoa fisica. Se for juridica, sera o nome fantasia. */
    Nome varchar(200) not null,
    /* Nome simplificado da pessoa */
    NomeAbreviado varchar(120),
    EmailPrincipal varchar(120),
    EmailSecundario varchar(120),
    RG bigint,
    CPF varchar(14),
    CNPJ varchar(32),
    RazaoSocial varchar(200),
    InscricaoEstadual varchar(50),
    InscricaoMunicipal varchar(50),
    TituloEleitoral bigint,
    Sexo int,
    EstadoCivil int,
    DataDeNascimento datetime,
    TipoPessoa int,
    ChavePessoa varchar(64) not null,
    Valido boolean not null default 0,
    ChaveAtivacao varchar(40),
    DataAtivacao datetime,
    DataHoraRegistro datetime not null default now(),
    DataHoraUltimaAtualizacao datetime not null default now(),
    DataHoraExclusao datetime default null,
    ChaveExclusao varchar(64) default null,
    NumeroDeRegistro varchar(64),
    Comentarios text
);

alter table Pessoa COMMENT = 'Dados comuns às pessoas do sistema.';

create table EstadoCivil
(
    Id int not null primary key auto_increment,
    Nome varchar(80) not null,
    Descritivo text
);

alter table EstadoCivil COMMENT = 'Tipos de estados civis (como solteiro, casado, viúvo, divorciado, etc).';

alter table Pessoa add constraint FK_Pessoa_EstadoCivil foreign key (EstadoCivil) references EstadoCivil(Id);

insert into EstadoCivil(Nome)
values ('ESCI_OUTRO'),
       ('ESCI_SOLTEIRO'),
       ('ESCI_CASADO'),
       ('ESCI_VIUVO'),
       ('ESCI_DIVORCIADO'),
       ('ESCI_UNIAOESTAVEL');
       
create table TipoPessoa
(
    Id int not null primary key,
    Nome varchar(200) not null,
    Descritivo text
);

alter table TipoPessoa COMMENT = 'Tipos de pessoa segundo sua função jurídica.';

alter table Pessoa add constraint FK_Pessoa_TipoPessoa foreign key (TipoPessoa) references TipoPessoa(Id);

insert into TipoPessoa(Id, Nome)
values (1, 'TIPE_PESSOA_JURIDICA'),
       (2, 'TIPE_PESSOA_FISICA');
       
create table Sexo
(
    Id int not null primary key,
    Nome varchar(200) not null,
    Descritivo text
);s

alter table Sexo COMMENT = 'Tipos pré-definidos de sexo (masculino ou feminino).';

alter table Pessoa add constraint FK_Pessoa_Sexo foreign key (Sexo) references Sexo(Id);

insert into Sexo(Id, Nome)
values (1, 'SEXO_FEMININO'),
	   (2, 'SEXO_MASCULINO');

/* Documento de identificação de pessoa física */
create table RG
(
	/* Identificador único do registro na tabela */
	Id bigint not null primary key auto_increment,
    /* Número do documento de identificação */
    Numero varchar(20) not null,
    /* Instituição responsável pela expedição do documento */
    OrgaoExpeditor varchar(120) not null,
    /* Unidade federativa onde o documento foi expedido */
    EstadoExpeditor bigint not null,
    DataExpedicao datetime
);

alter table RG COMMENT = 'Registro de documentos identificadores de pessoas físicas.';

alter table Pessoa add constraint FK_Pessoa_RG foreign key (RG) references RG(Id);

create table TituloEleitoral
(
	Id bigint not null primary key auto_increment,
    NumeroTE varchar(40) not null,
    ZonaTE varchar(8) not null,
    SecaoTE varchar(8) not null,
    DataExpedicao datetime,
    EstadoExpedicao bigint not null,
    DataHoraRegistro datetime not null default now()
);

alter table tituloeleitoral COMMENT = 'Registro de título eleitoral de pessoa física..';

alter table Pessoa add constraint FK_Pessoa_TituloEleitoral foreign key (TituloEleitoral) references TituloEleitoral(Id);

create table Endereco
(
	/* Identificador único do registro na tabela */
	Id bigint not null primary key auto_increment,
    TipoDeEndereco bigint,
    Logradouro varchar(300) not null,
    NumeroEndereco varchar(10),
    Complemento varchar(120),
    Bairro varchar(200),
    Cidade bigint not null,
    /* Código postal */
    CEP varchar(15),
    /* Pessoa dona do endereço */
    Pessoa bigint,
    /* Comeentários e/ou observações pertinentes */
    Comentarios text,
    EnderecoPrincipal boolean not null default false,
    DataHoraRegistro datetime not null default now()
);

alter table Endereco COMMENT = 'Registro de endereço físico completo de pessoa..';

alter table Endereco add constraint FK_Endereco_Pessoa foreign key (Pessoa) references Pessoa(Id);

create table TipoEndereco
(
	/* Identificador único do registro na a=tabela */
	Id bigint not null primary key auto_increment,
    Nome varchar(200) not null,
    CaminhoCompletoIcone varchar(300),
    Comentarios text,
    DataHoraRegistro datetime not null default now()
);

alter table tipoendereco COMMENT = 'Tipo de endereço segundo a sua função (residencial, comercial, etc).';

alter table Endereco add constraint FK_TipoEndereco_Endereco foreign key (TipoDeEndereco) references TipoEndereco(Id);

/* Registro de municípios */
create table Cidade
(
	/* Identificador único do registro na tabela */
	Id bigint not null primary key auto_increment,
    /* Nome do município */
    Nome varchar(300) not null,
    /* Unidade federativa (estado) ao qual o município pertence */
    UnidadeFederativa bigint not null,
    /* Comentários e/ou observações pertinentes */
    Comentarios text,
    DataHoraRegistro datetime not null default now()
);

alter table Cidade COMMENT = 'Registro de municípios.';

alter table Endereco add constraint FK_Cidade_Endereco foreign key (Cidade) references Cidade(Id);

create table UnidadeFederativa
(
	Id bigint not null primary key auto_increment,
    Nome varchar(200) not null,
    Sigla varchar(3) not null,
    Comentarios text,
    DataHoraRegistro datetime not null default now()
);

alter table unidadefederativa COMMENT = 'Registro de unidades federativas (ou estados).';

alter table Cidade add constraint FK_UnidadeFederativa_Cidade foreign key (UnidadeFederativa) references UnidadeFederativa(Id);
alter table RG add constraint FK_RG_UnidadeFederativa foreign key (EstadoExpeditor) references UnidadeFederativa(Id);
alter table TituloEleitoral add constraint FK_TituloEleitoral_UnidadeFederativa foreign key (EstadoExpedicao) references UnidadeFederativa(Id);

/* Registro de telefones de pessoas */
create table Telefone
(
	/* Identificador único do registro na tabela */
	Id bigint not null primary key auto_increment,
    DDI varchar(5) not null default '+55',
    DDD varchar(4) not null,
    NumeroTelefone varchar(12) not null,
    Ramal varchar(6),
    Pessoa bigint,
    TipoDeTelefone bigint,
    DataHoraRegistro datetime not null default now(),
    Comentarios text
);

alter table Telefone COMMENT = 'Registro de telefones de pessoas.';

alter table Telefone add constraint FK_Telefone_Pessoa foreign key (Pessoa) references Pessoa(Id);

create table TipoTelefone
(
	Id bigint not null primary key auto_increment,
    Nome varchar(200) not null,
    Comentarios text,
    CaminhoCompletoIcone varchar(300),
    DataHoraRegistro datetime not null default now()
);

alter table tipotelefone COMMENT = 'Tipo de telefone segundo o seu uso (residencial, comercial, etc).';

alter table Telefone add constraint FK_Telefone_TipoTelefone foreign key (TipoDeTelefone) references TipoTelefone(Id);

create table Cliente
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key,
    Contato varchar(120),
    /* Usuário responsável pelo gerenciamento da conta do cliente no enqueteMobile */
    Gerente bigint not null
);

alter table cliente COMMENT = 'Registro de clientes do EnqueteMobile, isto é, empresas que registram as enquetes e as executam..';

alter table Cliente add constraint FK_Pessoa_Cliente foreign key (Id) references Pessoa(Id);

create table Usuario
(
    Id bigint not null primary key,
    ApelidoUsuario varchar(50) not null,
    Senha varchar(64),
    /* Tipo do usuário (se do cliente ou administrador */
    TipoUsuario bigint not null,
    /* Cliente ao qual o usuário pertence */
    Cliente bigint,
    PerguntaSecreta varchar(200),
    RespostaSecreta varchar(100),
    AlterarSenha boolean not null default false,
    UsuarioMestre boolean not null default false,
    /* Caminho completo para arquivo de imagem de foto do usuário */
    Foto varchar(300),
    ControleRedefinicaoSenha varchar(50),
    DataHoraSolicitacaoRedefinicaoSenha datetime
);

alter table usuario COMMENT = 'Registro de usuários do sistema.';

alter table Usuario add constraint FK_Pessoa_Usuario foreign key (Id) references Pessoa(Id);
alter table Usuario add constraint FK_Usuario_Cliente foreign key (Cliente) references Cliente(Id);
alter table Cliente add constraint FK_Cliente_Gerente foreign key (Gerente) references Usuario(Id);

create table TipoUsuario
(
	Id int not null primary key,
    Nome varchar(200) not null,
    Descritivo text
);

alter table TipoUsuario COMMENT = 'Registro do tipo de usuário. O tipo define a área do sistema que o usuário poderá acessar (se a administrativa ou somente a do cliente.';

alter table Usuario add constraint FK_Usuario_TipoUsuario foreign key (TipoUsuario) references TipoUsuario(Id);

insert into TipoUsuario (Id, Nome)
values (1, 'TIUS_Sistema'),
	   (2, 'TIUS_Cliente');

/* Registro de sistemas ou aplicações */       
create table Sistema
(
    /* Identificador único do registro no banco */
    Id bigint not null primary key auto_increment,
    Nome varchar(200) not null,
    Descricao text,
    Movel boolean not null default false,
    ChaveSistema varchar(100),
    CaminhoCompletoIcone varchar(300),
    DataHoraRegistro datetime not null default now()
);

alter table sistema COMMENT = 'Sistemas ou aplicações que poderão acessar o EnqueteMobile.';

create table AssuntoMensagem
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    Nome varchar(200) not null,
    Descricao text,
    DataHoraRegistro datetime not null default now()
);

alter table assuntomensagem COMMENT = 'Registro de assuntos de mensagem que usuário poderá enviar aos administradores do sistema pela página de envio de mensagem (aplicação web) ou tela de envio de mensagens (aplicação mobile).';

create table ConfiguracaoCliente
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    /* Sistema ao qual a configuração se aplica */
    Sistema bigint not null,
    Cliente bigint not null,
    /* Data e hora da inserção do registro na tabela */
    DataHoraRegistro datetime not null default now(),
    DataHoraInvalidacao datetime,
    PeriodoTrocaPeriodicaSenha timestamp,
    ToleranciaParaResponderEnquete timestamp,
    ToleranciaSemMovimentacao timestamp
);

alter table configuracaocliente COMMENT = 'Registro de configurações gerais específicas do cliente.';

alter table ConfiguracaoCliente add constraint FK_ConfiguracaoCliente_Sistema foreign key (Sistema) references Sistema(Id);
alter table ConfiguracaoCliente add constraint FK_ConfiguracaoCliente_Cliente foreign key (Cliente) references Cliente(Id);

/* Tabela de log dos acessos ao banco */
create table LogBD
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    DataHora datetime not null default now(),
    /* Usuário do banco de dados utilizado */
    UsuarioBD varchar(120),
    /* Usuário do enquete mobile */
    UsuarioSistema varchar(120),
    /* Aplicação ou sistema a partir da qual o acesso ao banco foi feito */
    Sistema bigint not null,
    /* Nome da tabela acessada */
    NomeTabela varchar(120),
    /* Identificador do registro afetado */
    IdRegistro bigint,
    /* Dados antigos (antes da execução da operação) */
    ValoresAntigos text,
    /* Dados novos (após a execução da operação) */
    ValoresNovos text,
    TipoDeOperacaoNoBancoDeDados int not null default 0
);

alter table logbd COMMENT = 'Log de execução de operações no banco de dados.';

alter table LogBD add constraint FK_LogBD_Sistema foreign key (Sistema) references Sistema(Id);

create table TipoOperacaoBD
(
    Id int not null primary key,
    Nome varchar(120) not null,
    Descricao text,
    DataHoraRegistro datetime not null default now()
);

alter table tipooperacaobd COMMENT = 'Tipos de operação que a aplicação poderá executar no banco de dados (essencialmente operações CRUD).';

alter table LogBD add constraint FK_LogBD_TipoOperacaoBD foreign key (TipoDeOperacaoNoBancoDeDados) references TipoOperacaoBD(Id);

insert into TipoOperacaoBD(Id, Nome)
values (1, 'TOBD_CONSULTAR'),
       (2, 'TOBD_CRIAR'),
       (3, 'TOBD_ATUALIZAR'),
       (4, 'TOBD_DELETAR');

/* Tabela de log da aplicação ou serviço */       
create table LogApp
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    Descricao text,
    Sistema bigint not null,
    IP varchar(15),
    /* Data e hora da inserção do registro no banco */
    DataHoraRegistroLogApp datetime not null default now(),
    LoginDoUsuario varchar(120),
    Modulo varchar(120),
    Classe varchar(120),
    Metodo varchar(120),
    Parametros text,
    UrlArquivoFonte varchar(300),
    NumeroLinhaCodigoFonte varchar(8),
    TipoDeAcaoDaAplicacao bigint,
    SQL_Code text,
    TipoExcecao text,
    ExcecaoCapturada text,
    NavegadorWebUsado varchar(100),
    Source text
);

alter table logapp COMMENT = 'Log de ações realizadas na aplicação (mais alto nível que o log de ações realizadas no banco).';

alter table LogApp add constraint FK_LogApp_Sistema foreign key (Sistema) references Sistema(Id);

create table TipoObjeto
(
    Id bigint not null primary key auto_increment,
    Nome varchar(200) not null,
    Descricao text,
    IdentificadorLiteral int,
    DataHoraRegistro datetime not null default now()
);

alter table tipoobjeto COMMENT = 'Tipos de objeto ou entidades do sistema sobre os quais podem incidir permissões.';

create table TipoAcaoAplicacao
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    Nome varchar(200) not null,
    Descricao text,
    /* Tipo do objeto do sistema sobre o qual a ação incide */
    TipoObjeto bigint not null,
    /* Data e hora da inserção do registro no banco */
    DataHoraRegistro datetime not null default now()
);

alter table tipoacaoaplicacao COMMENT = 'Tipos de ações ou tarefas que podem ser executadas no sistema em relação a dado tipo de objeto (por exemplo, para o tipo de objeto Cliente, pode ser executada a criação deste, atualização do registro, bloqueio, etc).';

alter table TipoAcaoAplicacao add constraint FK_TipoAcaoAplicacao_TipoObjeto foreign key (TipoObjeto) references TipoObjeto(Id);
alter table LogApp add constraint FK_LogApp_TipoAcaoAplicacao foreign key (TipoDeAcaoDaAplicacao) references TipoAcaoAplicacao(Id);

create table TipoObjetoPermissao
(
    Id bigint not null primary key auto_increment,
    Nome varchar(200) not null,
    Descricao text,
    TipoObjeto bigint not null,
    TipoDeAcaoDaAplicacao bigint not null,
    IdentificadorLiteral int
);

alter table TipoObjetoPermissao COMMENT = 'Permissões relacionadas às ações que podem ser executadas sobre cada tipo de objeto.';

alter table TipoObjetoPermissao add constraint FK_TipoObjetoPermissao_TipoObjeto foreign key (TipoObjeto) references TipoObjeto(Id);
alter table TipoObjetoPermissao add constraint FK_TipoObjetoPermissao_TipoDeAcaoDaAplicacao foreign key (TipoDeAcaoDaAplicacao) references TipoAcaoAplicacao(Id);

/* Recursos do sistema sobre os quais podem incidir permissões */
create table Recurso
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    /* Nome do recurso */
    Nome varchar(200) not null,
    /* Comentários e/ou observações pertinentes */
    Comentarios text,
    /* Sistema ou aplicação ao qual o recurso pertence */
    Sistema bigint not null,
    /* Tipo do recurso */
    TipoRecurso bigint not null,
    Localizacao varchar(1000),
    /* Flag indicador de recurso exclusivo do painel administrativo */
    ItemAdministrativo boolean not null default false
);

alter table Recurso COMMENT = 'Recursos físicos, como páginas web, frame de aplicação móvel, etc.';

alter table Recurso add constraint FK_Resurso_Sistema foreign key (Sistema) references Sistema(Id);

create table TipoRecurso
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    Nome varchar(200) not null,
    Descricao text,
    /* Data e hora de inserção do registro no banco */
    DataHoraRegistro datetime not null default now()
);

alter table tiporecurso COMMENT = 'Tipo ou categoria do recurso..';

alter table Recurso add constraint FK_Recurso_TipoRecurso foreign key (TipoRecurso) references TipoRecurso(Id);

create table TipoObjeto_Recurso
(
    ItemRecurso bigint not null,
    TipoObjeto bigint not null,
    PermissoesUsadas varchar(20),
    primary key (ItemRecurso, TipoObjeto)
);

alter table tipoobjeto_recurso COMMENT = 'Associa ao recurso os tipos de objeto ou entidades do sistema que poderão ser manipuladas neste.';

alter table TipoObjeto_Recurso add constraint FK_TipoObjetoRecurso_TipoObjeto foreign key (TipoObjeto) references TipoObjeto(Id);
alter table TipoObjeto_Recurso add constraint FK_TipoObjetoRecurso_Recurso foreign key (ItemRecurso) references Recurso(Id);

/* Gerenciamento da comunicação entre dispositivos móveis e servidor */
create table ControleComunicacao
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    IdRemoto bigint,
    IdOperacao int,
    DispositivoMovel bigint not null,
    /* Data e hora do envio da comunicação */
    DataHoraSaida datetime,
    /* Data e hora do recebimento da comunicação */
    DataHoraEntrada datetime,
    /* Dados enviados */
    ConteudoPacoteSaida text,
    /* Dados recebidos */
    ConteudoPacoteEntrada text,
    PossuiRetorno boolean not null default false,
    ChaveUsuario varchar(50),
    SentidoComunicacao int not null,
    Processado boolean not null default false,
    /* Chave identificadora dessa comunicação em especial */
    ChaveComunicacao varchar(50),
    MensagemErro text
);

alter table controlecomunicacao COMMENT = 'Tabela de gerenciamento da comunicação entre os dispositivos móveis e o servidor..';

/* Gerenciamento de sessão de usuário */
create table GerenciadorSessao
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    /* Sistema onde se deu a autenticação do usuário */
    OrigemSessao bigint not null,
    /* Chave pública identificadora dessa sessão em específico */
    ChaveSessao varchar(50),
    /* Chave pública identificadora do sistema onde se deu a autenticação */
    ChaveSistema varchar(50),
    /* Identificador do usuário autenticado */
    IdUsuarioAutenticado bigint,
    /* Data e hora da autenticaçào (início da sessão */
    DataHoraInicio datetime not null,
    DataHoraUltimaMovimentacao datetime not null,
    /* Data e hora do término da sessão */
    DataHoraExpiracao datetime,
    /* Causa do término da sessão */
    MotivoTermino text
);

alter table GerenciadorSessao add constraint FK_GerenciadorSessao_Sistema foreign key (OrigemSessao) references Sistema(Id);

/* Grupos ou perfis de usuários */
create table GrupoUsuario
(
    /* Identificador único do registro no banco */
    Id bigint not null primary key auto_increment,
    /* Nome do perfil de usuário */
    Nome varchar(200) not null,
    /* Comentários e/ou observações pertinentes */
    Descricao text,
    GrupoDoSistema boolean,
    /* Data e hora da inserção do registro no banco */
    DataHoraRegistro datetime not null default now(),
    /* Data e hora da última atualização do registro */
    DataHoraUltimaAtualizacao datetime not null default now()
);

/* Tabela associativa de usuário a perfil de usuário */
create table Usuario_GrupoUsuario
(
    /* Usuário associado ao perfil */
    Usuario bigint not null,
    /* Perfil ao qual o usuário foi associado */
    GrupoDeUsuario bigint not null,
    primary key (Usuario, GrupoDeUsuario)
);

alter table Usuario_GrupoUsuario add constraint FK_UsuarioGrupoUsuario_Usuario foreign key (Usuario) references Usuario(Id);
alter table Usuario_GrupoUsuario add constraint FK_UsuarioGrupoUsuario_GrupoUsuario foreign key (GrupoDeUsuario) references GrupoUsuario(Id);

create table EscopoPermissao
(
    Id bigint not null primary key,
    Nome varchar(200) not null,
    Descricao text
);

insert into EscopoPermissao(Id, Nome)
values (0, 'ESPE_NENHUM'),
       (1, 'ESPE_PROPRIO'),
       (2, 'ESPE_CLIENTE'),
       (3, 'ESPE_SISTEMA'),
       (4, 'ESPE_PUBLICO');
       
create table Permissao
(
    /* Identificador único do registro no banco */
    Id bigint not null primary key auto_increment,
    GrupoDeUsuario bigint,
    /* Usuário ao qual as permissões pertencem */
    Usuario bigint,
    /* Objeto do sistema ao qual as permissões se aplicam */
    TipoObjeto int,
    EscopoPermissao bigint not null,
    LimiteNumeroRegistro int not null default 0, /* A priori sem limitação */
    PermissaoDoObjeto int,
    Valido boolean not null default false,
    DataHoraRegistro datetime not null default now()
);

alter table Permissao add constraint FK_Permissao_GrupoUsuario foreign key (GrupoDeUsuario) references GrupoUsuario(Id);
alter table Permissao add constraint FK_Permissao_Usuario foreign key (Usuario) references Usuario(Id);
alter table Permissao add constraint FK_Permissao_EscopoPermissao foreign key (EscopoPermissao) references EscopoPermissao(Id);

create table ConfiguracaoGlobal
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    /* Sistema ou aplicação ao qual as configuraçòes se aplicam */
    Sistema bigint not null,
    ConfiguracaoEnvioCorreioEletronicoGlobal bigint,
    SenhaMestra varchar(64),
    ToleranciaParaResponderEnquete time,
    TempoLimiteSessao time,
    /* Tempo máximo que o usuário pode permanecer conectado sem realizar ação */
    ToleranciaSemMovimentacao time,
    /* Máximo de usuários conectados simultaneamente */
    MaximoUsuariosConectadosGlobal int not null default 0, /* A priori, sem limitação */
    MaximoUsuariosConectadosPorCliente int not null default 0, /* A priori, sem limitação */
    DataHoraRegistro datetime not null default now(),
    DataHoraInvalidacao datetime
);

alter table ConfiguracaoGlobal add constraint FK_ConfiguracaoGlobal_Sistema foreign key (Sistema) references Sistema(Id);

create table TipoEnderecoServidor
(
    Id bigint not null primary key auto_increment,
    Nome varchar(200) not null,
    Descricao text,
    FormatoString varchar(40),
    DataHoraRegistro datetime not null default now(),
    UsuarioResponsavelPeloRegistro bigint not null
);

alter table TipoEnderecoServidor add constraint FK_TipoEnderecoServidor_Usuario foreign key (UsuarioResponsavelPeloRegistro) references Usuario(Id);

/* Definições para envio de e-mail automatizado */
create table DadosCorreioEletronico
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    Nome varchar(200) not null,
    Descricao text,
    /* Login para autenticação no servidor SMTP */
    ApelidoUsuario varchar(50) not null,
    /* Senha para autenticação no servidor SMTP */
    Senha varchar(50) not null,
    UsarSSL boolean not null default 0,
    /* Formato empregado no endereço do servidor SMTP */
    TipoDeEnderecoDoServidorSmtp bigint not null,
    /* Endereço do servidor SMTP */
    EnderecoServidorSmtp varchar(200) not null,
    Porta varchar(8),
    /* Data e hora da inserção do registro na tabela */
    DataHoraRegistro datetime not null default now(),
    /* Data e hora da invalidação da configuração */
    DataHoraInvalidacao datetime
);

alter table DadosCorreioEletronico add constraint FK_DadosCorreioEletronico_TipoEnderecoServidor foreign key (TipoDeEnderecoDoServidorSmtp) references TipoEnderecoServidor(Id);
alter table ConfiguracaoGlobal add constraint FK_ConfiguracaoGlobal_DadosCorreioEletronico foreign key (ConfiguracaoEnvioCorreioEletronicoGlobal) references DadosCorreioEletronico(Id);

/* Caixa de mensagens entre o entrevistador e a empresa */
create table CorreioClienteEntrevistador
(
    /* Identificador unico do registro no banco */
    Id bigint not null primary key auto_increment,
    /* Cliente envolvido na comunicação */
    Cliente bigint not null,
    /* Entrevistador envolvido na comunicação */
    Entrevistador bigint not null,
    /* Mensagem enviada */
    Mensagem text not null,
    /* Sentido da comunicação (se cliente -> entrevistador ou entrevistador -> cliente) */
    SentidoComunicacao int not null,
    ControleDeComunicacao bigint,
    StatusMensagemCorreio bigint,
    ConfirmacaoAbertura boolean
);

alter table CorreioClienteEntrevistador add constraint FK_CorreioClienteEntrevistador_Cliente foreign key (Cliente) references Cliente(Id);
alter table CorreioClienteEntrevistador add constraint FK_CorreioClienteEntrevistador_Entrevistador foreign key (Entrevistador) references Usuario(Id);
alter table CorreioClienteEntrevistador add constraint FK_CorreioClienteEntrevistador_ControleComunicacao foreign key (ControleDeComunicacao) references ControleComunicacao(Id);

/* Tipos de dispositivo móvel */
create table TipoDispositivoMovel
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    Nome varchar(200) not null,
    Descricao text,
    Sistema bigint not null,
    DataHoraRegistro datetime not null default now()
);

alter table TipoDispositivoMovel add constraint FK_TipoDispositivoMovel_Sistema foreign key (Sistema) references Sistema(Id);

/* Registro de dispositivos móveis dos clientes */
create table DispositivoMovel
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    /* Chave pública iodentificadora do dispositivo móvel */
    ChaveDispositivoMovel varchar(50) not null,
    /* cliente ao qual o dispositivo móvel pertence */
    Cliente bigint not null,
    ModeloDeDispositivoMovel bigint,
    TipoDispositivoMovel bigint not null,
    /* Número da nota fiscal de compra do dispositivo móvel */
    NumeroNotaFiscal varchar(50),
    /* Número de série do dispositivo móvel */
    IMEI varchar(20),
    RedesSuportadas varchar(200),
    UsuarioResponsavelPeloRegistro bigint not null,
    DataHoraRegistro datetime not null default now(),
    DataHoraExclusao datetime default null,
    ChaveExclusao varchar(64) default null
);

alter table DispositivoMovel add constraint FK_DispositivoMovel_Cliente foreign key (Cliente) references Cliente(Id);
alter table DispositivoMovel add constraint FK_DispositivoMovel_Usuario foreign key (UsuarioResponsavelPeloRegistro) references Usuario(Id);
alter table DispositivoMovel add constraint FK_DispositivoMovel_TipoDispositivoMovel foreign key (TipoDispositivoMovel) references TipoDispositivoMovel(Id);
alter table ControleComunicacao add constraint FK_ControleComunicacao_DispositivoMovel foreign key (DispositivoMovel) references DispositivoMovel(Id);

/* Registro de fabricantes de dispositivos móveis */
create table FabricanteDispositivoMovel
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key,
    /* Página web do fabricante do dispositivo móvel */
    PaginaWeb varchar(300)
);

alter table FabricanteDispositivoMovel add constraint FK_FabricanteDispositivoMovel_Pessoa foreign key (Id) references Pessoa(Id);

/* Tbela de marcas (grupos de modelos) de dispositivos moveis */
create table Marca
(
    /* Identificador unico do registro no banco */
    Id bigint not null primary key auto_increment,
    /* NMome da marca */
    Nome varchar(200) not null,
    /* Fabricante dono da marca */
    FabricanteDeDispositivoMovel bigint not null,
    /* Comentarios e/ou observações pertinentes */
    Comentarios text,
    DataHoraRegistro datetime not null default now()
);

alter table Marca add constraint FK_Marca_FabricanteDispositivoMovel foreign key (FabricanteDeDispositivoMovel) references FabricanteDispositivoMovel(Id);

/* Tabela de modelos de dispositvo movel */
create table Modelo
(
    /* Identificador unico do registro no banco */
    Id bigint not null primary key auto_increment,
    /* Nome do modelo */
    Nome varchar(200) not null,
    /* Marca a qual o modelo pertence */
    MarcaDeDispositivoMovel bigint not null,
    /* Especificações tecnicas do modelo */
    EspecificacoesTecnicas text,
    /* Tipos de redes suportadas */
    RedesSuportadas varchar(500),
    /* Pagina web do modelo */
    PaginaWeb varchar(300),
    /** Comentarios e/ou observações pertinentes */
    Comentarios text,
    DataHoraRegistro datetime not null default now()
);

alter table Modelo add constraint FK_Modelo_Marca foreign key (MarcaDeDispositivoMovel) references Marca(Id);
alter table DispositivoMovel add constraint FK_DispositivoMovel_Modelo foreign key (ModeloDeDispositivoMovel) references Modelo(Id);

create table FornecedorDispositivoMovel
(
    Id bigint not null primary key,
    PaginaWeb varchar(300),
    Cliente bigint not null
);

alter table FornecedorDispositivoMovel add constraint FK_FornecedorDispositivoMovel_Cliente foreign key (Cliente) references Cliente(Id);
alter table FornecedorDispositivoMovel add constraint FK_FornecedorDispositivoMovel_Pessoa foreign key (Id) references Pessoa(Id);

/* Associa fornecedor de dispositivos móveis a fabricantes com os quais ele trabalha */
create table Fornecedor_Fabricante
(
    Id bigint not null primary key auto_increment;
    FornecedorDeDispositivoMovel bigint not null,
    FabricanteDeDispositivoMovel bigint not null,
    DataHoraAssociacao datetime not null,
    primary key (FornecedorDeDispositivoMovel, FabricanteDeDispositivoMovel)
);

alter table Fornecedor_Fabricante add constraint FK_FornecedorFabricante_FornecedorDispositivoMovel foreign key (FornecedorDeDispositivoMovel) references FornecedorDispositivoMovel(Id);
alter table Fornecedor_Fabricante add constraint FK_FornecedorFabricante_FabricanteDispositivoMovel foreign key (FabricanteDeDispositivoMovel) references FabricanteDispositivoMovel(Id);

/* Registro de empresas responsáveis pela manutenção de dispositivos móveis */
create table AutorizadaDispositivoMovel
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key,
    Cliente bigint not null
);

alter table AutorizadaDispositivoMovel add constraint FK_AutorizadaDispositivoMovel_Cliente foreign key (Cliente) references Cliente(Id);
alter table AutorizadaDispositivoMovel add constraint FK_AutorizadaDispositivoMovel_Pessoa foreign key (Id) references Pessoa(Id);

/* Associa a autorizada aos fabricantes com os quais ela trabalha */
create table AutorizadaFabricante
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    Autorizada bigint not null,
    FabricanteDeDispositivoMovel bigint not null,
    /* Modelos que a autorizada dá suporte */
    ModelosTrabalhados varchar(500),
    Comentarios text,
    /* Data e hora da inserção do registro na tabela */
    DataHoraRegistro datetime not null default now()
);

alter table AutorizadaFabricante add constraint FK_AutorizadaFabricante_AutorizadaDispositivoMovel foreign key (Autorizada) references AutorizadaDispositivoMovel(Id);
alter table AutorizadaFabricante add constraint FK_AutorizadaFabricante_FabricanteDispositivoMovel foreign key (FabricanteDeDispositivoMovel) references FabricanteDispositivoMovel(Id);

/* Registro de notas fiscais de compra de dispositivos móveis */
create table NotaFiscal
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    /* Cliente que realizou a compra */
    Cliente bigint not null,
    /* Fornecedor onde a compra foi feita */
    FornecedorDeDispositivoMovel bigint not null,
    /* Número da nota fiscal */
    Numero varchar(40) not null,
    ProtocoloAutorizacaoUso varchar(40),
    DataHora datetime not null
);

alter table NotaFiscal add constraint FK_NotaFiscal_Cliente foreign key (Cliente) references Cliente(Id);
alter table NotaFiscal add constraint FK_NotaFiscal_FornecedorDispositivoMovel foreign key (FornecedorDeDispositivoMovel) references FornecedorDispositivoMovel(Id);

/* Associa dispositivos móveis às suas respectivas notas de compra */
create table DispositivoMovel_NotaFiscal
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    NotaFiscal bigint not null,
    DispositivoMovel bigint not null,
    Garantia bigint,
    MedidaUnidade varchar(30),
    ValorUnitario decimal(15,2),
    CodigoProduto varchar(40),
    /* Quantidade de dispositivos móveis do tipo relacionado comprados */
    Quantidade decimal(12,6) not null default 0.0,
    AliquotaIpi decimal(4,3),
    ValorIpi decimal(15,2),
    AliquotaIcms decimal(4,3),
    BaseCalculoIcms decimal(15,2),
    ValorIcms decimal(15,2),
    CFOP varchar(4),
    NCM varchar(8),
    /* Código da Situação Tributária */
    CST varchar(3)
);

alter table DispositivoMovel_NotaFiscal add constraint FK_DispositivoMovelNotaFiscal_NotaFiscal foreign key (NotaFiscal) references NotaFiscal(Id);
alter table DispositivoMovel_NotaFiscal add constraint FK_DispositivoMovelNotaFiscal_DispositivoMovel foreign key (DispositivoMovel) references DispositivoMovel(Id);

create table TipoOrigemGarantia
(
    Id int not null primary key auto_increment,
    Nome varchar(200) not null,
    Descricao text
);

insert into TipoOrigemGarantia (Nome)
values ('TIOG_OUTRO'),
       ('TIOG_FABRICANTE'),
       ('TIOG_FABRICANTE_EXTENDIDA'),
       ('TIOG_LOJA'),
       ('TIOG_LOJA_EXTENDIDA'),
       ('TIOG_SEGURO');
       
create table GarantiaDispositivoMovel
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    NumeroContratoGarantia varchar(50),
    /* Origem da garantia */
    TipoDeOrigemDeGarantia int not null,
    /* dispositivo móvel coberto */
    DispositivoMovel bigint not null,
    /* Para garantias obtidas a partir de contratação de seguro */
    ContratoDeSeguro bigint,
    /* Data e hora de in;icio de vigência de garantia */
    DataHoraInicio datetime not null,
    /* Data e hora prevista para término da garantia */
    DataHoraTerminoPrevisao datetime,
    /* Data e hora do término real da garantia */
    DataHoraTerminoReal datetime,
    /* Causa do fim da garantia */
    MotivoTermino text,
    /* Valor pago pela garantia */
    Valor decimal(15,2)
);

alter table GarantiaDispositivoMovel add constraint FK_GarantiaDispositivoMovel_TipoOrigemGarantia foreign key (TipoDeOrigemDeGarantia) references TipoOrigemGarantia(Id);
alter table GarantiaDispositivoMovel add constraint FK_GarantiaDispositivoMovel_DispositivoMovel foreign key (DispositivoMovel) references DispositivoMovel(Id);
alter table DispositivoMovel_NotaFiscal add constraint FK_DispositivoMovelNotaFiscal_GarantiaDispositivoMovel foreign key (Garantia) references GarantiaDispositivoMovel(Id);

create table DadosManutencao
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    /* Autorizada onde foi realizado o reparo */
    Autorizada bigint not null,
    ResponsavelPelaRetirada bigint,
    TecnicoResponsavelPeloReparo bigint,
    ServicoRealizado text,
    ResponsavelPelaDevolucao bigint,
    CondicoesDeRetornoDoDispositivoMovel text,
    /* Flag indicador de cobertura do reparo pela garantia */
    GarantiaCobriu boolean not null default false,
    /* Flag indicador da necessidade de descarte do dispositivo móvel pela não possibilidade de reparo */
    RequerDescarte boolean not null default false,
    DataHoraInicio datetime not null,
    DataHoraTermino datetime,
    DataHoraSaidaAutorizada datetime,
    DataHoraEntradaAutorizada datetime,
    Valor decimal(15,2),
    MotivoManutencao text
);

alter table DadosManutencao add constraint FK_DadosManutencao_AutorizadaDispositivoMovel foreign key (Autorizada) references AutorizadaDispositivoMovel(Id);
alter table DadosManutencao add constraint FK_DadosManutencao_ResponsavelRetirada foreign key (ResponsavelPelaRetirada) references Pessoa(Id);
alter table DadosManutencao add constraint FK_DadosManutencao_ResponsavelReparo foreign key (TecnicoResponsavelPeloReparo) references Pessoa(Id);
alter table DadosManutencao add constraint FK_DadosManutencao_ResponsavelDevolucao foreign key (ResponsavelPelaDevolucao) references Pessoa(Id);

/* Para remoção de dispositivo móvel dos ativos da empresa */
create table DadosRemocao
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    /* Para dispositivo móvel removido por perda ou roubo */
    DadosBoletimOcorrencia varchar(1500),
    MotivoRemocaoDispositivoMovel varchar(1000),
    /* Descritivo do ocorrido bem como do destino dado */
    Destino varchar(1000)
);

/* Registro de auditoria em dispositivos móveis */
create table DadosAuditoria
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    ResponsavelPelaAuditoria bigint not null,
    ResultadoAuditoria varchar(1500),
    /* Flag indicador de necessidade de reparo */
    RequerManutencao boolean not null default 0,
    /* Flag indicador de necessidade de remoção */
    RequerDescarte boolean not null default 0
);

alter table DadosAuditoria add constraint FK_DadosAuditoria_ResponsavelAuditoria foreign key (ResponsavelPelaAuditoria) references Pessoa(Id);

/* Histórico de retiradas para a realização de enquetes na rua */
create table DadosSaidaEnquete
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    /* Dispositivo móvel necessita de reparo após o retorno */
    RequerManutencao boolean not null default 0,
    /* Dispositivo móvel deve ser removido por roubo ou dano irreparável */
    RequerDescarte boolean not null default 0,
    /* Comentários ou observações pertinetes */
    Comentarios varchar(3000),
    /* Chip de telefonia associado ao dispositivo móvel */
    SimCard bigint,
    /* Descritivo do estado de retorno, quando necessário informar */
    CondicoesDeRetornoDoDispositivoMovel varchar(1500)
);

create table EstadoDM
(
	Id bigint not null primary key auto_increment,
    Nome varchar(200),
    Descricao varchar(3000)
);

insert into EstadoDM(Nome)
values ('ESDM_OUTRO'),
       ('ESDM_ENQUETEEXTERNA'),
       ('ESDM_DESCARTE'),
       ('ESDM_AUDITORIA'),
       ('ESDM_AQUISICAO'),
       ('ESDM_MANUTENCAO');

/* Formas de uso do dispositivo móvel */
create table TipoUsoDispositivoMovel
(
    /* Identificador único do registro no banco */
    Id bigint not null primary key auto_increment,
    Nome varchar(200) not null,
    Descricao varchar(3000),
    /* Tempo máximo que o dispositivo pode permanecer neste estado */
    ToleranciaMaxima time,
    EstadoDoDispositivoMovelAssociado bigint
);

alter table TipoUsoDispositivoMovel add constraint FK_TipoUsoDispositivoMovel_EstadoDM foreign key (EstadoDoDispositivoMovelAssociado) references EstadoDM(Id);

create table TipoAcaoRemota
(
    Id bigint not null primary key auto_increment,
    Nome varchar(200) not null,
    Descricao varchar(3000)
);

insert into TipoAcaoRemota(Nome)
values ('TAR_CONSULTADADOS'),
       ('TAR_AUTENTICACAO'),
       ('TAR_SUBMISSAORESPOSTA'),
       ('TAR_SINCRONISMODADOS'),
       ('TAR_SINALVIDA'),
       ('TAR_VALIDACAOAUTENTICACAO');

/* Histórico de acessos ao servidor pelo dispositivo móvel remotamente */       
create table UsoRemotoDM
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    /* Data e hora em que se realizou a comunicação */
    DataHora datetime not null,
    ControleDeUsoDoDispositivoMovel bigint,
    /* Ação realizada */
    TipoDeAcaoRemota bigint,
    /* IP do dispositivo móvel */
    IP varchar(15),
    IMEI varchar(20),
    Comentarios varchar(3000),
    /* Localização do dispositivo móvel quando realizou a comunicação */
    DadosGps bigint,
    ControleDeComunicacao bigint
);

alter table UsoRemotoDM add constraint FK_UsoRemotoDM_TipoAcaoRemota foreign key (TipoDeAcaoRemota) references TipoAcaoRemota(Id);
alter table UsoRemotoDM add constraint FK_UsoRemotoDM_ControleComunicacao foreign key (ControleDeComunicacao) references ControleComunicacao(Id);

/* Histórico de utilização de dispositivo móvel */
create table ControleUsoDM
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    Comentarios varchar(3000),
    FuncionarioResponsavel bigint not null,
    UsuarioResponsavelPeloRegistro bigint not null,
    DispositivoMovel bigint not null,
    /* Data e hora em que o dispositivo móvel foi retirado */
    DataHoraSaida_DM datetime,
    /* Data e hora em que o dispositivo móvel foi devolvido (exceto remoção) */
    DataHoraDevolucao_DM datetime,
    TipoDeUsoDoDispositivoMovel bigint,
    DadosDeSaidaParaAuditoria bigint,
    DadosDeSaidaParaEnquete bigint,
    DadosDeSaidaParaRemocao bigint,
    DadosDeSaidaParaManutencao bigint
);

alter table ControleUsoDM add constraint FK_ControleUsoDM_FuncionarioResponsavel foreign key (FuncionarioResponsavel) references Usuario(Id);
alter table ControleUsoDM add constraint FK_ControleUsoDM_UsuarioResponsavel foreign key (UsuarioResponsavelPeloRegistro) references Usuario(Id);
alter table ControleUsoDM add constraint FK_ControleUsoDM_DispositivoMovel foreign key (DispositivoMovel) references DispositivoMovel(Id);
alter table ControleUsoDM add constraint FK_ControleUsoDM_TipoUsoDispositivoMovel foreign key (TipoDeUsoDoDispositivoMovel) references TipoUsoDispositivoMovel(Id);
alter table ControleUsoDM add constraint FK_ControleUsoDM_DadosAuditoria foreign key (DadosDeSaidaParaAuditoria) references DadosAuditoria(Id);
alter table ControleUsoDM add constraint FK_ControleUsoDM_DadosSaidaEnquete foreign key (DadosDeSaidaParaEnquete) references DadosSaidaEnquete(Id);
alter table ControleUsoDM add constraint FK_ControleUsoDM_DadosRemocao foreign key (DadosDeSaidaParaRemocao) references DadosRemocao(Id);
alter table ControleUsoDM add constraint FK_ControleUsoDM_Dados foreign key (DadosDeSaidaParaManutencao) references DadosManutencao(Id);
alter table UsoRemotoDM add constraint FK_UsoRemotoDM_ControleUsoDM foreign key (ControleDeUsoDoDispositivoMovel) references ControleUsoDM(Id);

/* Seguradoras */
create table SeguradoraDispositivoMovel
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key,
    /* Número de registro ada seguradora em órgão competente */
    NumeroDeRegistro varchar(50),
    Cliente bigint not null,
    PaginaWeb varchar(300)
);

alter table SeguradoraDispositivoMovel add constraint FK_SeguradoraDispositivoMovel_Pessoa foreign key (Id) references Pessoa(Id);
alter table SeguradoraDispositivoMovel add constraint FK_SeguradoraDispositivoMovel_Cliente foreign key (Cliente) references Cliente(Id);

create table ContratoSeguro
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    Cliente bigint not null,
    Seguradora bigint not null,
    /* Número do contrato realizado */
    NumeroContrato varchar(50),
    SinistrosCobertos varchar(20),
    /* Valor pago pelo seguro */
    Valor float,
    /* Data e hora da inserção do registro na tabela */
    DataHoraRegistro datetime not null default now(),
    /* Data e hora da contratação do seguro */
    DataHoraContratacao datetime,
    DataHoraTerminoPrevisao datetime,
    DataHoraTerminoReal datetime,
    Observacoes varchar(3000)
);

alter table ContratoSeguro add constraint FK_ContratoSeguro_Cliente foreign key (Cliente) references Cliente(Id);
alter table ContratoSeguro add constraint FK_ContratoSeguro_SeguradoraDispositivoMovel foreign key (Seguradora) references SeguradoraDispositivoMovel(Id);

create table SeguroDispositivoMovel
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    /* Dispositivo móvel coberto pelo seguro */
    DispositivoMovel bigint not null,
    ContratoDeSeguro bigint not null,
    ValorPeloDispositivo float,
    /* Data e hora de início de vigência do contrato para o dispoitivo móvel */
    DataHoraInicio datetime,
    /* Data e hora do término da vigência do contrato para o dispositivo móvel */
    DataHoraTermino datetime,
    MotivoTermino varchar(1000)
);

alter table SeguroDispositivoMovel add constraint FK_SeguroDispositivoMovel_DispositivoMovel foreign key (DispositivoMovel) references DispositivoMovel(Id);
alter table SeguroDispositivoMovel add constraint FK_SeguroDispositivoMovel_ContratoSeguro foreign key (ContratoDeSeguro) references ContratoSeguro(Id);

/* Registro de operadoras de telefonia */
create table OperadoraTelefonia
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key,
    CodigoDiscagem varchar(3)
);

alter table OperadoraTelefonia add constraint FK_OperadoraTelefonia_Pessoa foreign key (Id) references Pessoa(Id);

/* Registro de chips de telefonia */
create table SimCard
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    /* Cliente dono do chip */
    Cliente bigint not null,
    /* Operadora do chip */
    Operadora bigint not null,
    /* Número de série do chip */
    IMSI varchar(30),
    /* Número de telefone associado ao chip */
    Telefone bigint not null,
    Comentarios varchar(3000),
    /* Data e hora da inserção do registro na tabela */
    DataHoraRegistro datetime not null default now()
);

alter table SimCard add constraint FK_SimCard_Cliente foreign key (Cliente) references Cliente(Id);
alter table SimCard add constraint FK_SimCard_OperadoraTelefonia foreign key (Operadora) references OperadoraTelefonia(Id);
alter table SimCard add constraint FK_SimCard_Telefone foreign key (Telefone) references Telefone(Id);
alter table DadosSaidaEnquete add constraint FK_DadosSaidaEnquete_SimCard foreign key (SimCard) references SimCard(Id);

create table AreaAtuacao
(
    Id bigint not null primary key auto_increment,
    Nome varchar(200) not null,
    Comentarios varchar(3000) not null,
    AreaAtuacaoPai bigint
);

alter table AreaAtuacao add constraint FK_AreaAtuacao_AreaAtuacaoPai foreign key (AreaAtuacaoPai) references AreaAtuacao(Id);

create table Atividade
(
    Id bigint not null primary key auto_increment,
    Nome varchar(200) not null,
    Comentarios varchar(3000),
    AreaAtuacao bigint not null,
    DataHoraRegistro datetime not null default now()
);

alter table Atividade add constraint FK_Atividade_AreaAtuacao foreign key (AreaAtuacao) references AreaAtuacao(Id);

/* Registro de entrevistados */
create table Entrevistado
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key,
    /* Atividade profissional exercida pelo entrevistado */
    Atividade bigint,
    /* Para pesquisa respondida online */
    Usuario bigint
);

alter table Entrevistado add constraint FK_Entrevistado_Pessoa foreign key (Id) references Pessoa(Id);
alter table Entrevistado add constraint FK_Entrevistado_Atividade foreign key (Atividade) references Atividade(Id);
alter table Entrevistado add constraint FK_Entrevistado_Usuario foreign key (Usuario) references Usuario(Id);

/* Categorias de pesquisa */
create table CategoriaPesquisa
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    /* Nome da categoria */
    Nome varchar(200) not null,
    Descricao text default null,
    CategoriaMestra bigint,
    PodeAdicionarPesquisas boolean not null default false,
    /* Para categoria criada pelo cliente */
    Cliente bigint,
    DataHoraRegistro datetime not null default now(),
    DataHoraUltimaAtualizacao datetime not null default now(),
    DataHoraExclusao datetime default null,
    ChaveExclusao varchar(64) default null
);

alter table CategoriaPesquisa add constraint FK_CategoriaPesquisa_Cliente foreign key (Cliente) references Cliente(Id);
alter table CategoriaPesquisa add constraint FK_CategoriaPesquisa_CategoriaMestra foreign key (CategoriaMestra) references CategoriaPesquisa(Id);

/* Registro das pesquisas de opinião em si */
create table Pesquisa
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    Nome varchar(200) not null,
    Descricao text default null,
    /* Cliente que criou a pesquisa */
    Cliente bigint not null,
    /* Categoria à qual a pesquisa pertence */
    CategoriaDePesquisa bigint,
    CamposDeIdentificacaoObrigatorios varchar(400),
    RespostaSemAutenticacao boolean not null default false,
    /* Data e hora de início da vigencia da pesquisa */
    DataHoraInicio datetime,
    /* Data e hora do término da vigencia da pesquisa */
    DataHoraTermino datetime,
    /* Usuário que criou a pesquisa */
    UsuarioResponsavelPeloRegistro bigint not null,
    /* Usuário que realizou a última atualização no registro da pesquisa */
    UsuarioResponsavelPelaUltimaAtualizacao bigint not null,
    Publico boolean not null default false,
    Valido boolean not null default true,
    /* Data e hora de criação do registro na tabela */
    DataHoraRegistro datetime not null default now(),
    DataHoraUltimaAtualizacao datetime not null default now(),
    DataHoraExclusao datetime default null,
    ChaveExclusao varchar(64)
);

alter table Pesquisa add constraint FK_Pesquisa_Cliente foreign key (Cliente) references Cliente(Id);
alter table Pesquisa add constraint FK_Pesquisa_CategoriaPesquisa foreign key (CategoriaDePesquisa) references CategoriaPesquisa(Id);
alter table Pesquisa add constraint FK_Pesquisa_UsuarioResponsavelPeloRegistro foreign key (UsuarioResponsavelPeloRegistro) references Usuario(Id);
alter table Pesquisa add constraint FK_Pesquisa_UsuarioResponsavelPelaUltimaAtualizacao foreign key (UsuarioResponsavelPelaUltimaAtualizacao) references Usuario(Id);

/** Tipos de resposta que podem ser dadas às questões das pesquisas */
create table TipoResposta
(
    /** Identificador único do registro no banco */
    Id bigint not null primary key auto_increment,
    /** Nome do tipo de resposta */
    Nome varchar(200) not null,
    /** Comentários e/ou observações pertinentes */
    Comentarios text,
    /** Flag indicador da possibilidade de marcação de mais de uma resposta */
    PermiteMultiplasRespostas boolean not null default false,
    /** Objeto HTML para o qual o tipo de resposta pode ser mapeado */
    ObjetoHtml varchar(25),
    /** Data e hora da criação do registro no banco */
    DataHoraRegistro datetime not null defaul now(),
    DataHoraExclusao datetime default null,
    ChaveExclusao varchar(64) default null
);

create table Questao
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    /* Pesquisa à qual a questão pertence */
    Pesquisa bigint not null,
    /* Enunciado da questão */
    Enunciado Texto not null,
    TipoDeResposta bigint,
    /* Ordem em que a questão deve aparecer */
    NumeroQuestao int not null,
    QuestaoObrigatoria boolean not null default false,
    JustificativaObrigatoria boolean not null default false,
    MensagemJustificativaPersonalizada varchar(300),
    MaximoAlternativasSelecionaveis int,
    /* Alternativa a ser selecionada automaticamente quando ua resposta não é dada (para questões não obrigatórias) */
    AlternativaPadrao bigint,
    IdOperacaoPendente int,
    /* Data e hora de inserção do registro na tabela */
    DataHoraRegistro datetime not null default now(),
    DataHoraUltimaAtualizacao datetime,
    Valido boolean not null default true
);

alter table Questao add constraint FK_Questao_Pesquisa foreign key (Pesquisa) references Pesquisa(Id);
alter table Questao add constraint FK_Questao_TipoResposta foreign key (TipoDeResposta) references TipoResposta(Id);

/* Registro de alternativas das questões, para questões de múltipla escolha */
create table Alternativa
(
    /* Identificador único do registro na tabela */
    Id bigint not null auto_increment primary key,
    ChavePublica varchar(64) not null,
    /* Questão à qual a alternativa pertence */
    Questao bigint not null,
    /* Ordem em que a alternativa deve aparecer */
    Numero int not null,
    /* Texto da alternativa */
    ValorAlternativa text,
    ProximaQuestao bigint,
    JustificativaObrigatoria boolean,
    IdOperacaoPendente int,
    /* Data e hora da inserção do registro na tabela */
    DataHoraRegistro datetime not null default now(),
    DataHoraUltimaAtualizacao datetime,
    Valido boolean not null default true
);

alter table Alternativa add constraint FK_Alternativa_Questao foreign key (Questao) references Questao(Id);
alter table Alternativa add constraint FK_Alternativa_QuestaoProxima foreign key (ProximaQuestao) references Questao(Id);
alter table Questao add constraint FK_Questao_AlternativaPadrao foreign key (AlternativaPadrao) references Alternativa(Id);

/* Respostas às questões das pesquisas */
create table Resposta
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    Enquete bigint not null,
    Questao bigint not null,
    RespostaTextual text,
    JustificativaResposta text,
    DataHora datetime not null,
    DadosGps bigint
);

alter table Resposta add constraint FK_Resposta_Questao foreign key (Questao) references Questao(Id);
alter table Resposta add constraint FK_Resposta_Enquete foreign key (Enquete) references Enquete(Id);
alter table Resposta add constraint FK_Resposta_DadosGps foreign key (DadosGps) references GPS_Data(Id);

create table AlternativaResposta
(
    Id bigint not null primary key auto_increment,
    Resposta bigint not null,
    Alternativa bigint not null
);

alter table AlternativaResposta add constraint FK_AlternativaResposta_Alternativa foreign key (Alternativa) references Alternativa(Id);
alter table AlternativaResposta add constraint FK_AlternativaResposta_Resposta foreign key (Resposta) references Resposta(Id);

/* Causas de término de enquete */
create table MotivoTerminoPesquisa
(
    Id int not null primary key auto_increment,
    Nome varchar(200) not null,
    Descricao text
);

insert into MotivoTerminoPesquisa(Nome)
values ('MOTP_OUTRO'),
       ('MOTP_PESQUISA_CONCLUIDA'),
       ('MOTP_CANCELAMENTO'),
       ('MOTP_SESSAO_EXPIRADA');
      
/* Enquetes realizadas */
create table Enquete
(
    /* Identificador único do registro na tabela */
    Id bigint not null primary key auto_increment,
    /* Sistema a partir do qual a pesquisa foi respondida */
    OrigemEnquete bigint,
    /* Pessoa que entrevistou */
    Entrevistador bigint,
    /* Quem respondeu às perguntas (entrevistado) */
    Entrevistado bigint,
    /* Endereço IP a partir do qual a pesquisa foi respondida (para pesquisas respondidas pela web) */
    IPEntrevistado varchar(15),
    /* Pesquisa que foi respondida */
    Pesquisa bigint not null,
    /* Data e hora do início da enquete */
    DataHoraInicio datetime not null,
    DataHoraUltimaAtividade datetime not null,
    DataHoraTermino datetime,
    MotivoTermino bigint,
    MensagemErro text,
    /* Localização em que a enquete foi respondida (para enquete respondida a partir da aplicação móvel) */
    DadosGps bigint
);

alter table Enquete add constraint FK_Enquete_DispositivoMovel foreign key (OrigemEnquete) references DispositivoMovel(Id);
alter table Enquete add constraint FK_Enquete_Entrevistador foreign key (Entrevistador) references Usuario(Id);
alter table Enquete add constraint FK_Enquete_Entrevistado foreign key (Entrevistado) references Entrevistado(Id);
alter table Enquete add constraint FK_Enquete_Pesquisa foreign key (Pesquisa) references Pesquisa(Id);
alter table Enquete add constraint FK_Enquete_MotivoTerminoPesquisa foreign key (MotivoTermino) references MotivoTerminoPesquisa(Id);

create table TipoSinistroCoberturaSeguro
(
	Id int not null primary key auto_increment,
    Nome varchar(200) not null,
    Descricao text default null,
    DataHoraRegistro datetime not null default now()
);

insert into TipoSinistroCoberturaSeguro (Nome)
values ('TSCS_NENHUM'),
       ('TSCS_DADOS'),
       ('TSCS_PERDA'),
       ('TSCS_FURTO'),
       ('TSCS_ROUBO'),
       ('TSCS_ACIDENTE'),
       ('TSCS_DEFEITO'),
       ('TSCS_OUTRO');

/* Associa usuários do EnqueteMobile a pesquisas que estes podem executar a partir da aplicaçào móvel. */
create table AutorizacaoUsuarioPesquisa
(
    Id bigint not null auto_increment primary key,
    Usuario bigint not null,
    Pesquisa bigint not null,
    DataHoraAutorizacao datetime not null default now(),
    Valido boolean not null default 0,
    DataHoraInvalidacao datetime
);

alter table AutorizacaoUsuarioPesquisa add constraint FK_AutorizacaoUsuarioPesquisa_Usuario foreign key (Usuario) references Usuario(Id);
alter table AutorizacaoUsuarioPesquisa add constraint FK_AutorizacaoUsuarioPesquisa_Pesquisa foreign key (Pesquisa) references Pesquisa(Id);

/* Associa as pesquisas aos dispositivos onde estas se encontram armazenadas */
create table PesquisaDispositivoMovel
(
    Pesquisa bigint not null,
    DispositivoMovel bigint not null,
    primary key (Pesquisa, DispositivoMovel)
);

alter table PesquisaDispositivoMovel add constraint FK_PesquisaDispositivoMovel_Pesquisa foreign key (Pesquisa) references Pesquisa(Id);
alter table PesquisaDispositivoMovel add constraint FK_PesquisaDispositivoMovel_DispositivoMovel foreign key (DispositivoMovel) references DispositivoMovel(Id);

/* Dados de localização recebidos dos dispositivos móveis. */
create table GPS_Data
(
    /* Identificador único do registro no banco */
    Id bigint not null primary key auto_increment,
    /* Identificador do registro de localização na base de dados do dispositivo móvel */
    IdRemoto bigint not null,
    Latitude float not null,
    Longitude float not null,
    /* Dispositivo móvel que enviou os dados de localização */
    DispositivoMovel bigint not null,
    /* Data e hora da criação do registro no banco */
    DataHoraRegistro datetime not null,
    DataHoraColetaDado datetime
);

alter table GPS_Data add constraint FK_GpsData_DispositivoMovel foreign key (DispositivoMovel) references DispositivoMovel(Id);
alter table Enquete add constraint FK_Enquete_GpsData foreign key (DadosGps) references GPS_Data(Id);
alter table Resposta add constraint FK_Resposta_GpsData foreign key (DadosGps) references GPS_Data(Id);
alter table UsoRemotoDM add constraint FK_UsoRemotoDM_GpsData foreign key (DadosGps) references GPS_Data(Id);

create table StatusMensagemCorreio
(
    Id int not null primary key auto_increment,
    Nome varchar(200) not null,
    Descricao text default null
);

insert into StatusMensagemCorreio(Nome)
values ('STMC_NENHUM'),
       ('STMC_ENVIADO'),
       ('STMC_RECEBIDO'),
       ('STMC_AGUARDANDO_ENVIO'),
       ('STMC_AGUARDANDO_RESPOSTA'),
       ('STMC_AGUARDAND_RETORNO');
