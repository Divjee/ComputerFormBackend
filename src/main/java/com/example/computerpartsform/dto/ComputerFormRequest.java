package com.example.computerpartsform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ComputerFormRequest {
    Long formId;
    Long partId;
    String justification;
}
