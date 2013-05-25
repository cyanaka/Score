/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fifa13.score.facade;

import com.fifa13.score.entity.Country;
import com.fifa13.score.entity.Game;
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
public class FacadeGame {
    
    @PersistenceContext
    private EntityManager em;


    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Game p) {
        if (p.getId() != null){
            p = em.merge(p);
        }
        em.persist(p);
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Game p) {
        em.remove(em.merge(p));
    }

    public List<Game> getGames() {
        return em.createQuery("SELECT p FROM Game p").getResultList();
    }
    
    public Country findCountry(Long idCountry){
        return em.find(Country.class, idCountry);
    }
}
