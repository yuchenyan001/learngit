package com.main;

import java.io.File;


//截取文件的后缀名
public class SubStringTest {

    public static void main(String args[]) {
        File file = new File("HelloWorld.java");
        String fileName = file.getName();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        System.out.println(suffix);
    }

}
