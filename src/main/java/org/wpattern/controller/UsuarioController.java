package org.wpattern.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.wpattern.bo.UsuarioBo;
import org.wpattern.entities.Usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by ocean on 9/20/2015.
 */
@ManagedBean
@SessionScoped
public class UsuarioController {

    @Autowired
    UsuarioBo usuarioBo;
    private static final Logger LOOGER = Logger.getLogger(UsuarioController.class);

    private boolean loggedIn;
    //Armazena o usuário logado
    private Usuario usuarioLogado;
    //Email e senha digitado pelo usuário na página XHTML
    private String email, senha;

    //Realiza o login caso de tudo certo
    public String doLogin() {
        Usuario usuarioFound = (Usuario) usuarioBo.isUsuarioReadyToLogin(email, senha);
        //Caso não tenha retornado nenhum usuario, então mostramos um erro //e redirecionamos ele para a página login.xhtml //para ele realiza-lo novamente
        if (usuarioFound == null) {
            //addErrorMessage("Email ou Senha errado, tente novamente !");
            FacesContext.getCurrentInstance().validationFailed();
            return "/login/login.xhtml?faces-redirect=true";
        } else
            //caso tenha retornado um usuario, setamos a variável loggedIn //como true e guardamos o usuario encontrado na variável //usuarioLogado. Depois de tudo, mandamos o usuário //para a página index.xhtml
            loggedIn = true;
        usuarioLogado = usuarioFound;
        return "/restricted/index.xhtml?faces-redirect=true";

    }

    //Realiza o logout do usuário logado

    public String doLogout() {
        //Setamos a variável usuarioLogado como nulo, ou seja, limpamos //os dados do usuário que estava logado e depois setamos a variável
        // loggedIn como false para sinalizar que o usuário não está mais //
       // logado usuarioLogado = null;
        loggedIn = false;
        //Mostramos um mensagem ao usuário e redirecionamos ele para a //página de login
        //addInfoMessage("Logout realizado com sucesso !");
        return "/login/login.xhtml?faces-redirect=true";
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
