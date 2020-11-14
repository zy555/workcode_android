package com.example.work02;

public class activity {
        private String name;
        private  int imageId;
        public  activity(String name,int imageId){
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

