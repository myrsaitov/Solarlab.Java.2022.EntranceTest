package com.myrsaitov;

import com.myrsaitov.nsmyinteface.MyInterface;
import com.myrsaitov.nsmylist.MyList;

import java.io.IOException;

public class Main {

    public static void main(String[] args){

        System.out.println("Hello Java!");

        MyInterface MI = new MyInterface();
        MyList ML = new MyList();

        try {
            MI.MainScreen(ML);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            MI.MyReadKey(ML);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}