package org.mql.spring.repositories;

import java.util.List;

import org.mql.spring.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DocumentRepository extends JpaRepository<Document, String>{
	@Query("SELECT d from Document d WHERE d.yearPublished BETWEEN :min and :max")
	public List<Document> findByDateIntervale(int min, int max);
	
	public List<Document> findByYearPublishedBetween(int yrear1, int year2); //est equivalent a celle du premier de JPQL
}
