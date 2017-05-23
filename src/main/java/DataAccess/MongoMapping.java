package DataAccess;

import DTO.DTOAuthorBook;
import DTO.DTOLocation;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.bson.Document;

public class MongoMapping {

    private MongoDatabase connect = DBconnectorMongo.getDBConnection();

    private Block<Document> print() {
        return new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document.toJson());
            }
        };
    }

    public List<DTOAuthorBook> getBooksByCity(String location) {

        List<DTOAuthorBook> collection = new ArrayList<>();
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("dbbooks");

        MongoCollection<Document> col = database.getCollection("books");

        try (MongoCursor<Document> cur = col.find(eq("locations.name", location)).iterator()) {
            while (cur.hasNext()) {

                Document doc = cur.next();

                collection.add(new DTOAuthorBook(doc.getString("title")));
                System.out.println(doc.getString("title"));

            }
        }

        mongoClient.close();
        return collection;
    }

    public List<DTOAuthorBook> getBooksByAuthor(String author) {

        List<DTOAuthorBook> collection = new ArrayList();
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("dbbooks");

        MongoCollection<Document> col = database.getCollection("books");

        try (MongoCursor<Document> cur = col.find(eq("author.name", author)).iterator()) {
            while (cur.hasNext()) {

                Document doc = cur.next();

                ArrayList authorArr = (ArrayList) doc.get("author");
                Document authorDoc = (Document) authorArr.get(0);
                String _author = authorDoc.getString("name");
                String title = doc.getString("title");

                collection.add(new DTOAuthorBook(title, _author));

                System.out.println("author: " + _author + " title: " + title);

            }
        }

        mongoClient.close();
        return collection;
    }

    public List<DTOLocation> getLocationByTitle(String title) {

        List<DTOLocation> listLocations = new ArrayList<DTOLocation>();

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("dbbooks");

        MongoCollection<Document> col = database.getCollection("books");

        try (MongoCursor<Document> cur = col.find(eq("title", title)).iterator()) {
            while (cur.hasNext()) {

                Document doc = cur.next();

                ArrayList locationArr = (ArrayList) doc.get("locations");

                for (int i = 0; i < locationArr.size(); i++) {
                    Document locationDoc = (Document) locationArr.get(i);

                    listLocations.add(new DTOLocation(locationDoc.getString("name"), locationDoc.getString("latitude"), locationDoc.getString("longitude")));
                    System.out.println("locationname: " + doc.getString("name"));

                }

            }
        }

        mongoClient.close();
        return listLocations;

    }

}
