package com.xupt.Part02;

import java.util.Random;

public class Consumer extends Thread{
    String name;
    MyStack<Character> myStack;
    public Consumer(){}
    public Consumer(String name,MyStack<Character> myStack){
        this.name=name;
        this.myStack=myStack;
    }
    @Override
    public void run(){
        while(true){
            char c=myStack.pop();
            System.out.println(name+"弹出字符"+c);
            try{
                Thread.sleep(90);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
