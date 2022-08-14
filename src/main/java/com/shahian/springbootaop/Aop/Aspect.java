package com.shahian.springbootaop.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {
        @Pointcut("execution(public void com.shahian.springbootaop.Service.BusinessService.saveEmployee())")
    public void p1(){

    }
    @Pointcut("execution(public String com.shahian.springbootaop.Service.BusinessService.helloEmployye())")
    public void p2() {

    }


    @Pointcut("execution(* com.shahian.springbootaop.Service.BusinessService.testMethodforAroundAdvice())")
    public void p4() {

    }

    @Before("p1()")
    public void beginTransaction() {
        System.out.println("Transaction begins !");
    }

    @After("p1()")
    public void completeTransaction() {
        System.out.println("Transaction completes !");
    }

    @AfterReturning("p1()")
    public void commitTransaction() {
        System.out.println("Transaction committed !");
    }

    @AfterThrowing("p1()")
    public void rollbackTransaction() {
        System.out.println("Transaction rolled back !");
    }

    @AfterReturning(value="p2()", returning = "obj")
    public void getAdviceReturnValue(Object obj) {
        System.out.println("Returning Value is : "+obj);
    }

    @AfterThrowing(value="p1()", throwing = "th")
    public void rollbackTransactionGetMessage(Throwable th) {
        System.out.println("Transaction rolled back ! Message from method : "+th);
    }


    @Around("p4()")
    public void testAroundAdvice(ProceedingJoinPoint pj) throws Throwable {

        System.out.println("Executing Before part of business method");

        pj.proceed();  // this code will call business method

        System.out.println("Executing After part of business method");
    }
    @Before(value = "execution(* com.shahian.springbootaop.Service.BusinessService.*(..)) and args(name,empId)")
    public void beforeAdvice(JoinPoint joinPoint, String name, String empId) {
        System.out.println("Before method:" + joinPoint.getSignature());

        System.out.println("Creating Employee with name - " + name + " and id - " + empId);
    }

    @After(value = "execution(* com.shahian.springbootaop.Service.BusinessService.*(..)) and args(name,empId)")
    public void afterAdvice(JoinPoint joinPoint, String name, String empId) {
        System.out.println("After method:" + joinPoint.getSignature());

        System.out.println("Successfully created Employee with name - " + name + " and id - " + empId);
    }
}
