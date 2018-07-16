package cn.ddssst.wuliao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@MapperScan("cn.ddssst.wuliao.mapper")
@ComponentScan("cn.ddssst.wuliao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}