package com.xupt.Part01;

public class Hero {
    private String name;
    private float hp;
    private int damage;
    private String skillName;
    private int skillCount=1;
    private int skillTimes;
    private int coolDownTime;
    public Hero(){}
    public Hero(String name,float hp,int damage){
        this.name=name;
        this.hp=hp;
        this.damage=damage;
    }
    public Hero(String name,float hp,int damage,HeroSkill skill){
        this.name=name;
        this.hp=hp;
        this.damage=damage;
        this.skillName=skill.getSkillName();
        this.skillTimes=skill.getSkillTimes();
        this.coolDownTime=skill.getCoolDownTime();
    }
    public void attackHero(Hero h){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        h.hp-=damage;
        System.out.println(name+"正在攻击"+h.name+","+h.name+"的血量变成了"+h.hp);
        if(h.isDead()){
            System.out.println(h.name+"死了!");
        }
    }
    public boolean isDead(){
        return hp>0?false:true;
    }
    public void specialSkill(){
        System.out.println(name+"使用"+skillName+"技能"+skillCount+"次");
        if(skillCount<skillTimes){
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        skillCount++;
        if(skillCount==skillTimes+1){
            skillCount=1;
            System.out.println("开始为时"+coolDownTime+"秒的冷却");
            for(int i=0;i<coolDownTime;i++){
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
