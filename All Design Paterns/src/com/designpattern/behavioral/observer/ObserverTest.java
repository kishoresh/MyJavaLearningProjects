package com.designpattern.behavioral.observer;
/*
 * Observer Design Pattern :
 * Observers  - A list of Cache's
 * Subject    - CacheManager, which stores the list of cahce's in a hash map.
 * When there is a change in REF data, CacheManager gets notified (it is a subscriber to a Topic) and onCacheChange() event is triggered. 
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

interface CacheInterface{          //Observers - All cache class's are observing for update.
	void update();
}

class Cache1 implements CacheInterface{
	@Override
	public void update() {
		System.out.println("Updating Cache1. " );		
	}
}

class Cache2 implements CacheInterface{
	@Override
	public void update() {
		System.out.println("Updating Cache2.");			
	}	
}

interface CacheManagerInterface{              //Subject - Any change to a cache, onCacheChange() event is triggered.
	void registerCache(String cacheName, CacheInterface cache);
	void onCacheChange(String cacheName);
	void notifyCache();
}

class CacheManager implements CacheManagerInterface{
	Map<String, CacheInterface> cacheMap = new HashMap<>();   //To store the cache's
	private String cacheName;
	
	@Override
	public void registerCache(String cacheName, CacheInterface cache) {
		cacheMap.put(cacheName, cache);		
	}	
	
	@Override
	public void onCacheChange(String cacheName) {
		this.cacheName = cacheName;
		notifyCache();
	}
	
	@Override
	public void notifyCache() {
		for(Map.Entry me : cacheMap.entrySet()){
			CacheInterface cache = (CacheInterface) me.getValue();
			if (me.getKey().equals(cacheName)){
				cache.update();
			}
		}
	}	
}

public class ObserverTest {

	public static void main(String[] args) {
		CacheInterface c1 = new Cache1();
		CacheInterface c2 = new Cache2();
		
		//Register the cache's with the CacheManager.
		CacheManager cm = new CacheManager();
		cm.registerCache("CACHE-1", c1);
		cm.registerCache("CACHE-2", c2);
		
		//Any change in REF data, the Message listener triggers onCacheChange of the CacheManager 
		cm.onCacheChange("CACHE-2");
		cm.onCacheChange("CACHE-1");
	}
}
