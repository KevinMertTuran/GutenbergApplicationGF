/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author mustafahakimi
 */
public class DTOLocation {
    
    private String UID;
    private String latitude;
    private String longitude;
    private String name;
    
    public DTOLocation(String name, String latitude, String longitude){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public DTOLocation(String name){
        this.name = name;
    }

    public String getUID() {
        return UID;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }
    
    
}
