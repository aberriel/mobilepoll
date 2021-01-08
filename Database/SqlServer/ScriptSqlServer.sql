create database EnqueteMobile;
go
use EnqueteMobile;
go

create table Pessoa
(
	Id bigint not null primary key identity(1,1),
	Nome varchar(200) not null,
	NomeAbreviado varchar(120),
	RazaoSocial varchar(200),
	EMailPrincipal varchar(120),
	EMailSecundario varchar(120),
	CPF varchar(14),
	CNPJ varchar(32),
	RG bigint,
	InscricaoEstadual varchar(50),
	InscricaoMunicipal varchar(50),
	TituloEleitoral bigint,
	Sexo int,
	EstadoCivil int,
	DataDeNascimento datetime,
	TipoPessoa int not null default 0,
	Valido bit not null default 1,
	ChaveAtivacao varchar(40),
	DataAtivacao datetime,
	DataHoraRegistro datetime not null default getdate(),
	DataHoraUltimaAtualizacao datetime not null default getdate(),
	NumeroDeRegistro varchar(64),
	Comentarios varchar(3000)
);

go

create table RG
(
	Id bigint not null primary key identity(1,1),
	Numero varchar(20),
	OrgaoExpeditor varchar(120),
	EstadoExpeditor bigint not null,
	DataExpedicao datetime not null
);

go

create table TituloEleitoral
(
	Id bigint not null primary key identity(1,1),
	NumeroTE varchar(40) not null,
	ZonaTE varchar(8) not null,
	SecaoTE varchar(8) not null,
	DataExpedicao datetime,
	EstadoExpedicao bigint
);

go

create table Endereco
(
	Id bigint not null primary key identity(1,1),
	TipoDeEndereco bigint,
	Logradouro varchar(300),
	NumeroEndereco varchar(10),
	Complemento varchar(120),
	Bairro varchar(200),
	Cidade bigint not null,
	CEP varchar(15),
	Pessoa bigint,
	Comentarios varchar(3000),
	EnderecoPrincipal bit not null default 0,
	DataHoraRegistro datetime not null default getdate()
);

go

create table TipoEndereco
(
	Id bigint not null primary key identity(1,1),
	Nome varchar(200) not null,
	CaminhoCompletoIcone varchar(300),
	Comentarios varchar(3000)
);

go

create table Cidade
(
	Id bigint not null primary key identity(1,1),
	Nome varchar(300) not null,
	UnidadeFederativa bigint not null,
	Comentarios varchar(3000)
);

go

create table UnidadeFederativa
(
	Id bigint not null primary key identity(1,1),
	Nome varchar(200) not null,
	Sigla varchar(3) not null,
	Comentarios varchar(3000)
);

go

create table Telefone
(
	Id bigint not null primary key identity(1,1),
	DDD varchar(4) not null,
	NumeroTelefone varchar(12) not null,
	Ramal varchar(6),
	Pessoa bigint,
	TipoDeTelefone bigint,
	DataHoraRegistro datetime not null default getdate(),
	Comentarios varchar(3000)
);

go

create table TipoTelefone
(
	Id bigint not null primary key identity(1,1),
	Nome varchar(200) not null,
	Comentarios varchar(3000),
	CaminhoCompletoIcone varchar(300)
);

go

create table Cliente
(
	Id bigint not null primary key,
	Contato varchar(120),
	Gerente bigint,
	RazaoSocial varchar(200)
);

go

create table Usuario
(
	Id bigint not null primary key,
	ApelidoUsuario varchar(50) not null,
	Senha varchar(50) not null,
	TipoUsuario int,
	Cliente bigint,
	PerguntaSecreta varchar(200),
	RespostaSecreta varchar(100),
	AlterarSenha bit not null default 0,
	UsuarioMestre bit not null default 0,
	Foto varchar(200)
);

go

create table Sistema
(
	Id bigint not null primary key identity(1,1),
	Nome varchar(200),
	Descricao varchar(3000),
	Movel bit not null default 0,
	ChaveSistema varchar(100),
	CaminhoCompletoIcone varchar(300)
);

