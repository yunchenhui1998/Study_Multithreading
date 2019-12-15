package com.xupt.Part02;

public class Test01 {
    public static void main(String[] args) {
        Hero gaiLun=new Hero("gaiLun",600);
        Hero teemo=new Hero("teemo",500);
        Thread t1=new Thread(){
            @Override
            public void run(){
                while(true){
                    gaiLun.hurt();
                    try{
                        Thread.sleep(100);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        Thread t2=new Thread(){
            @Override
            public void run(){
                while(true){
                    gaiLun.recover();
                    try{
                        Thread.sleep(10);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();
    }
}
