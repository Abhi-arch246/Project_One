package com.abhi.projectone;

public class Model {
    private String Title;
    private String Description;
    private String Image;

    public Model(){

    }


    public Model(String title, String description, String image) {
        Title = title;
        Description = description;
        Image = image;
    }

    public String getTitle() {
        return Title;
    }


    public String getDescription() {
        return Description;
    }


    public String getImage() {
        return Image;
    }

}
