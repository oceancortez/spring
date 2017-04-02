package org.omc.support.settings.user;

import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;
import org.omc.constant.AcaoE;
import org.omc.constant.Outcome;
import org.omc.factory.SendEmailFactory;
import org.omc.model.Acao;
import org.omc.model.Email;
import org.omc.model.UserEntity;
import org.omc.model.repositories.IUserRepository;
import org.omc.model.utils.BaseBeans;
import org.omc.rest.JSONTest;
import org.omc.utils.FacesMensage;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by ocean on 10/6/2015.
 */
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Named(value = "userAddEditMB")
public class UserAddEditMB extends BaseBeans {

    public static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(JSONTest.class);

    @Inject
    private FacesContext context;

    @Inject
    private IUserRepository userRepository;

    @Inject
    private UserMB mbUserBean;
    
    @Inject
    private SendEmailFactory sendEmailFactory;
    
    private Email emailInfo;

    private UserEntity user;
    private String title;
    private String messages;   
    
    private boolean acaoAdd;
    private boolean acaoUpdate;
    
    private Acao acao;
    private UserEntity userBackup;
    

    public UserAddEditMB() {
        this.user = new UserEntity();
        this.userBackup = new UserEntity();
        this.acao = new Acao();
        
        
    }

    public void add() {
        this.title = this.getResourcesProperty("labels", "user_add");
        this.acao.setAcaoE(AcaoE.ADD);        
        this.acaoAdd = acao.isAdd();
    }
   //TODO   - Terminar método de ação
    public void update() {
        this.title = this.getResourcesProperty("labels", "user_update");
        this.user = this.mbUserBean.getSelectUser();
        userBackup = user;
        this.acao.setAcaoE(AcaoE.UPDATE);
        this.acaoAdd = acao.isUpdate();
    }
    public void buildEmailToSend(UserEntity user, boolean add) {
    	emailInfo = new Email();
    	LOGGER.info("Início da intancia Email(): ");
        Map<String, String> mapUser = new HashMap<String, String>();
        mapUser.put("Nome do Usuário", user.getName());
        mapUser.put("Login do usuário", user.getUsername());
        mapUser.put("Role", user.getRole());
        if(add){
        emailInfo.setSubject("Novo Usuário");
        }else{
        	emailInfo.setSubject("Atualização do Usuário");	
        }
        emailInfo.setMsg("Novo Usuário: " + mapUser);
        sendEmailFactory.sendEmail(emailInfo);
        LOGGER.info("Início da chamanda [sendEmailFactory.sendEmail(emailInfo)] " + emailInfo);
	}

    public void save() {
        if(this.user != null && validaForm()){        	
            if(this.user.getId() == null){
            	LOGGER.info("Inserindo novo usuário: " + user);
                buildEmailToSend(user, true);
                this.userRepository.save(this.user);
                messages = "User '" + user.getUsername() + "' Add with Succsess!";
                mbUserBean.setMessages(messages);
                FacesMensage.redirect(Outcome.PAGES_USER_LIST.getOutcome());
                
            }else{
                //Update
            	LOGGER.info("Atualização do usuário: " + user);
            	buildEmailToSend(user, false);            	
                this.userRepository.save(this.user);
                messages = "User '" + user.getUsername() + "' Update with Succsess!";
                mbUserBean.setMessages(messages);
                FacesMensage.redirect(Outcome.PAGES_USER_LIST.getOutcome());
            }
        }
        FacesMensage.addMessageInfo(messages);
    }

    public boolean validaForm(){

        if(this.user.getUsername().equals("") && this.user.getName().equals("")){
            this.messages = "Favor preencher o formulário";
            return false;
        }
        if(this.user.getUsername().equals("")){
            this.messages = "O campo Nome não pode ser nulo";
            return false;

        }if(this.user.getName().equals("")){
            this.messages = "O campo Per Unit não pode ser nulo";
            return false;        
            
        }if(this.userBackup.getPassword() == null && 
        		!this.user.getPassword().equals(user.getConfirmPassword())){
        	this.messages = "As senhas não conferem, favor digitar novamente!";
            return false;               
        
            
        } if(this.userBackup.getPassword() != null 
        		&& this.user.getConfirmPassword().equals("") && !user.getPassword().equals("")){
        	this.messages = "O campo Password Password não pode ser nulo!";
            return true;
            
        } if(this.userBackup.getPassword() != null 
        		&& this.user.getPassword().equals("") && !user.getConfirmPassword().equals("")){
        	this.messages = "O campo Confirm Password não pode ser nulo!";
            return true;       
            
        } if(this.userBackup.getPassword() != null 
        		&& this.user.getPassword().equals("") || this.user.getConfirmPassword().equals("")){
        	this.user.setPassword(userBackup.getPassword());
            return true;
            
        }if(this.user.getRole() == null){
        	this.messages = "O campo Role é obrigatório!";
            return false;
        }
        return true;
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

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

	public Acao getAcao() {
		return acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
	}

	public boolean isAcaoAdd() {
		return acaoAdd;
	}

	public void setAcaoAdd(boolean acaoAdd) {
		this.acaoAdd = acaoAdd;
	}

	public boolean isAcaoUpdate() {
		return acaoUpdate;
	}

	public void setAcaoUpdate(boolean acaoUpdate) {
		this.acaoUpdate = acaoUpdate;
	}

	public UserEntity getUserBackup() {
		return userBackup;
	}

	public void setUserBackup(UserEntity userBackup) {
		this.userBackup = userBackup;
	}
	
	

	



    
}
