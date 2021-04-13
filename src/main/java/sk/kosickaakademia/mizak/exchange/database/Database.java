package sk.kosickaakademia.mizak.exchange.database;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.MongoClient;


public class Database {
    private static final MongoClient mongoClient = new MongoClient();
    private static MongoDatabase database;
    private static Document docs;


    public void insertExchangeHistory(){

    }
}