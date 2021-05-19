package com.uem.clinica.dao;

import com.uem.clinica.entidades.Paciente;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class PacienteDAO implements InterfaceDAO<Paciente> {

    private EntityManager em;
    
    public PacienteDAO(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }

    @Override
    public ArrayList<Paciente> getEntidades() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Paciente> cq = cb.createQuery(Paciente.class);
        Root<Paciente> rootTable = cq.from(Paciente.class);
        CriteriaQuery<Paciente> all = cq.select(rootTable);
        
        TypedQuery<Paciente> allQuery = em.createQuery(all);
        
        return (ArrayList<Paciente>) allQuery.getResultList();
    }

    @Override
    public void adicionarEntidade(Paciente obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }

    @Override
    public Paciente buscarEntidade(int id) {
        return em.find(Paciente.class, id);
    }

    @Override
    public void removerEntidade(int id) {
        em.getTransaction().begin();
        Paciente p = em.find(Paciente.class, id);
        if (p != null) {
            em.remove(p);
        }
        em.getTransaction().commit();
    }
}
