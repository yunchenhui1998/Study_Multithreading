package com.xupt.Part01;

public class HeroSkill {
    private String skillName;
    private int skillTimes;
    private int coolDownTime;
    public HeroSkill(){}
    public HeroSkill(String skillName,int skillTimes,int coolDownTime){
        this.skillName=skillName;
        this.skillTimes=skillTimes;
        this.coolDownTime=coolDownTime;
    }

    public String getSkillName() {
        return skillName;
    }

    public int getSkillTimes() {
        return skillTimes;
    }

    public int getCoolDownTime() {
        return coolDownTime;
    }
}
