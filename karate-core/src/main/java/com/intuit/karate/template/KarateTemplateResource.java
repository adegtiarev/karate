/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Project: https://karatelabs.github.io/karate
*    Release: https://github.com/karatelabs/karate/releases/tag/v1.3.1
*    Source File: KarateTemplateResource.java
*    
*    Copyrights:
*      copyright 2020 intuit inc
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
 * Copyright 2020 Intuit Inc.
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
package com.intuit.karate.template;

import com.intuit.karate.resource.Resource;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import org.thymeleaf.templateresource.ITemplateResource;

/**
 *
 * @author pthomas3
 */
public class KarateTemplateResource implements ITemplateResource {

    private final Resource resource;

    public KarateTemplateResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String getDescription() {
        return resource.getRelativePath();
    }

    @Override
    public String getBaseName() {
        return resource.getRelativePath();
    }

    @Override
    public boolean exists() {
        return true;
    }

    @Override
    public Reader reader() throws IOException {
        return new InputStreamReader(resource.getStream());
    }

    @Override
    public ITemplateResource relative(String relativeLocation) {
        return new KarateTemplateResource(resource.resolve(relativeLocation));
    }

}
