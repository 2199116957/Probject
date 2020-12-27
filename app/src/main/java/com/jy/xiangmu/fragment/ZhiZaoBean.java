package com.jy.xiangmu.fragment;

class ZhiZaoBean {
    private int Image;
    private String title;
    private String title2;

    public ZhiZaoBean(int image, String title, String title2) {
        Image = image;
        this.title = title;
        this.title2 = title2;
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

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }
}
