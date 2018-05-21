package com.rs.mybatis.routing;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.rs.mybatis.pojo.BaseDomain;
import com.rs.mybatis.routing.router.DBRouter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description 切面切点 在Router注解的方法执行前执行 切点织入
 */
@Slf4j
@Data
@Aspect
@Component
public class DBRouterInterceptor {

    @Resource
    private DBRouter dbRouter;

    @Pointcut("@annotation( com.rs.mybatis.routing.annotation.Router)")
    public void aopPoint() {
    }

    @Before("aopPoint()")
    public Object doRoute(JoinPoint jp) throws Throwable {
        long t1 = System.currentTimeMillis();
        /*
        Method method = getMethod(jp);
        Router router = method.getAnnotation(Router.class);
        */

        Object[] args = jp.getArgs();
        if (args != null && args.length > 0) {
            if (args[0] instanceof BaseDomain) {
                long userId = ((BaseDomain) args[0]).getUserId();
                dbRouter.doRouteByUserId(userId);
            } else if (args[0] instanceof Long) {
                long userId = (Long) args[0];
                dbRouter.doRouteByUserId(userId);
            }
        }
        log.debug("doRouteTime{}" + (System.currentTimeMillis() - t1));
        return true;
    }

    private Method getMethod(JoinPoint jp) throws NoSuchMethodException {
        Signature sig = jp.getSignature();
        MethodSignature msig = (MethodSignature) sig;
        return jp.getTarget().getClass().getMethod(msig.getName(), msig.getParameterTypes());
    }

}
