import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="Direccion")
public class DireccionEntity implements Serializable {
    @Id
    @Column(name = "idAlum")
    private int idAlum;
    @Column(name="calle")
    private String calle;
    @Column(name="numero")
    private int numero;
    @Column(name="poblacion")
    private String poblacion;
    @Column(name="provincia")
    private String provincia;

    @OneToOne(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private AlumnadoEntity alumnado;

    public DireccionEntity(int idAlum, String calle, int numero, String poblacion, String provincia) {
        this.idAlum = idAlum;
        this.calle = calle;
        this.numero = numero;
        this.poblacion = poblacion;
        this.provincia = provincia;
    }

    public DireccionEntity() {
    }

    public int getIdAlum() {
        return idAlum;
    }

    public void setIdAlum(int idAlum) {
        this.idAlum = idAlum;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public AlumnadoEntity getAlumnado() {
        return alumnado;
    }

    public void setAlumnado(AlumnadoEntity alumnado) {
        this.alumnado = alumnado;
    }
}
