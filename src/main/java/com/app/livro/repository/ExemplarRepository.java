package com.app.livro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.livro.model.Exemplar;

public interface ExemplarRepository extends JpaRepository<Exemplar, Long>{

}
