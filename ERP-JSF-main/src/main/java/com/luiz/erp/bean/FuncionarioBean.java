package com.luiz.erp.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.luiz.erp.model.Funcionario;
import com.luiz.erp.service.FuncionarioService;
/*
 * Usuário preenche o formulário na tela (funcionario.xhtml);

	Clica em “Salvar” → chama #{funcionarioBean.salvar};

	O FuncionarioBean recebe o objeto e chama service.salvar(funcionario);

	O FuncionarioService abre uma transação JPA e insere o registro no banco;

	Após sucesso, o Bean atualiza a lista e limpa o formulário.
 */

@Named("funcionarioBean")       // nome usado na view: #{funcionarioBean}
@ViewScoped                     // mantém os dados enquanto o usuário estiver na mesma página
public class FuncionarioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Funcionario funcionario;           // usado no formulário de cadastro
    private List<Funcionario> funcionarios;    // lista mostrada na tabela


    private FuncionarioService service = new FuncionarioService();

    // Inicializa dados quando a tela é carregada
    @PostConstruct
    public void init() {
        funcionario = new Funcionario();
        funcionarios = service.listar(); // carrega todos os funcionários do banco
    }

    // Salvar novo funcionário
    public void salvar() {
        try {
            service.salvar(funcionario);
            funcionario = new Funcionario();   // limpa o formulário
            funcionarios = service.listar();   // atualiza a lista
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Excluir funcionário
    public void excluir(Long id) {
        try {
            service.excluir(id);
            funcionarios = service.listar();
        } catch (Exception e) {
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
