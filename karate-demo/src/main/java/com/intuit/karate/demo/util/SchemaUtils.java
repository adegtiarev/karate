/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Project: https://karatelabs.github.io/karate
*    Release: https://github.com/karatelabs/karate/releases/tag/v1.4.0
*    Source File: SchemaUtils.java
*    
*    Copyrights:
*      copyright (c) 2013 gopivotal, inc. all rights reserved
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

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author pthomas3
 */
public class SchemaUtils {

    private static final Logger logger = LoggerFactory.getLogger(SchemaUtils.class);
    
    public static boolean isValid(String json, String schema) throws Exception {
        JsonNode schemaNode = JsonLoader.fromString(schema);       
        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonSchema jsonSchema = factory.getJsonSchema(schemaNode); 
        JsonNode jsonNode = JsonLoader.fromString(json);
        ProcessingReport report = jsonSchema.validate(jsonNode);
        logger.debug("report: {}", report);
        return report.isSuccess();
    }

}
