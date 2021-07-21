package com.ruppyrup.loadifabsent;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.security.ProviderException;
import java.util.concurrent.ExecutionException;

public class TestLoadIfAbsent {
    public static void main(String[] args) {
        FatBoy fb1 = FatBoyFactory.loadIfAbsent("Bob");
        FatBoy fb2 = FatBoyFactory.loadIfAbsent("Bob");
        FatBoy fb3 = FatBoyFactory.loadIfAbsent("Alice");

        if (fb1.equals(fb2)) System.out.println("The fatboys match");
        if (!fb1.equals(fb3)) System.out.println("The fatboys dont match");
    }
}

class FatBoyFactory {
    private static final LoadingCache<String, FatBoy> cachedProvider =
            CacheBuilder
                    .newBuilder()
                    .build(CacheLoader.from(name -> name != null ? new FatBoy(name) : null));

//    private FatBoy fatBoy;
//
//    public FatBoyFactory(String name) {
//        this.fatBoy = getFatBoy(name);
//    }

    public static FatBoy loadIfAbsent(String name) {
        try {
            return cachedProvider.get(name);
        } catch (ExecutionException e) {
            throw new ProviderException(e);
        }
    }

//    private FatBoy getFatBoy(String name) {
//        return new FatBoy(name);
//    }
}

class FatBoy {
    String name;

    public FatBoy(String name) {
        this.name = name;
    }
}
