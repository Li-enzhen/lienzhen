package com.xiaomi.domain;

import java.util.List;

/**
 * Created by Li Enzhen
 * 2019/7/1 0001 下午 10:21
 */
public class PageBean<T> {
    //页码
    private int pageNum;
    //页大小
    private int pageSize;
    //总数据
    private long totalSize;
    //总页数
    private int pageCount;
    //数据
    private List<T> data;

    //开始页码
    private int startPage;

    //结束页码

    private int endPage;

    public PageBean(int pageNum, int pageSize, long totalSize, List<T> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.data = data;

        //计算pageCount
        this.pageCount = (int) (this.totalSize % this.pageSize == 0 ? this.totalSize / this.pageSize : this.totalSize / this.pageSize + 1);

        //设置开始页码和结束页码
        // (1)正常请求
        startPage = pageNum - 4;
        endPage = pageNum + 5;
        //(2) 小于等于5
        if (pageNum <= 5) {
            startPage = 1;
            endPage = 10;
        }
        //(3)大于pageCount-5;
        if (pageNum >= pageCount - 5) {
            startPage = pageCount - 9;
            endPage = pageCount;
        }
        //(4)总页数<10
        if (pageCount < 10) {
            startPage = 1;
            endPage = pageCount;
        }

    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }
}
