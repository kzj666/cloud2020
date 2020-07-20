package com.kk.myrule;

/*
@author kzj
@date 2020/7/15 - 9:33
*/

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {
   @Bean
    public IRule myRule(){
       return new RandomRule();
   }
}
