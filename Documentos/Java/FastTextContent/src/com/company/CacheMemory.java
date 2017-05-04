package com.company;


import java.util.Hashtable;
import java.util.Observable;

public class CacheMemory extends Observable
{

    private Hashtable<String, MyHtml> CacheDictionary = new Hashtable<>();
    private static CacheMemory Instance;


    synchronized static CacheMemory getInstance()
    {
        if (Instance==null)
        {
            Instance = new CacheMemory();
        }
        return Instance;
    }

    MyHtml get(String pKey)
    {
//        System.out.println("Abriendo la puerta");
//        notifyToInterface(pKey);
//        return CacheDictionary.get(pKey);
        return getCacheDictionary().remove(pKey);

    }

    void add(String pKey, MyHtml pValue)
    {
        if (!CacheDictionary.containsKey(pKey)) {
            CacheDictionary.put(pKey, pValue);
            notifyToInterface(pKey);
        }
    }


    Hashtable<String, MyHtml> getCacheDictionary() {
        return CacheDictionary;
    }

    void notifyToInterface(String pKey)
    {
        setChanged();
        this.notifyObservers(CacheDictionary.get(pKey));
    }
}


