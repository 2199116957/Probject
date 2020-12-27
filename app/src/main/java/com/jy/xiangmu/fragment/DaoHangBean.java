package com.jy.xiangmu.fragment;

public class DaoHangBean {
    private int Images;
    private String desc;

    public DaoHangBean(int images, String desc) {
        Images = images;
        this.desc = desc;
    }

    public int getImages() {
        return Images;
    }

    public void setImages(int images) {
        Images = images;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
