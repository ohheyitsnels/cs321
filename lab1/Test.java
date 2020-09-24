package com.company;

public class Test {
    public static void main(String[] args) {
        TestCache testCache = new TestCache();
	    String mode = args[0];

	    switch (mode){
            case "1":{
                testCache.testFirstLevelCache(Integer.parseInt(args[1]), args[2]);
                break;
            }
            case "2" :{
                testCache.testSecondLevelCache(Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
                break;
            }
            default:
                throw new NullPointerException("bad");
        }
    }
}
