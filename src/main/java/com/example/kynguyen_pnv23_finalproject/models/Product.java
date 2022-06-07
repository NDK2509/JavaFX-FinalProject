package com.example.kynguyen_pnv23_finalproject.models;

import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class Product {
    private String id;
    private String name;
    private int price;
    private String img;
    private String type;
    private String color;

    private Specs specs = null;

    public Product(String id, String name, int price, String img, String type, String color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
        this.type = type;
        this.color = color;
    }

    public Product(String id, String name, int price, String img, String type, String color, Specs specs) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
        this.type = type;
        this.color = color;
        this.specs = specs;
    }

    public Product(String name, int price, String img, String type, String color, Specs specs) {
        this.name = name;
        this.price = price;
        this.img = img;
        this.type = type;
        this.color = color;
        this.specs = specs;
    }

    public String getId() {
        return id;
    }
    public Product setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }
    public int getPrice() {
        return price;
    }

    public Product setPrice(int price) {
        this.price = price;
        return this;
    }

    public String getImg() {
        return img;
    }

    public Product setImg(String img) {
        this.img = img;
        return this;
    }
    public String getType() {
        return type;
    }
    public Product setType(String type) {
        this.type = type;
        return this;
    }
    public String getColor() {
        return color;
    }
    public Product setColor(String color) {
        this.color = color;
        return this;
    }
    public Specs getSpecs() {
        return specs;
    }
    public Product setSpecs(Specs specs) {
        this.specs = specs;
        return this;
    }
    public String getInternalMemory() {return specs.internalMemory;}
    public String getRam() {
        return specs.ram;
    }
    public String getChargePort() {return specs.chargePort;}
    public String getSpecial() {return specs.special;}
    public Bson getUpdateBson() {
        return Updates.combine(
                Updates.set("name", name),
                Updates.set("price", price),
                Updates.set("img", img),
                Updates.set("type", type),
                Updates.set("color", color),
                Updates.set("specs.internalMemory", specs.internalMemory),
                Updates.set("specs.ram", specs.ram),
                Updates.set("specs.chargePort", specs.chargePort),
                Updates.set("specs.special", specs.special)
            );
    }
    public Document getMongoDocument() {
        return new Document()
            .append("name", name)
            .append("price", price)
            .append("img", img)
            .append("type", type)
            .append("color", color)
            .append("specs", new Document()
                .append("internalMemory", specs.internalMemory)
                .append("ram", specs.ram)
                .append("chargePort", specs.chargePort)
                .append("special", specs.special)
            );
    }
    public static class Specs {
        private String internalMemory;
        private String ram;
        private String chargePort;
        private String special;

        public Specs(String internalMemory, String ram, String chargePort, String special) {
            this.internalMemory = internalMemory;
            this.ram = ram;
            this.chargePort = chargePort;
            this.special = special;
        }

        public String getInternalMemory() {
            return internalMemory;
        }
        public Specs setInternalMemory(String internalMemory) {
            this.internalMemory = internalMemory;
            return this;
        }
        public String getRam() {
            return ram;
        }
        public Specs setRam(String ram) {
            this.ram = ram;
            return this;
        }
        public String getChargePort() {
            return chargePort;
        }
        public Specs setChargePort(String chargePort) {
            this.chargePort = chargePort;
            return this;
        }

        public String getSpecial() {
            return special;
        }

        public Specs setSpecial(String special) {
            this.special = special;
            return this;
        }
    }
}