package io.api.softfinance.controllers;

import io.api.softfinance.Response;
import io.api.softfinance.models.Card;
import io.api.softfinance.services.CardService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    public ResponseEntity<Card> show(
            @PathVariable @Valid @NotEmpty(message = "O campo uuid é obrigatório") String uuid
    ) {
        return new ResponseEntity<>(cardService.findById(uuid), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> create(@RequestBody @Valid Card card) throws Exception {
        return new ResponseEntity<>(new Response(
                "Cartão cadastrado com sucesso.",
                cardService.create(card).getUuid()
        ), HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Response> delete(
            @PathVariable @Valid @NotEmpty(message = "O campo uuid é obrigatório") String uuid
    ) throws Exception {
        cardService.delete(uuid);
        return new ResponseEntity<>(new Response(
                "Cartão deletado com sucesso.",
                null
        ), HttpStatus.OK);
    }
}
