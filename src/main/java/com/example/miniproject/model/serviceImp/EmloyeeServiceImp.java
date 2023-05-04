package com.example.miniproject.model.serviceImp;

import com.example.miniproject.model.dto.EmloyeeRequest;
import com.example.miniproject.model.entity.ERoles;
import com.example.miniproject.model.entity.Emloyee;
import com.example.miniproject.model.entity.Roles;
import com.example.miniproject.model.repository.EmloyeeRepository;
import com.example.miniproject.model.repository.RolesRepository;
import com.example.miniproject.model.service.EmloyeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmloyeeServiceImp implements EmloyeeService {
    @Autowired
    private EmloyeeRepository emloyeeRepository;
    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public List<Emloyee> findAll() {
        return emloyeeRepository.findAll();
    }

    @Override
    public Emloyee findById(int id) {
        return emloyeeRepository.findById(id).get();
    }

    @Override
    public String save(EmloyeeRequest emloyeeRequest) {
                if (emloyeeRepository.existsByEmail(emloyeeRequest.getEmail())) {
            return "Email is already";
        }
        Emloyee emloyee = new Emloyee();
        emloyee.setNameEmloyee(emloyeeRequest.getNameEmloyee());
        emloyee.setEmail(emloyeeRequest.getEmail());
        emloyee.setDepartment(emloyeeRequest.getDepartment());
        Set<String> strRoles = emloyeeRequest.getListRoles();
        Set<Roles> listRoles = new HashSet<>();
        if (strRoles == null) {
            Roles emloyeeRole = rolesRepository.findByRoleName(ERoles.ROLES_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found"));
            listRoles.add(emloyeeRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Roles adminRole = rolesRepository.findByRoleName(ERoles.ROLES_ADMIN).orElseThrow(() -> new RuntimeException("Error: Admin"));
                        listRoles.add(adminRole);
                    case "user":
                        Roles userRole = rolesRepository.findByRoleName(ERoles.ROLES_USER).orElseThrow(() -> new RuntimeException("Error: User"));
                        listRoles.add(userRole);
                }
            });
        }
        emloyee.setListRoles(listRoles);
        try {
            emloyeeRepository.save(emloyee);
            return "Them moi thanh cong ";
        } catch (Exception e) {
            e.printStackTrace();
            return "Them moi k thanh cong ";
        }
    }

    @Override
    public String update(EmloyeeRequest emloyeeRequest) {
        Emloyee emloyee = emloyeeRepository.findById(emloyeeRequest.getId()).get();
        if (emloyeeRepository.existsByEmail(emloyeeRequest.getEmail())) {
            return "Email is already";
        }emloyee.setNameEmloyee(emloyeeRequest.getNameEmloyee());
        emloyee.setEmail(emloyeeRequest.getEmail());
        emloyee.setDepartment(emloyeeRequest.getDepartment());
        try {
            emloyeeRepository.save(emloyee);
            return "Đã cập nhập thành công";
        } catch (Exception e) {
            e.printStackTrace();
            return "Cap nhap k thanh cong  ";
        }
    }

    @Override
    public void deleteEmloyee(int id) {
        emloyeeRepository.deleteById(id);
    }

}
