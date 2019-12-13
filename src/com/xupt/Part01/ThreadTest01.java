package com.xupt.Part01;

public class ThreadTest01 {
    public static void main(String[] args) {
        Hero gaiLun=new Hero("gaiLun",600,50);
        Hero teemo=new Hero("teemo",550,60);
        Hero liQing=new Hero("liQing",580,55);
        Hero jie=new Hero("jie",585,60);
//        while(!teemo.isDead()){
//            gaiLun.attackHero(teemo);
//        }
//        while(!liQing.isDead()){
//            jie.attackHero(liQing);
//        }
        //实现的多线程方法一：继承Thread类
//        KillThread01 kill1=new KillThread01(gaiLun,teemo);
//        kill1.start();
//        KillThread01 kill2=new KillThread01(jie,liQing);
//        kill2.start();
        //实现多线程方法二：实现Runnable接口
//        KillThread02 kill1=new KillThread02(gaiLun,teemo);
//        new Thread(kill1).start();
//        KillThread02 kill2=new KillThread02(jie,liQing);
//        new Thread(kill2).start();
        //实现多线程方法三：匿名类;
        Thread kill1=new Thread(){
            @Override
            public void run(){
                while(!teemo.isDead()){
                    gaiLun.attackHero(teemo);
                }
            }
        };
        kill1.start();
        Thread kill2=new Thread(){
            @Override
            public void run(){
                while(!liQing.isDead()){
                    jie.attackHero(liQing);
                }
            }
        };
        kill2.start();
    }
}
