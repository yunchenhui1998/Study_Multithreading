package com.xupt.Part02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Practice02 {
    static ThreadPoolExecutor threadPool=new ThreadPoolExecutor(10,15,60, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
    public static void main(String[] args) {
        searchFile("D:/target01","Magic");
    }
    private static void searchFile(String path,String key){
        File f=new File(path);
        if(!f.exists()){
            System.out.println("文件不存在");
            return;
        }
        if(f.isFile()&&f.getAbsolutePath().endsWith(".txt")){
            threadPool.execute(new SearchFile(f,key));
        }
        if(f.isDirectory()){
            File[] files=f.listFiles();
            if(files!=null){
                for(File file:files){
                    searchFile(file.getAbsolutePath(),key);
                }
            }
        }
    }
}
class SearchFile implements  Runnable{
    private File f;
    private String key;
    public SearchFile(File f,String key){
        this.f=f;
        this.key=key;
    }
    public void run(){
        String mark=searchKey(f);
        if(mark.contains(key)){
            String name=Thread.currentThread().getName();
            System.out.println(name+"找到字符串"+key+"在文件夹"+f.getAbsolutePath()+"中");
        }
    }
    public String searchKey(File f){
        byte[] data=new byte[(int) f.length()];
        try(FileInputStream fis=new FileInputStream(f)){
            fis.read(data);
            return new String(data);
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }
}