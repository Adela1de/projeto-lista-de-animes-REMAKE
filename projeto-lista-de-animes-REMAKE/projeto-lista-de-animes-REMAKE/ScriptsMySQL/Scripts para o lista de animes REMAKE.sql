##Scrip para pegar os generos de um anime pelo seu id
select g.name from tb_anime ani, tb_genre g
inner join tb_anime_genre anig
where anig.anime_id = ani.id
and g.id = anig.genre_id
and ani.id = 17;

##Script para pegar os animes pelo genero
select ani.name from tb_anime ani, tb_genre g
inner join tb_anime_genre anig
where anig.anime_id = ani.id
and g.id = anig.genre_id
and g.name like 'Slice of life';

##Pega todas os ratings de um anime e os usuários
select tar.rating, a.name, u.username 
from tb_anime_rating tar, tb_rating_anime tra, tb_rating_user tru inner join tb_user u, tb_anime a
where tar.id = tra.rating_id 
and tar.id = tru.rating_id
and tru.user_id = u.id 
and tra.anime_id = a.id
and a.id = 20;

##Pega todas os ratings de um usuário em específico
select tar.rating, a.name, u.username 
from tb_anime_rating tar, tb_rating_anime tra, tb_rating_user tru inner join tb_user u, tb_anime a
where tar.id = tra.rating_id 
and tar.id = tru.rating_id
and tru.user_id = u.id 
and tra.anime_id = a.id
and u.id = 19;

##Pega uma rating em específico com base no usuário e anime
select tar.rating, a.name, u.username 
from tb_anime_rating tar, tb_rating_anime tra, tb_rating_user tru inner join tb_user u, tb_anime a
where tar.id = tra.rating_id 
and tar.id = tru.rating_id
and tru.user_id = u.id 
and tra.anime_id = a.id
and u.id = 19
and a.id = 18 ;



