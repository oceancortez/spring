package org.omc.support.exception;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class IndexExceptionBean {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String navigate(){
        System.out.println(10/0);
        return "anonymousView";
    }
}
