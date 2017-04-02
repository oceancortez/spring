package org.omc.utils.controller;

import org.omc.model.utils.BaseBeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by ocean on 10/11/2015.
 */
public class BaseController extends BaseBeans implements Serializable{


    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void redirect(String url){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
            ec.redirect(ec.getRequestContextPath() + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
