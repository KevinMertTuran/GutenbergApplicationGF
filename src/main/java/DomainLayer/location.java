/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainLayer;

/**
 *
 * @author mustafahakimi
 */
public class location {
    
    String UID;
    String latitude;
    String longitude;
    String name;

    public location(String UID, String latitude, String longitude, String name) {
        this.UID = UID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "location{" + "UID=" + UID + ", latitude=" + latitude + ", longitude=" + longitude + ", name=" + name + '}';
    }
    
    
}
