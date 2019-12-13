package com.xupt.Part01;

public class KillThread02 implements Runnable{
    private Hero h1;
    private Hero h2;
    public KillThread02(Hero h1,Hero h2){
        this.h1=h1;
        this.h2=h2;
    }
    public void run(){
        while(!h2.isDead()){
            h1.attackHero(h2);
        }
    }
}
