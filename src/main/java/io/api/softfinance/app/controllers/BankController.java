package io.api.softfinance.app.controllers;

import io.api.softfinance.app.Response;
import io.api.softfinance.domain.interfaces.services.IBankService;
import io.api.softfinance.domain.models.Bank;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banco")
public class BankController {

    @Autowired
    private IBankService bankService;


    @GetMapping
    private ResponseEntity<List<Bank>> index(String search) {
        return new ResponseEntity<>(bankService.findAll(search), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    private ResponseEntity<Bank> show(String uuid) {
        return new ResponseEntity<>(bankService.findById(uuid), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Response> create(@RequestBody @Valid Bank bank) {
        return new ResponseEntity<>(new Response(
                "Banco cadastrado com sucesso.",
                bankService.create(bank).getUuid()
        ), HttpStatus.OK);
    }
}
