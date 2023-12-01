/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Project: https://karatelabs.github.io/karate
*    Release: https://github.com/karatelabs/karate/releases/tag/v1.1.0
*    Source File: Karate.java
*    
*    Copyrights:
*      copyright 2018 intuit inc
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
 * Copyright 2018 Intuit Inc.
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
package com.intuit.karate.junit5;

import com.intuit.karate.Runner;
import com.intuit.karate.Suite;
import com.intuit.karate.core.Feature;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;

public class Karate extends Runner.Builder<Karate> implements Iterable<DynamicNode> {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @TestFactory
    public @interface Test {

    }

    // short cut for new Karate().path()
    public static Karate run(String... paths) {
        return new Karate().path(paths);
    }

    @Override
    public Iterator<DynamicNode> iterator() {
        Suite suite = new Suite(this);
        List<DynamicNode> list = new ArrayList();
        List<CompletableFuture> futures = new ArrayList();
        for (Feature feature : suite.features) {
            FeatureNode featureNode = new FeatureNode(suite, futures, feature, suite.tagSelector);
            String testName = feature.getResource().getFileNameWithoutExtension();
            DynamicNode node = DynamicContainer.dynamicContainer(testName, featureNode);
            list.add(node);
        }
        if (list.isEmpty()) {
            Assertions.fail("no features or scenarios found: " + this);
        }
        return list.iterator();
    }

}
