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
@Table(name = "view_programacion_medico_servicio")
@NamedQueries({
    @NamedQuery(name = "ViewProgramacionMedicoServicio.findAll", query = "SELECT v FROM ViewProgramacionMedicoServicio v"),
    @NamedQuery(name = "ViewProgramacionMedicoServicio.findBySercod", query = "SELECT v FROM ViewProgramacionMedicoServicio v WHERE v.sercod = :sercod"),
    @NamedQuery(name = "ViewProgramacionMedicoServicio.findBySerdes", query = "SELECT v FROM ViewProgramacionMedicoServicio v WHERE v.serdes = :serdes")})
public class ViewProgramacionMedicoServicio implements Serializable , Comparable<ViewProgramacionMedicoServicio> {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "sercod")
    private String sercod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "serdes")
    private String serdes;

    public ViewProgramacionMedicoServicio() {
    }

    public String getSercod() {
        return sercod;
    }

    public void setSercod(String sercod) {
        this.sercod = sercod;
    }

    public String getSerdes() {
        return serdes;
    }

    public void setSerdes(String serdes) {
        this.serdes = serdes;
    }

    public int compareTo(ViewProgramacionMedicoServicio s) {
        int compare = s.serdes.compareTo(serdes);

        if (compare < 0) {
            return 1;
        } else if (compare > 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
