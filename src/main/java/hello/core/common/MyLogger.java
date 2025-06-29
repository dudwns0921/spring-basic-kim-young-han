package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Setter
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void log(String message) {
        System.out.println("[" + uuid + "] " + requestURL + " " + message);
    }

    @PostConstruct
    public void init() {
        System.out.println("MyLogger.init " + this);
        uuid = java.util.UUID.randomUUID().toString();
    }

    @PreDestroy
    public void close() {
        System.out.println("MyLogger.close " + this);
        System.out.println("MyLogger uuid = " + uuid);
        System.out.println("MyLogger requestURL = " + requestURL);
    }
}
