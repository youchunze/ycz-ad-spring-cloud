package com.ycz.ad.untils;

import java.util.Map;
import java.util.function.Supplier;

/**
 * @author: hyczzz
 * @date: 2019/12/15 0015 20:11
 * @description:
 */
public class CommonUtils {

    public static <K,V> V getorCreate(K key, Map<K,V> map, Supplier<V> factory){

        return map.computeIfAbsent(key, k -> factory.get());
    }
}
