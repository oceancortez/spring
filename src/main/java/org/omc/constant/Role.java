package org.omc.constant;

/**
 * Created by ocortez on 10/29/2015.
 */
public enum Role {

    ROLE_USER("ROLE_USER"),
    RULE_ADMIN("RULE_ADMIN");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return role;
    }
}
