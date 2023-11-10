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
@Table(name = "view_web_menu_deta")
@NamedQueries({
    @NamedQuery(name = "ViewWebMenuDeta.findAll", query = "SELECT v FROM ViewWebMenuDeta v"),
    @NamedQuery(name = "ViewWebMenuDeta.findByCodmen", query = "SELECT v FROM ViewWebMenuDeta v WHERE v.codmen = :codmen"),
    @NamedQuery(name = "ViewWebMenuDeta.findByCodmenYUsecod", query = "SELECT v FROM ViewWebMenuDeta v WHERE v.codmen = :codmen and v.usecod = :usecod"),
    @NamedQuery(name = "ViewWebMenuDeta.findByNommen", query = "SELECT v FROM ViewWebMenuDeta v WHERE v.nommen = :nommen"),
    @NamedQuery(name = "ViewWebMenuDeta.findByCodrol", query = "SELECT v FROM ViewWebMenuDeta v WHERE v.codrol = :codrol"),
    @NamedQuery(name = "ViewWebMenuDeta.findByCodmas", query = "SELECT v FROM ViewWebMenuDeta v WHERE v.codmas = :codmas"),
    @NamedQuery(name = "ViewWebMenuDeta.findByAsigperm", query = "SELECT v FROM ViewWebMenuDeta v WHERE v.asigperm = :asigperm"),
    @NamedQuery(name = "ViewWebMenuDeta.findByTipmen", query = "SELECT v FROM ViewWebMenuDeta v WHERE v.tipmen = :tipmen"),
    @NamedQuery(name = "ViewWebMenuDeta.findByHtml", query = "SELECT v FROM ViewWebMenuDeta v WHERE v.html = :html"),
    @NamedQuery(name = "ViewWebMenuDeta.findByIclass", query = "SELECT v FROM ViewWebMenuDeta v WHERE v.iclass = :iclass"),
    @NamedQuery(name = "ViewWebMenuDeta.listarXUsecod", query = "SELECT v FROM ViewWebMenuDeta v WHERE v.usecod = :usecod and v.asigperm=1"),
    @NamedQuery(name = "ViewWebMenuDeta.findByUsecod", query = "SELECT v FROM ViewWebMenuDeta v WHERE v.usecod = :usecod")})
public class ViewWebMenuDeta implements Serializable {

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
    @Size(max = 10)
    @Column(name = "tipmen")
    private String tipmen;
    @Size(max = 150)
    @Column(name = "html")
    private String html;
    @Size(max = 150)
    @Column(name = "iclass")
    private String iclass;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "usecod")
    private int usecod;

    public ViewWebMenuDeta() {
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

    public String getTipmen() {
        return tipmen;
    }

    public void setTipmen(String tipmen) {
        this.tipmen = tipmen;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getIclass() {
        return iclass;
    }

    public void setIclass(String iclass) {
        this.iclass = iclass;
    }

    public int getUsecod() {
        return usecod;
    }

    public void setUsecod(int usecod) {
        this.usecod = usecod;
    }
    
}
