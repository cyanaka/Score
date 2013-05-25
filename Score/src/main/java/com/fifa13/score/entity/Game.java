/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fifa13.score.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author P9908343
 */
@Entity
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date gameDate;
    @ManyToOne
    private Player playerHome;
    @ManyToOne
    private Player playerAway;
    @ManyToOne
    private Team teamHome;
    @ManyToOne
    private Team teamAway;

    private Integer scoreHome;
    private Integer scoreAway;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    public Player getPlayerHome() {
        return playerHome;
    }

    public void setPlayerHome(Player playerHome) {
        this.playerHome = playerHome;
    }

    public Player getPlayerAway() {
        return playerAway;
    }

    public void setPlayerAway(Player playerAway) {
        this.playerAway = playerAway;
    }

    public Team getTeamHome() {
        return teamHome;
    }

    public void setTeamHome(Team teamHome) {
        this.teamHome = teamHome;
    }

    public Team getTeamAway() {
        return teamAway;
    }

    public void setTeamAway(Team teamAway) {
        this.teamAway = teamAway;
    }

    public Integer getScoreHome() {
        return scoreHome;
    }

    public void setScoreHome(Integer scoreHome) {
        this.scoreHome = scoreHome;
    }

    public Integer getScoreAway() {
        return scoreAway;
    }

    public void setScoreAway(Integer scoreAway) {
        this.scoreAway = scoreAway;
    }
    
    
    
}
