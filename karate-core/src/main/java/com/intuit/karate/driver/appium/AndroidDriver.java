/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Project: https://karatelabs.github.io/karate
*    Release: https://github.com/karatelabs/karate/releases/tag/v1.3.1
*    Source File: AndroidDriver.java
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
package com.intuit.karate.driver.appium;

import com.intuit.karate.FileUtils;
import com.intuit.karate.core.ScenarioRuntime;
import java.util.Map;

/**
 * @author babusekaran
 */
public class AndroidDriver extends AppiumDriver {

    public static final String DRIVER_TYPE = "android";

    protected AndroidDriver(MobileDriverOptions options) {
        super(options);
    }

    public static AndroidDriver start(Map<String, Object> map, ScenarioRuntime sr) {
        MobileDriverOptions options = new MobileDriverOptions(map, sr, 4723, FileUtils.isOsWindows() ? "cmd.exe" : "appium");
        // additional commands needed to start appium on windows
        if (FileUtils.isOsWindows()){
            options.arg("/C");
            options.arg("cmd.exe");
            options.arg("/K");
            options.arg("appium");
        }
        options.arg("--port=" + options.port);
        return new AndroidDriver(options);
    }

    @Override
    public void activate() {
        super.setContext("NATIVE_APP");
    }

}
