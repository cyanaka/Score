/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fifa13.score.controller;

import com.fifa13.score.entity.Player;
import com.fifa13.score.facade.FacadePlayer;
import java.util.List;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author P9908343
 */
@Component (value = "playerController")
@ViewScoped
public class PlayerController {
    
    private Player auxiliary;
    @Autowired
    private FacadePlayer facade;
    
    
    public PlayerController(){
        this.auxiliary = new Player();
    }

    public Player getAuxiliary() {
        return auxiliary;
    }

    public void setAuxiliary(Player auxiliary) {
        this.auxiliary = auxiliary;
    }
    
    public String preparedNewPlayer(){
        this.auxiliary = new Player();
        return "./editPlayer.xhtml?faces-redirect=true";
    }
    
    public String preparedEditPlayer(Player p){
        this.auxiliary = p;
        return "./editPlayer.xhtml?faces-redirect=true";
    }
    
    public String delete(Player p){
        facade.delete(p);
        return "./listPlayer.xhmtl?faces-redirect=true";
    }
    
    public String confirm(){
        facade.save(auxiliary);
        return "./listPlayer.xhmtl?faces-redirect=true";
    }
    
    public List<Player> getPlayers(){
        return facade.getPlayers();
    }
    
    
    
    
}
