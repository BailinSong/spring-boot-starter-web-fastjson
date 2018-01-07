# Spring boot web fastjson
## 描述 Description
* 使用 Fastjson 替换原默认 Jackson 作为 Http 请求与返回的 序列化工具类。<br>
Use Fastjson to replace the serialized utility class that was originally default Jackson as Http request and return.

* 使用Spring auto configuration 机制,你可以将此包添加入Maven依赖即可完成自动替换，无需对现有代码进行更改。<br>
Using the Spring auto configuration mechanism, you can add this package to Maven dependencies to complete automatic substitution without having to make changes to existing code.

* FastJson默认使用UTF-8字符集进行编码，如需要修改可以在Application配置中添加相关定义。<br>
Fast Json use the utf-8 character set by default to code, and you can add the relevant definitions in the Application configuration if you need to modify it.

## 例子 Example

application.yml:
```yaml
fastjson:
    charset: UTF-8
```

application.properties:
```properties
fastjson.charset=UTF-8
```

pom.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://maven.apache.org/POM/4.0.0">
    
    <parent>
        <artifactId>spring-boot</artifactId>
        <groupId>com.blueline</groupId>
        <version>Camden.RELEASE</version>
    </parent>
    
    <modelVersion>4.0.0</modelVersion>
    
    <artifactId>web-fastjson-example</artifactId>
    
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>    
        <dependency>
            <groupId>com.blueline</groupId>
            <artifactId>spring-boot-starter-web-fastjson</artifactId>
            <version>1.0.0.RELEASE</version>
        </dependency>
    </dependencies>
</project>
```