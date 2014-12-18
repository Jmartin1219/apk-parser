package net.dongliu.apk.parser.utils;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * @author Dong Liu
 */
public class XmlUtils {

    public static Long longValue(NamedNodeMap namedNodeMap, String name) {
        String value = value(namedNodeMap, name);
        if (value == null) {
            return null;
        } else {
            return Long.valueOf(value);
        }
    }

    public static Integer getIntAttribute(NamedNodeMap namedNodeMap, String name) {
        String value = value(namedNodeMap, name);
        if (value == null) {
            return null;
        } else {
            return Integer.valueOf(value);
        }
    }

    public static boolean boolValue(NamedNodeMap namedNodeMap, String name, boolean defaultValue) {
        Boolean value = getBoolAttribute(namedNodeMap, name);
        return value == null ? defaultValue : value;
    }

    public static Boolean getBoolAttribute(NamedNodeMap namedNodeMap, String name) {
        String value = value(namedNodeMap, name);
        if (value == null) {
            return null;
        } else {
            return Boolean.valueOf(value);
        }
    }

    public static String value(NamedNodeMap namedNodeMap, String name) {
        Node node = namedNodeMap.getNamedItem(name);
        if (node == null) {
            if (name.startsWith("android:")) {
                name = name.substring("android:".length());
            }
            node = namedNodeMap.getNamedItem(name);
            if (node == null) {
                return null;
            }
        }
        return node.getNodeValue();
    }
}
