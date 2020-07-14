package com.example.demo.controllers;

import java.util.List;

import com.example.demo.models.Case;
import com.example.demo.service.CaseService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaseController {
    private CaseService caseService;

    public CaseController (CaseService caseService) {
        super();
        this.caseService = caseService;
    }

    @CrossOrigin
    @GetMapping ("/")

    public ResponseEntity <List <Case>> getCase () {
        return new ResponseEntity <List <Case>> (this.caseService.getCases(), HttpStatus.OK);
    }
}