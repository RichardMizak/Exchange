package sk.kosickaakademia.mizak.exchange.database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.MongoClient;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Database {
    private static final MongoClient mongoClient = new MongoClient();
    private static MongoDatabase database;
    private static Document docs;
    private static MongoCollection<Document> collection;
    private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public <T> void insertExchangeHistory(double value, String from, String to, T result){
        collection = database.getCollection("currency");
        JSONObject object = new JSONObject();
        object.put("value", value);
        object.put("from", from);
        object.put("to", to);
        object.put("result", result);
        object.put("datetime", date.format(new Date()));
        docs = Document.parse(object.toJSONString());
        collection.insertOne(docs);
    }
}