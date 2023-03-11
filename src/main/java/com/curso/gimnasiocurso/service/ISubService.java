package com.curso.gimnasiocurso.service;

import com.curso.gimnasiocurso.model.dto.RespuestaDto;
import com.curso.gimnasiocurso.model.dto.SubDto;

public interface ISubService {
    RespuestaDto mostrarTodos();

    RespuestaDto crearSuscripcion(SubDto subDto);
}
