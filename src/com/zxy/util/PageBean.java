package com.zxy.util;

import java.util.List;

/**
 * @Company: 宝鸡大学
 * @author: 大宝
 * @date: 2021/3/7
 * @time: 21:05
 */
public class PageBean<B> {
    private int totalRows;//总记录数
    private int pageCount;//总页数
    private int curPage;//当前页
    private int rowsPageCount=5;//每页记录数
    private List<B> list;//每页记录
    private int start;
    private int end;

    public void page(){
        if(totalRows%rowsPageCount==0){
            pageCount=totalRows/rowsPageCount;
        }else {
            pageCount=totalRows/rowsPageCount+1;
        }
        start=(curPage-1)*rowsPageCount;
        end=start+rowsPageCount;
    }
    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getRowsPageCount() {
        return rowsPageCount;
    }

    public void setRowsPageCount(int rowsPageCount) {
        this.rowsPageCount = rowsPageCount;
    }

    public List<B> getList() {
        return list;
    }

    public void setList(List<B> list) {
        this.list = list;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalRows=" + totalRows +
                ", pageCount=" + pageCount +
                ", curPage=" + curPage +
                ", rowsPageCount=" + rowsPageCount +
                ", list=" + list +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
