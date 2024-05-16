package com.hivel.pokemon.service;

import com.hivel.pokemon.DAO.PokemonRepo;
import com.hivel.pokemon.entity.Pokemon;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonServiceInterface{

    @Autowired
    private PokemonRepo pokemonRepo;


    @Override
    public List<Pokemon> getAllPokemons() {
        return List.of((Pokemon) pokemonRepo.findAll());
    }

    @Override
    public Pokemon savePokemon(Pokemon pokemon) {
        return pokemonRepo.save(pokemon);
    }

    @Override
    public void deletePokemonById(int id) {
        pokemonRepo.deleteById(id);
    }

    @Override
    public Pokemon updatePokemon(Pokemon pokemon, int id) {
        pokemon.setId(id);
        return pokemonRepo.save(pokemon);
    }
}
