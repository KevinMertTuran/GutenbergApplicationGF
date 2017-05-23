
package DomainLayer;


public class author {
    
    String UID;
    String name;

    public author(String UID, String name) {
        this.UID = UID;
        this.name = name;
    }
    
    public author(){
        
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "author{" + "UID=" + UID + ", name=" + name + '}';
    }
    
    
}
