package com.jy.xiangmu.fragment;

class DaoHangBean {
    private String Images;
    private String desc;

    public DaoHangBean(String images, String desc) {
        Images = images;
        this.desc = desc;
    }

    public String getImages() {
        return Images;
    }

    public void setImages(String images) {
        Images = images;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
