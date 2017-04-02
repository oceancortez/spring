package br.com.oxi.laicnanifnalpym.utils;

public enum Route {
	

	BUILD("laicnanifnalpym/build"),
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
