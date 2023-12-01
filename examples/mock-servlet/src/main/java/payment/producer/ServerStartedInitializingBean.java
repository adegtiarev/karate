/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Project: https://karatelabs.github.io/karate
*    Release: https://github.com/karatelabs/karate/releases/tag/v1.3.1
*    Source File: ServerStartedInitializingBean.java
*    
*    Copyrights:
*      copyright 2017 intuit inc
*      copyright 2020 pthomas3
*      copyright 2011-2019 the bootstrap authors (https://github.com/twbs/bootstrap/graphs/contributors)
*    
*    Licenses:
*      MIT License
*      SPDXId: MIT
*    
*    Auto-attribution by Threatrix, Inc.
*    
*    ------ END LICENSE ATTRIBUTION ------
*/
package payment.producer;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author pthomas3
 */
@Component
public class ServerStartedInitializingBean implements ApplicationRunner, ApplicationListener<WebServerInitializedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(ServerStartedInitializingBean.class);

    private int localPort;

    public int getLocalPort() {
        return localPort;
    }

    @Override
    public void run(ApplicationArguments aa) throws Exception {
        logger.info("server started with args: {}", Arrays.toString(aa.getSourceArgs()));
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent e) {
        localPort = e.getWebServer().getPort();
        logger.info("after runtime init, local server port: {}", localPort);
    }

}
