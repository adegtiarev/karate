/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Project: https://karatelabs.github.io/karate
*    Release: https://github.com/karatelabs/karate/releases/tag/v1.4.0
*    Source File: FizzBuzz.java
*    
*    Copyrights:
*      copyright 2017 intuit inc
*    
*    Licenses:
*      MIT License
*      SPDXId: MIT
*    
*    Auto-attribution by Threatrix, Inc.
*    
*    ------ END LICENSE ATTRIBUTION ------
*/
package com.intuit.karate.demo.util;

/**
 *
 * @author pthomas3
 */
public class FizzBuzz {

    public static boolean isMultiple(int n, int i) {
        return n % i == 0;
    }

    public static boolean isFizzy(int n) {
        return isMultiple(n, 3);
    }

    public static boolean isBuzzy(int n) {
        return isMultiple(n, 5);
    }

    public static String process(int n) {
        return isFizzy(n) ? isBuzzy(n)
                ? "FizzBuzz"
                : "Fizz"
                : isBuzzy(n)
                ? "Buzz"
                : n + "";
    }

}
