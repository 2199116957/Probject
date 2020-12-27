package com.jy.xiangmu.fragment;

class LayLinBean {
    private int Image;
    private String title;
    private String name;
    private String Retail;

    public LayLinBean(int image, String title, String name, String retail) {
        Image = image;
        this.title = title;
        this.name = name;
        Retail = retail;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRetail() {
        return Retail;
    }

    public void setRetail(String retail) {
        Retail = retail;
    }
}
