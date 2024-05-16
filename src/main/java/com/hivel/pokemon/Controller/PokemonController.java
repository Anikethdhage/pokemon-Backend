package com.hivel.pokemon.Controller;


import com.hivel.pokemon.DAO.PokemonRepo;
import com.hivel.pokemon.entity.Pokemon;
import com.hivel.pokemon.service.PokemonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class PokemonController {

    @Autowired
    private PokemonServiceImpl pokemonService;

    @GetMapping("/search")
    public List<Pokemon> PokemonSearchByQuery(@RequestParam String name){
        return pokemonService.getPokemonMatchingSearchQuery(name);
    }


    @GetMapping("/getAll")
    public List<Pokemon> getAllPokemons(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int size) {
        return pokemonService.getAllPokemons(page, size);
    }

    @PutMapping("/updateById/{id}")
    public Pokemon updateById(@RequestBody Pokemon pokemon, @PathVariable int id){
        return pokemonService.updatePokemon(pokemon,id);
    }

    @PostMapping("/postPokemon")
    public Pokemon createPokemon(@RequestBody Pokemon pokemon){
        return pokemonService.savePokemon(pokemon);
    }

    @DeleteMapping("/deleteById/{id}")
    void deletePokemon(@PathVariable int id){
        pokemonService.deletePokemonById(id);
    }
}
