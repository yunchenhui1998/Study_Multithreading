package com.xupt.Part01;
/*
英雄有可以放一个技能叫做: 波动拳-a du gen。
每隔一秒钟，可以发一次，但是只能连续发3次。

发完3次之后，需要充能5秒钟，充满，再继续发。

借助本章节学习到的知识点，实现这个效果

 */
public class Practice02 {
    public static void main(String[] args) {
        HeroSkill skill1=new HeroSkill("hasagi",3,5);
        Hero yaSuo=new Hero("yaSuo",600,50,skill1);
        Thread t1=new Thread(){
            @Override
            public void run(){
                while(true){
                    yaSuo.specialSkill();
                }
            }
        };
        t1.start();
    }
}
