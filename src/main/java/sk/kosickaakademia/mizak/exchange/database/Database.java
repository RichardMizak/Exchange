package sk.kosickaakademia.mizak.exchange.database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.MongoClient;
import java.util.Arrays;
import java.util.Date;
import java.util.List;



public class Database {
    private static final MongoClient mongoClient = new MongoClient();
    private static MongoDatabase database;
    private static Document docs;
    private static MongoCollection<Document> collection;
    private Date date=new Date();
//---------------------------------------------------------------------------------------
    public void insertExchangeHistory(double value, String[] to){
        database=mongoClient.getDatabase("ExchangeDB");
        collection = database.getCollection("ExchangeHistory");
        List<String> list = Arrays.asList(to.clone());
        Document doc = new Document("date",date.toString())
                .append("value",value)
                .append("rates", list);
        collection.insertOne(doc);
    }
    //---------------------------------------------------------------------------------------
    public void test(){
        database=mongoClient.getDatabase("testDB");
        collection = database.getCollection("test");
        docs=new Document("name","riso")
                .append("ages","2");
        collection.insertOne(docs);
    }
}