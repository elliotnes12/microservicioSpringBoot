package com.cloud.microservicio.repository;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository("ClienteRepositoryEntity")
public class ClienteMEntityImpl implements ClienteMEntity {

    private Log log = LogFactory.getLog(ClienteMEntityImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Cliente> findAll()
    {
        log.info("Clase :: ClienteRepositoryEntity");
        log.info(em.createQuery("from Cliente").getResultList().size());
        return em.createQuery("from Cliente").getResultList();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
         em.persist(cliente);
    }

    @Override
    @Transactional
    public Cliente findById(long id) {
        em.createQuery("SELECT c from Cliente where ")
        return em.find(Cliente.class,id);
    }
}
