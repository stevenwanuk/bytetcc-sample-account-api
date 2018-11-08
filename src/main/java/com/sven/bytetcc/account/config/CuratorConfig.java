package com.sven.bytetcc.account.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CuratorConfig implements WebMvcConfigurer
{

    @Bean
    public CuratorFramework curatorFramework() throws InterruptedException
    {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder() //
                        .connectString("127.0.0.1:2181") //
                        .sessionTimeoutMs(1000 * 3)
                        .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                        .build();
        curatorFramework.start();
        curatorFramework.blockUntilConnected();
        return curatorFramework;
    }

}
