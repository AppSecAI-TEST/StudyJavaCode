//: generics/ClassTypeCapture.java
package com.example.doun.chapter15generics;

import android.util.Log;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

class Building {
    String title;
    Building(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}

class House extends Building {
    House(String title) {
        super(title);
    }
}

public class ClassTypeCapture<T> {
    Class<T> kind;

    Map<String, Class<?>> kindsMap = new HashMap<>();

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public Object c(String title) {
        try{
//            kind.newInstance();
            Constructor constructor = kind.getDeclaredConstructor(String.class);
            return constructor.newInstance(title);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public void addType(String typename, Class<?> kind){
        kindsMap.put(typename, kind);
    }

    public Object createNew(String typename){
        Class<?> classInfo = kindsMap.get(typename);
        if (classInfo == null){
            Log.e("ClassTypeCapture", "没有"+typename+"类型");
            return null;
        }

        try {
            return classInfo.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<Building>(Building.class);
//        System.out.println(ctt1.f(new Building()));
//        System.out.println(ctt1.f(new House()));
//        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<House>(House.class);
//        System.out.println(ctt2.f(new Building()));
//        System.out.println(ctt2.f(new House()));
    }
} /* Output:
true
true
false
true
*///:~
