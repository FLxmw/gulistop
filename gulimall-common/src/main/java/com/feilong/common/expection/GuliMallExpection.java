package com.feilong.common.expection;

import com.feilong.common.enums.BizCodeEnum;
import com.feilong.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FeiLong
 * @version 1.8
 * @date 2020/11/19 22:51
 */
@RestControllerAdvice
@Slf4j
@SuppressWarnings("ALL")
public class GuliMallExpection {

    /**
     * 集中处理参数校验的异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public R handleValidException(MethodArgumentNotValidException exception) {
        Map<String, String> map = new HashMap<>();
        BindingResult bindingResult = exception.getBindingResult();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            String field = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            map.put(field, message);
            log.error("数据校验出现问题 数据问题{} 异常类型{}", exception.getMessage(), exception.getClass());
        });
        return R.error(BizCodeEnum.VALID_EXCEPTION.getCode(), BizCodeEnum.VALID_EXCEPTION.getMessage()).put("data", map);
    }

    /**
     * 所有的异常处理方法
     *
     * @param throwable
     * @return
     */
    @ExceptionHandler(value = Throwable.class)
    public R handleExpection(Throwable throwable) {
        log.error("异常类型{},未知异常{}", throwable.getClass(), throwable.getMessage());
        return R.error(BizCodeEnum.UNKNOW_EXEPTION.getCode(), BizCodeEnum.UNKNOW_EXEPTION.getMessage());
    }
}