go

create table AssuntoMensagem
(
	Id bigint not null primary key identity(1,1),
	Nome varchar(200),
	Descricao varchar(3000),
	DataHoraRegistro datetime not null default getdate()
);

go

create table ConfiguracaoCliente
(
	Id bigint not null primary key identity(1,1),
	Sistema bigint not null,
	Cliente bigint not null,
	DataHoraRegistro datetime not null default getdate(),
	DataHoraInvalidacao datetime,
	PeriodoTrocaPeriodicaSenha datetime,
	ToleranciaParaResponderEnquete datetime,
	ToleranciaSemMovimentacao datetime
);

go

create table LogBD
(
	Id bigint not null primary key identity(1,1),
	DataHora datetime not null,
	UsuarioBD varchar(120) not null,
	UsuarioSistema varchar(120) not null,
	Sistema bigint not null,
	NomeTabela varchar(120) not null,
	IdRegistro bigint,
	ValoresAntigos varchar(8000),
	ValoresNovos varchar(8000),
	TipoDeOperacaoNoBancoDeDados int
);

go

create table LogApp
(
	Id bigint not null primary key identity(1,1),
	Descricao varchar(3000),
	Sistema bigint not null,
	IP varchar(15),
	DataHoraRegistroLogApp datetime,
	LoginDoUsuario varchar(120),
	Modulo varchar(120),
	Classe varchar(120),
	Metodo varchar(120),
	Parametros varchar(8000),
	UrlArquivoFontr varchar(300),
	NumeroLinhaCodigoFonte varchar(8),
	TipoDeAcaoDaAplicacao int,
	SQL_Code varchar(8000),
	NavegadorWebUsado varchar(100),
	TipoExcecao varchar(120),
	ExcecaoCapturada varchar(8000),
	Source varchar(8000)
);

go

create table TipoObjeto
(
	Id bigint not null identity(1,1) primary key,
	Nome varchar(200) not null,
	Descricao varchar(3000) not null,
	IdentificadorLiteral int not null
);

go

create table TipoAcaoAplicacao
(
	Id bigint not null identity(1,1) primary key,
	Nome varchar(200) not null,
	Descricao varchar(3000),
	TipoObjeto bigint not null,
	DataHoraRegistro datetime
);

go

create table TipoObjetoPermissao
(
	Id bigint not null identity(1,1) primary key,
	Nome varchar(200) not null,
	Descricao varchar(3000),
	TipoObjeto bigint not null,
	TipoAcaoAplicacao int not null,
	IdentificadorLiteral int
);

go

create table Recurso
(
	Id bigint not null identity(1,1) primary key,
	Nome varchar(200),
	Comentarios varchar(3000),
	Sistema bigint not null,
	TipoRecurso bigint not null,
	Localizacao varchar(1000),
	ItemAdministrativo bit not null default 0
);

go

create table TipoRecurso
(
	Id bigint not null identity(1,1) primary key,
	Nome varchar(200) not null,
	Descricao varchar(3000),
	DataHoraRegistro datetime not null default getdate()
);

go

create table TipoObjeto_Recurso
(
	ItemRecurso bigint not null,
	TipoObjeto bigint not null,
	PermissoesUsadas varchar(20),
	constraint PK_TipoObjetoRecurso primary key nonclustered (ItemRecurso, TipoObjeto)
);

go

create table ControleComunicacao
(
	Id bigint not null identity(1,1) primary key,
	IdRemoto bigint not null,
	IdOperacao int not null,
	DispositivoMovel bigint not null,
	DataHoraEnvio datetime,
	DataHoraRetorno datetime,
	ConteudoPacoteEnvio varchar(8000),
	ConteudoPacoteRetorno varchar(8000),
	PossuiRetorno bit not null default 0,
	ChaveUsuario varchar(50),
	SentidoComunicacao int not null,
	Processado bit not null default 0,
	MensagemErro varchar(500)
);

go

