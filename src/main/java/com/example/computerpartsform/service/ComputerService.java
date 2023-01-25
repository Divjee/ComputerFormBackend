package com.example.computerpartsform.service;

import com.example.computerpartsform.dto.ComputerFormRequest;
import com.example.computerpartsform.enums.ComputerPartType;
import com.example.computerpartsform.model.ComputerForm;
import com.example.computerpartsform.model.ComputerPart;
import com.example.computerpartsform.repository.ComputerPartRepository;
import com.example.computerpartsform.repository.ComputerFormRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Data
public class ComputerService {

    ComputerPartRepository computerPartRepository;

    ComputerFormRepository computerFormRepository;

    public ComputerPart addComputerPart(ComputerPart part){
        Optional<ComputerPartType> computerPartType = ComputerPartType.fromValue(part.getType());
        if (computerPartType.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        computerPartRepository.save(part);
        return part;
    }

    public String deleteAllParts() {
        computerPartRepository.deleteAll();
        return "all parts are deleted";
    }

    public List<ComputerPart> addExistingParts() {
        List<ComputerPart> parts = List.of(new ComputerPart(ComputerPartType.CPU.getValue(), "INTEL", "Xeon 2nd Gen 6256", BigDecimal.valueOf(6630.33)),
                new ComputerPart(ComputerPartType.MONITOR.getValue(), "DELL", "Alienware AW2521H", BigDecimal.valueOf(599.0)),
                new ComputerPart(ComputerPartType.GPU.getValue(), "GeForce", "GTX 1660 Ti XLR8 OC", BigDecimal.valueOf(279.0)),
                new ComputerPart(ComputerPartType.MOUSE.getValue(), "Logitech", "G903 Lightspeed", BigDecimal.valueOf(129.0)),
                new ComputerPart(ComputerPartType.KEYBOARD.getValue(), "Logitech", "Lightspeed RGB", BigDecimal.valueOf(249.0)),
                new ComputerPart(ComputerPartType.RAM.getValue(), "Corsair", "DDR4-4866", BigDecimal.valueOf(859.0)));
        computerPartRepository.saveAll(parts);
        return parts;
    }

    public ComputerForm addComputerForm(ComputerFormRequest form) {
        Instant now = Instant.now().truncatedTo(ChronoUnit.SECONDS);
        Date timeStamp = Date.from(now);
        if (computerPartRepository.findById(form.getPartId()).isPresent()) {
            ComputerPart comp = computerPartRepository.findById(form.getPartId()).get();
            ComputerForm computerForm = new ComputerForm(comp, form.getJustification(), timeStamp);
            computerFormRepository.save(computerForm);
            return computerForm;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public ComputerPart getComputerPart(Long partId) {
        return computerPartRepository.findById(partId).get();
    }

    public ComputerForm getComputerForm(Long partId) {
        return computerFormRepository.findById(partId).get();
    }

    public String deleteAllForms() {
        computerFormRepository.deleteAll();
        return "all forms are deleted";
    }

    public List<ComputerPart> getAllParts() {
        return computerPartRepository.findAll().stream().sorted(Comparator.comparingLong(ComputerPart::getId)).collect(Collectors.toList());
    }

    public List<ComputerForm> getAllForms() {
        return computerFormRepository.findAll().stream().sorted(Comparator.comparingLong(ComputerForm::getId)).collect(Collectors.toList());
    }

    public ComputerPart editPart(ComputerPart part) {
        computerPartRepository.save(part);
        return part;
    }

    public ComputerFormRequest updateForm(ComputerFormRequest request) {

        for (ComputerForm f : computerFormRepository.findAll()) {
            if (f.getId() == request.getFormId()) {
                f.setPart(computerPartRepository.findById(request.getPartId()).get());
                f.setJustification(request.getJustification());
                computerFormRepository.save(f);
                return request;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void deleteFormById(Long id) {
        computerFormRepository.deleteById(id);
    }

    public void deletePartById(Long id) {
        computerPartRepository.deleteById(id);
    }

    public List<String> getListOfEnums() {
        return ComputerPartType.getValueNames();
    }

}
