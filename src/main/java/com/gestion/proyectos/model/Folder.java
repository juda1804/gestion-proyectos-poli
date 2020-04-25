package com.gestion.proyectos.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name ="folders")
public class Folder implements Serializable {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long padre;
	
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "group_id", nullable = false)
    private Group group;
	
	@JsonManagedReference
	@OneToMany(
	        mappedBy = "folder",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	        )
	private List<File> files = new ArrayList<>();
	
	
	private String nombre;
	private String descripcion;	
	private Date fecha;
	
	public Folder() {
	
	}
		
	public Folder(Long idPadre, String nombre, String descripcion, Date fecha, Group group) {			
		this.padre = idPadre;		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.group = group;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPadre() {
		return padre;
	}

	public void setPadre(Long idPadre) {
		this.padre = idPadre;
	}
	
	public Long getGroup_id() {
		return group.getId();
	}
	
	
	//@JsonIgnore
	public Group getGroup() {
		return group;
	}
	
	//@JsonIgnore
	public void setGroup(Group group) {
		this.group = group;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Folder [id=" + id + ", padre=" + padre + ", group=" + group + ", files=" + files + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", fecha=" + fecha + "]";
	}
	
	
	
	
}
