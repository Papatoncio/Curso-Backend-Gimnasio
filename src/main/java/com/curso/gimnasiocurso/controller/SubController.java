package com.curso.gimnasiocurso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.gimnasiocurso.model.dto.RespuestaDto;
import com.curso.gimnasiocurso.model.dto.SubDto;
import com.curso.gimnasiocurso.service.ISubService;

@RestController
@RequestMapping("/suscripciones")
public class SubController {

    @Autowired
    private ISubService subService;

    @GetMapping(path = "/subs/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaDto> obtenerSuscripciones() {
        RespuestaDto respuesta = subService.mostrarTodos();
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PostMapping(path = "/subs/nuevaSuscripcion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaDto> crearSuscripcion(@RequestBody SubDto suscripcion) {
        RespuestaDto respuesta = subService.crearSuscripcion(suscripcion);
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }
}
