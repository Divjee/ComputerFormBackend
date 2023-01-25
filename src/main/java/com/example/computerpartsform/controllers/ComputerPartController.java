package com.example.computerpartsform.controllers;

import com.example.computerpartsform.dto.ComputerFormRequest;
import com.example.computerpartsform.model.ComputerForm;
import com.example.computerpartsform.model.ComputerPart;
import com.example.computerpartsform.service.ComputerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("app")
@AllArgsConstructor
class ComputerPartController {

    private ComputerService computerService;

    @PutMapping("/edit-hardware")
    public ResponseEntity<ComputerPart> editPart(@Valid @RequestBody ComputerPart part) {
        return new ResponseEntity<>(computerService.editPart(part), HttpStatus.OK);
    }

    @Operation(summary = "Save a computer part",
            description = "Save a computer part in the database")
    @PostMapping("/hardware")
    public ResponseEntity<ComputerPart> savePart(@Valid @RequestBody ComputerPart part) throws JsonProcessingException {
        return new ResponseEntity<>(computerService.addComputerPart(new ComputerPart(part.getType(), part.getBrand(), part.getModel(), part.getPrice())), HttpStatus.CREATED);
    }

    @Operation(summary = "Deletes all parts",
            description = "Deletes all parts in the database")
    @DeleteMapping("/deleteParts")
    public ResponseEntity<String> deleteAllParts() {
        return new ResponseEntity<>(computerService.deleteAllParts(), HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Saves computer built in parts in database")
    @PutMapping("/addHardware")
    public ResponseEntity<List<ComputerPart>> addHardware() {
        return new ResponseEntity<>(computerService.addExistingParts(), HttpStatus.OK);
    }

    @Operation(summary = "Saves a computer form in the database",
            description = "The partId is the ID number of which computer part will be given to the form " +
                    "and the JUSTIFICATION is the reasoning behind giving the part")
    @PostMapping("/addComputerForm")
    public ResponseEntity<ComputerForm> addComputerForm(@Valid @RequestBody ComputerFormRequest form) {
        return new ResponseEntity<>(computerService.addComputerForm(form), HttpStatus.CREATED);
    }

    @Operation(summary = "Finds a computer part by existing ID")
    @GetMapping("/part/{id}")
    public ResponseEntity<ComputerPart> getPartById(@PathVariable Long id) {
        return new ResponseEntity<>(computerService.getComputerPart(id), HttpStatus.OK);
    }

    @Operation(summary = "Finds a computer form by existing ID")
    @GetMapping("/form/{id}")
    public ResponseEntity<ComputerForm> getFormById(@PathVariable Long id) {
        return new ResponseEntity<>(computerService.getComputerForm(id), HttpStatus.OK);
    }

    @Operation(summary = "Deletes all forms",
            description = "Deletes all forms in the database")
    @DeleteMapping("/deleteForms")
    public ResponseEntity<String> deleteAllForms() {
        return new ResponseEntity<>(computerService.deleteAllForms(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getAllParts")
    public ResponseEntity<List<ComputerPart>> getAllParts() {
        return new ResponseEntity<>(computerService.getAllParts(), HttpStatus.OK);
    }

    @GetMapping("/getAllForms")
    public ResponseEntity<List<ComputerForm>> getAllForms() {
        return new ResponseEntity<>(computerService.getAllForms(), HttpStatus.OK);
    }

    @PutMapping("/edit-form")
    public ResponseEntity<ComputerFormRequest> editForm(@Valid @RequestBody ComputerFormRequest form) {
        return new ResponseEntity<>(computerService.updateForm(form), HttpStatus.OK);
    }

    @DeleteMapping("/formDelete/{id}")
    public ResponseEntity<String> deleteForm(@PathVariable("id") Long id) {
        computerService.deleteFormById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping("/partDelete/{id}")
    public ResponseEntity<String> deletePart(@PathVariable("id") Long id) {
        computerService.deletePartById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/partNames")
    public ResponseEntity<List<String>> getPartNames() {
        return new ResponseEntity<>(computerService.getListOfEnums(), HttpStatus.OK);
    }
}
