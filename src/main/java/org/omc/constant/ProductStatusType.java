package org.omc.constant;

/**
 * Created by ocortez on 10/29/2015.
 */
public enum ProductStatusType {

    A("A"),
    I("I");

    private String value;

     ProductStatusType(String value) {
        this.value = value;
    }

    ProductStatusType() {

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
