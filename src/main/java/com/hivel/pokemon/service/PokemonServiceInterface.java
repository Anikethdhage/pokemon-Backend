package com.hivel.pokemon.service;

import com.hivel.pokemon.entity.Pokemon;

import java.util.List;

public interface PokemonServiceInterface {

    List<Pokemon> getAllPokemons();
    Pokemon savePokemon(Pokemon pokemon);
    void deletePokemonById(int id);
    Pokemon updatePokemon(Pokemon pokemon, int id);
}
