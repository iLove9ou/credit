package com.credit.gateway;

import com.credit.gateway.impl.ConsumerDubboServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GatewayApplication.class, args);
        ConsumerDubboServiceImpl consumerDubboService = context.getBean(ConsumerDubboServiceImpl.class);
        consumerDubboService.print();
    }
}
