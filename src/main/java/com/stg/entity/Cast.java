package com.stg.entity;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Cast {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int actorId;
	@Column(length = 20)
	private String actorName;
	private String actorRole;
	private int actorAge;
	private String actorImageUrl;
	@Column(columnDefinition = "VARCHAR(650)")
	private String actorDescrip;
	@JsonBackReference
	@ManyToMany(mappedBy = "actors")
	private List<Movie> movies = new ArrayList<Movie>();

	public Cast() {
		super();
	}

	public Cast(int actorId, String actorName, String actorRole, int actorAge, String actorImageUrl,
			String actorDescrip, List<Movie> movies) {
		super();
		this.actorId = actorId;
		this.actorName = actorName;
		this.actorRole = actorRole;
		this.actorAge = actorAge;
		this.actorImageUrl = actorImageUrl;
		this.actorDescrip = actorDescrip;
		this.movies = movies;
	}

//	public Cast(int actorId, String actorName, String actorRole, String actorImageUrl, String actorDescrip,
//			List<Movie> movies) {
//		super();
//		this.actorId = actorId;
//		this.actorName = actorName;
//		this.actorRole = actorRole;
//		this.actorImageUrl = actorImageUrl;
//		this.actorDescrip = actorDescrip;
//		this.movies = movies;
//	}

//	public Cast(int actorId, String actorName, String actorRole, List<Movie> movies) {
//		super();
//		this.actorId = actorId;
//		this.actorName = actorName;
//		this.actorRole = actorRole;
//		this.movies = movies;
//
//	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getActorRole() {
		return actorRole;
	}

	public void setActorRole(String actorRole) {
		this.actorRole = actorRole;
	}

	public int getActorAge() {
		return actorAge;
	}

	public void setActorAge(int actorAge) {
		this.actorAge = actorAge;
	}

	public String getActorImageUrl() {
		return actorImageUrl;
	}

	public void setActorImageUrl(String actorImageUrl) {
		this.actorImageUrl = actorImageUrl;
	}

	public String getActorDescrip() {
		return actorDescrip;
	}

	public void setActorDescrip(String actorDescrip) {
		this.actorDescrip = actorDescrip;
	}

}
