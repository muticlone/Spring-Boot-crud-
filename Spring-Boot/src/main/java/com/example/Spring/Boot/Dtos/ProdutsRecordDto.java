package com.example.Spring.Boot.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutsRecordDto(@NotBlank String name , @NotNull BigDecimal value) {




}
