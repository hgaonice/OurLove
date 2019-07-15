7.1 Swagger
7.1.1 Swagger介绍
OpenAPI规范（OpenAPI Specification 简称OAS）是Linux基金会的一个项目，试图通过定义一种用来描述API格
式或API定义的语言，来规范RESTful服务开发过程，目前版本是V3.0，并且已经发布并开源在github上。
（https://github.com/OAI/OpenAPI-Specification）
Swagger是全球最大的OpenAPI规范（OAS）API开发工具框架，支持从设计和文档到测试和部署的整个API生命周
期的开发。 (https://swagger.io/)
Spring Boot 可以集成Swagger，生成Swagger接口，Spring Boot是Java领域的神器，它是Spring项目下快速构建
项目的框架。
7.1.2 Swagger常用注解
在Java类中添加Swagger的注解即可生成Swagger接口，常用Swagger注解如下：
@Api：修饰整个类，描述Controller的作用 @ApiOperation：描述一个类的一个方法，或者说一个接口
@ApiParam：单个参数描述 @ApiModel：用对象来接收参数 @ApiModelProperty：用对象接收参数时，描述对
象的一个字段 @ApiResponse：HTTP响应其中1个描述 @ApiResponses：HTTP响应整体描述 @ApiIgnore：使用
该注解忽略这个API @ApiError ：发生错误返回的信息 @ApiImplicitParam：一个请求参数
@ApiImplicitParams：多个请求参数
@ApiImplicitParam属性：
北京市昌平区建材城西路金燕龙办公楼一层 电话：400-618-9090
属性 取值 作用
paramType 查询参数类型
path 以地址的形式提交数据
query 直接跟参数完成自动映射赋值
body 以流的形式提交 仅支持POST
header 参数在request headers 里边提交
form 以form表单的形式提交 仅支持POST
dataType 参数的数据类型 只作为标志说明，并没有实际验证
Long
String
name 接收参数名
value 接收参数的意义描述
required 参数是否必填
true 必填
false 非必填
defaultValue 默认值
7.1.3 Swagger接口定义
修改接口工程中页面查询接口，添加Swagger注解。
在QueryPageRequest类中使用注解 ApiModelProperty 对属性注释：
@Api(value="cms页面管理接口",description = "cms页面管理接口，提供页面的增、删、改、查")
public interface CmsPageControllerApi {
@ApiOperation("分页查询页面列表")
@ApiImplicitParams({
@ApiImplicitParam(name="page",value = "页
码",required=true,paramType="path",dataType="int"),
@ApiImplicitParam(name="size",value = "每页记录
数",required=true,paramType="path",dataType="int")
})
public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) ;
}
@Data
北京市昌平区建材城西路金燕龙办公楼一层 电话：400-618-9090
7.1.4 Swagger接口测试
Swagger接口生成工作原理：
1、系统启动，扫描到api工程中的Swagger2Configuration类
2、在此类中指定了包路径com.xuecheng，找到在此包下及子包下标记有@RestController注解的controller类
3、根据controller类中的Swagger注解生成接口文档。
启动cms服务工程，查看接口文档，请求：http://localhost:31001/swagger-ui.html
点击“分页查询页面列表”，打开接口详情
public class QueryPageRequest extends RequestData {
//站点id
@ApiModelProperty("站点id")
private String siteId;
//页面ID
@ApiModelProperty("页面ID")
private String pageId;
//页面名称
@ApiModelProperty("页面名称")
private String pageName;
//页面别名
@ApiModelProperty("页面别名")
private String pageAliase;
//模版id
@ApiModelProperty("模版id")
private String templateId;
}
北京市昌平区建材城西路金燕龙办公楼一层 电话：400-618-9090
使用Swagger工具测试服务接口：
1）在cms服务接口中打断点
2）打开接口文档页面，输入请求参数，点击“Try it out”发起请求。


http://localhost:80/swagger-ui.html