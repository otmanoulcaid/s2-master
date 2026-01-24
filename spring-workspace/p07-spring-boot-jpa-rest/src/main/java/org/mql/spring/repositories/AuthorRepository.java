package org.mql.spring.repositories;

import java.util.List;

import org.mql.spring.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//repository enterface qui etand de l'une des interfaces repository qui est JpaRepository 

//JpaRepository<T,ID> t:type de model de donne, et l'id :type de cle primaire
//CrudRepository <T,ID> :si on veut recuperer page par page
//on annote pas les interfaces on annote  les classes si on annote on dit a springdatajpa donne une instance 

//No Code Repository
public interface AuthorRepository extends  JpaRepository<Author, Integer>  {
	public List<Author> findByName(String name);
	//ici il faut absolument utilise un nom existant
	//dans la class author  findByX et pour resoudre ca on utilise une annotation @Query

	/*
	 * JPQL: JPA Query Language,un langage de requetes oriente objet
	 * derive du langage SQL,Plutot que d'interroger les tables,
	 * JPQL permet de manipuler les classes et les objets
	 */
	@Query("SELECT a from Author a WHERE a.name Like %:keyword ")//ici on doit avoir les noms comme dans la base de donne 
	public List<Author> findByKeyword(String keyword);

}
