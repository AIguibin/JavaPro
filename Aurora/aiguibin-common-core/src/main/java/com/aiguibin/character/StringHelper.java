package com.aiguibin.character;
/**
 * 描述： 字符串工具类
 *
 * @author AIguibin Date time 2018/7/25 11:23
 */
public class StringHelper {
    /**
     *
     * @param str 字符串
     * @return 字符串为isNull
     */
    public static boolean isNull(String str){
        if (str==null
                || "null".equals(str.trim())
                || "NULL".equals(str.trim())){
            return true;
        }else{
            return false;
        }

    }

    /**
     *
     * @param str 字符串
     * @return 字符串isNotNull
     */
    public static boolean isNotNull(String str){
        if (isNull(str)){
            return false;
        }else{
            return true;
        }
    }
    /**
     *
     * @param str 字符串
     * @return 字符串isKong
     */
    public static boolean isKong(String str){
        if (str.trim()=="" ||"".equals(str.trim())){
            return true;
        }else{
            return false;
        }
    }
    /**
     *
     * @param str 字符串
     * @return 字符串isNotKong
     */
    public static boolean isNotKong(String str){
        if (isKong(str)){
            return false;
        }else{
            return true;
        }
    }
    /**
     *
     * @param str 字符串
     * @return 字符串isEmpty
     */
    public static boolean isEmpty(String str){
        if (isNull(str) || isKong(str)){
            return true;
        }else {
            return false;
        }
    }
    /**
     *
     * @param str 字符串
     * @return 字符串isNotEmpty
     */
    public static boolean isNotEmpty(String str){
        if (isEmpty(str)){
            return false;
        }else {
            return true;
        }
    }
}
