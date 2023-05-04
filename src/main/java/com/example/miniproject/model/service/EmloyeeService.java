package com.example.miniproject.model.service;

import com.example.miniproject.model.dto.EmloyeeRequest;
import com.example.miniproject.model.entity.Emloyee;

import java.util.List;

public interface EmloyeeService {
    List<Emloyee> findAll();

    Emloyee findById(int id);

    String save(EmloyeeRequest emloyeeRequest);

    String update(EmloyeeRequest emloyeeRequest);

    void deleteEmloyee(int id);
}
