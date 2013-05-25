/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fifa13.score.facade;

import com.fifa13.score.entity.Country;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author P9908343
 */
@Service
public class FacadeCountry {
    
    @PersistenceContext
    private EntityManager em;


    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Country c) {
        if (c.getId() != null){
            c = em.merge(c);
        }
        em.persist(c);
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Country c) {
        em.remove(em.merge(c));
    }

    public List<Country> getCountries() {
        return em.createQuery("SELECT c FROM Country c ORDER BY c.name").getResultList();
    }

    public Country findCountry(Long idCountry) {
        return em.find(Country.class, idCountry);
    }
}
