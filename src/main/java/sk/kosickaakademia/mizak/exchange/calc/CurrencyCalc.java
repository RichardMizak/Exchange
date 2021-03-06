package sk.kosickaakademia.mizak.exchange.calc;

import sk.kosickaakademia.mizak.exchange.api.Api;
import sk.kosickaakademia.mizak.exchange.database.Database;

import java.util.*;

public class CurrencyCalc {
    Database mongo=new Database();
    private static final String[] currency= new String[]{"USD","CZK","GBP","PLN","BTC"};
    //----------------------------------------------------------------------------------
    public void calculate(double eur){
        if(eur<0){
            System.out.println("Input number can't be a negative value!");
            return;
        }
        Set<String> set=new HashSet<>();
        Collections.addAll(set, currency);
        Api api=new Api();
        Map map=api.getExchange(set);
        for(String temp:currency){
            if(map.containsKey(temp)){
                double value=(double)map.get(temp);
                double result=eur*value;
                print("EUR",temp, eur, result, value);
            }
        }
    }
    //----------------------------------------------------------------------------------
    private void print(String from, String to, double eur, double result, double rate){
        System.out.println(eur +" "+from+" -> "+result+" "+to+" (exchange rate: "+rate+" )");
    }
    //-----------------------------------------------------------------------------------
    public Map<String, Double> calculate(double base_currency_eur, String[] currency) {
        if(base_currency_eur<0){
            System.out.println("Input number can't be a negative value!");
            return null;
        }
        mongo.insertExchangeHistory(base_currency_eur,currency);
        Set<String> set=new HashSet<>();
        Collections.addAll(set, currency);
        Api api=new Api();
        Map map=api.getExchange(set);
        Map<String,Double>values=new HashMap<>();
        for (Map.Entry<String, Double> entry : (Iterable<Map.Entry<String, Double>>) map.entrySet()) {
            values.put(entry.getKey(), entry.getValue() * base_currency_eur);
        }
        return values;
    }
}

