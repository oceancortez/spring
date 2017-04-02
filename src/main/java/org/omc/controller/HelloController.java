package org.omc.controller;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class HelloController {

    public String getHello(){
        return "Hello Ufa";
    }

    public String getBye(){
        return "Bye Ufa";
    }
}
