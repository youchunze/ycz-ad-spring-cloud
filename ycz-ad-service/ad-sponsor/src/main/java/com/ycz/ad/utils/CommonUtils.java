package com.ycz.ad.utils;

import com.ycz.ad.exception.AdException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.time.DateUtils;

import java.util.Date;

/**
 * @author: hyczzz
 * @date: 2019/12/9 0009 22:44
 * @description:
 */
public class CommonUtils {

    private static String[] parsePattern = {
            "yyyy-mm-dd","yyyy/mm/dd","yyyy.mm.dd"
    };

    public static String md5(String value){
        return DigestUtils.md5Hex(value).toUpperCase();
    }

    public static Date parseStringDate(String dateString) throws AdException{
        try {
            return DateUtils.parseDate(
                    dateString,parsePattern
            );
        }catch (Exception ex){
            throw new AdException(ex.getMessage());
        }
    }
}
