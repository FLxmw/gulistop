package com.feilong.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * @author FeiLong
 * @version 1.8
 * @date 2020/11/20 12:46
 * 自定义校验器
 */
@SuppressWarnings("ALL")
public class ListValueConstraintValidator implements ConstraintValidator<ListValue, Integer> {

    private Set<Integer> set = new HashSet<>();

    /**
     * 初始化方法
     *
     * @param constraintAnnotation
     */
    @Override
    public void initialize(ListValue constraintAnnotation) {
        //获取指定注解的值
        int[] value = constraintAnnotation.value();
        for (int i : value) {
            set.add(i);
        }
    }

    /**
     * 根据注解的值判断是否校验成功！
     *
     * @param value   需要校验的值
     * @param context
     * @return
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return set.contains(value);
    }
}
