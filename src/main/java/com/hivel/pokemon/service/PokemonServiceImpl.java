package com.hivel.pokemon.service;

import com.hivel.pokemon.DAO.PokemonRepo;
import com.hivel.pokemon.entity.Pokemon;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements PokemonServiceInterface{

    @Autowired
    private PokemonRepo pokemonRepo;


    @Override
    public List<Pokemon> getPokemonMatchingSearchQuery(String name) {
        List<Pokemon> results = new ArrayList<>();
        String lowerCaseSearchParam = name.toLowerCase();

        for (Pokemon pk : pokemonRepo.findAll()) {
            if (pk.getName().toLowerCase().contains(lowerCaseSearchParam)) {
                results.add(pk);
            }
        }

        return results;
    }

    @Override
    public List<Pokemon> getAllPokemons(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return  pokemonRepo.findAll(pageable).stream().sorted((a,b) -> a.getName().compareTo(b.getName())).collect(Collectors.toList());
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
