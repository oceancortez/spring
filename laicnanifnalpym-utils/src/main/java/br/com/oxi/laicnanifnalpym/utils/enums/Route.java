package br.com.oxi.laicnanifnalpym.utils.enums;

public enum Route {
	

	BUILD("laicnanifnalpym/build"),
	USER_CREATE("user/create"),
	USER_SIGN_IN("user/signIn"),
	USER_LOGIN("/login.jsp"),
	USER_SIGN_OUT("user/signOut"),
	USER_HOME("user/home"),
	USER_SIDEBAR("template/sidebar"),
	RECIPE_VIEW("recipe/view"),
	RECIPE("recipe"),
	RECIPE_TABLE("recipe/table"),
	RECIPE_CREATE("recipe/create"),
	RECIPE_UPDATE("recipe/update"),
	RECIPE_TYPE_CREATE("recipeType/create"),
	RECIPE_TYPE_UPDATE("recipeType/update"),
	CATEGORY_DETAIL("stok/category/detail"),
	CATEGORY_LIST("stok/category/list"),
	CATEGORY_SAVE("stok/category/save"),
	CATEGORY_UPDATE("stok/category/update"),
	ACCOUNT_CREATE("account/create");

    private String value;

    Route(String value) {
        this.value = value;
    }

    public String toString() {

        return this.value;
    }
}
