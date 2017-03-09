package com.tar.spring.core.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitar on 09.03.17.
 */
public class CacheFileEventLogger extends FileEventLogger {
    int cacheSize;
    List<Event> cache;
    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
        cache = new ArrayList<>(cacheSize);
    }

    @Override
    public void logEvent(Event msg) {
        cache.add(msg);
        if (cacheSize == cache.size()){
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        for (Event event : cache)
            super.logEvent(event);
    }

   public void destroy(){
        if (!cache.isEmpty())
            writeEventsFromCache();
    }
}
