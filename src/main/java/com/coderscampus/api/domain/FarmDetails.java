package com.coderscampus.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class FarmDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long farm_details_id;
	private String farmName;
	// Meat
	private Boolean beef;
	private Boolean pork;
	private Boolean poultry;
	private Boolean mutton;
	// Veg
	private Boolean tomato;
	private Boolean carrot;
	private Boolean broccoli;
	private Boolean corn;
	// Fruits
	private Boolean blueberry;
	private Boolean strawberry;
	private Boolean apple;
	private Boolean pear;
	// Dairy
	private Boolean egg;
	private Boolean milk;
	private Boolean creams;
	private Boolean butter;
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "user_id")
	@MapsId
	private User user;

	private Long userIdFromFE;

	public Long getUserId() {
		return userIdFromFE;
	}

	public void setUserId(Long userId) {
		this.userIdFromFE = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public FarmDetails() {

	}

	public FarmDetails(String farmName, Boolean beef, Boolean pork, Boolean poultry, Boolean mutton, Boolean tomato,
			Boolean carrot, Boolean broccoli, Boolean corn, Boolean blueberry, Boolean strawberry, Boolean apple,
			Boolean pear, Boolean egg, Boolean milk, Boolean creams, Boolean butter) {
		super();
		this.farmName = farmName;
		this.beef = beef;
		this.pork = pork;
		this.poultry = poultry;
		this.mutton = mutton;
		this.tomato = tomato;
		this.carrot = carrot;
		this.broccoli = broccoli;
		this.corn = corn;
		this.blueberry = blueberry;
		this.strawberry = strawberry;
		this.apple = apple;
		this.pear = pear;
		this.egg = egg;
		this.milk = milk;
		this.creams = creams;
		this.butter = butter;
	}

	public Long getId() {
		return farm_details_id;
	}

	public void setId(Long id) {
		this.farm_details_id = id;
	}

	public String getFarmName() {
		return farmName;
	}

	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}

	public Boolean getBeef() {
		return beef;
	}

	public void setBeef(Boolean beef) {
		this.beef = beef;
	}

	public Boolean getPork() {
		return pork;
	}

	public void setPork(Boolean pork) {
		this.pork = pork;
	}

	public Boolean getPoultry() {
		return poultry;
	}

	public void setPoultry(Boolean poultry) {
		this.poultry = poultry;
	}

	public Boolean getMutton() {
		return mutton;
	}

	public void setMutton(Boolean mutton) {
		this.mutton = mutton;
	}

	public Boolean getTomato() {
		return tomato;
	}

	public void setTomato(Boolean tomato) {
		this.tomato = tomato;
	}

	public Boolean getCarrot() {
		return carrot;
	}

	public void setCarrot(Boolean carrot) {
		this.carrot = carrot;
	}

	public Boolean getBroccoli() {
		return broccoli;
	}

	public void setBroccoli(Boolean broccoli) {
		this.broccoli = broccoli;
	}

	public Boolean getCorn() {
		return corn;
	}

	public void setCorn(Boolean corn) {
		this.corn = corn;
	}

	public Boolean getBlueberry() {
		return blueberry;
	}

	public void setBlueberry(Boolean blueberry) {
		this.blueberry = blueberry;
	}

	public Boolean getStrawberry() {
		return strawberry;
	}

	public void setStrawberry(Boolean strawberry) {
		this.strawberry = strawberry;
	}

	public Boolean getApple() {
		return apple;
	}

	public void setApple(Boolean apple) {
		this.apple = apple;
	}

	public Boolean getPear() {
		return pear;
	}

	public void setPear(Boolean pear) {
		this.pear = pear;
	}

	public Boolean getEgg() {
		return egg;
	}

	public void setEgg(Boolean egg) {
		this.egg = egg;
	}

	public Boolean getMilk() {
		return milk;
	}

	public void setMilk(Boolean milk) {
		this.milk = milk;
	}

	public Boolean getCreams() {
		return creams;
	}

	public void setCreams(Boolean creams) {
		this.creams = creams;
	}

	public Boolean getButter() {
		return butter;
	}

	public void setButter(Boolean butter) {
		this.butter = butter;
	}

	public Long getUserIdFromFE() {
		return userIdFromFE;
	}

	public void setUserIdFromFE(Long userIdFromFE) {
		this.userIdFromFE = userIdFromFE;
	}

	@Override
	public String toString() {
		return "FarmDetails [farm_details_id=" + farm_details_id + ", farmName=" + farmName + ", beef=" + beef
				+ ", pork=" + pork + ", poultry=" + poultry + ", mutton=" + mutton + ", tomato=" + tomato + ", carrot="
				+ carrot + ", broccoli=" + broccoli + ", corn=" + corn + ", blueberry=" + blueberry + ", strawberry="
				+ strawberry + ", apple=" + apple + ", pear=" + pear + ", egg=" + egg + ", milk=" + milk + ", creams="
				+ creams + ", butter=" + butter + "]";
	}

//	

}
