/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package desktopapplicationdb;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "contactos", catalog = "agenda", schema = "")
@NamedQueries({
    @NamedQuery(name = "Contactos.findAll", query = "SELECT c FROM Contactos c"),
    @NamedQuery(name = "Contactos.findByCodigo", query = "SELECT c FROM Contactos c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Contactos.findByNombres", query = "SELECT c FROM Contactos c WHERE c.nombres = :nombres"),
    @NamedQuery(name = "Contactos.findByApellidoPaterno", query = "SELECT c FROM Contactos c WHERE c.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Contactos.findByApellidoMaterno", query = "SELECT c FROM Contactos c WHERE c.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Contactos.findBySexo", query = "SELECT c FROM Contactos c WHERE c.sexo = :sexo"),
    @NamedQuery(name = "Contactos.findByFechaNacimiento", query = "SELECT c FROM Contactos c WHERE c.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Contactos.findByDomicilio", query = "SELECT c FROM Contactos c WHERE c.domicilio = :domicilio"),
    @NamedQuery(name = "Contactos.findByTelefono", query = "SELECT c FROM Contactos c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Contactos.findByTelefonoDomicilio", query = "SELECT c FROM Contactos c WHERE c.telefonoDomicilio = :telefonoDomicilio"),
    @NamedQuery(name = "Contactos.findByCorreoElectronico", query = "SELECT c FROM Contactos c WHERE c.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "Contactos.findByComentarios", query = "SELECT c FROM Contactos c WHERE c.comentarios = :comentarios")})
public class Contactos implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    @Column(name = "sexo")
    private Integer sexo;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "domicilio")
    private String domicilio;
    @Column(name = "telefono")
    private Integer telefono;
    @Column(name = "telefono_domicilio")
    private Integer telefonoDomicilio;
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Column(name = "comentarios")
    private String comentarios;

    public Contactos() {
    }

    public Contactos(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        Integer oldCodigo = this.codigo;
        this.codigo = codigo;
        changeSupport.firePropertyChange("codigo", oldCodigo, codigo);
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        String oldNombres = this.nombres;
        this.nombres = nombres;
        changeSupport.firePropertyChange("nombres", oldNombres, nombres);
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        String oldApellidoPaterno = this.apellidoPaterno;
        this.apellidoPaterno = apellidoPaterno;
        changeSupport.firePropertyChange("apellidoPaterno", oldApellidoPaterno, apellidoPaterno);
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        String oldApellidoMaterno = this.apellidoMaterno;
        this.apellidoMaterno = apellidoMaterno;
        changeSupport.firePropertyChange("apellidoMaterno", oldApellidoMaterno, apellidoMaterno);
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        Integer oldSexo = this.sexo;
        this.sexo = sexo;
        changeSupport.firePropertyChange("sexo", oldSexo, sexo);
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        Date oldFechaNacimiento = this.fechaNacimiento;
        this.fechaNacimiento = fechaNacimiento;
        changeSupport.firePropertyChange("fechaNacimiento", oldFechaNacimiento, fechaNacimiento);
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        String oldDomicilio = this.domicilio;
        this.domicilio = domicilio;
        changeSupport.firePropertyChange("domicilio", oldDomicilio, domicilio);
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        Integer oldTelefono = this.telefono;
        this.telefono = telefono;
        changeSupport.firePropertyChange("telefono", oldTelefono, telefono);
    }

    public Integer getTelefonoDomicilio() {
        return telefonoDomicilio;
    }

    public void setTelefonoDomicilio(Integer telefonoDomicilio) {
        Integer oldTelefonoDomicilio = this.telefonoDomicilio;
        this.telefonoDomicilio = telefonoDomicilio;
        changeSupport.firePropertyChange("telefonoDomicilio", oldTelefonoDomicilio, telefonoDomicilio);
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        String oldCorreoElectronico = this.correoElectronico;
        this.correoElectronico = correoElectronico;
        changeSupport.firePropertyChange("correoElectronico", oldCorreoElectronico, correoElectronico);
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        String oldComentarios = this.comentarios;
        this.comentarios = comentarios;
        changeSupport.firePropertyChange("comentarios", oldComentarios, comentarios);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contactos)) {
            return false;
        }
        Contactos other = (Contactos) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "desktopapplicationdb.Contactos[codigo=" + codigo + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
