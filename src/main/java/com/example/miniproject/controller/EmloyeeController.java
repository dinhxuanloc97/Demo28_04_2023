package com.example.miniproject.controller;

import com.example.miniproject.model.dto.EmloyeeRequest;
import com.example.miniproject.model.entity.Emloyee;
import com.example.miniproject.model.repository.EmloyeeRepository;
import com.example.miniproject.model.service.EmloyeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmloyeeController {
    @Autowired
    private EmloyeeService emloyeeService;

        @GetMapping("/getAll")
    public List<Emloyee> getAll() {
        return emloyeeService.findAll();
    }

    @GetMapping("/{id}")
    public Object getEmloyeeById(@PathVariable("id") int id) {
        return emloyeeService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> createEmloyee(@RequestBody EmloyeeRequest emloyeeRequest) {
        return ResponseEntity.ok(emloyeeService.save(emloyeeRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmloyee(@PathVariable("id") int id, @RequestBody EmloyeeRequest emloyeeRequest) {
        emloyeeRequest.setId(id);
        return ResponseEntity.ok(emloyeeService.update(emloyeeRequest));
    }

    @DeleteMapping("/{id}")
    public String deleteEmloyee(@PathVariable("id") int id) {
        try {
            emloyeeService.deleteEmloyee(id);
            return "Xóa thành công ";
        } catch (Exception e) {
            e.printStackTrace();
            return "Id không tồn tại  ";
        }
    }

}
