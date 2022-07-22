package com.example.myshopping.domain;


// javabean --> books表
public class Books {

    private int id;
    private String name;
    private String author;
    private String publishhouse;
    private float price;
    private int nums;  // 库存量
    private int shoppingNum = 1;  // 加入购物车的数量

    public int getShoppingNum() {
        return shoppingNum;
    }

    public void setShoppingNum(int shoppingNum) {
        this.shoppingNum = shoppingNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishhouse() {
        return publishhouse;
    }

    public void setPublishhouse(String publishhouse) {
        this.publishhouse = publishhouse;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }
}
