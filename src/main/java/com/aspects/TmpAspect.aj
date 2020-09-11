package com.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public aspect TmpAspect {
    //метод из сервисов
    @Pointcut("execution(* *.findAllAdverts(..))")
    private void findAdvertsMethods() {
    }
    //конкретный метод из конкретного контроллера
    @Pointcut("execution(* com.web.AdvertController.getAllAdverts(..))")
    private void allFindAdvertsMethods2() {
    }


    @Before("findAdvertsMethods()")
    public void Test2(JoinPoint joinPoint) {
        log.info("check1");
    }

    @Before("allFindAdvertsMethods2()")
    public void Test3(JoinPoint joinPoint) {
        log.info("check2");
    }



    @Before("findAdvertsMethods()")
    public void getNameUserByAspect(ProceedingJoinPoint pjp, JoinPoint joinPoint) throws Throwable {
        log.info("From aspect 1");
        Object retVal = pjp.proceed();
        System.out.println(retVal);
        System.out.println(joinPoint.getArgs());
        System.out.println(joinPoint.getKind());
        System.out.println(joinPoint.getSignature());
        System.out.println(joinPoint.getSourceLocation());
        System.out.println(joinPoint.getStaticPart());
        System.out.println(joinPoint.getThis().toString());
        System.out.println(joinPoint.getClass().getName());
    }

    @Before("allFindAdvertsMethods2()")
    public void getNameUserByAspect2(ProceedingJoinPoint pjp, JoinPoint joinPoint) throws Throwable {
        log.info("From aspect 2");
        Object retVal = pjp.proceed();
        System.out.println(retVal);
        System.out.println(joinPoint.getArgs());
        System.out.println(joinPoint.getKind());
        System.out.println(joinPoint.getSignature());
        System.out.println(joinPoint.getSourceLocation());
        System.out.println(joinPoint.getStaticPart());
        System.out.println(joinPoint.getThis().toString());
        System.out.println(joinPoint.getClass().getName());
    }
}
