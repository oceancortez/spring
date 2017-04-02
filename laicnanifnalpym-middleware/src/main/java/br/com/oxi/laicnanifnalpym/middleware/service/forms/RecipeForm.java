package br.com.oxi.laicnanifnalpym.middleware.service.forms;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;

import br.com.oxi.laicnanifnalpym.repository.domain.AccountEntity;
import br.com.oxi.laicnanifnalpym.repository.domain.RecipeTypeEntity;
import br.com.oxi.laicnanifnalpym.utils.enums.RecipeStatus;

/***
 *
 * @author Ocean Cortez
 *
 */

public class RecipeForm implements Serializable {

    private static final long serialVersionUID = -4811644933092970338L;

    @FormParam("id")
    private Long id;

    @NotNull
    @FormParam("description")
    private String description;

    @NotNull
    @FormParam("idRecipeType")
    private Long idRecipeType;

    @NotNull
    @FormParam("idAccount")
    private Long idAccount;

    @FormParam("id_user")
    private Long idUser;

    @FormParam("value")
    @NotNull
    private Double value;

    @NotNull
    @FormParam("receivedStatus")
    private RecipeStatus recipeStatus;

    @NotNull
    @FormParam("creationDate")
    private Date creationDate;

    @FormParam("accounts")
    private Set<AccountEntity> accounts;

    @FormParam("recipesTypes")
    private Set<RecipeTypeEntity> recipeTypes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIdRecipeType() {
        return idRecipeType;
    }

    public void setIdRecipeType(Long idRecipeType) {
        this.idRecipeType = idRecipeType;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public RecipeStatus getRecipeStatus() {
        return recipeStatus;
    }

    public void setRecipeStatus(RecipeStatus recipeStatus) {
        this.recipeStatus = recipeStatus;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Set<AccountEntity> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<AccountEntity> accounts) {
        this.accounts = accounts;
    }

    public Set<RecipeTypeEntity> getRecipeTypes() {
        return recipeTypes;
    }

    public void setRecipeTypes(Set<RecipeTypeEntity> recipeTypes) {
        this.recipeTypes = recipeTypes;
    }

    @Override
    public String toString() {
        return "RecipeForm [id=" + id + ", description=" + description + ", idRecipeType=" + idRecipeType + ", idAccount=" + idAccount
                + ", idUser=" + idUser + ", value=" + value + ", recipeStatus=" + recipeStatus + ", creationDate=" + creationDate
                + ", accounts=" + accounts + ", recipeTypes=" + recipeTypes + "]";
    }

}
