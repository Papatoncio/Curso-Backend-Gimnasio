package com.curso.gimnasiocurso.model.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaDto implements Serializable {
    private static final long serialVersionUID = 6393550292874643298L;

    private String mensaje;
    private List<SubDto> suscripciones;
}
