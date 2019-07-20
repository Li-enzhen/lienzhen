package com.xiaomi.domain;

/**
 * Created by Li Enzhen
 * CREATE TABLE `tb_goods_type` (
 * `id` int(11) NOT NULL AUTO_INCREMENT,
 * `name` varchar(50) NOT NULL,
 * `level` int(11) DEFAULT NULL,
 * `Parent` int(11) DEFAULT NULL,
 * PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8
 */
public class GoodsType {
    private Integer id;
    private String name;
    private Integer level;
    private Integer parent;

    public GoodsType(Integer id, String name, Integer level, Integer parent) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.parent = parent;
    }

    public GoodsType() {

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", parent=" + parent +
                '}';
    }
}
