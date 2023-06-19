package hello.proxyre.config.v1_proxy;

import hello.proxyre.app.v2.OrderControllerV2;
import hello.proxyre.app.v2.OrderRepositoryV2;
import hello.proxyre.app.v2.OrderServiceV2;
import hello.proxyre.config.v1_proxy.concrete_proxy.OrderControllerConcreteProxy;
import hello.proxyre.config.v1_proxy.concrete_proxy.OrderServiceConcreteProxy;
import hello.proxyre.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcreteProxyConfig {

    @Bean
    public OrderControllerV2 orderControllerV2(LogTrace logTrace) {
        OrderControllerV2 controllerImpl = new OrderControllerV2(orderServiceV2(logTrace));
        return new OrderControllerConcreteProxy(controllerImpl, logTrace);
    }

    @Bean
    public OrderServiceV2 orderServiceV2(LogTrace logTrace) {
        OrderServiceV2 serviceImpl = new OrderServiceV2(orderRepositoryV2());
        return new OrderServiceConcreteProxy(serviceImpl, logTrace);
    }

    @Bean
    public OrderRepositoryV2 orderRepositoryV2() {
        return new OrderRepositoryV2();
    }
}
