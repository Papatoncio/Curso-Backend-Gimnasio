package com.curso.gimnasiocurso.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SUB")
@Getter
@Setter
public class SubEntity implements Serializable {

    private static final long serialVersionUID = -876575009214606732L;

    @Id
    @Column(name = "ID_SUB_PK", nullable = false, length = 2)
    @SequenceGenerator(name = "SEQ_ID_SUB_PK", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_SUB_PK")
    private Integer idSub;

    @Column(name = "STATUS_SUB", nullable = false, length = 15)
    private Integer statusSUB;

    @Column(name = "PRECIO_SUB", nullable = false, length = 4)
    private Integer precioSUB;

    @Column(name = "TIPO_SUB", nullable = false, length = 30)
    private Integer tipoSUB;
}
