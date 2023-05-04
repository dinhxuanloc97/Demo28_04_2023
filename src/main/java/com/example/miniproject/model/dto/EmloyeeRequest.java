package com.example.miniproject.model.dto;

import lombok.Data;

import java.util.Set;

@Data
public class EmloyeeRequest {
    private int id;
    private String nameEmloyee;
    private String email;
    private String department;
    private Set<String> listRoles;
}
