package sk.kosickaakademia.mizak.exchange.api;



import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Api {
    private static final String Apikey="d9e277ac89a180d27ae66846733a6f64";

    public Map getExchange(Set<String> rate){
        if (rate==null||rate.size()==0)
        return null;
        return parseData(rate);
    }
    public String reqApi() {
        try {
            URL url = new URL("http://api.exchangeratesapi.io/v1/latest?access_key=" + Apikey);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responsecode = conn.getResponseCode();
            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                String inline="";
                Scanner scanner=new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    inline+=scanner.nextLine();
                }
                scanner.close();
                return inline;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
        private Map parseData (Set < String > rates) {
            String inline = reqApi();
            if (inline == null)
                return null;
            try {
                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(inline);
                JSONObject obj = (JSONObject) data_obj.get("rates");
                Map<String, Double> maps = new HashMap<>();
                for (String temp : rates) {
                    if (obj.containsKey(temp)) {
                        double value = (double) obj.get(temp);
                        maps.put(temp, value);
                    }
                }
                return maps;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return null;
        }
    }



