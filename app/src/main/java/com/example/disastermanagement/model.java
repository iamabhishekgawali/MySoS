package com.example.disastermanagement;

public class model {


    String name,value,desp;

    public  model()
    {

    }

    public model(String name, String value, String desp) {
        this.name = name;
        this.value = value;
        this.desp = desp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }
}
