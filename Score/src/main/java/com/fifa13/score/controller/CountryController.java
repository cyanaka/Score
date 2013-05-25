/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fifa13.score.controller;

import com.fifa13.score.entity.Country;
import com.fifa13.score.facade.FacadeCountry;
import java.util.List;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author P9908343
 */
@Component (value = "countryController")
@ViewScoped
public class CountryController {
    
    private Country auxiliary;
    @Autowired
    private FacadeCountry facade;
    
    
    public CountryController(){
        this.auxiliary = new Country();
    }

    public Country getAuxiliary() {
        return auxiliary;
    }

    public void setAuxiliary(Country auxiliary) {
        this.auxiliary = auxiliary;
    }
    
    public String preparedNewCountry(){
        this.auxiliary = new Country();
        return "./editCountry.xhtml?faces-redirect=true";
    }
    
    public String preparedEditCountry(Country c){
        this.auxiliary = c;
        return "./editCountry.xhtml?faces-redirect=true";
    }
    
    public String delete(Country c){
        facade.delete(c);
        return "./listCountry.xhmtl?faces-redirect=true";
    }
    
    public String confirm(){
        facade.save(auxiliary);
        return "./listCountry.xhmtl?faces-redirect=true";
    }
    
    public List<Country> getCountries(){
        return facade.getCountries();
    }
    
    
    
    
}
