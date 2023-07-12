package ru.smartjava.springbootparameters.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.smartjava.springbootparameters.impl.DevProfile;
import ru.smartjava.springbootparameters.impl.ProductionProfile;
import ru.smartjava.springbootparameters.interfaces.SystemProfile;

@Configuration
public class BeanConfigs {

    @Bean
    @ConditionalOnProperty(prefix = "smartjava", name = "profile.dev", havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(prefix = "smartjava", name = "profile.dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
