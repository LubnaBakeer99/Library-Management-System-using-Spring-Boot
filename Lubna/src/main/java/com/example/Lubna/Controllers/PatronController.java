package com.example.Lubna.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Lubna.Services.PatronService;
import com.example.Lubna.untity.Patron;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {
    @Autowired
    private PatronService patronService;

    @GetMapping
    public List<Patron> getAllPatrons() {
        return patronService.getAllPatrons();
    }

    @GetMapping("/api/patrons/{id}")
    public Patron getPatronById(@PathVariable Long id) {
        return patronService.getPatronById(id);
    }

    @PostMapping
    public Patron createPatron(@RequestBody Patron patron) {
        return patronService.createPatron(patron);
    }

    @PutMapping("/api/patrons/{id}")
    public Patron updatePatron(@PathVariable Long id, @RequestBody Patron patronDetails) {
        return patronService.updatePatron(id, patronDetails);
    }

    @DeleteMapping("/api/patrons/{id}")
    public ResponseEntity<?> deletePatron(@PathVariable Long id) {
        patronService.deletePatron(id);
        return ResponseEntity.ok().build();
    }
}
