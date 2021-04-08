package sk.kosickaakademia.mizak.exchange.calc;

import sk.kosickaakademia.mizak.exchange.api.Api;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CurrencyCalc {
    private static final String[] currency= new String[]{"USD","CZK","BTC","GBP","PLN"};
    //----------------------------------------------------------------------------------
    public void calculate(double eur){
        if(eur<0){
            System.out.println("Input number can't be a negative value!");
            return;
        }
        Set<String> set=new HashSet<>();
        Collections.addAll(set, currency);
        Api apiRequest=new Api();
        Map map=apiRequest.getExchange(set);
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
}

