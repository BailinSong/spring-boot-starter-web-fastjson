package com.blueline.spring.boot.fastjson;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.charset.Charset;

@ConfigurationProperties(prefix = "fastjson")
public class FastJsonProperties {

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    String charset = "UTF-8";

    public Charset getCharSetInstance(){
        return Charset.forName(getCharset());
    }

}
