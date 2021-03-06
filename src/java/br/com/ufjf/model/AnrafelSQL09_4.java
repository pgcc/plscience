package br.com.ufjf.model;

import java.io.Serializable;

/**
 * Class AnrafelSQL09_4 ( 9.4 ) SQL para trazer as interações realizadas entre
 * os cientistas SELECT A.`idRationale`, F.`NameScientist` ,
 * F.`institutionScientist` , A.`data` , A.`hora` , A.`message` FROM
 * `Communication` A LEFT OUTER JOIN `Rationale` C ON ( A.`idRationale` =
 * C.`idRationale` ) LEFT OUTER JOIN `What` D ON ( C.`idWhat` = D.`idWhat` )
 * LEFT OUTER JOIN `User` F ON ( A.`idScientist_Emissor` = F.`idScientist` )
 * WHERE (A.`idRationale` =1)
 * 
 * idRationale NameScientist institutionScientist data hora message
 * 
 * @author magnus, anrafel, jonathan
 * 
 */
public class AnrafelSQL09_4 implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idRationale;
	private String NameScientist;
	private String institutionScientist;
	private String data;
	private String hora;
	private String message;

	public int getIdRationale() {
		return idRationale;
	}

	public void setIdRationale(int idRationale) {
		this.idRationale = idRationale;
	}

	public String getNameScientist() {
		return NameScientist;
	}

	public void setNameScientist(String nameScientist) {
		NameScientist = nameScientist;
	}

	public String getInstitutionScientist() {
		return institutionScientist;
	}

	public void setInstitutionScientist(String institutionScientist) {
		this.institutionScientist = institutionScientist;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}// ultima
