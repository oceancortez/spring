package org.wpattern.entities;

import org.wpattern.utils.BaseBean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USUARIO")
public class Usuario extends BaseBean {

    @Id
    @GeneratedValue
    @Column(name = "ID_USUARIO", nullable = false)
    Long idUsuario;

    @Column(name = "NOM_USUARIO", nullable = false)
    String nomUsuario;

    @Column(name = "LOGIN_USUARIO",  nullable = false)
    String LoginUsuario;

    @Column(name = "EMAIL_USUARIO" ,  nullable = false)
    String EmailUsuario;

    @Column(name = "SENHA_USUARIO", nullable = false)
    String SenhaUsuario;

    @Column(name = "DT_CAD_USUARIO")
    Date dtCadUsuairo;

    @Column(name = "DT_ULT_ALT_USUARIO")
    Date dtUltAltUsuario;

    @Transient
    String sessionUsuario;

    @Transient
    String coockieUsuario;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getLoginUsuario() {
        return LoginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        LoginUsuario = loginUsuario;
    }

    public String getEmailUsuario() {
        return EmailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        EmailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return SenhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        SenhaUsuario = senhaUsuario;
    }

    public Date getDtCadUsuairo() {
        return dtCadUsuairo;
    }

    public void setDtCadUsuairo(Date dtCadUsuairo) {
        this.dtCadUsuairo = dtCadUsuairo;
    }

    public Date getDtUltAltUsuario() {
        return dtUltAltUsuario;
    }

    public void setDtUltAltUsuario(Date dtUltAltUsuario) {
        this.dtUltAltUsuario = dtUltAltUsuario;
    }

    public String getSessionUsuario() {
        return sessionUsuario;
    }

    public void setSessionUsuario(String sessionUsuario) {
        this.sessionUsuario = sessionUsuario;
    }

    public String getCoockieUsuario() {
        return coockieUsuario;
    }

    public void setCoockieUsuario(String coockieUsuario) {
        this.coockieUsuario = coockieUsuario;
    }




}
