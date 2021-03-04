package com.sistema.sistemagerenciamento.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTelefone {

    RESIDENCIAL("Residencial"),
    CELULAR("Mobile"),
    COMERCIAL("Comercial");

    private final String description;
}
