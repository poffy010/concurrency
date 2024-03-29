package com.mmall.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.mmall.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * @author Poffy Zhang
 * @date 2021/8/10 10:08
 * @desc
 */
@Slf4j
@NotThreadSafe
public class ImmutableExample3 {

    private final static ImmutableList list = ImmutableList.of(1,2,3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer,Integer> map = ImmutableMap.of(1,2,3,4);

    private final static ImmutableMap<Integer,Integer> map2 = ImmutableMap.<Integer,Integer>builder().put(1,2).put(3,4).build();

    public static void main(String[] args) {
//        a = 2;
//        b = "3";
//        list.add(4);
//        set.add(4);
//        map.put(5,6);
        log.info("{}",map);
    }
}
