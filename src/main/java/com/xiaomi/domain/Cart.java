package com.xiaomi.domain;

/**
 * Created by Li Enzhen
 * CREATE TABLE `tb_cart` (
 * `id` int(11) NOT NULL,
 * `pid` int(11) NOT NULL DEFAULT '0',
 * `Num` int(11) DEFAULT NULL,
 * `money` int(11) DEFAULT NULL,
 * PRIMARY KEY (`id`,`pid`),
 * KEY `fk_cart_pid` (`pid`),
 * CONSTRAINT `fk_cart_id` FOREIGN KEY (`id`) REFERENCES `tb_user` (`id`),
 * CONSTRAINT `fk_cart_pid` FOREIGN KEY (`pid`) REFERENCES `tb_goods` (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8
 */
public class Cart {
    private Integer id;
    private Integer pid;
    private Integer num;
    private Double moeny;

    public Cart(Integer id, Integer pid, Integer num, Double moeny) {
        this.id = id;
        this.pid = pid;
        this.num = num;
        this.moeny = moeny;
    }

    public Cart() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getMoeny() {
        return moeny;
    }

    public void setMoeny(Double moeny) {
        this.moeny = moeny;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", pid=" + pid +
                ", num=" + num +
                ", moeny=" + moeny +
                '}';
    }
}
