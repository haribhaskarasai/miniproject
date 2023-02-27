
package com.stg.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Crew {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int techId;
	private String techName;
	private String techRole;
	private int techAge;
	private String techImageUrl;
	@Column(columnDefinition = "VARCHAR(650)")
	private String techDescrip;
	@JsonBackReference
	@ManyToMany(mappedBy = "technicians")
	private List<Movie> movies = new ArrayList<Movie>();

	public Crew() {
		super();
	}

	public Crew(int techId, String techName, String techRole, int techAge, String techImageUrl, String techDescrip,
			List<Movie> movies) {
		super();
		this.techId = techId;
		this.techName = techName;
		this.techRole = techRole;
		this.techAge = techAge;
		this.techImageUrl = techImageUrl;
		this.techDescrip = techDescrip;
		this.movies = movies;
	}

//	public Crew(int techId, String techName, String techRole, List<Movie> movies) {
//		super();
//		this.techId = techId;
//		this.techName = techName;
//		this.techRole = techRole;
//		this.movies = movies;
//	}

	public int getTechId() {
		return techId;
	}

	public void setTechId(int techId) {
		this.techId = techId;
	}

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public String getTechRole() {
		return techRole;
	}

	public void setTechRole(String techRole) {
		this.techRole = techRole;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public int getTechAge() {
		return techAge;
	}

	public void setTechAge(int techAge) {
		this.techAge = techAge;
	}

	public String getTechImageUrl() {
		return techImageUrl;
	}

	public void setTechImageUrl(String techImageUrl) {
		this.techImageUrl = techImageUrl;
	}

	public String getTechDescrip() {
		return techDescrip;
	}

	public void setTechDescrip(String techDescrip) {
		this.techDescrip = techDescrip;
	}

}
