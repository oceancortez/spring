package org.omc.controller;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.WebAttributes;
import org.springframework.web.context.WebApplicationContext;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by ocean on 10/11/2015.
 */
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Named(value = "loginController")
public class LoginController implements PhaseListener {

    protected static final Logger LOGGER = Logger.getLogger(LoginController.class);


    public String doLogin() throws ServletException, IOException{
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
                .getRequestDispatcher("/j_spring_security_check");

        dispatcher.forward((ServletRequest) context.getRequest(),
                (ServletResponse) context.getResponse());

        FacesContext.getCurrentInstance().responseComplete();

        return null;
    }

    @Override
    public void afterPhase(PhaseEvent phaseEvent) {

    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {

        Exception e = (Exception) FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get(WebAttributes.AUTHENTICATION_EXCEPTION);

        if (e instanceof BadCredentialsException) {
            LOGGER.debug("Found exception in session map: "+e);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(
                    WebAttributes.AUTHENTICATION_EXCEPTION, null);

            String errorMessage = FacesContext.getCurrentInstance().getApplication().
            getResourceBundle(FacesContext.getCurrentInstance(),"messages").
            getString("message_missing");


            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Username or password not valid.", "Username or password not valid"));
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }
}
