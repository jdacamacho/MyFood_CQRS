package com.unicauca.my_food.infrastucture;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mapper {
    @Bean
    public ModelMapper createMapper(){
        return new ModelMapper();
    }
}
