package com.luiz.erp.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.luiz.erp.model.Usuario;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario = new Usuario();

    public String logar() {

        if(usuario.getLogin().equals("admin") && usuario.getSenha().equals("123")) {
            return "/pages/home.xhtml?faces-redirect=true";
        }

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login inválido", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);

        return null;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
