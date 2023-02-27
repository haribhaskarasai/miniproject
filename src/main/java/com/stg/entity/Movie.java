package com.stg.entity;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mvId;
	@Column(name = "moviename", length = 20)
	private String mvName;		

	private String mvGener;

	private float mvRating;

	private String mvImageUrl;

	private String mvVideoUrl;
	@Column(columnDefinition = "VARCHAR(750)")
	private String mvDescrip;

	private LocalDate releaseDate;

	// @JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "movie_actor", joinColumns = {
			@JoinColumn(name = "movie_Id", referencedColumnName = "mvId", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "actor_Id", referencedColumnName = "actorId", nullable = false, updatable = false), })
	private List<Cast> actors = new ArrayList<Cast>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "movie_tech", joinColumns = {
			@JoinColumn(name = "movie_Id", referencedColumnName = "mvId", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "tech_Id", referencedColumnName = "techId", nullable = false, updatable = false), })
	private List<Crew> technicians = new ArrayList<Crew>();

	public Movie() {
		super();
	}

	public Movie(int mvId, String mvName, String mvGener, float mvRating, String mvImageUrl, String mvVideoUrl,
			String mvDescrip, LocalDate releaseDate, List<Cast> actors, List<Crew> technicians) {
		super();
		this.mvId = mvId;
		this.mvName = mvName;
		this.mvGener = mvGener;
		this.mvRating = mvRating;
		this.mvImageUrl = mvImageUrl;
		this.mvVideoUrl = mvVideoUrl;
		this.mvDescrip = mvDescrip;
		this.releaseDate = releaseDate;
		this.actors = actors;
		this.technicians = technicians;
	}

//	public Movie(int mvId, String mvName, float mvRating, String mvGener, LocalDate releaseDate, List<Cast> actors,
//			List<Crew> crews) {
//		super();
//		this.mvId = mvId;
//		this.mvName = mvName;
//		this.mvGener = mvGener;
//		this.releaseDate = releaseDate;
//		this.actors = actors;
//		this.mvRating = mvRating;
//		this.crews = crews;
//	}
//	public Movie(int mvId, String mvName, String mvGener, float mvRating, String mvUrl, LocalDate releaseDate,
//			List<Cast> actors, List<Crew> crews) {
//		super();
//		this.mvId = mvId;
//		this.mvName = mvName;
//		this.mvGener = mvGener;
//		this.mvRating = mvRating;
//		this.mvUrl = mvUrl;
//		this.releaseDate = releaseDate;
//		this.actors = actors;
//		this.crews = crews;
//	}
//	public Movie(int mvId, String mvName, String mvGener, float mvRating, String mvImageUrl, String mvVideoUrl,
//			LocalDate releaseDate, List<Cast> actors, List<Crew> crews) {
//		super();
//		this.mvId = mvId;
//		this.mvName = mvName;
//		this.mvGener = mvGener;
//		this.mvRating = mvRating;
//		this.mvImageUrl = mvImageUrl;
//		this.mvVideoUrl = mvVideoUrl;
//		this.releaseDate = releaseDate;
//		this.actors = actors;
//		this.crews = crews;
//	}

	public int getMvId() {
		return mvId;
	}

	public void setMvId(int mvId) {
		this.mvId = mvId;
	}

	public String getMvName() {
		return mvName;
	}

	public void setMvName(String mvName) {
		this.mvName = mvName;
	}

	public String getMvGener() {
		return mvGener;
	}

	public void setMvGener(String mvGener) {
		this.mvGener = mvGener;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<Cast> getActors() {
		return actors;
	}

	public void setActors(List<Cast> actors) {
		this.actors = actors;
	}

	public float getMvRating() {
		return mvRating;
	}

	public void setMvRating(float mvRating) {
		this.mvRating = mvRating;
	}

	public String getMvImageUrl() {
		return mvImageUrl;
	}

	public void setMvImageUrl(String mvImageUrl) {
		this.mvImageUrl = mvImageUrl;
	}

	public String getMvDescrip() {
		return mvDescrip;
	}

	public void setMvDescrip(String mvDescrip) {
		this.mvDescrip = mvDescrip;
	}

	public String getMvVideoUrl() {
		return mvVideoUrl;
	}

	public void setMvVideoUrl(String mvVideoUrl) {
		this.mvVideoUrl = mvVideoUrl;
	}

	public List<Crew> getTechnicians() {
		return technicians;
	}

	public void setTechnicians(List<Crew> technicians) {
		this.technicians = technicians;
	}

}
