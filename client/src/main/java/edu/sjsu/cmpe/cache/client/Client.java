package edu.sjsu.cmpe.cache.client;

public class Client {

    public static void main(String[] args) throws Exception {
        System.out.println("Starting Cache Client...");
        CacheServiceInterface cache = new DistributedCacheService(
                "http://localhost:3000");
        CacheServiceInterface myCache = new DistributedCacheService(
                "http://localhost:3000","http://localhost:3001","http://localhost:3002");


        System.out.println("putting (1 => foo)");
        myCache.putAsynch(1, "foo");
        System.out.println("Sleeping for 25 seconds...");
        Thread.sleep(25000);
        System.out.println("Updating putting (1 => bar)");
        myCache.putAsynch(1, "bar");
        System.out.println("Sleeping for 25 seconds...");
        Thread.sleep(25000);
        System.out.println("getting values...");
        String value = myCache.getAsynch(1);
        System.out.println("Value received: "+value);
        System.out.println("Existing Cache Client...");
    }

}
