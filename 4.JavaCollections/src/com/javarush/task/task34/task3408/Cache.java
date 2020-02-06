package com.javarush.task.task34.task3408;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<K, V>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        V ret=null;
        if(cache.containsKey(key)) {
            ret = cache.get(key);
        }
        else {
            cache.put(key,clazz.getConstructor(key.getClass()).newInstance(key));
            ret = cache.get(key);
        }
        return ret;
    }

    public boolean put(V obj){
        Method metod = null;
        int size = size();
        try {
            metod = obj.getClass().getDeclaredMethod("getKey");
        }
        catch (NoSuchMethodException e) {
            return false;

        }
        metod.setAccessible(true);
        K temp = null;
        try {
            temp = (K)metod.invoke(obj);
        } catch (IllegalAccessException e) {
return false;
        } catch (InvocationTargetException e) {
            return false;

        }
        cache.put(temp,obj);
        if (size() > size){
          return true;
        }
        else
        return false;
    }

    public int size() {
        return cache.size();
    }
}
