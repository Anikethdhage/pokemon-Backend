package com.hivel.pokemon.DAO;

import com.hivel.pokemon.entity.Pokemon;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepo extends BaseDAO<Pokemon, Integer>{
}
