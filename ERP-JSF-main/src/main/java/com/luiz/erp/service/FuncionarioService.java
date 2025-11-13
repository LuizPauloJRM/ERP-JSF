package com.luiz.erp.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.luiz.erp.model.Funcionario;
//Get vai iniciar minha transação
//em persistence (funcionario) -> Referencia minhas configurações gerenciamento no persistence
//get transation confirma minha transação ao efetivar envia ao banco 
// DAO = Data Access Object
// Responsável pela comunicação entre a aplicação e o banco de dados
public class FuncionarioService {

    // EntityManagerFactory é a "fábrica" de conexões com o banco
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("luiz");

    // Método para salvar (inserir) um funcionário no banco
    //em.merge(funcionario) sincroniza obj funcionario  com registro no banco
    //em. Uma abreviação para o entity manager
    /*
	 * em.persist(): Inserir um novo registro. em.find(): Buscar um registro pelo
	 * ID. em.merge(): Atualizar um registro. em.remove(): Excluir um registro.
	 * 
	 */
    public void salvar(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin(); // inicia transação
            em.persist(funcionario); // insere o funcionário no banco
            em.getTransaction().commit(); // confirma a transação
        } catch (Exception e) {
            em.getTransaction().rollback(); // desfaz em caso de erro
            e.printStackTrace();
        } finally {
            em.close(); 
        }
    }
    //rollback caso ocorra erro transação é desfeita
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

    // Método para excluir um funcionário
    public void excluir(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Funcionario funcionario = em.find(Funcionario.class, id);
            if (funcionario != null) {
                em.getTransaction().begin();
                em.remove(funcionario);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
