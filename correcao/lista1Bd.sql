create table ingrediente(
	nome varchar, 
	peso float, -- peso em gramas
	id serial primary key
);

insert into ingrediente values('chocolate', 10);
insert into ingrediente values('leite condensado', 20);
insert into ingrediente values('açúcar', 30);
insert into ingrediente values('caramelo', 150);

create table instituicao(
	nome varchar,
	id serial primary key
);

insert into instituicao values('Mundo dos Doces');
insert into instituicao values('Doces mania');
insert into instituicao values('Doces Mais');

create table curso( 
	nome varchar, 
	modalidade varchar, 
	duracao int, --tempo em horas
	id serial primary key
);

insert into curso values('Bolos para casamento', 'Bolos em camadas', 30);
insert into curso values('Tortas para festas', 'Tortas doces', 50);
insert into curso values('Sobremesas para casamento', 'Sobremesas', 40);
insert into curso values('Sobremesas para lanche', 'Sobremesas', 40);
create table cursoinstituicao( 
	idcurso int references curso(id), 
	idinstituicao int references instituicao(id),
	id serial primary key
);

insert into cursoinstituicao values(1, 1);
insert into cursoinstituicao values(1, 2);
insert into cursoinstituicao values(2, 3);

create table confeiteiro( 
	nome varchar, 
	especialidade varchar,
	id serial primary key
);

insert into confeiteiro values('Jorge Amado', 'Bolos');
insert into confeiteiro values('Jorge Paulo Ramos', 'Tortas');
insert into confeiteiro values('Jorge Ricardo', 'Docinhos de festa');
insert into confeiteiro values('Jorge Tadeu', 'Bolos');
insert into confeiteiro values('Jorge Teodoro', 'Bolos');
select * from confeiteiro
create table doce( 
	nome varchar, 
	pesomedio float, 
	valor float,
	idconfeiteiro int references confeiteiro(id),
	id serial primary key
);

insert into doce values('Trufado de natal', 20, 137, 1);
insert into doce values('Floresta negra ', 10, 320, 2);
insert into doce values('Bolo formigueiro', 40, 320, 2);
insert into doce values('Bolo de chocolate', 35, 320, 2);
insert into doce values('Bolo de cenoura', 36, 322, 2);
insert into doce values('Biscoito de chocolate', 36, 322, 2);

create table doceingrediente(
	iddoce int references doce(id), 
	idingrediente int references ingrediente(id),
	id serial primary key
);

insert into doceingrediente values(1, 1);
insert into doceingrediente values(1, 2);
insert into doceingrediente values(2, 2);
insert into doceingrediente values(2, 3);

create table cursoconfeiteiro( 
	idcurso int references curso(id), 
	idconfeiteiro int references confeiteiro(id),
	id serial primary key
);

insert into cursoconfeiteiro values(1, 1);
insert into cursoconfeiteiro values(2, 2);
insert into cursoconfeiteiro values(3, 3);

--a
select doce.nome
from doce, ingrediente, doceingrediente
where iddoce = doce.id and
	  idingrediente = ingrediente.id and 
	  pesomedio > 3 and
	  valor > 126 and 
	  ingrediente.nome = 'chocolate'

--b
select avg(peso) from doce
--c
select * 
from curso, confeiteiro, cursoconfeiteiro
where idcurso = curso.id and
	  idconfeiteiro = confeiteiro.id
--d
select nome from curso order by duracao desc

--e
select curso.nome
from curso, instituicao, confeiteiro, cursoinstituicao, cursoconfeiteiro
where cursoinstituicao.idcurso = curso.id and
	  idinstituicao = instituicao.id and
	  cursoconfeiteiro.idcurso = curso.id and
	  idconfeiteiro = confeiteiro.id and 
	  duracao > 20 and
	  instituicao.nome = 'Mundo dos Doces' and
	  especialidade = 'Bolos'
	  
--f
select ingrediente.nome, confeiteiro.nome, doce.nome
from ingrediente, doce, confeiteiro, doceingrediente
where iddoce = doce.id and
	  idingrediente = ingrediente.id and 
      idconfeiteiro = confeiteiro.id
	  
	  
select ingrediente.nome, confeiteiro.nome, doce.nome
from ingrediente
inner join doceingrediente
on idingrediente = ingrediente.id
inner join doce
on iddoce = doce.id 
inner join confeiteiro
on idconfeiteiro = confeiteiro.id


	  
--g
select confeiteiro.nome, confeiteiro.especialidade
from confeiteiro, curso, doce, cursoconfeiteiro
where idcurso = curso.id and
	  doce.idconfeiteiro = confeiteiro.id and
      cursoconfeiteiro.idconfeiteiro = confeiteiro.id and 
	  curso.nome = 'Bolos para casamento' and
	  duracao = 80

--h
select confeiteiro.nome
from curso, confeiteiro, doce, ingrediente, cursoconfeiteiro, doceingrediente
where iddoce = doce.id and
	  idingrediente = ingrediente.id and
	  idcurso = curso.id and
	  cursoconfeiteiro.idconfeiteiro = confeiteiro.id and
	  doce.idconfeiteiro = confeiteiro.id and
	  ingrediente.nome = 'leite condensado' and
	  curso.nome = 'Bolos para casamento'

--i
select nome from doce where nome like '%chocolate%'
	  
	  

