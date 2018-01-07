package com.blueline.spring.boot.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
@ConditionalOnClass(JSON.class)
@EnableConfigurationProperties(FastJsonProperties.class)
public class FastJsonAutoConfiguration {

    @Autowired
    FastJsonProperties fastJsonProperties;

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverter(){
        Charset charset = fastJsonProperties.getCharSetInstance();
        FastJsonHttpMessageConverter jsonConverter=new FastJsonHttpMessageConverter();
        FastJsonConfig config=new FastJsonConfig();
        config.setCharset(charset);
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
        List<MediaType> mediaTypes = new ArrayList<MediaType>();
        mediaTypes.add(new MediaType(MediaType.APPLICATION_JSON, charset));
        jsonConverter.setSupportedMediaTypes(mediaTypes);
        jsonConverter.setFastJsonConfig(config);
        return new HttpMessageConverters((HttpMessageConverter<?>) jsonConverter);
    }
}
