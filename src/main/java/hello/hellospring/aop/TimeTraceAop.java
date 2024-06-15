package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component //컴포넌트 스캔 방식으로 AOP를 빈으로 등록
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))") //AOP를 적용할 곳을 설정 가능 -> 얘는 지금 hello.hellospring 하위에 모두 적용
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMS = finish - start;
            System.out.println("END : " + joinPoint.toString() + " " + timeMS + "ms");
        }
    }
}
