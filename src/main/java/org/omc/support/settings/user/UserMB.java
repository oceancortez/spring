package org.omc.support.settings.user;

import org.apache.log4j.Logger;
import org.omc.model.UserEntity;
import org.omc.model.utils.BaseBeans;
import org.omc.model.repositories.IUserRepository;
import org.omc.utils.controller.BaseController;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by ocean on 10/6/2015.
 */
@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value = "userMB")
public class UserMB extends BaseController {
    private static final Long serialVersionUID = 2121212L;
    private static final Logger LOGGER = Logger.getLogger(UserMB.class);

    @Inject
    private IUserRepository userRepository;

    private List<UserEntity> users;
    private Long id;
    private UserEntity selectUser;
    protected String messages;

    public void onLoad(){
    this.users = this.userRepository.findAll();
        if (messages != null){
            addMessage(messages);
        }
    }


    public void unselectUser(){
        this.selectUser = null;
    }

    public void selectUser(SelectEvent evt){
        try {
            if(evt.getObject() != null){
                this.selectUser = (UserEntity) evt.getObject();
            }else{
                this.selectUser = null;
            }
        }catch (Exception e){
            this.selectUser = null;
            LOGGER.error("Erro ao {selectUser}: " + e.getMessage(), e);
        }
    }

    public void delete(){
        if(this.selectUser != null){
            userRepository.delete(selectUser.getId());
            messages = "User '" + selectUser.getUsername() + "' excluded with Succsess!";
        }
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getSelectUser() {
        return selectUser;
    }

    public void setSelectUser(UserEntity selectUser) {
        this.selectUser = selectUser;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}
