package com.devxpress;

import javax.script.*;
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

    public static boolean palindromeOptimised(String str) {

        int len = str.length();

        // Optimised by only looping through half the string
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
