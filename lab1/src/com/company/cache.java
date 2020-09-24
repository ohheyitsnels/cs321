package com.company;
import java.util.LinkedList;

public class cache<T> {
    private final int maxSize;
    private LinkedList<T> list = new LinkedList<T>();

    public cache(int maxSize){
        this.maxSize = maxSize;
    }

    public T getObject(T object){
            if(list.contains(object)){
                list.remove(object);
                list.addFirst(object);
                return object;
            }
        list.addFirst(object);
        return null;
    }

    public void addObject(T object){
        if (getObject(object) == null){
            list.addFirst(object);
        }
    }

    public void removeObject(T object){
        T foundObject = getObject(object);
        list.remove(foundObject);
    }

    public void clearCache(){
        list = new LinkedList<>();
    }
}
