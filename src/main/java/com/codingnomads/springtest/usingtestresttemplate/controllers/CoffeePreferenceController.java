/* CodingNomads (C)2024 */
package com.codingnomads.springtest.usingtestresttemplate.controllers;

import com.codingnomads.springtest.usingtestresttemplate.models.CoffeePreference;
import com.codingnomads.springtest.usingtestresttemplate.services.CoffeePreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/coffee")
public class CoffeePreferenceController {

    @Autowired
    CoffeePreferenceService service;

    @GetMapping
    public ResponseEntity<?> getCoffeePreference() {
        List<CoffeePreference> coffeePreferences= service.getAllCoffeePreferences();
        if (coffeePreferences.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("There are no coffee preferences yet.");
        }
            return ResponseEntity.ok(coffeePreferences);
    }

    @PostMapping
    public ResponseEntity<?> postNewCoffeePreference(@RequestBody CoffeePreference coffeePreference) {
        try {
            CoffeePreference preference = service.insertNewCoffeePreference(coffeePreference);
            return ResponseEntity.ok()
                    .header("Location", "http://www.url.com/new/location")
                    .body(preference);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Exception(e.getMessage()));
        }
    }
}
