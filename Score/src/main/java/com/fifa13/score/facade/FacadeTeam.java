/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fifa13.score.facade;

import com.fifa13.score.entity.Team;
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
public class FacadeTeam {
    
    @PersistenceContext
    private EntityManager em;


    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Team p) {
        if (p.getId() != null){
            p = em.merge(p);
        }
        em.persist(p);
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Team p) {
        em.remove(em.merge(p));
    }

    public List<Team> getTeams() {
        return em.createQuery("SELECT p FROM Team p ORDER BY p.name").getResultList();
    }

    public List<Team> getTeams(Long idCountry) {
        return em.createQuery("SELECT t FROM Team t WHERE t.id = :idTeam").setParameter("idTeam", idCountry).getResultList();
    }

    public Team findTeam(Long idTeam) {
        return em.find(Team.class, idTeam);
    }
}
