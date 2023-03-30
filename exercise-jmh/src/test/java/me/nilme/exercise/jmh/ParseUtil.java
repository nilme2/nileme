package me.nilme.exercise.jmh;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ParseUtil {


    /**
     * 字符串 *号 模糊符号匹配
     *
     * @param str1 模糊串
     * @param str2 完整串
     * @return
     */
    public static boolean fuzzyMatch(String str1, String str2) {
        if (StringUtils.isAnyEmpty(str1, str2)) {
            return false;
        }

        str1 = cleanPatternStr(str1);
        str2 = cleanPatternStr(str2);

        String newStr1 = str1.replaceAll("\\*+", ".+");
        String newStr2 = str2.replaceAll("\\*+", ".+");
        return Pattern.matches(newStr2, str1) || Pattern.matches(newStr1, str2);
    }

    /**
     * 字符串 *号替换成%，多个*号只会被替换成一个
     *
     * @param str
     * @return
     */
    public static String fuzzy(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return str.replaceAll("\\*+", "%");
    }

    /**
     * 列表中是否存在模糊匹配的项
     *
     * @param data
     * @param str
     * @return
     */
    public static boolean fuzzyList(Collection<String> data, String str) {
        if (StringUtils.isEmpty(str) || CollectionUtils.isEmpty(data)) {
            return false;
        }
        for (String datum : data) {
            if (fuzzyMatch(str, datum)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 校验是否是手机号，这里不做强校验，运营商的号段可能会更新
     *
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone) {
        if (StringUtils.isEmpty(phone)) {
            return false;
        }
        String check = "^1(\\d|\\*){10}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(phone);
        return matcher.matches();
    }


    /**
     * 清除列表中的null、空字符串
     *
     * @param collection
     */
    public static void collectionTrim(Collection collection) {
        if (collection != null && collection.size() > 0) {
            collection.remove(null);
            collection.remove("");
        }
    }

    /**
     * 列表模糊去重,并尽量保留完整的串
     *
     * @param collection
     */
    public static Set<String> collectionDistinct(Collection<String> collection) {
        collectionTrim(collection);
        Set<String> newset = new HashSet<>();
        for (String str : collection) {
            boolean isNew = true;
            for (String s : newset) {
                if (MatchUtils.wildcardMatch(str, s)) {
                    isNew = false;
                    if (s.contains("*") && !str.contains("*")) {
                        newset.remove(s);
                        newset.add(str);
                    }
                    break;
                }
            }
            if (isNew) {
                newset.add(str);
            }
        }
        return newset;
    }

    /**
     * map根据key模糊去重
     *
     * @param map
     */
    public static HashMap<String, Integer> mapDistinct(Map<String, Integer> map) {
        Set<String> keySet = map.keySet();
        HashMap<String, Integer> newmap = new HashMap<>();

        for (String key : keySet) {
            Set<String> newKeyset = newmap.keySet();
            boolean isNew = true;
            String repeatKey = null;
            for (String newkey : newKeyset) {
                if (fuzzyMatch(key, newkey)) {
                    isNew = false;
                    repeatKey = newkey;
                    break;
                }
            }
            if (isNew) {
                newmap.put(key, map.get(key));
            } else {
                newmap.put(repeatKey, newmap.get(repeatKey) + map.get(key));
            }
        }

        return newmap;
    }

    /**
     * 正则字符清除
     *
     * @param str
     * @return
     */
    private static String cleanPatternStr(String str) {
        return str.replaceAll("[(){}$|?]+", "");
    }

    public static void main(String[] args) {
        String idcard1 = "125725666999";
        String idcard2 = "125725666999";

        System.out.println(ParseUtil.fuzzyMatch(idcard1, idcard2));//true

        System.out.println(ParseUtil.fuzzy("125**257**9*******99*"));

        System.out.println(fuzzyList(Arrays.asList("18066265836", "18066265837"), "18066265837"));

        Set<String> set = new HashSet<>();
        set.add("1234*67");
        set.add("12*4*67");
        set.add("1234*68");
        set.add("1234568");
        set.add("xxxx");

        Set<String> strings = collectionDistinct(set);
        System.out.println(strings);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("180(6)626**36", 1);
        map.put("???", 10);
        map.put("印度尼|西亚{印}度尼西亚（Telkomsel)公司", 1);
        map.put("1806**65836", 4);
        map.put("1806626**37", 2);
        map.put("18066265836", 4);

        System.out.println(mapDistinct(map));


        System.out.println(isPhone("18066*6*83*"));

        System.out.println(ParseUtil.fuzzyMatch("郭乐", "**乐"));

    }

}
