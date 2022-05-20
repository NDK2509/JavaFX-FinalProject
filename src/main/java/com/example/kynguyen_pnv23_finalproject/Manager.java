package com.example.kynguyen_pnv23_finalproject;

import com.example.kynguyen_pnv23_finalproject.connectDB.MongoDBConnection;
import com.example.kynguyen_pnv23_finalproject.models.Admin;
import com.example.kynguyen_pnv23_finalproject.models.Product;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import static com.mongodb.client.model.Filters.*;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    public static final String PRODUCT_COLLECTION_NAME = "products";
    private final MongoDatabase mgDB = new MongoDBConnection().getDataBase();
    private static final String ADMIN_COLLECTION_NAME = "admins";
    public List<Admin> getAdminList() {
        var list = new ArrayList<Admin>();
        mgDB.getCollection(ADMIN_COLLECTION_NAME).find().forEach(doc ->
            list.add(new Admin(
                    doc.getString("userName"),
                    doc.getString("password")
            ))
        );
        return list;
    }
    public Admin getAdminByUserName(String userName) {
        var result = mgDB.getCollection(ADMIN_COLLECTION_NAME).find(eq("userName", userName)).first();
        return result == null ? null : new Admin(result.getString("userName"), result.getString("password"));
    }

    //---------------Product-------------------
    public List<Product> getProductList() {
        var list = new ArrayList<Product>();
        mgDB.getCollection(PRODUCT_COLLECTION_NAME).find().forEach(doc -> {
            var product = new Product(
                    doc.get("_id").toString(),
                    doc.getString("name"),
                    doc.getInteger("price"),
                    doc.getString("img"),
                    doc.getString("type"),
                    doc.getString("color")
            );
//            System.out.println(product.getId());
            var specsDoc = (Document)doc.get("specs");
            product.setSpecs(new Product.Specs(
                    specsDoc.getString("internalMemory"),
                    specsDoc.getString("RAM"),
                    specsDoc.getString("chargePort"),
                    specsDoc.getString("special")
            ));
            list.add(product);
            System.out.println(product.getSpecs().getRAM());
        });
        return list;
    }

}
