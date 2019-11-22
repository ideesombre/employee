package tp.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import tp.xml.dummy.DummyAlreadyExistsException;


@Aspect
@Component
public class AspectLogger {

	@After("execution(* tp.xml.dummy.DummyService.get*())")
	public void logAfter() {
		System.out.println("log after is called");
	}
	
	@Before("execution(* tp.xml.dummy.DummyService.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("log before method : "+joinPoint.getSignature().getName());
	}
	
	@AfterThrowing(pointcut="execution(* tp.xml.dummy.DummyService.*(..))", throwing="ex")
	public void logException(Exception ex) {
		System.out.println("Exception is thrown "+ex);
	}
	

	
	@Around("execution(* tp.xml.dummy.DummyService.save*(..))")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Before calling joinPoint");
		long startTime = System.nanoTime();
		Object returnedValue = joinPoint.proceed();
		long endTime = System.nanoTime();
		System.out.println("after calling joinPoint");
		System.out.println(joinPoint.getSignature().getName()+" duration : "+(endTime-startTime)+" ns");
		return returnedValue;
	}
	
}
