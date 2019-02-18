package com.bancolombia.homologador.persistencia.Persistencia;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonaDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Personas> getAll(){
        String hql = "FROM Personas";
        return  entityManager.createQuery(hql).getResultList();
    }
}
