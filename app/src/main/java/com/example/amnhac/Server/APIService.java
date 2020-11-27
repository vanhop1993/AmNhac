package com.example.amnhac.Server;

public class APIService {

    private static String base_url = "https://vanhop.000webhostapp.com/Server/";

    public static Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
