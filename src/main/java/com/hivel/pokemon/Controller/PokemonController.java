package com.hivel.pokemon.Controller;


import com.hivel.pokemon.DAO.PokemonRepo;
import com.hivel.pokemon.entity.Pokemon;
import com.hivel.pokemon.service.PokemonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PokemonController {

    @Autowired
    private PokemonServiceImpl pokemonService;


    @GetMapping(name = "/getAll")
    public List<Pokemon> getAllPokemons() {
        return pokemonService.getAllPokemons();
    }

    @PutMapping(name = "/updateById/{id}")
    public Pokemon updateById(@RequestBody Pokemon pokemon, @PathVariable int id){
        return pokemonService.updatePokemon(pokemon,id);
    }

    @PostMapping(name = "/postPokemon")
    public Pokemon createPokemon(@RequestBody Pokemon pokemon){
        return pokemonService.savePokemon(pokemon);
    }

    @DeleteMapping(name = "/deleteById/{id}")
    void deletePokemon(@PathVariable int id){
        pokemonService.deletePokemonById(id);
    }
}
