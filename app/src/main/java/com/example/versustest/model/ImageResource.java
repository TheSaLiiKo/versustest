package com.example.versustest.model;

import java.io.Serializable;

// реализует интерфейс Serializable, важно отправить объект руководства другому действию

public class ImageResource implements Serializable{

    private String imgResource, base, description;
    private int drawableResource; // это для целей тестирования...

    public ImageResource(String title) {

    }

    public ImageResource(int drawableResource) {
        this.drawableResource = drawableResource;
    }

    public ImageResource(String description, String imgResource, String base, int drawableResource) {
        this.description = description;
        this.imgResource = imgResource;
        this.base = base;
        this.drawableResource = drawableResource;
    }

    public String getImgResource() {
        return imgResource;
    }

    public void setImgResource(String imgResource) {
        this.imgResource = imgResource;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDrawableResource() {
        return drawableResource;
    }

    public void setDrawableResource(int drawableResource) {
        this.drawableResource = drawableResource;
    }
}

