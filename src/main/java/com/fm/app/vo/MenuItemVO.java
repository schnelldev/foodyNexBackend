package com.fm.app.vo;

import java.util.List;

public class MenuItemVO {
	String menuItemName;
	int clientId;
	int cuisineId;
	String imageUrl;
	boolean starter;
	boolean mainCourse;
	boolean dessert;
	boolean bread;
	boolean salad;
	boolean gravy;
	boolean veg;
	boolean nonveg;
	boolean vegan;
	boolean containsEgg;
	boolean asPerCatch;
	boolean hasNoVariant;
	List<MenuVariantVO> variants; 

	public String getMenuItemName() {
		return menuItemName;
	}

	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getCuisineId() {
		return cuisineId;
	}

	public void setCuisineId(int cuisineId) {
		this.cuisineId = cuisineId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isStarter() {
		return starter;
	}

	public void setStarter(boolean starter) {
		this.starter = starter;
	}

	public boolean isMainCourse() {
		return mainCourse;
	}

	public void setMainCourse(boolean mainCourse) {
		this.mainCourse = mainCourse;
	}

	public boolean isDessert() {
		return dessert;
	}

	public void setDessert(boolean dessert) {
		this.dessert = dessert;
	}

	public boolean isBread() {
		return bread;
	}

	public void setBread(boolean bread) {
		this.bread = bread;
	}

	public boolean isSalad() {
		return salad;
	}

	public void setSalad(boolean salad) {
		this.salad = salad;
	}

	public boolean isGravy() {
		return gravy;
	}

	public void setGravy(boolean gravy) {
		this.gravy = gravy;
	}

	public boolean isVeg() {
		return veg;
	}

	public void setVeg(boolean veg) {
		this.veg = veg;
	}

	public boolean isNonveg() {
		return nonveg;
	}

	public void setNonveg(boolean nonveg) {
		this.nonveg = nonveg;
	}

	public boolean isVegan() {
		return vegan;
	}

	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}

	public boolean isContainsEgg() {
		return containsEgg;
	}

	public void setContainsEgg(boolean containsEgg) {
		this.containsEgg = containsEgg;
	}

	public boolean isAsPerCatch() {
		return asPerCatch;
	}

	public void setAsPerCatch(boolean asPerCatch) {
		this.asPerCatch = asPerCatch;
	}

	public boolean isHasNoVariant() {
		return hasNoVariant;
	}

	public void setHasNoVariant(boolean hasNoVariant) {
		this.hasNoVariant = hasNoVariant;
	}

	public List<MenuVariantVO> getVariants() {
		return variants;
	}

	public void setVariants(List<MenuVariantVO> variants) {
		this.variants = variants;
	}

}