create table GerenciadorSessao
(
	Id bigint not null identity(1,1) primary key,
	OrigemSessao bigint not null,
	ChaveSessao varchar(50),
	ChaveSistema varchar(50),
	IdUsuarioAutenticado bigint not null,
	DataHoraInicio datetime,
	DataHoraUltimaMovimentacao datetime,
	DataHoraExpiracao datetime,
	MotivoTermino varchar(400)
);

go

create table GrupoUsuario
(
	Id bigint not null identity(0,1) primary key,
	Nome varchar(200) not null,
	Descricao varchar(3000),
	GrupoDoSistema bit not null default 0,
	DataHoraRegistro datetime not null default getdate(),
	DataHoraUltimaAtualizacao datetime not null default getdate()
);

go

create table Usuario_GrupoUsuario
(
	Usuario bigint not null,
	GrupoDeUsuario bigint not null,
	constraint PK_UsuarioGrupoUsuario primary key nonclustered (Usuario, GrupoDeUsuario)
);

go

create table Permissao
(
	Id bigint not null identity(1,1) primary key,
	GrupoDeUsuario bigint,
	Usuario bigint,
	TipoObjeto int not null,
	EscopoPermissao int not null,
	LimiteNumeroRegistro int,
	PermissaoDoObjeto int not null,
	Valido bit not null default 1
);

go

create table ConfiguracaoGlobal
(
	Id bigint not null identity(0,1) primary key,
	Sistema bigint not null,
	ConfiguracaoEnvioCorreioEletronicoGlobal bigint not null,
	SenhaMEstra varchar(20),
	ToleranciaParaResponderEnquete time,
	TempoLimiteSessao time,
	ToleranciaSemMovimentacao time
);

go

create table TipoEnderecoServidor
(
	Id bigint not null identity(1,1) primary key,
	Nome varchar(200) not null,
	Descricao varchar(3000),
	FormatoString varchar(40),
	DataHoraRegistro datetime not null default getdate(),
	UsuarioResponsavelPeloRegistro bigint not null
);

go

create table DadosCorreioEletronico
(
	Id bigint not null identity(0,1) primary key,
	Nome varchar(200),
	Descricao varchar(3000),
	ApelidoUsuario varchar(50) not null,
	Senha varchar(50) not null,
	UsarSSL bit not null default 0,
	TipoDeEnderecoDoServidor bigint not null,
	EnderecoServidorSmtp varchar(200) not null,
	Porta varchar(8),
	DataHoraRegistro datetime not null default getdate(),
	DataHoraInvalidacao datetime not null default getdate()
);

go

create table CorreioClienteEntrevistador
(
	Id bigint not null identity(0,1) primary key,
	Cliente bigint not null,
	Entrevistador bigint not null,
	Mensagem varchar(300) not null,
	SentidoComunicacao int not null,
	ControleDeComunicacao bigint not null,
	StatusMensagemCorreio int not null,
	ConfirmacaoAbertura bit not null default 0
);

