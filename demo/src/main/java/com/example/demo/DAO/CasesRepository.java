package com.example.demo.DAO;

import java.io.Serializable;

import com.example.demo.models.Case;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasesRepository <T, ID extends Serializable> extends JpaRepository<Case, Long> {
}