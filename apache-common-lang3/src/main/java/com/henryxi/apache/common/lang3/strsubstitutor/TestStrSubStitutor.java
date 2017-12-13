package com.henryxi.apache.common.lang3.strsubstitutor;

import org.apache.commons.lang3.text.StrLookup;
import org.apache.commons.lang3.text.StrSubstitutor;

import java.util.HashMap;
import java.util.Map;

public class TestStrSubStitutor {
    public static void main(String[] args) {
        String tobeSubstitutedStr = "this is tobe substituted string, my name is ${name}";
        String tobeSubstitutedStr2 = "this is tobe substituted string, my name is @(name)";
        Map<String, String> map = new HashMap<>();
        map.put("name", "henry");
        StrSubstitutor strSubstitutor = new StrSubstitutor(map);
        String afterReplacedStr = strSubstitutor.replace(tobeSubstitutedStr);
        System.out.println(afterReplacedStr);
        StrSubstitutor customStrSubstitutor = new StrSubstitutor((StrLookup<?>) null, "@(", ")", '@');
        String replace = customStrSubstitutor.replace(tobeSubstitutedStr2);
        System.out.println(replace);
    }
}
