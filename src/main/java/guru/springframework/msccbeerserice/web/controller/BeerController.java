package guru.springframework.msccbeerserice.web.controller;

import guru.springframework.msccbeerserice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.plugin.util.UIUtil;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UIUtil beerId){
       //todo Impl
        return new ResponseEntity(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody BeerDto beerDto){
        //todo Impl
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId") UIUtil beerId,@RequestBody BeerDto beerDto){
        //todo Impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
