/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Project: https://karatelabs.github.io/karate
*    Release: https://github.com/karatelabs/karate/releases/tag/v1.3.1
*    Source File: JobCommand.java
*    
*    Copyrights:
*      copyright 2019 intuit inc
*    
*    Licenses:
*      MIT License
*      SPDXId: MIT
*    
*    Auto-attribution by Threatrix, Inc.
*    
*    ------ END LICENSE ATTRIBUTION ------
*/
/*
 * The MIT License
 *
 * Copyright 2019 Intuit Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.intuit.karate.job;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pthomas3
 */
public class JobCommand {

    private final String command;

    private String workingPath;
    private boolean background;

    public JobCommand(String command) {
        this.command = command;
    }

    public void setBackground(boolean background) {
        this.background = background;
    }

    public void setWorkingPath(String workingPath) {
        this.workingPath = workingPath;
    }        

    public JobCommand(Map<String, Object> map) {
        command = (String) map.get("command");
        workingPath = (String) map.get("workingPath");
        Boolean temp = (Boolean) map.get("background");
        background = temp == null ? false : temp;
    }

    public String getCommand() {
        return command;
    }

    public String getWorkingPath() {
        return workingPath;
    }

    public boolean isBackground() {
        return background;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap(3);
        map.put("command", command);
        map.put("workingPath", workingPath);
        if (background) {
            map.put("background", true);
        }
        return map;
    }

}
