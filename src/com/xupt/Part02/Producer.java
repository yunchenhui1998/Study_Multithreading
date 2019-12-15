package com.xupt.Part02;

import java.util.Random;

public class Producer extends Thread{
    String name;
    MyStack<Character> myStack;
    public Producer(){};
    public Producer(String name,MyStack<Character> myStack){
        this.name=name;
        this.myStack=myStack;
    }
    @Override
    public void run(){
        Random r=new Random();
        while(true){
            char c=(char)(r.nextInt(26)+'A');
            myStack.push(c);
            System.out.println(name+"压入字符"+c);
            try{
                Thread.sleep(30);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
