//package logging;
//
//
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class SaleTransactionLoggingAspect {
//
//    private static final Logger logger = LoggerFactory.getLogger(SaleTransactionLoggingAspect.class);
//
//    @AfterReturning(pointcut = "execution(* com.quiz._quiz.services.SaleService.updateSaleTransaction(..))", returning = "result")
//    public void logAfterSaleTransactionUpdate(Object result) {
//        logger.info("Sale transaction updated: {}", result);
//    }
//}
//
