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
@Table(catalog = "wic", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procedencia.findAll", query = "SELECT p FROM Procedencia p"),
    @NamedQuery(name = "Procedencia.findByIdProcedencia", query = "SELECT p FROM Procedencia p WHERE p.idProcedencia = :idProcedencia"),
    @NamedQuery(name = "Procedencia.findByNombre", query = "SELECT p FROM Procedencia p WHERE p.nombre = :nombre")})
public class Procedencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_procedencia")
    private Long idProcedencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String nombre;
    @Lob
    @Size(max = 65535)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procedencia")
    private List<Estudio> estudioList;

    public Procedencia() {
    }

    public Procedencia(Long idProcedencia) {
        this.idProcedencia = idProcedencia;
    }

    public Procedencia(Long idProcedencia, String nombre) {
        this.idProcedencia = idProcedencia;
        this.nombre = nombre;
    }

    public Long getIdProcedencia() {
        return idProcedencia;
    }

    public void setIdProcedencia(Long idProcedencia) {
        this.idProcedencia = idProcedencia;
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
        hash += (idProcedencia != null ? idProcedencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procedencia)) {
            return false;
        }
        Procedencia other = (Procedencia) object;
        return !((this.idProcedencia == null && other.idProcedencia != null) || (this.idProcedencia != null && !this.idProcedencia.equals(other.idProcedencia)));
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getIdProcedencia());
    }

}
