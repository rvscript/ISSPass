package com.example.lib;

import java.util.ArrayList;

public class MyClass {

    public static void main(String[] args) {

        int[] array = {1, 2, 4, 7, 6, 5, 8};
        ArrayList<Integer> arrayList = new ArrayList<>();
        int z;

        for(int i = 0 ; i < array.length+1; i++){
            arrayList.add(i+1);
        }

        for(int i = 0; i < arrayList.size(); i++){
            z=0;
            for(int j = 0; j<array.length; j++){
                if(array[j] == arrayList.get(i)){
                    z++;
                }
            }
            if(z == 0){
                System.out.println(arrayList.get(i));
            }
        }

        int y = 0;

        for(int i = 0; i < array.length; i++){
            y = y + array[i];
        }

        System.out.println("sum:"+y);

        int w = 0;
        for (int i = 0; i < arrayList.size(); i++){
            w = w + arrayList.get(i);
        }

        System.out.println("sum:"+w);
        System.out.println("missing number is: "+ (w -y));
    }
}
