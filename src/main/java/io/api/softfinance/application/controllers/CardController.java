package io.api.softfinance.application.controllers;

import io.api.softfinance.application.Response;
import io.api.softfinance.domain.models.Card;
import io.api.softfinance.domain.services.CardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public ResponseEntity<List<Card>> index() {
        return new ResponseEntity<>(cardService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Card> show(@PathVariable String uuid) {
        return new ResponseEntity<>(cardService.findById(uuid), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> create(@Valid @RequestBody Card card) throws Exception {
        Response response = new Response("Cartão cadastrado com sucesso.", cardService.create(card).getUuid());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Response> delete(@PathVariable String uuid) throws Exception {
        cardService.delete(uuid);
        return new ResponseEntity<>(new Response("Cartão deletado com sucesso.", null), HttpStatus.OK);
    }
}
