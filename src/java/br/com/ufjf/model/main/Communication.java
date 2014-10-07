package br.com.ufjf.model.main;
// Generated 13/01/2014 11:59:13 by Hibernate Tools 3.6.0


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Communication generated by hbm2java
 */
@Entity
@Table(name="Communication"
    ,catalog="collaborate"
)
@XmlRootElement
public class Communication  implements java.io.Serializable {

private static final long serialVersionUID = 1L;
     private Integer idComunication;
     private String message;
     private int idRationale;
     private String subfeature;
     private int idScientistReceptor;
     private int idScientistEmissor;
     private String data;
     private String hora;
     private int lidaSn;

    public Communication() {
    }

	
    public Communication(int idRationale, int idScientistReceptor, int idScientistEmissor, String data, String hora, int lidaSn) {
        this.idRationale = idRationale;
        this.idScientistReceptor = idScientistReceptor;
        this.idScientistEmissor = idScientistEmissor;
        this.data = data;
        this.hora = hora;
        this.lidaSn = lidaSn;
    }
    public Communication(String message, int idRationale, String subfeature, int idScientistReceptor, int idScientistEmissor, String data, String hora, int lidaSn) {
       this.message = message;
       this.idRationale = idRationale;
       this.subfeature = subfeature;
       this.idScientistReceptor = idScientistReceptor;
       this.idScientistEmissor = idScientistEmissor;
       this.data = data;
       this.hora = hora;
       this.lidaSn = lidaSn;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idComunication", unique=true, nullable=false)
    public Integer getIdComunication() {
        return this.idComunication;
    }
    
    public void setIdComunication(Integer idComunication) {
        this.idComunication = idComunication;
    }

    
    @Column(name="message")
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

    
    @Column(name="idRationale", nullable=false)
    public int getIdRationale() {
        return this.idRationale;
    }
    
    public void setIdRationale(int idRationale) {
        this.idRationale = idRationale;
    }

    
    @Column(name="Subfeature", length=200)
    public String getSubfeature() {
        return this.subfeature;
    }
    
    public void setSubfeature(String subfeature) {
        this.subfeature = subfeature;
    }

    
    @Column(name="idScientist_Receptor", nullable=false)
    public int getIdScientistReceptor() {
        return this.idScientistReceptor;
    }
    
    public void setIdScientistReceptor(int idScientistReceptor) {
        this.idScientistReceptor = idScientistReceptor;
    }

    
    @Column(name="idScientist_Emissor", nullable=false)
    public int getIdScientistEmissor() {
        return this.idScientistEmissor;
    }
    
    public void setIdScientistEmissor(int idScientistEmissor) {
        this.idScientistEmissor = idScientistEmissor;
    }

    
    @Column(name="data", nullable=false, length=20)
    public String getData() {
        return this.data;
    }
    
    public void setData(String data) {
        this.data = data;
    }

    
    @Column(name="hora", nullable=false, length=20)
    public String getHora() {
        return this.hora;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }

    
    @Column(name="lidaSN", nullable=false)
    public int getLidaSn() {
        return this.lidaSn;
    }
    
    public void setLidaSn(int lidaSn) {
        this.lidaSn = lidaSn;
    }




}


