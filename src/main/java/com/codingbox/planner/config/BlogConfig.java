package com.codingbox.planner.config;

//import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlogConfig {


    //Entity-DTO 간 변환
    /*@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }*/
    @Bean
    public UploadFileUtil uploadFileUtil(){
        return new UploadFileUtil(uploadPath());
    }

    //파일 저장될 절대 경로(로컬)
    @Bean(name = "uploadPath")
    public String uploadPath() {
        return System.getProperty("user.dir")+"/src/main/resources/static/assets";
    }

}
