package com.lb.server_gateway.factory;

import com.lb.server_gateway.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: liuben
 * @date: 2019/9/18
 */
@Configuration
public class BeanFactory {

    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }

}
