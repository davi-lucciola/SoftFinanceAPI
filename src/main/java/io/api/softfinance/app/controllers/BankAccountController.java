package io.api.softfinance.app.controllers;

import io.api.softfinance.app.Response;
import io.api.softfinance.domain.interfaces.services.IBankAccountService;
import io.api.softfinance.domain.models.BankAccount;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class BankAccountController {

    @Autowired
    private IBankAccountService bankAccountService;

    @GetMapping
    private ResponseEntity<List<BankAccount>> index() {
        return new ResponseEntity<>(bankAccountService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    private ResponseEntity<BankAccount> show(@PathVariable @Valid String uuid) {
        return new ResponseEntity<>(bankAccountService.findById(uuid), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Response> create(@RequestBody @Valid BankAccount bankAccount) {
        return new ResponseEntity<>(new Response(
                "Conta Bancaria cadastrada com sucesso.",
                bankAccountService.create(bankAccount).getUuid()
        ), HttpStatus.CREATED);
    }
}
