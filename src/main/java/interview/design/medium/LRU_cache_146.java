package interview.design.medium;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU_cache_146 {
	class LRUCache {
	    
	    private Cache cache;

	    public LRUCache(int capacity) {
	        this.cache = new Cache(capacity);
	        
	    }
	    
	    public int get(int key) {
	        if(cache.containsKey(key))
	            return cache.get(key);
	            
	        return -1;
	    }
	    
	    public void put(int key, int value) {
	        this.cache.put(key, value);
	    }
	    
	    
	    class Cache extends LinkedHashMap<Integer, Integer> {
	        
	        private int maxCapacity;
	        
	        public Cache(int capacity) {
	            super(capacity, 0.75f, true);
	            this.maxCapacity = capacity;
	            
	        }
	        
	        @Override
	        protected boolean removeEldestEntry(Map.Entry eldest) {
	            return size() > maxCapacity;
	        }
	    }
	}

}
