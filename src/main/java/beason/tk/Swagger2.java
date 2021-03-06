package beason.tk;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/** 
 * localhost:8081/swagger-ui.html
 * Created by shu.xinghu on 2018/6/28.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket webApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("接口文档")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("beason.tk.controller"))
                .paths(PathSelectors.any()).build();
    }
    @Bean
    public Docket webApi1(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("aba")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("beason.tk.controller"))
                .paths(PathSelectors.any()).build();
    }

    /**
     swagger2使用说明：
     @Api：用在类上，说明该类的作用
     @ApiOperation：用在方法上，说明方法的作用
     @ApiIgnore：使用该注解忽略这个API
     @ApiImplicitParams：用在方法上包含一组参数说明
     @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
     paramType：参数放在哪个地方
     header-->请求参数的获取：@RequestHeader
     query-->请求参数的获取：@RequestParam
     path（用于restful接口）-->请求参数的获取：@PathVariable
     body（不常用）
     form（不常用）
     name：参数名
     dataType：参数类型
     required：参数是否必须传
     value：参数的意思
     defaultValue：参数的默认值
     code：数字，例如400
     message：信息，例如"请求参数没填好"
     response：抛出异常的类
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Demo使用Swagger2构建RESTful APIs")
                .description("微信打卡服务")
                .contact(new Contact("shuxinghu", "http://petstore.swagger.io/v2/swagger.json", "beasonshu@sina.com"))
                .version("1.0")
                .build();
    }
}
