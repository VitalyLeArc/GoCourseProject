package com.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HistoryRecorder {

    @Pointcut("execution(public * com.service.AdvertService.findAll*(..))")
    private void allFindAdvertsMethods(){

    }
}
