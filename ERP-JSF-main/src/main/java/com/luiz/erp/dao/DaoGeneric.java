package com.luiz.erp.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.luiz.erp.util.JPAUtil;

public class DaoGeneric<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Class<T> classe;

    public DaoGeneric(Class<T> classe) {
        this.classe = classe;
    }

    // SALVAR
    public void salvar(T entidade) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(entidade);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    // ATUALIZAR (merge)
    public T atualizar(T entidade) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        T atualizado;

        try {
            tx.begin();
            atualizado = em.merge(entidade);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }

        return atualizado;
    }

    // DELETAR
    public void deletar(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            T entidade = em.find(classe, id);
            if (entidade != null) {
                em.remove(entidade);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    // BUSCAR POR ID
    public T buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(classe, id);
        } finally {
            em.close();
        }
    }

    // LISTAR TODOS
    public List<T> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String jpql = "SELECT t FROM " + classe.getSimpleName() + " t";
            TypedQuery<T> q = em.createQuery(jpql, classe);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

}
