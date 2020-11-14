package com.example.text_1;

public class Tao {
    private String name;
    private  int imageID;
    public  Tao(String name,int imageID){
        this.name=name;
        this.imageID=imageID;
    }
    public String getName(){

        return name;
    }

    public int getImageID(){
        return imageID;
    }
}