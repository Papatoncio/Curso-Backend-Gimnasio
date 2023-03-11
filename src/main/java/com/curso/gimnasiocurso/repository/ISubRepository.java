package com.curso.gimnasiocurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.gimnasiocurso.model.entity.SubEntity;

public interface ISubRepository extends JpaRepository<SubEntity, Integer> {

}
