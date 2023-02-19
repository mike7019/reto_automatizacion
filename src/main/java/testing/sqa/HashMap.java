package testing.sqa;

import java.util.Map;

public class HashMap {

    public static void main(String[] args) {

        java.util.HashMap<Integer, String> hashMap = new java.util.HashMap<Integer, String>();
        hashMap.put(1, "Mike");
        hashMap.put(2, "arturo");
        System.out.println(hashMap);
        System.out.println(hashMap.keySet());
        System.out.println(hashMap.values());
    }

}