go
alter table Pessoa add constraint FK_Pessoa_RG foreign key (RG) references RG(Id);
go
alter table Pessoa add constraint FK_Pessoa_TituloEleitoral foreign key (TituloEleitoral) references TituloEleitoral(Id);
go
alter table Endereco add constraint FK_Endereco_Pessoa foreign key (Pessoa) references Pessoa(Id);
go
alter table Endereco add constraint FK_Endereco_TipoEndereco foreign key (TipoDeEndereco) references TipoEndereco(Id);
go
alter table Endereco add constraint FK_Endereco_Cidade foreign key (Cidade) references Cidade(Id);
go
alter table Cidade add constraint FK_Cidade_UnidadeFederativa foreign key (UnidadeFederativa) references UnidadeFederativa(Id);
go
alter table RG add constraint FK_RG_UnidadeFederativa foreign key (EstadoExpeditor) references UnidadeFederativa(Id);
go
alter table TituloEleitoral add constraint FK_TituloEleitoral_UnidadeFederativa foreign key (EstadoExpedicao) references UnidadeFederativa(Id);
go
alter table Telefone add constraint FK_Telefone_Pessoa foreign key (Pessoa) references Pessoa(Id);
go
alter table Telefone add constraint FK_Telefone_TipoTelefone foreign key (TipoDeTelefone) references TipoTelefone(Id);
go
alter table Cliente add constraint FK_Cliente_Pessoa foreign key (Id) references Pessoa(Id);
go
alter table Usuario add constraint FK_Usuario_Pessoa foreign key (Id) references Pessoa(Id);
go
alter table Cliente add constraint FK_Cliente_Gerente foreign key (Gerente) references Usuario(Id);
go
alter table Usuario add constraint FK_Usuario_Cliente foreign key (Cliente) references Cliente(Id);
go
alter table ConfiguracaoCliente add constraint FK_ConfiguracaoCliente_Sistema foreign key (Sistema) references Sistema(Id);
go
alter table ConfiguracaoCliente add constraint FK_ConfiguracaoCliente_Cliente foreign key (Cliente) references Cliente(Id);
go
alter table LogBD add constraint FK_LogBD_Sistema foreign key (Sistema) references Sistema(Id);
go
alter table LogApp add constraint FK_LogApp_Sistema foreign key (Sistema) references Sistema(Id);
go
alter table TipoAcaoAplicacao add constraint FK_TipoAcaoAplicacao_TipoObjeto foreign key (TipoObjeto) references TipoObjeto(Id);
go
alter table TipoObjetoPermissao add constraint FK_TipoObjetoPermissao_TipoObjeto foreign key (TipoObjeto) references TipoObjeto(Id);
go
alter table Recurso add constraint FK_Recurso_Sistema foreign key (Sistema) references Sistema(Id);
go
alter table Recurso add constraint FK_Recurso_TipoRecurso foreign key (TipoRecurso) references TipoRecurso(Id);
go
alter table TipoObjeto_Recurso add constraint FK_TipoObjetoRecurso_Recurso foreign key (ItemRecurso) references Recurso(Id);
go
alter table TipoObjeto_Recurso add constraint FK_TipoObjetoRecurso_TipoObjeto foreign key (TipoObjeto) references TipoObjeto(Id);
go
alter table GerenciadorSessao add constraint FK_GerenciadorSessao_Sistema foreign key (OrigemSessao) references Sistema(Id);
go
alter table Usuario_GrupoUsuario add constraint FK_UsuarioGrupoUsuario_Usuario foreign key (Usuario) references Usuario(Id);
go
alter table Usuario_GrupoUsuario add constraint FK_UsuarioGrupoUsuario_GrupoUsuario foreign key (GrupoDeUsuario) references GrupoUsuario(Id);
go
alter table Permissao add constraint FK_Permissao_GrupoUsuario foreign key (GrupoDeUsuario) references GrupoUsuario(Id);
go
alter table Permissao add constraint FK_Permissao_Usuario foreign key (Usuario) references Usuario(Id);
go
alter table ConfiguracaoGlobal add constraint FK_ConfiguracaoGlobal_Sistema foreign key (Sistema) references Sistema(Id);
go
alter table TipoEnderecoServidor add constraint FK_TipoEnderecoServidor_Usuario foreign key (UsuarioResponsavelPeloRegistro) references Usuario(Id);
go
alter table DadosCorreioEletronico add constraint FK_DadosCorreioEletronico_TipoEnderecoServidor foreign key (TipoDeEnderecoDoServidor) references TipoEnderecoServidor(Id);
go
alter table ConfiguracaoGlobal add constraint FK_ConfiguracaoGlobal_DadosCorreioEletronico foreign key (ConfiguracaoEnvioCorreioEletronicoGlobal) references DadosCorreioEletronico(Id);
go
alter table CorreioClienteEntrevistador add constraint FK_CorreioClienteEntrevistador_Cliente foreign key (Cliente) references Cliente(Id);
go
alter table CorreioClienteEntrevistador add constraint FK_CorreioClienteEntrevistador_Entrevistador foreign key (Entrevistador) references Usuario(Id);