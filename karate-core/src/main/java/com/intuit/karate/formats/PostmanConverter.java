/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Project: https://karatelabs.github.io/karate
*    Release: https://github.com/karatelabs/karate/releases/tag/v1.2.0.RC1
*    Source File: PostmanConverter.java
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
package com.intuit.karate.formats;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PostmanConverter {

    /**
     * Run the logic required to convert a single Postman collection
     * file from the disk into a Karate feature file and write it to Karate's
     * output directory as a new file.
     *
     * @param importFile the (String) path to the file to import
     * @param outputDir  the (String) path to the output directory
     * @return boolean - true if successful, false otherwise
     */
    public boolean convert(final String importFile, final String outputDir) {
        try {
            final Path pathTo = Paths.get(importFile);
            if (!Files.exists(pathTo)) {
                System.err.println("File at '" + importFile + "' does not exist; cannot import");
                return false;
            }
            final String content = new String(Files.readAllBytes(pathTo), StandardCharsets.UTF_8);
            final List<PostmanItem> items = PostmanUtils.readPostmanJson(content);
            final String collectionName = pathTo.getFileName().toString()
                .replace(".postman_collection", "")
                .replace(".json", "");
            final String converted = PostmanUtils.toKarateFeature(collectionName, items);
            final Path outputFilePath = Paths.get(outputDir, collectionName + ".feature");
            Files.write(outputFilePath, converted.getBytes());
            System.out.println("Converted feature file available at " + outputFilePath.toAbsolutePath().toString());
            return true;
        } catch (IOException e) {
            System.err.println("An error occurred with processing the file - the task could not be completed");
            return false;
        }
    }

}
