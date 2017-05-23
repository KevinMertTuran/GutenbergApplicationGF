/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DomainLayer.Controller;
import DomainLayer.author;
import DomainLayer.location;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Collection;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author mustafahakimi
 */
@Path("location")
public class locationREST {

    @Context
    private UriInfo context;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Controller c = new Controller();

    /**
     * Creates a new instance of bookREST
     */
    public locationREST() {
    }
    
    
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @Path("{id}")
    public String getLocation(@PathParam("id") String id) {
        return gson.toJson(c.getLocation(id));
    }
    
    @GET
    @Produces("application/json")
    public String getAllLocations(){
        Collection<location> locations = c.getAllLocations();
        JsonArray json = new JsonArray();
        for(location l : locations){
            JsonObject jo = new JsonObject();
            jo.addProperty("UID", l.getUID());
            jo.addProperty("latitude", l.getLatitude());
            jo.addProperty("longitude", l.getLongitude());
            jo.addProperty("name", l.getName());
            json.add(jo);
        }
        String jsonStr = gson.toJson(json);
        return jsonStr;
    }
}
