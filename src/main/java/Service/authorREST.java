
package Service;

import DomainLayer.Controller;
import DomainLayer.author;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


@Path("author")
public class authorREST {

    @Context
    private UriInfo context;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Controller c = new Controller();

    private static final String SUCCESS_RESULT = "success";
    private static final String FAILURE_RESULT = "failure";

    public authorREST() {
    }

    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @Path("{id}")
    public String getAuthor(@PathParam("id") String id) {
        return gson.toJson(c.getAuthor(id));
    }

    @GET
    @Produces("application/json")
    public String getAllAuthors() {
        Collection<author> authors = c.getAllAuthors();
        JsonArray json = new JsonArray();
        for (author a : authors) {
            JsonObject jo = new JsonObject();
            jo.addProperty("UID", a.getUID());
            jo.addProperty("name", a.getName());
            json.add(jo);
        }
        String jsonStr = gson.toJson(json);
        return jsonStr;
    }

    @DELETE
    @Produces("application/json")
    @Consumes("application/json")
    @Path("{id}")
    public String deleteAuthorById(@PathParam("id") String id) {

        c.deleteAuthorById(id);
        if (id != null) {
            return gson.toJson(SUCCESS_RESULT);
        }
        return gson.toJson(FAILURE_RESULT);
    }
    
//    
//    @PUT
//    @Produces("application/json")
//    @Consumes("application/json")
//    @Path("{id}")
//    public String updateAuthorById(@PathParam("id") String id){
//        c.updateBookById(id, "new value");
//        if (id != null) {
//            return gson.toJson(SUCCESS_RESULT);
//        }
//        return gson.toJson(FAILURE_RESULT);
//    }
    

}
