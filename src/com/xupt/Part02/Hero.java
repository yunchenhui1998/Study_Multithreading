package com.xupt.Part02;

public class Hero {
    private String name;
    private float hp;
    private int damage;
    public Hero(){};
    public Hero(String name,float hp){
        this.name=name;
        this.hp=hp;
    }
    public void attcakHero(Hero h){
        if(!h.isDead()){
            h.hp-=damage;
            System.out.println(name+"正在攻击"+h.name+","+h.name+"血量变成了"+h.hp);
        }else{
            System.out.println(h.name+"死了");
        }
    }
    public boolean isDead(){
        if(hp<=0){
            return true;
        }
        else{
            return false;
        }
    }
    public synchronized void hurt(){
        hp-=1;
        System.out.println(name+",血量减一,血量变成了"+hp);
        this.notify();
    }
    public synchronized void recover(){
        if(hp>=1000){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        hp+=1;
        System.out.println(name+",血量加一,血量变成了"+hp);
    }
}
