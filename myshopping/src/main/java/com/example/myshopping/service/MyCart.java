package com.example.myshopping.service;

import com.example.myshopping.domain.Books;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// 表示我的购物车
public class MyCart {

    HashMap<String, Books> hm = new HashMap<>();

    // 添加书
    public void addBook(String id,Books book){

        if(hm.containsKey(id)){

            book = hm.get(id);
            int shoppingnum = book.getShoppingNum();
            book.setShoppingNum(++shoppingnum);
        }else{
            hm.put(id,book);
        }

    }

    // 添加书的第二种方法
    public void addBook2(String id){

        if(hm.containsKey(id)){
            Books book = hm.get(id);
            int shoppingnum = book.getShoppingNum();
            book.setShoppingNum(++shoppingnum);
        }else{
            hm.put(id, new BookService().getBookById(id));
        }

    }

    // 删除书
    public void delBook(String id){
        hm.remove(id);
    }

    //更新书(对于购物车的更新)
    public void updateBook(String id,int nums){
        Books book = hm.get(id);
        book.setShoppingNum(nums);
    }

    //显示该购物车中的所有商品信息
    public ArrayList<Books> showMyCart(){

        ArrayList<Books> al = new ArrayList<>();
        Iterator<String> it = hm.keySet().iterator();

        while(it.hasNext()){
            String id = it.next();
            Books book = hm.get(id);
            al.add(book);
        }

        return al;
    }

    //清空购物车
    public void clearBook(String id){
        hm.clear();
    }

    //返回该购物车的总价
    public float getTotalPrice(){
        float totalPrice = 0.0f;
        Iterator<String> it = hm.keySet().iterator();

        while(it.hasNext()){
            String id = it.next();
            Books book = hm.get(id);
            totalPrice += book.getPrice()*book.getShoppingNum();
        }

        return totalPrice;
    }

    //返回该购物车是否为空
    public Boolean IsEmpty() {
        System.out.println("判断购物车为空？");
        if (hm.isEmpty()){
            System.out.println("购物车为空");
            return true;
        }else {
            System.out.println("购物车为不为空");
            return false;
        }


    }

}
