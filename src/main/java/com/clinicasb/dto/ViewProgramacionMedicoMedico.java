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
@Table(name = "view_programacion_medico_medico")
@NamedQueries({
    @NamedQuery(name = "ViewProgramacionMedicoMedico.findAll", query = "SELECT v FROM ViewProgramacionMedicoMedico v"),
    @NamedQuery(name = "ViewProgramacionMedicoMedico.findByMedcod", query = "SELECT v FROM ViewProgramacionMedicoMedico v WHERE v.medcod = :medcod"),
    @NamedQuery(name = "ViewProgramacionMedicoMedico.findByMednam", query = "SELECT v FROM ViewProgramacionMedicoMedico v WHERE v.mednam = :mednam"),
    @NamedQuery(name = "ViewProgramacionMedicoMedico.findBySercod", query = "SELECT v FROM ViewProgramacionMedicoMedico v WHERE v.sercod = :sercod")})
public class ViewProgramacionMedicoMedico implements Serializable , Comparable<ViewProgramacionMedicoMedico>{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "medcod")
    private String medcod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "mednam")
    private String mednam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "sercod")
    private String sercod;

    public ViewProgramacionMedicoMedico() {
    }

    public String getMedcod() {
        return medcod;
    }

    public void setMedcod(String medcod) {
        this.medcod = medcod;
    }

    public String getMednam() {
        return mednam;
    }

    public void setMednam(String mednam) {
        this.mednam = mednam;
    }

    public String getSercod() {
        return sercod;
    }

    public void setSercod(String sercod) {
        this.sercod = sercod;
    }

    public int compareTo(ViewProgramacionMedicoMedico s) {
        int compare = s.mednam.compareTo(mednam);

        if (compare < 0) {
            return 1;
        } else if (compare > 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
