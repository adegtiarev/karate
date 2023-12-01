/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Project: https://karatelabs.github.io/karate
*    Release: https://github.com/karatelabs/karate/releases/tag/v0.9.6
*    Source File: LenientSslConnectionSocketFactory.java
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
/*
 * The MIT License
 *
 * Copyright 2017 Intuit Inc.
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
package org.apache.http.conn.ssl;

import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import org.apache.http.protocol.HttpContext;

/**
 * in a separate package just for log level config consistency
 * 
 * @author pthomas3
 */
public class LenientSslConnectionSocketFactory extends SSLConnectionSocketFactory {
    
    public LenientSslConnectionSocketFactory(SSLContext sslContext, HostnameVerifier hostnameVerifier) {
        super(sslContext, hostnameVerifier);
    }

    @Override
    public Socket createLayeredSocket(Socket socket, String target, int port, HttpContext context) throws IOException {
        return super.createLayeredSocket(socket, "", port, context);
    }
    
}
