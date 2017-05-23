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
public class book {
    
    String UID;
    String title;
    String text;

    public book(String UID, String title, String text) {
        this.UID = UID;
        this.title = title;
        this.text = text;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "book{" + "UID=" + UID + ", title=" + title + ", text=" + text + '}';
    }
    
    
}
