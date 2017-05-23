package DataAccess;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import java.util.Arrays;

public class DBconnectorMongo {
    
//    public MongoClient client;
//    public MongoDatabase database;
//    public MongoCollection<Document> collection;
//
//    public void initiate() {
//        client = new MongoClient("localhost", 27017);
//        database = client.getDatabase("dbbooks");
//        collection = database.getCollection("books");
//    }
    
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    private static String dbName = "dbbooks";
    private static String username = "user";
    private static String password = "pass";

    private static String host = "localhost";
    private static int port = 27017;

    private DBconnectorMongo() {
        mongoClient = initializeClient();
    }

    public static synchronized MongoDatabase getDBConnection() {
        if (database == null) {
            database = initializeClient().getDatabase(dbName);
        }
        return database;
    }

    private static MongoClient initializeClient() {
        MongoCredential credential = MongoCredential.createCredential(username, dbName, password.toCharArray());
        return new MongoClient(new ServerAddress(host,port), Arrays.asList(credential));
    }

}
