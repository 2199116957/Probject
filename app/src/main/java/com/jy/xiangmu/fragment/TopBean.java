package com.jy.xiangmu.fragment;

public class TopBean {
    /**
     * id : 314
     * title : 关爱他成长的每一个足迹
     * content : <img src="//yanxuan.nosdn.127.net/75c55a13fde5eb2bc2dd6813b4c565cc.jpg">
     <img src="//yanxuan.nosdn.127.net/e27e1de2b271a28a21c10213b9df7e95.jpg">
     <img src="//yanxuan.nosdn.127.net/9d413d1d28f753cb19096b533d53418d.jpg">
     <img src="//yanxuan.nosdn.127.net/64b0f2f350969e9818a3b6c43c217325.jpg">
     <img src="//yanxuan.nosdn.127.net/a668e6ae7f1fa45565c1eac221787570.jpg">
     <img src="//yanxuan.nosdn.127.net/0d4004e19728f2707f08f4be79bbc774.jpg">
     <img src="//yanxuan.nosdn.127.net/79ee021bbe97de7ecda691de6787241f.jpg">
     * avatar : https://yanxuan.nosdn.127.net/14943186689221563.png
     * item_pic_url : https://yanxuan.nosdn.127.net/14943267735961674.jpg
     * subtitle : 专业运动品牌同厂，毛毛虫鞋买二送一
     * topic_category_id : 2
     * price_info : 0
     * read_count : 6.4k
     * scene_pic_url : https://yanxuan.nosdn.127.net/14943267735961674.jpg
     * topic_template_id : 0
     * topic_tag_id : 0
     * sort_order : 1
     * is_show : 1
     */

    private String title;
    private String item_pic_url;
    private String subtitle;

    public TopBean(String title, String item_pic_url, String subtitle) {
        this.title = title;
        this.item_pic_url = item_pic_url;
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getItem_pic_url() {
        return item_pic_url;
    }

    public void setItem_pic_url(String item_pic_url) {
        this.item_pic_url = item_pic_url;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}