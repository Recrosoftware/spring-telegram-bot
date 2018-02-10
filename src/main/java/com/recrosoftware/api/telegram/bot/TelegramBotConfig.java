package com.recrosoftware.api.telegram.bot;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.ws.rs.ApplicationPath;
import java.util.concurrent.Executor;

@EnableAsync
@Configuration
@ComponentScan("com.recrosoftware.api.telegram.bot")
@ApplicationPath("/rs-telegram-api/bot")
class TelegramBotConfig extends ResourceConfig implements ImportAware {
    TelegramBotConfig() {
        register(WebHookUpdaterEP.class);
    }

    @Value("${config.telegram.bots.core-pool-size:32}")
    private Integer corePoolSize;


    @Bean(name = "telegramAsyncExecutor")
    public Executor getTelegramAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(corePoolSize);
        taskExecutor.setQueueCapacity(0);
        taskExecutor.setThreadNamePrefix("TgBot-");
        taskExecutor.initialize();

        return taskExecutor;
    }

    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {
    }
}
