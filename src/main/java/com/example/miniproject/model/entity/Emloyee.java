package com.example.miniproject.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Emloyee")
@Data
public class Emloyee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;
    @Column(name = "nameEmloyee")
    private String nameEmloyee;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "department")
    private String department;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Emloyee_Role", joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Roles> listRoles = new HashSet<>();
}
