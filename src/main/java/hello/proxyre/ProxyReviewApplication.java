package hello.proxyre;

import hello.proxyre.config.v1_proxy.ConcreteProxyConfig;
import hello.proxyre.config.v1_proxy.InterfaceProxyConfig;
import hello.proxyre.trace.logtrace.FieldLogTrace;
import hello.proxyre.trace.logtrace.LogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(InterfaceProxyConfig.class)
@SpringBootApplication(scanBasePackages = "hello.proxyre.app") //주의
public class ProxyReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyReviewApplication.class, args);
    }

    @Bean
    public LogTrace logTrace() {
        return new FieldLogTrace();
    }
}
