package com.xinshe.web.common.util;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : zym
 * @date : 2019/4/4 11:49
 * @desc :
 */
public class DFDCollectionUtils {
    /**
     * 将某一集合按照大小进行拆分
     * @param list
     * @param maxSize
     * @return
     */
    public static final <T> List<List<T>> decomposeList(List<T> list, int maxSize) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        if (maxSize < 1) {
            throw new IllegalArgumentException("are you kidding me");
        }
        List<List<T>> result = Collections.emptyList();
        int totalSize = list.size();
        if (totalSize > maxSize) {
            int countOfList = totalSize / maxSize;
            if (totalSize % maxSize > 0) {
                countOfList++;
            }
            result = new ArrayList<List<T>>(countOfList);
            for (int index = 0; index < countOfList; index++) {
                int fromIndex = maxSize * index;
                //因为toIndex是exclusive的，所以此处不做-1操作
                int toIndex = maxSize * (index + 1);
                if (toIndex > totalSize) {
                    toIndex = totalSize;
                }
                result.add(list.subList(fromIndex, toIndex));
            }
        } else {
            result = new ArrayList<List<T>>(1);
            result.add(list);
        }
        return result;
    }
}
