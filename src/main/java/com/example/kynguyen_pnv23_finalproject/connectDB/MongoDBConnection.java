package com.example.kynguyen_pnv23_finalproject.connectDB;

import com.mongodb.client.*;
import com.mongodb.*;
import com.mongodb.client.MongoClient;
public class MongoDBConnection {
    private MongoDatabase db;
    public MongoDBConnection() {
        try {
            ConnectionString connectionString = new ConnectionString("mongodb+srv://ndkdev:ndk2509@ndk.ps3ya.mongodb.net/?retryWrites=true&w=majority");
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connectionString)
                    .serverApi(ServerApi.builder()
                            .version(ServerApiVersion.V1)
                            .build())
                    .build();
            MongoClient mongoClient = MongoClients.create(settings);
            db = mongoClient.getDatabase("JavaFX");
            System.out.println("MongoDB: Successfully!!!");
        } catch (MongoClientException e) {
            System.out.println("Can't connect MongoDB: " + e.getMessage());
        }
    }
    public MongoDatabase getDataBase() {
        return db;
    }
}
