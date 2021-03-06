/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * Created by Felipe Rodriguez Arias <ucifarias@gmail.com>.
 */
package cu.cenpis.gps.wic.data.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author farias-i5
 */
@Entity
@Table(catalog = "wic", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudio.findAll", query = "SELECT e FROM Estudio e"),
    @NamedQuery(name = "Estudio.findByIdEstudio", query = "SELECT e FROM Estudio e WHERE e.idEstudio = :idEstudio"),
    @NamedQuery(name = "Estudio.findByRmiId", query = "SELECT e FROM Estudio e WHERE e.rmiId = :rmiId"),
    @NamedQuery(name = "Estudio.findByFecha", query = "SELECT e FROM Estudio e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Estudio.findByDiagnostico", query = "SELECT e FROM Estudio e WHERE e.diagnostico.idDiagnostico = :idDiagnostico"),
    @NamedQuery(name = "Estudio.findByPaciente", query = "SELECT e FROM Estudio e WHERE e.paciente.idPaciente = :idPaciente"),
    @NamedQuery(name = "Estudio.findByPositivo", query = "SELECT e FROM Estudio e WHERE e.positivo = :positivo")})
public class Estudio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estudio")
    private Long idEstudio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "rmi_id")
    private String rmiId;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "impresion_diagnostica")
    private String impresionDiagnostica;
    @Basic(optional = false)
    @NotNull
    private Boolean positivo;
    @JoinColumn(name = "diagnostico", referencedColumnName = "id_diagnostico")
    @ManyToOne(optional = false)
    private Diagnostico diagnostico;
    @JoinColumn(name = "especialidad", referencedColumnName = "id_espacialidad")
    @ManyToOne(optional = false)
    private Especialidad especialidad;
    @JoinColumn(name = "medico", referencedColumnName = "id_medico")
    @ManyToOne(optional = false)
    private Medico medico;
    @JoinColumn(name = "paciente", referencedColumnName = "id_paciente")
    @ManyToOne(optional = false)
    private Paciente paciente;
    @JoinColumn(name = "procedencia", referencedColumnName = "id_procedencia")
    @ManyToOne(optional = false)
    private Procedencia procedencia;
    @JoinColumn(name = "tipo_estudio", referencedColumnName = "id_tipo_estudio")
    @ManyToOne(optional = false)
    private TipoEstudio tipoEstudio;
    @JoinColumn(name = "usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "modalidad", referencedColumnName = "id_modalidad")
    @ManyToOne(optional = false)
    private Modalidad modalidad;

    public Estudio() {
    }

    public Estudio(Long idEstudio) {
        this.idEstudio = idEstudio;
    }

    public Estudio(Long idEstudio, String rmiId, Date fecha, String impresionDiagnostica, Boolean positivo) {
        this.idEstudio = idEstudio;
        this.rmiId = rmiId;
        this.fecha = fecha;
        this.impresionDiagnostica = impresionDiagnostica;
        this.positivo = positivo;
    }

    public Long getIdEstudio() {
        return idEstudio;
    }

    public void setIdEstudio(Long idEstudio) {
        this.idEstudio = idEstudio;
    }

    public String getRmiId() {
        return rmiId;
    }

    public void setRmiId(String rmiId) {
        this.rmiId = rmiId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getImpresionDiagnostica() {
        return impresionDiagnostica;
    }

    public void setImpresionDiagnostica(String impresionDiagnostica) {
        this.impresionDiagnostica = impresionDiagnostica;
    }

    public Boolean getPositivo() {
        return positivo;
    }

    public void setPositivo(Boolean positivo) {
        this.positivo = positivo;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Procedencia getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(Procedencia procedencia) {
        this.procedencia = procedencia;
    }

    public TipoEstudio getTipoEstudio() {
        return tipoEstudio;
    }

    public void setTipoEstudio(TipoEstudio tipoEstudio) {
        this.tipoEstudio = tipoEstudio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudio != null ? idEstudio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudio)) {
            return false;
        }
        Estudio other = (Estudio) object;
        return !((this.idEstudio == null && other.idEstudio != null) || (this.idEstudio != null && !this.idEstudio.equals(other.idEstudio)));
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getIdEstudio());
    }

}
