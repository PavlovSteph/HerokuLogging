package com.gcu.util;


import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.springframework.aop.interceptor.AbstractMonitoringInterceptor;

public class Tracer extends AbstractMonitoringInterceptor {
    private static final long serialVersionUID = -5378974652504403928L;

    public Tracer() {
    }

    // use the dynamic Spring logger
    public Tracer(boolean useDynamicLogger) {
        setUseDynamicLogger(useDynamicLogger);
    }

    @Override
    protected Object invokeUnderTrace(MethodInvocation invocation, Log log) throws Throwable {
        // Get the method name to log
        String name = createInvocationTraceName(invocation);

        // Log the method entry at INFO level
        log.info("Entering method: " + invocation.getThis().getClass().getName() + "." + name);

        long start = System.currentTimeMillis();
        try {
        	
            // Proceed with the method invocation
            return invocation.proceed();
        } catch (Throwable ex) {
        	
            // Log any exceptions thrown in the method at ERROR level
            log.error("Exception in method: " + invocation.getThis().getClass().getName() + "." + name + ": " + ex.getMessage(), ex);
            // throw the exception after logging it
            throw ex; 
        } finally {
            long end = System.currentTimeMillis();
            long time = end - start;

            // Log method exit at INFO level with execution time
            log.info("Exiting method: " + invocation.getThis().getClass().getName() + "." + name + " with execution time: " + time + " ms");

            // Log a warning if method execution time exceeds 10 ms
            if (time > 10) {
                log.warn("Method " + name + " execution took longer than 10 ms");
            }
        }
    }


}
