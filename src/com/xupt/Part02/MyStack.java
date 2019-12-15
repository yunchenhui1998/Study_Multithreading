package com.xupt.Part02;

import java.util.LinkedList;
import java.util.List;

public class MyStack<T> {
    LinkedList<T> l=new LinkedList<>();
    public synchronized void push(T t){
        if(l.size()>=200){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        l.push(t);
        this.notifyAll();
    }
    public synchronized T pop(){
        if(l.size()==0){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        T t=l.pop();
        this.notifyAll();
        return t;
    }
    public synchronized T peek(){
        return l.peek();
    }
}
