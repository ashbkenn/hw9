package c322spring2024homework2.controllers;

import c322spring2024homework2.model.*;
import c322spring2024homework2.repository.GuitarsRepository;
import c322spring2024homework2.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guitars")
public class InventoryController {
    private GuitarsRepository guitarsRepository;

    public InventoryController(GuitarsRepository guitarsRepository) {
        this.guitarsRepository = guitarsRepository;
    }

    @GetMapping("/search")
    public List<GuitarTable> searchGuitars(@RequestParam(required = false) String serialNumber,
                                      @RequestParam(required = false) double price,
                                      @RequestParam(required = false) String builder,
                                      @RequestParam(required = false) String model,
                                      @RequestParam(required = false) String type,
                                      @RequestParam(required = false) String backWood ,
                                      @RequestParam(required = false) String topWood) {
        GuitarTable searchCriteria = new GuitarTable(serialNumber, price, builder, model, type, backWood, topWood);
        Example<GuitarTable> example = Example.of(searchCriteria);
        List<GuitarTable> guitars = (List<GuitarTable>) guitarsRepository.findAll(example);
        //return guitarsRepository.search(searchCriteria);
        return guitars;
    }

    @PostMapping("/add")
    public GuitarTable addGuitar(@RequestBody GuitarTable guitar) {

        return guitarsRepository.save(guitar);
    }

    @GetMapping("/find/{serialNumber}")
    public GuitarTable findGuitar(@PathVariable String serialNumber) {

        Optional<GuitarTable> guitar = guitarsRepository.findById(serialNumber);
        if(!guitar.isEmpty()) {
            return guitar.get();
        } else {
            return null;
        }
    }
}
