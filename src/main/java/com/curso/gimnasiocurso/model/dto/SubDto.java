package com.curso.gimnasiocurso.model.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubDto implements Serializable {

    private static final long serialVersionUID = 1986795217523876093L;

    private Integer statusSUB;

    private Integer precioSUB;

    private Integer tipoSUB;

}
