package com.hivel.pokemon.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseDAO <T, J> extends JpaRepository<T, J> {
}
