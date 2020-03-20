package com.bortnichenko.listOfRegions.telda;

import com.bortnichenko.listOfRegions.telda.resource.RegionResource;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MappedTypes(RegionResource.class)
@MapperScan("com.bortnichenko.listOfRegions.telda.mapper")
@SpringBootApplication
public class TeldaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeldaApplication.class, args);
    }

}
