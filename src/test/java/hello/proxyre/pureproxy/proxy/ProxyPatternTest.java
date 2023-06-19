package hello.proxyre.pureproxy.proxy;

import hello.proxyre.pureproxy.proxy.code.CacheProxy;
import hello.proxyre.pureproxy.proxy.code.ProxyPatternClient;
import hello.proxyre.pureproxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

public class ProxyPatternTest {

    @Test
    @Description("캐시에서 가져오지 않아서 실행을 여러번 시켜도 똑같은 시간이 발생함")
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    @Description("캐시에서 가져오기 때문에 실행을 여러번 시키면 처음에만 시간이 걸리고 다음부턴 빨리 실행함")
    void cacheProxyTest() {
        RealSubject realSubject = new RealSubject();
        CacheProxy cacheProxy = new CacheProxy(realSubject);
        ProxyPatternClient client = new ProxyPatternClient(cacheProxy);
        client.execute();
        client.execute();
        client.execute();
    }
}
