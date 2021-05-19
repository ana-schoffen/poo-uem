package com.uem.clinica.dao;

import com.uem.clinica.entidades.Consulta;
import com.uem.clinica.entidades.Consulta;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class ConsultaDAO implements InterfaceDAO<Consulta> {
    private EntityManager em;

    public ConsultaDAO(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }

    @Override
    public ArrayList<Consulta> getEntidades() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Consulta> cq = cb.createQuery(Consulta.class);
        Root<Consulta> rootTable = cq.from(Consulta.class);
        CriteriaQuery<Consulta> all = cq.select(rootTable);
        
        TypedQuery<Consulta> allQuery = em.createQuery(all);
        
        return new ArrayList<>(allQuery.getResultList());
    }

    @Override
    public void adicionarEntidade(Consulta obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();    
    }

    @Override
    public Consulta buscarEntidade(int id) {
        return em.find(Consulta.class, id);
    }

    @Override
    public void removerEntidade(int id) {
        em.getTransaction().begin();
        Consulta p = em.find(Consulta.class, id);
        if (p != null) {
            em.remove(p);
        }
        em.getTransaction().commit();
    }
}
