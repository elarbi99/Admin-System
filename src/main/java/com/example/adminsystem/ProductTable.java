package com.example.adminsystem;

import javafx.beans.property.SimpleStringProperty;

public class ProductTable {
    private SimpleStringProperty id;
    private SimpleStringProperty item;
    private  SimpleStringProperty price;
    private  SimpleStringProperty onHand;
    private  SimpleStringProperty description;
    public ProductTable( String id,String item,String price,String onHand,String description)
    {
        this.id=new SimpleStringProperty(id);
        this.item=new SimpleStringProperty(item);
        this.price=new SimpleStringProperty(price);
        this.onHand=new SimpleStringProperty(onHand);
        this.description=new SimpleStringProperty(description);
    }
    public String getId() {
        return id.get();
    }
    public String getOnHand() {
        return onHand.get();
    }

    public SimpleStringProperty onHandProperty() {
        return onHand;
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }


    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getItem() {
        return item.get();
    }

    public SimpleStringProperty itemProperty() {
        return item;
    }

    public void setItem(String item) {
        this.item.set(item);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }
    public void setIds(String id){this.id.set(id);}
}
