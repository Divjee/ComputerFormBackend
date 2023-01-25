package com.example.computerpartsform;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.example.computerpartsform.dto.ComputerFormRequest;
import com.example.computerpartsform.model.ComputerForm;
import com.example.computerpartsform.model.ComputerPart;
import com.example.computerpartsform.repository.ComputerFormRepository;
import com.example.computerpartsform.repository.ComputerPartRepository;
import com.example.computerpartsform.service.ComputerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ComputerServiceTest {
    @Mock
    private ComputerPartRepository computerPartRepository;
    @Mock
    private ComputerFormRepository computerFormRepository;
    @InjectMocks
    private ComputerService computerService;
    private ComputerPart computerPart;

    @Before
    public void setUp() {
        computerPart = new ComputerPart("CPU", "part1 desc", "112dl", BigDecimal.valueOf(112));
    }

    @Test
    public void testAddComputerPart_validComputerPart_success() {
        when(computerPartRepository.save(any(ComputerPart.class))).thenReturn(computerPart);
        ComputerPart addedPart = computerService.addComputerPart(computerPart);
        Assertions.assertNotNull(addedPart);
        Assertions.assertEquals(computerPart.getId(), addedPart.getId());
        Assertions.assertEquals(computerPart.getType(), addedPart.getType());
        Assertions.assertEquals(computerPart.getBrand(), addedPart.getBrand());
        Assertions.assertEquals(computerPart.getModel(), addedPart.getModel());
        Assertions.assertEquals(computerPart.getPrice(), addedPart.getPrice());
    }

    @Test
    public void testAddComputerForm() {
        ComputerPart computerPart = new ComputerPart(1L, "CPU", "part1 desc", "112dl", BigDecimal.valueOf(112));
        ComputerFormRequest formRequest = new ComputerFormRequest(1L, computerPart.getId(), "Justification");

        when(computerPartRepository.findById(computerPart.getId())).thenReturn(Optional.of(computerPart));

        ComputerForm addedForm = computerService.addComputerForm(formRequest);

        Assertions.assertNotNull(addedForm);
        Assertions.assertEquals(computerPart.getId(), addedForm.getPart().getId());
        Assertions.assertEquals("Justification", addedForm.getJustification());
        Assertions.assertNotNull(addedForm.getTimeStamp());
        verify(computerFormRepository, times(1)).save(addedForm);
    }

}




