package com.luiz.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.luiz.erp.model.Empresa;
import com.luiz.erp.repository.Empresas;
import com.luiz.erp.util.Transacional;

public class CadastroEmpresaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Empresas empresas;

    /*Transação*/
    @Transacional
    public void salvar(Empresa empresa) {
        empresas.guardar(empresa);
    }

    @Transacional
    public void excluir(Empresa empresa) {
        empresas.remover(empresa);
    }

}