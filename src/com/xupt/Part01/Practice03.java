package com.xupt.Part01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Practice03 {
    public static void main(String[] args) {
        List<String> l=new ArrayList<>();
        Thread t1=new Thread(){
            @Override
            public void run(){
                findCode(makeRandomCode(),l);
            }
        };
        t1.start();
        Thread t2=new Thread(){
            @Override
            public void run(){
                while(true){
                    while(l.isEmpty()){
                        try{
                            Thread.sleep(1000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    String s=l.remove(0);
                    System.out.println("尝试密码:"+s);
                }
            }
        };
        t2.setDaemon(true);
        t2.start();
    }
    private static String makeRandomCode(){
        Random r=new Random();
        char[] randomCode=new char[3];
        char max='z'+1;
        char min='0';
        for(int i=0;i<3;i++){
            while(true){
                char make=(char)(r.nextInt(max-min)+min);
                if(Character.isLetterOrDigit(make)){
                    randomCode[i]=make;
                    break;
                }
            }
        }
        return String.valueOf(randomCode);
    }
    private static void findCode(String target, List<String> l){
        char[] findedCode=new char[3];
        for(int i='0';i<='z';i++){
            boolean flagI=false;
            for(int j='0';j<='z';j++){
                boolean flagJ=false;
                for(int k='0';k<='z';k++){
                    if(Character.isLetterOrDigit(i)&&Character.isLetterOrDigit(j)&&Character.isLetterOrDigit(k)){
                        findedCode[0]=(char)i;
                        findedCode[1]=(char)j;
                        findedCode[2]=(char)k;
                        String findPass=new String(findedCode);
                        try{
                            Thread.sleep(1);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        l.add(findPass);
                        if(findPass.equals(target)){
                            System.out.println("密码是"+findPass);
                            flagI=true;
                            flagJ=true;
                            break;
                        }
                    }
                }
                if(flagJ){
                    break;
                }
            }
            if(flagI){
                break;
            }
        }
    }
}
