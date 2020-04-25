package com.fm.app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MenuVariant extends MenuItem {

	public static final String SEQUENCE_NAME = "menu_variant_sequence";

	@Id
	int menuVariantId;
	String variantName;
	int price;
	boolean active;

	public int getMenuVariantId() {
		return menuVariantId;
	}

	public void setMenuVariantId(int menuVariantId) {
		this.menuVariantId = menuVariantId;
	}

	public String getVariantName() {
		return variantName;
	}

	public void setVariantName(String variantName) {
		this.variantName = variantName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
