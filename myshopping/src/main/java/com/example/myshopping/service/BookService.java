package com.example.myshopping.service;


import com.example.myshopping.domain.Books;
import com.example.myshopping.util.DBUtil;
import com.example.myshopping.util.SqlHelper;

import java.sql.ResultSet;
import java.util.ArrayList;

// 处理和 books 表相关的业务逻辑
public class BookService {

    // 根据id取book
    public Books getBookById(String id){

        Books book = new Books();

        String sql = "select * from Books where id=?";
        String[] params = {id};
        ArrayList al = new SqlHelper().executeQuery(sql, params);
        if(al.size()==1){
            Object[] object = (Object[]) al.get(0);
            book.setId(Integer.parseInt(object[0].toString()));
            book.setName(object[1].toString());
            book.setAuthor(object[2].toString());
            book.setPublishhouse(object[3].toString());
            book.setPrice(Float.parseFloat(object[4].toString()));
            book.setNums(Integer.parseInt(object[5].toString()));
        }
        return book;
    }

    //得到所有的书籍信息
    public ArrayList<Books> getAllBook(){

        String sql = "select * from Books where 1=?";
        String[] params = {"1"};
        ArrayList al = new SqlHelper().executeQuery(sql, params);

        ArrayList<Books> newAL = new ArrayList<Books>();

        for(int i=0;i<al.size();i++){
            Object[] object = (Object[]) al.get(i);
            Books book = new Books();
            book.setId(Integer.parseInt(object[0].toString()));
            book.setName(object[1].toString());
            book.setAuthor(object[2].toString());
            book.setPublishhouse(object[3].toString());
            book.setPrice(Float.parseFloat(object[4].toString()));
            book.setNums(Integer.parseInt(object[5].toString()));
            newAL.add(book);
        }
        return newAL;

    }

}
