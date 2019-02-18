package com.bancolombia.homologador.persistencia.Persistencia;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Table;


@Entity
@Table(name = "PERSONAS")
public class Personas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "ID_PERSONA")
    private BigDecimal idPersona;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "COLUMN1")
    private String column1;
    @Column(name = "COLUMN2")
    private BigInteger column2;

    public Personas() {
    }

    public Personas(BigDecimal idPersona) {
        this.idPersona = idPersona;
    }

    public BigDecimal getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(BigDecimal idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public BigInteger getColumn2() {
        return column2;
    }

    public void setColumn2(BigInteger column2) {
        this.column2 = column2;
    }
}