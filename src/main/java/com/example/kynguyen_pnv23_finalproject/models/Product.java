package com.example.kynguyen_pnv23_finalproject.models;

import com.mongodb.client.model.Updates;
import org.bson.conversions.Bson;

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
    public Bson getUpdateBson() {
        return Updates.combine(
                Updates.set("name", name),
                Updates.set("price", price),
                Updates.set("img", img),
                Updates.set("type", type),
                Updates.set("color", color)
            );
    }
    public static class Specs {
        private String internalMemory;
        private String RAM;
        private String chargePort;
        private String spacial;

        public Specs(String internalMemory, String RAM, String chargePort, String spacial) {
            this.internalMemory = internalMemory;
            this.RAM = RAM;
            this.chargePort = chargePort;
            this.spacial = spacial;
        }

        public String getInternalMemory() {
            return internalMemory;
        }
        public Specs setInternalMemory(String internalMemory) {
            this.internalMemory = internalMemory;
            return this;
        }
        public String getRAM() {
            return RAM;
        }
        public Specs setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }
        public String getChargePort() {
            return chargePort;
        }
        public Specs setChargePort(String chargePort) {
            this.chargePort = chargePort;
            return this;
        }

        public String getSpacial() {
            return spacial;
        }

        public Specs setSpacial(String spacial) {
            this.spacial = spacial;
            return this;
        }
    }
}