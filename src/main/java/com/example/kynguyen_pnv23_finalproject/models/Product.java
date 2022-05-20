package com.example.kynguyen_pnv23_finalproject.models;

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
        public void setInternalMemory(String internalMemory) {
            this.internalMemory = internalMemory;
        }
        public String getRAM() {
            return RAM;
        }
        public void setRAM(String RAM) {
            this.RAM = RAM;
        }
        public String getChargePort() {
            return chargePort;
        }
        public void setChargePort(String chargePort) {
            this.chargePort = chargePort;
        }

        public String getSpacial() {
            return spacial;
        }

        public void setSpacial(String spacial) {
            this.spacial = spacial;
        }
    }
}