package com.tansun.frame.ssm.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 *
 *
 * @author AIguibin
 * Date time 2019年05月21日 16:46:43
 */
public class BookEntity extends BaseRowModel {
    public final static String PATH="E:\\TanSunCode\\WorkBackEnd\\tansun-frameweb-ssm\\doc\\book.xlsx";

    @ExcelProperty(value = "编号" ,index = 0)
    private String bookId;
    @ExcelProperty(value = "书名" ,index = 1)
    private String title;
    @ExcelProperty(value = "作者" ,index = 2)
    private String author;
    @ExcelProperty(value = "发行时间" ,index = 3)
    private String publishTime;
    @ExcelProperty(value = "销售价格" ,index = 4)
    private String price;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
