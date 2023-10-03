package io.api.softfinance.controllers;

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

    @PostMapping
    public ResponseEntity<Response> save(@Valid @RequestBody Card card) throws Exception {
        String cardId = cardService.save(card).getUuid();

        return new ResponseEntity<>(new Response("Cartão cadastrado com sucesso.", cardId), HttpStatus.OK);
    }
}
