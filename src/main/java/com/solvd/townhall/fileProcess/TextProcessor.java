package com.solvd.townhall.fileProcess;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class TextProcessor {
    public static void main(String[] args) throws IOException {

        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        String text = FileUtils.readFileToString(new File("src/main/resources/fileToExamine.txt"), "UTF-8").toLowerCase(Locale.ROOT);
        for (String word : StringUtils.split(text)) {
            Object j = ((wordCount.containsKey(word)) ? wordCount.put(word, wordCount.get(word)+1) : wordCount.put(word,1));}
        FileUtils.writeStringToFile(new File("src/main/resources/wordCountResults"), wordCount.toString(), "UTF-8");
        }
    }

