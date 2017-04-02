package org.oxi.springmvc.utils;

public enum Route {
	

	CATEGORY("stok/category/category"),
	CATEGORY_DETAIL("stok/category/detail"),
	CATEGORY_LIST("stok/category/list"),
	CATEGORY_SAVE("stok/category/save"),
	CATEGORY_UPDATE("stok/category/update");

    private String value;

    Route(String value) {
        this.value = value;
    }

    public String toString() {

        return this.value;
    }
}
