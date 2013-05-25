/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fifa13.score.facade;

import com.fifa13.score.entity.Player;
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
public class FacadePlayer {
    
    @PersistenceContext
    private EntityManager em;


    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Player p) {
        if (p.getId() != null){
            p = em.merge(p);
        }
        em.persist(p);
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Player p) {
        em.remove(em.merge(p));
    }

    public List<Player> getPlayers() {
        return em.createQuery("SELECT p FROM Player p ORDER BY p.name").getResultList();
    }
}
