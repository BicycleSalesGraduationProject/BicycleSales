package com.hlbrc.bicyclesales.controller;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BaseController {
    public static Map<String,Object> getParameterMap(HttpServletRequest request) {
        Map properties = request.getParameterMap();
        Map<String,Object> returnMap = new HashMap<String, Object>();
        Iterator entries = properties.entrySet().iterator();
        String name = "";
        String value = "";
        while(entries.hasNext()) {
            Map.Entry entry = (Map.Entry)entries.next();
            name = (String)entry.getKey();
            Object valueObj = entry.getValue();
            if (valueObj == null) {
                value = "";
            } else if (!(valueObj instanceof String[])) {
                value = valueObj.toString();
            } else {
                value = "";
                String[] values = (String[])valueObj;
                for (String v :values) {
                    value = value + v +",";
                }
                value = value.substring(0, value.length() - 1);
            }
            value = value.trim();
            returnMap.put(name, value);
        }
        return returnMap;
    }

}