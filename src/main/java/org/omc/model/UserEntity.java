package org.omc.model;

import org.omc.model.model.utils.BaseEntities;

import javax.persistence.*;

@Entity
@Table(name = "Users")
@AttributeOverride(name = "id", column = @Column(name = "UserId"))
public class UserEntity extends BaseEntities<Long> {

    private static final long serialVersionUID = 201404140102L;

    private String name;

    private String username;

    private String password;

    private String role;

    private String sessionId;

    public UserEntity() {
    }

    public UserEntity(String name, String username, String password, String role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Transient
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
