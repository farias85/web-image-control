/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.cenpis.gps.wic.data.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author farias-i5
 */
@Entity
@Table(name = "tipo_estudio", catalog = "wic", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEstudio.findAll", query = "SELECT t FROM TipoEstudio t"),
    @NamedQuery(name = "TipoEstudio.findByIdTipoEstudio", query = "SELECT t FROM TipoEstudio t WHERE t.idTipoEstudio = :idTipoEstudio"),
    @NamedQuery(name = "TipoEstudio.findByNombre", query = "SELECT t FROM TipoEstudio t WHERE t.nombre = :nombre")})
public class TipoEstudio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_estudio")
    private Long idTipoEstudio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String nombre;
    @Lob
    @Size(max = 65535)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEstudio")
    private List<Estudio> estudioList;

    public TipoEstudio() {
    }

    public TipoEstudio(Long idTipoEstudio) {
        this.idTipoEstudio = idTipoEstudio;
    }

    public TipoEstudio(Long idTipoEstudio, String nombre) {
        this.idTipoEstudio = idTipoEstudio;
        this.nombre = nombre;
    }

    public Long getIdTipoEstudio() {
        return idTipoEstudio;
    }

    public void setIdTipoEstudio(Long idTipoEstudio) {
        this.idTipoEstudio = idTipoEstudio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Estudio> getEstudioList() {
        return estudioList;
    }

    public void setEstudioList(List<Estudio> estudioList) {
        this.estudioList = estudioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEstudio != null ? idTipoEstudio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEstudio)) {
            return false;
        }
        TipoEstudio other = (TipoEstudio) object;
        if ((this.idTipoEstudio == null && other.idTipoEstudio != null) || (this.idTipoEstudio != null && !this.idTipoEstudio.equals(other.idTipoEstudio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
