package com.xupt.Part01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//遍历所有文件，当遍历到文件是.java的时候，创建一个线程去查找这个文件的内容，不必等待这个线程结束，继续遍历下一个文件
public class Practice01 {
    public static void main(String[] args) {
        searchFolder("D:/target01","Magic");
    }
    private static void searchFolder(String path,String key){
        File f=new File(path);
        if(f.isFile()){
            if(f.getAbsolutePath().endsWith(".txt")){
                Thread th=new Thread(){
                    @Override
                    public void run(){
                        searchKey(f,key);
                    }
                };
                th.start();
            }
        }else{
            for(File t:f.listFiles()){
                searchFolder(t.getAbsolutePath(),key);
            }
        }
    }
    private static void searchKey(File f,String key){
        int n=-1;
        byte[] data=new byte[(int)f.length()];
        try(FileInputStream fis=new FileInputStream(f)){
            while((n=fis.read(data))!=-1){
                String s=new String(data);
                if(s.contains(key)){
                    System.out.println(f.getAbsolutePath());
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
