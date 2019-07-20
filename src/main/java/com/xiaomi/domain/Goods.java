package com.xiaomi.domain;

import java.util.Date;

/**
 * Created by Li Enzhen
 * CREATE TABLE `tb_goods` (
 * `id` int(11) NOT NULL AUTO_INCREMENT,
 * `name` varchar(100) NOT NULL,
 * `pubdate` date DEFAULT NULL,
 * `picture` varchar(255) NOT NULL,
 * `price` int(11) NOT NULL,
 * `star` tinyint(4) NOT NULL DEFAULT '0',
 * `intro` text,
 * `typeid` int(11) NOT NULL,
 * PRIMARY KEY (`id`),
 * KEY `fk_typeid` (`typeid`),
 * CONSTRAINT `fk_typeid` FOREIGN KEY (`typeid`) REFERENCES `tb_goods_type` (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8
 */
public class Goods {
    private Integer id;
    private String name;
    private Date pubdate;
    private String picture;
    private double price;
    private Integer star;
    private String intro;
    private Integer typeid;

    public Goods(Integer id, String name, Date pubdate, String picture, double price, Integer star, String intro, Integer typeid) {
        this.id = id;
        this.name = name;
        this.pubdate = pubdate;
        this.picture = picture;
        this.price = price;
        this.star = star;
        this.intro = intro;
        this.typeid = typeid;
    }

    public Goods() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pubdate=" + pubdate +
                ", picture='" + picture + '\'' +
                ", price=" + price +
                ", star=" + star +
                ", intro='" + intro + '\'' +
                ", typeid=" + typeid +
                '}';
    }
}
