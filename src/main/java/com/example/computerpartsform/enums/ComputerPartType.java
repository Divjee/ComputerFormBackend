package com.example.computerpartsform.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum ComputerPartType {
    MOUSE("Mouse"),
    MONITOR("Monitor"),
    KEYBOARD("Keyboard"),
    CPU("CPU"),
    RAM("RAM"),
    GPU("GPU");

    private String value;

    ComputerPartType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Optional<ComputerPartType> fromValue(String value) {
        return Arrays.stream(ComputerPartType.values())
                .filter(type -> type.getValue().equalsIgnoreCase(value))
                .findFirst();
    }

    public String getName() {
        return value;
    }

    public static List<String> getValueNames() {
        return Arrays.stream(ComputerPartType.values())
                .map(ComputerPartType::getName)
                .collect(Collectors.toList());
    }
}
