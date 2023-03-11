package com.curso.gimnasiocurso.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.curso.gimnasiocurso.model.dto.RespuestaDto;
import com.curso.gimnasiocurso.model.dto.SubDto;
import com.curso.gimnasiocurso.model.entity.SubEntity;
import com.curso.gimnasiocurso.repository.ISubRepository;

@Service
public class SubService implements ISubService {

    private static final Logger log = LoggerFactory.getLogger(SubService.class);

    @Autowired
    private ISubRepository subRepository;

    @Override
    public RespuestaDto mostrarTodos() {

        List<SubEntity> subs = new ArrayList<>();

        try {
            subs = subRepository.findAll();
        } catch (DataAccessException e) {
            log.debug("Ha ocurrido un error al accesar a la BD. Excepción {}", e.getMessage());
        }

        RespuestaDto respuesta = new RespuestaDto();
        if (!subs.isEmpty()) {
            List<SubDto> subsDto = new ArrayList<>();
            subs.forEach(sub -> {
                SubDto subDto = new SubDto();
                subDto.setPrecioSUB(sub.getPrecioSUB());
                subDto.setStatusSUB(sub.getStatusSUB());
                subDto.setTipoSUB(sub.getTipoSUB());
                subsDto.add(subDto);
            });
            respuesta.setMensaje("Información obtenida con éxito");
            respuesta.setSuscripciones(subsDto);
            return respuesta;
        }
        respuesta.setMensaje("No se encontraron suscripciones");
        return respuesta;
    }

    @Override
    @Transactional
    public RespuestaDto crearSuscripcion(SubDto subDto) {
        SubEntity subEntity = new SubEntity();
        subEntity.setPrecioSUB(subDto.getPrecioSUB());
        subEntity.setStatusSUB(subDto.getStatusSUB());
        subEntity.setTipoSUB(subDto.getTipoSUB());

        try {
            subEntity = subRepository.save(subEntity);
        } catch (DataAccessException e) {
            log.debug("Ha ocurrido un error al accesar a la BD. Excepción {}", e.getMessage());
        }

        SubDto subRespuesta = new SubDto();
        subRespuesta.setPrecioSUB(subEntity.getPrecioSUB());
        subRespuesta.setStatusSUB(subEntity.getStatusSUB());
        subRespuesta.setTipoSUB(subEntity.getTipoSUB());

        RespuestaDto respuesta = new RespuestaDto();
        respuesta.setMensaje("Suscripción creada con éxito");
        respuesta.setSuscripciones(Arrays.asList(subRespuesta));

        return respuesta;
    }
}
