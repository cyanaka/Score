/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fifa13.score.controller;

import com.fifa13.score.entity.Country;
import com.fifa13.score.entity.Team;
import com.fifa13.score.facade.FacadeCountry;
import com.fifa13.score.facade.FacadeTeam;
import java.util.List;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author P9908343
 */
@Component (value = "teamController")
@ViewScoped
public class TeamController {
    
    private Team auxiliary;
    private Long idCountry;
    @Autowired
    private FacadeTeam facade;
    @Autowired
    private FacadeCountry facadeCountry;
    
    
    public TeamController(){
        this.auxiliary = new Team();
        this.idCountry = 0L;
    }

    public Team getAuxiliary() {
        return auxiliary;
    }

    public void setAuxiliary(Team auxiliary) {
        this.auxiliary = auxiliary;
    }
    
    public String preparedNewTeam(){
        this.auxiliary = new Team();
        return "./editTeam.xhtml?faces-redirect=true";
    }
    
    public String preparedEditTeam(Team t){
        this.auxiliary = t;
        return "./editTeam.xhtml?faces-redirect=true";
    }
    
    public String delete(Team p){
        facade.delete(p);
        return "./listTeam.xhmtl?faces-redirect=true";
    }
    
    public String confirm(){
        setCountryOnTeam();
        facade.save(auxiliary);
        return "./listTeam.xhmtl?faces-redirect=true";
    }
    
    public List<Team> getTeams(){
        return facade.getTeams();
    }
    
    public List<Country> getAllCountry(){
        return facadeCountry.getCountries();
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
    }

    private void setCountryOnTeam() {
        this.auxiliary.setCountry(facadeCountry.findCountry(idCountry));
    }
    
    
    
    
}
