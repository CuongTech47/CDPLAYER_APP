package com.example.btl_music4b.Service;

public class APIService {
    private static String base_url = "https://musicapp8247.000webhostapp.com//Server/";
    public static Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
