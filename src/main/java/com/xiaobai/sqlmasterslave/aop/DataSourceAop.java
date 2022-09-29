package com.xiaobai.sqlmasterslave.aop;

import com.xiaobai.sqlmasterslave.annotation.sourceWith;
import com.xiaobai.sqlmasterslave.config.RoutingDataSourceContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Aspect
@Component
public class DataSourceAop {
    @Around("@annotation(sourceWith)")
    public Object routingWithDataSource(ProceedingJoinPoint joinPoint, sourceWith sourceWith) throws Throwable {
        String key = sourceWith.value();
        if (StringUtils.hasText(key)) {
            key += "DataSource";
        }
        try (RoutingDataSourceContext ctx = new RoutingDataSourceContext(key)) {
            return joinPoint.proceed();
        }
    }
}
