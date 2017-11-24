package com.devxpress;

import javax.script.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Palindrome {

    public static void main(String[] args){
        ScriptEngineManager mgr=new ScriptEngineManager();
        List<ScriptEngineFactory> list=mgr.getEngineFactories();
        System.out.println("Supported Script Engines");
        for (  ScriptEngineFactory factory : list) {
            String name=factory.getEngineName();
            String version=factory.getEngineVersion();
            String language=factory.getLanguageName();
            String languageVersion=factory.getLanguageVersion();
            System.out.printf("Name: %s (%s) / Language: %s / Version: %s \n",name,version,language,languageVersion);
            List<String> engNames=factory.getNames();
            for (    String e : engNames) {
                System.out.printf("\tEngine Alias: %s\n",e);
            }
        }
    }

    public static boolean palindromeBuilderReverse(String str) {

        return new StringBuilder(str).reverse().toString().equals(str);
    }

    public static boolean palindromeForLoop(String str) {

        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            sb.insert(0, c);
        }

        return sb.toString().equals(str);
    }

    public static boolean palindromeJavaScript(String str, String functionName) throws Exception {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        if (!(engine instanceof Invocable)) {
            throw new RuntimeException("Invoking methods is not supported.");
        }

        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        // Get script from JS File on classpath (from resources)
        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(
                                     loader.getResourceAsStream("js/palindrome.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        return ((Boolean) ((Invocable) engine).invokeFunction(functionName, str)).booleanValue();
    }

}
