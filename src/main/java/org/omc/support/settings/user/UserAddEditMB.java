package org.omc.support.settings.user;

import org.omc.model.UserEntity;
import org.omc.model.model.utils.BaseBeans;
import org.omc.model.repositories.IUserRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ResourceBundle;

/**
 * Created by ocean on 10/6/2015.
 */
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Named(value = "userAddEditMB")
public class UserAddEditMB extends BaseBeans {

    public static final long serialVersionUID = 1L;

    @Inject
    private FacesContext context;

    @Inject
    private IUserRepository userRepository;

    @Inject
    private UserMB mbUserBean;

    private UserEntity user;
    private String title;

    public UserAddEditMB() {
        this.user = new UserEntity();
    }

    public void add() {
        this.title = this.getResourcesProperty("labels", "user_add");
    }

    public void update() {
        this.title = this.getResourcesProperty("labels", "user_update");
        this.user = this.mbUserBean.getSelectUser();
    }

    public void save() {
        if(this.user != null){
            if(this.user.getId() == null){
                this.userRepository.save(this.user);
            }else{
                //Update
                this.userRepository.save(this.user);
            }
        }
    }

    public void cancel() {
    this.mbUserBean.unselectUser();
    }

    private String getResourcesProperty(String resource, String label) {
        Application application = this.context.getApplication();
        ResourceBundle bundle = application.getResourceBundle(this.context, resource);
        return bundle.getString(label);
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
