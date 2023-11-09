package io.api.softfinance.app.controllers;

import io.api.softfinance.app.Response;
import io.api.softfinance.domain.interfaces.services.ICardService;
import io.api.softfinance.domain.models.Card;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartao")
public class CardController {

    @Autowired
    private ICardService cardService;

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
