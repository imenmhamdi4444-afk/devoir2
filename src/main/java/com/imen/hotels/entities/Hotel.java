package com.imen.hotels.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 	
	 
	private Long idHotel;
	private String nomHotel;
	private String ville;
	private Double prixNuit;
	private int etoiles;
	
	@ManyToOne
	private TypeHotel typeHotel;
	
	public Hotel() {
		super();
		
	}
	
	public Hotel(String nomHotel, String ville, Double prixNuit, int etoiles) {
		super();
		this.nomHotel = nomHotel;
		this.ville = ville;
		this.prixNuit = prixNuit;
		this.etoiles = etoiles;
	}



	public Long getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}
	public String getNomHotel() {
		return nomHotel;
	}
	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public Double getPrixNuit() {
		return prixNuit;
	}
	public void setPrixNuit(Double prixNuit) {
		this.prixNuit = prixNuit;
	}
	public int getEtoiles() {
		return etoiles;
	}
	public void setEtoiles(int etoiles) {
		this.etoiles = etoiles;
	}



	@Override
	public String toString() {
		return "Hotel [idHotel=" + idHotel + ", nomHotel=" + nomHotel + ", ville=" + ville + ", prixNuit=" + prixNuit
				+ ", etoiles=" + etoiles + "]";
	}
	
	

	
	
	
}
