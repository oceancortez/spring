package org.omc.controller;

import org.springframework.stereotype.Controller;

import javax.faces.bean.ManagedBean;


@ManagedBean
@Controller
public class HelloController {

    public String getHello() {
        return "Hello Ufa";
    }

    public String getBye() {
        return "Bye Ufa";
    }
}
