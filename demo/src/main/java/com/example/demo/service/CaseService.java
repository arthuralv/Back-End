package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.DAO.CasesRepository;
import com.example.demo.models.Case;
import com.example.demo.models.ReaderToCSV;

import org.springframework.stereotype.Service;



@Service
public class CaseService {
    private CasesRepository <Case, Long> casesDAO;
    private ReaderToCSV reader;

    public CaseService (CasesRepository <Case, Long> casesDAO) {
        super();
        this.casesDAO = casesDAO;
    }

    public void saveCase (ArrayList <ArrayList <String>> array) {
        for (ArrayList <String> elem : array) {
            this.reciveCase(new Case(elem.get(0), elem.get(1)));
        }
    }

    public void read () {
        this.saveCase(this.reader.CSVReader());
    }

    public Case reciveCase (Case caso) {
        return this.casesDAO.save(caso);
    }

    public List<Case> getCases () {
        return this.casesDAO.findAll();
    }

}