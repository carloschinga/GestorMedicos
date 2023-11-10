/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "view_web_menu_deta_rol")
@NamedQueries({
    @NamedQuery(name = "ViewWebMenuDetaRol.findAll", query = "SELECT v FROM ViewWebMenuDetaRol v"),
    @NamedQuery(name = "ViewWebMenuDetaRol.findByCodmen", query = "SELECT v FROM ViewWebMenuDetaRol v WHERE v.codmen = :codmen"),
    @NamedQuery(name = "ViewWebMenuDetaRol.findByNommen", query = "SELECT v FROM ViewWebMenuDetaRol v WHERE v.nommen = :nommen"),
    @NamedQuery(name = "ViewWebMenuDetaRol.findByCodrol", query = "SELECT v FROM ViewWebMenuDetaRol v WHERE v.codrol = :codrol"),
    @NamedQuery(name = "ViewWebMenuDetaRol.findByCodmas", query = "SELECT v FROM ViewWebMenuDetaRol v WHERE v.codmas = :codmas"),
    @NamedQuery(name = "ViewWebMenuDetaRol.findByAsigperm", query = "SELECT v FROM ViewWebMenuDetaRol v WHERE v.asigperm = :asigperm")})
public class ViewWebMenuDetaRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codmen")
    private int codmen;
    @Size(max = 100)
    @Column(name = "nommen")
    private String nommen;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codrol")
    private int codrol;
    @Column(name = "codmas")
    private Integer codmas;
    @Column(name = "asigperm")
    private Integer asigperm;

    public ViewWebMenuDetaRol() {
    }

    public int getCodmen() {
        return codmen;
    }

    public void setCodmen(int codmen) {
        this.codmen = codmen;
    }

    public String getNommen() {
        return nommen;
    }

    public void setNommen(String nommen) {
        this.nommen = nommen;
    }

    public int getCodrol() {
        return codrol;
    }

    public void setCodrol(int codrol) {
        this.codrol = codrol;
    }

    public Integer getCodmas() {
        return codmas;
    }

    public void setCodmas(Integer codmas) {
        this.codmas = codmas;
    }

    public Integer getAsigperm() {
        return asigperm;
    }

    public void setAsigperm(Integer asigperm) {
        this.asigperm = asigperm;
    }
    
}
