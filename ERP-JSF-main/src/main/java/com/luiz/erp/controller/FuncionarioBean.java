package com.luiz.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.luiz.erp.model.Funcionario;
import com.luiz.erp.service.FuncionarioService;

@Named("funcionariosBean")
@ViewScoped
public class FuncionarioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Funcionario funcionario;
    private List<Funcionario> funcionarios;

    private FuncionarioService funcionarioService = new FuncionarioService();

    @PostConstruct
    public void init() {
        funcionario = new Funcionario();
        funcionarios = funcionarioService.listar();
    }

    // 🔹 Método para salvar funcionário
    public void salvar() {
        try {
            funcionarioService.salvar(funcionario);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Funcionário salvo com sucesso!"));

            // Atualiza lista e limpa o form
            funcionarios = funcionarioService.listar();
            funcionario = new Funcionario();

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao salvar funcionário."));
            e.printStackTrace();
        }
    }

    // Getters e Setters
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
