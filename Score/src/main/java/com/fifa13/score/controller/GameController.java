/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fifa13.score.controller;

import com.fifa13.score.entity.Country;
import com.fifa13.score.entity.Game;
import com.fifa13.score.entity.Player;
import com.fifa13.score.entity.Team;
import com.fifa13.score.facade.FacadeCountry;
import com.fifa13.score.facade.FacadeGame;
import com.fifa13.score.facade.FacadePlayer;
import com.fifa13.score.facade.FacadeTeam;
import java.util.List;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author P9908343
 */
@Component (value = "gameController")
@ViewScoped
public class GameController {
    
    private Game auxiliary;
    
    private Long idPlayerHome;
    private Long idPlayerAway;
    
    private Long idTeamHome;
    private Long idTeamAway;
    
    private Long idCountry;
    private Country auxilaryCountry;
    
    private List<Team> selectTeam;
    
    @Autowired
    private FacadeGame facade;
    @Autowired
    private FacadePlayer facadePlayer;
    @Autowired
    private FacadeTeam facadeTeam;
    @Autowired
    private FacadeCountry facadeCountry;
    
    
    public GameController(){
        initializeAll();
    }

    public Game getAuxiliary() {
        return auxiliary;
    }

    public void setAuxiliary(Game auxiliary) {
        this.auxiliary = auxiliary;
    }
    
    public String preparedNewGame(){
        this.auxiliary = new Game();
        return "./editGame.xhtml?faces-redirect=true";
    }
    
    public String preparedEditGame(Game p){
        this.auxiliary = p;
        return "./editGame.xhtml?faces-redirect=true";
    }
    
    public String delete(Game p){
        facade.delete(p);
        return "./listGame.xhmtl?faces-redirect=true";
    }
    
    public String confirm(){
        updateAllValue();
        facade.save(this.auxiliary);
        return "./listGame.xhmtl?faces-redirect=true";
    }
    
    public void updateAllValue(){
        this.auxiliary.setPlayerHome(this.facadePlayer.findPlayer(this.idPlayerHome));
        this.auxiliary.setPlayerAway(this.facadePlayer.findPlayer(this.idPlayerAway));
        this.auxiliary.setTeamHome(this.facadeTeam.findTeam(this.idTeamHome));
        this.auxiliary.setTeamAway(this.facadeTeam.findTeam(this.idTeamAway));
    }
    
    public List<Game> getGames(){
        return facade.getGames();
    }
    
    public List<Player> getAllPlayers(){
        return facadePlayer.getPlayers();
    }

    public Long getIdPlayerHome() {
        return idPlayerHome;
    }

    public void setIdPlayerHome(Long idPlayerHome) {
        this.idPlayerHome = idPlayerHome;
    }

    public Long getIdPlayerAway() {
        return idPlayerAway;
    }

    public void setIdPlayerAway(Long idPlayerAway) {
        this.idPlayerAway = idPlayerAway;
    }

    public Long getIdTeamHome() {
        return idTeamHome;
    }

    public void setIdTeamHome(Long idTeamHome) {
        this.idTeamHome = idTeamHome;
    }

    public Long getIdTeamAway() {
        return idTeamAway;
    }

    public void setIdTeamAway(Long idTeamAway) {
        this.idTeamAway = idTeamAway;
    }

    public List<Team> getSelectTeam() {
        return selectTeam;
    }

    public Country getAuxilaryCountry() {
        return auxilaryCountry;
    }

    public void setAuxilaryCountry(Country auxilaryCountry) {
        this.auxilaryCountry = auxilaryCountry;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
    }
    
    public List<Country> getAllCountry(){
        return facadeCountry.getCountries();
    }
    
    public void refreshTeam(){
        this.auxilaryCountry = facadeCountry.findCountry(idCountry);
    }

    private void initializeAll() {
        this.auxiliary = new Game();
        this.auxilaryCountry = new Country();
    }
    
    
    
   
}
