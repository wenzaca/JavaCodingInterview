package com.interview.geeksforgeeks;

import java.util.*;

public class CheckDependenciesInstallList {

    public static void main(String[] args) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, Collections.emptyList());
        map.put(1, Arrays.asList(0));
        map.put(2, Arrays.asList(1,0,4));
        map.put(3, Arrays.asList(0));
        map.put(4, Arrays.asList(3));


        solution(map).forEach(System.out::println);

    }


    public static List<Integer> solution(Map<Integer, List<Integer>> map){
        Map<Integer, Integer> linkedMap = new LinkedHashMap<>();


        while (linkedMap.size()!=map.size()){
                for(Integer key: map.keySet()) {
                    boolean isNotReady = false;
                    List<Integer> integers = map.get(key);
                    if (integers.isEmpty()) {
                        linkedMap.put(key, 0);
                        continue;
                    }
                    for (Integer value : integers) {
                        if (linkedMap.get(value) == null) {
                            isNotReady = true;
                            break;
                        }
                    }
                    if (isNotReady) {
                        continue;
                    }
                    linkedMap.put(key, 0);
                }
        }
        return (List<Integer>) linkedMap.values();
    }
}
