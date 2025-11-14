package com.luiz.erp.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.luiz.erp.model.Empresa;
import com.luiz.erp.model.Funcionario;

// DAO = Data Access Object
// Responsável pela comunicação entre a aplicação e o banco de dados
public class FuncionarioService {

    // EntityManagerFactory é a "fábrica" de conexões com o banco
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("luiz");

 // Método para salvar ou atualizar um funcionário no banco
    public void salvar(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin(); // inicia a transação

            // Verifica se o funcionário está associado a uma empresa
            if (funcionario.getEmpresa() != null && funcionario.getEmpresa().getId() != null) {
                // Busca a empresa gerenciada no banco
                Empresa empresaManaged = em.find(Empresa.class, funcionario.getEmpresa().getId());
                if (empresaManaged == null) {
                    throw new IllegalArgumentException("Empresa não encontrada com ID: " + funcionario.getEmpresa().getId());
                }
                funcionario.setEmpresa(empresaManaged); // associa a empresa gerenciada
            }

            // merge cuida de inserir ou atualizar dependendo do estado da entidade
            em.merge(funcionario);

            em.getTransaction().commit(); // confirma a transação
        } catch (Exception e) {
            em.getTransaction().rollback(); // desfaz a transação em caso de erro
            e.printStackTrace();
        } finally {
            em.close(); // fecha o EntityManager
        }
    }

    //Método para atualizar um funcionário existente
    public void atualizar(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(funcionario); // atualiza os dados do funcionário
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    //Método para listar todos os funcionários
    public List<Funcionario> listar() {
        EntityManager em = emf.createEntityManager();
        List<Funcionario> funcionarios = null;
        try {
            funcionarios = em.createQuery("FROM Funcionario", Funcionario.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return funcionarios;
    }

    // Método para buscar um funcionário pelo ID
    public Funcionario buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Funcionario funcionario = null;
        try {
            funcionario = em.find(Funcionario.class, id); // busca pela chave primária
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return funcionario;
    }

   
 // Método para excluir um funcionário pelo ID
    public void excluir(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction(); // pega a transação
        try {
            tx.begin(); // inicia a transação
            
            // Busca o funcionário gerenciado
            Funcionario funcionario = em.find(Funcionario.class, id);
            if (funcionario != null) {
                em.remove(funcionario); // remove a entidade gerenciada
            } else {
                System.out.println("Funcionário não encontrado com ID: " + id);
            }

            tx.commit(); // confirma a exclusão
        } catch (Exception e) {
            if (tx.isActive()) { // garante que a transação só será revertida se estiver ativa
                tx.rollback(); 
            }
            e.printStackTrace();
        } finally {
            em.close(); // fecha EntityManager
        }
    }
}
