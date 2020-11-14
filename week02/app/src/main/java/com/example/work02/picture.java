package com.example.work02;

public class picture {
    private String name;
    private  int imageId;
    public  picture(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public String getName(){
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}