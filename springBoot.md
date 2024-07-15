## springboot
### SpringBoot基础回顾
#### 约定优于配置
> Build Anything with Spring Boot: Spring Boot is the starting point for building all Spring-based applications.Spring Boot is designed to get you up and running as quickly as possible，with minimal upfront configuration of spring.

上面是引自官网的一段话，大概是说: SpringBoot是所有基于Spring开发的项目的起点。
SpringBoot的设计是为了让你尽可能快的跑起来Spring应用程序并且尽可能减少你的配置文件。

约定优于配置(Convention over Configuration)，又称按约定编程，是一种软件设计范式。

本质上是说，系统、类库或框架应该假定合理的默认值，而非要求提供不必要的配置。比如说模型中有一个名为User的类，那么数据库中对应的表就会默认命名为user。只有在偏离这一个约定的时候，例如想要将该表命名为person，才需要写有关这个名字的配置。(配置@Table)

比如平时架构师搭建项目就是限制软件开发随便写代码，制定出一套规范，让开发人员按统一的要求进行开发编码测试之类的，这样就加强了开发效率与审查代码效率。所以说写代码的时候就需要按要求命名，这样统一规范的代码就有良好的可读性与维护性了

约定优于配置简单来理解，就是遵循约定
#### SpringBoot概念
##### Spring优缺点分析
- **优点**：
  spring是Java企业版(Java Enterprise Edition，JEE，也称J2EE)的轻量级代替品。无需开发重量级的Enterprise JavaBean(EJB)， Spring为企业级Java开发提供了一种相对简单的方法，通过依赖注入和面向切面编程，用简单的Java对象(Plain Old Java Object,POJO)实现了EJB的功能
- **缺点**:
  虽然Spring的组件代码是轻量级的，但它的配置却是重量级的。一开始，Spring用XML配置，而且是很多XML配置。
  Spring 2.5引入了基于注解的组件扫描，这消除了大量针对应用程序自身组件的显式XML配置。
  Spring3.0引入了基于Java的配置，这是一种类型安全的可重构配置方式，可以代替XML。

所有这些配置都代表了开发时的损耗。因为在思考Spring特性配置和解决业务问题之间需要进行思维切换，所以编写配置挤占了编写应用程序逻辑的时间。
和所有框架一样，Spring实用，但与此同时它要求的回报也不少。

除此之外，项目的依赖管理也是一件耗时耗力的事情。在环境搭建时，需要分析要导入哪些库的坐标，
而且还需要分析导入与之有依赖关系的其他库的坐标，一旦选错了依赖的版本，
随之而来的不兼容问题就会严重阻碍项目的开发进度
##### SpringBoot解决上述spring问题
SpringBoot对上述Spring的缺点进行的改善和优化，基于约定优于配置的思想，可以让开发人员不必在配置与逻辑业务之间进行思维的切换，全身心的投入到逻辑业务的代码编写中，
从而大大提高了开发的效率，一定程度上缩短了项目周期

- 起步依赖
  起步依赖本质上是一个Maven项目对象模型(Project Object Model，POM)，定义了对其他库的传递依赖，这些东西加在一起即支持某项功能。
  
  简单的说，起步依赖就是将具备某种功能的坐标打包到一起，并提供一些默认的功能。自动配置
  
- 自动配置

  springboot的自动配置，指的是springboot，会自动将一些配置类的bean注册进ioc容器，我们可以需要的地方使用@autowired或者@resource等注解来使用它。

  “自动"的表现形式就是我们只需要引我们想用功能的包，相关的配置我们完全不用管，springboot会自动注入这些配置bean，我们直接使用这些bean即可

  springboot:简单、快速、方便地搭建项目;对主流开发框架的无配置集成﹔极大提高了开发、部署效率

#### SpringBoot案例实现

##### 使用Spring Initializer(maven)方式构建Spring Boot项目

本质上说，Spring Initializer是一个Web应用，它提供了一个基本的项目结构，能够帮助我们快速构建一个基础的Spring Boot项目

- pom文件

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <project xmlns="http://maven.apache.org/POM/4.0.0"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
      <modelVersion>4.0.0</modelVersion>
  
      <parent>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-parent</artifactId>
          <version>2.3.11.RELEASE</version>
      </parent>
  
      <groupId>com.pyip</groupId>
      <artifactId>springboot-01-demo</artifactId>
      <version>1.0-SNAPSHOT</version>
      <packaging>war</packaging>
  
      <properties>
          <maven.compiler.source>8</maven.compiler.source>
          <maven.compiler.target>8</maven.compiler.target>
          <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
      </properties>
  
      <dependencies>
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-web</artifactId>
          </dependency>
      </dependencies>
  
      <build>
          <plugins>
              <plugin>
                  <groupId>org.springframework.boot</groupId>
                  <artifactId>spring-boot-maven-plugin</artifactId>
              </plugin>
          </plugins>
      </build>
  
  </project>
  ```

- 测试接口

  ```java
  @RestController
  public class HelloController {
      @RequestMapping("/hello")
      public String sayHello(){
          return "Hello Spring Boot\n";
      }
  }
  ```

- 测试结果

  ![](img/demoResult.png)

#### 单元测试与热部署

- 单元测试

  开发中，每当完成一个功能接口或业务方法的编写后，通常都会借助单元测试验证该功能是否正确。Spring Boot对项目的单元测试提供了很好的支持，在使用时，需要提前在项目的pom.xml文件中添加spring-boot-starter-test测试依赖启动器，可以通过相关注解实现单元测试
  演示:

  - 1．添加spring-boot-starter-test测试依赖启动器
    在项目的pom.xml文件中添加spring-boot-starter-test测试依赖启动器，示例代码如下︰

    ```xml
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-test</artifactId>
                <scope>test</scope>
            </dependency>
    ```

    注意︰使用Spring Initializr方式搭建的Spring Boot项目，会自动加入spring-boot-starter-test测试依赖启动器，无需再手动添加

  - 编写单元测试类和测试方法
    使用Spring Initializr方式搭建的Spring Boot项目，会在src.test.java测试目录下自动创建与项目主程序启动类对应的单元测试类

    ```java
    @SpringBootTest
    @RunWith(SpringRunner.class)
    public class SpringBootDemoTest {
        @Autowired
        private HelloController helloController;
    
        @Test
        public void test01(){
            String result = helloController.sayHello();
            System.out.println(result);// Hello Spring Boot
        }
    }
    ```

- 热部署
  在开发过程中，通常会对一段业务代码不断地修改测试，在修改之后往往需要重启服务，有些服务需要加载很久才能启动成功，这种不必要的重复操作极大的降低了程序开发效率。为此,Spring Boot框架专门提供了进行热部署的依赖启动器，用于进行项目热部署，而无需手动重启项目

  - 演示:1．添加spring-boot-devtools热部署依赖启动器
    在Spring Boot项目进行热部署测试之前，需要先在项目的pom.xml文件中添加spring-boot-devtools热部署依赖启动器:

    ```xml
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-devtools</artifactId>
            </dependency>
    ```

    由于使用的是IDEA开发工具，添加热部署依赖可能没有任何效果，接下来还需要对IDEA开发工具进行热部署相关的功能设置。

  - IDEA工具热部署设置

    file->settings->Build,Execution,Deployment->Compiler,打开Build project automaticlly 然后保存退出 

    在项目任意页面中使用组合快捷键"Ctrl+Shift+Alt+/"打开Maintenance选项框，选中并打开Registry页面，列表中到"compiler.automake.allow.when.app.running"，将该选项后的Value值勾选，用于指定IDEA工具在程序运行过程中自动编译，最后单击【Close】按钮完成设置（IDEA2021及之前）

    file->settings->advanced Settings,勾选Allow Auto-make to start even if developed application is currently running，apply并ok

#### 全局配置文件

全局配置文件能够对一些默认配置值进行修改。

Spring Boot使用一个application.properties或者application.yaml的文件作为全局配置文件，该文件存放在src/main/resource目录或者类路径的/config，一般会选择resource目录。接下来，将针对这两种全局配置文件进行讲解

##### application.properties配置文件

使用Spring Initializr方式构建Spring Boot项目时，会在resource目录下自动生成一个空的application.properties文件，Spring Boot项目启动时会自动加载application.properties文件。
我们可以在application.properties文件中定义Spring Boot项目的相关属性，当然，这些相关属性可以是系统属性、环境变量、命令参数等信息，也可以是自定义配置文件名称和位置

```properties
server.port=80B1
spring.datasource.driver-class-name=com.mysql.jdbc.Driverspring.config.additional-location=
spring.config.location=
spring.config.name=application
```

接下来，通过一个案例对Spring Boot项目中application.properties配置文件的具体使用进行讲解

- 演示:
  预先准备了两个实体类文件，后续会演示将application.properties配置文件中的自定义配置属性注入到Person实体类的对应属性中

  - 先在项目的com.lagou包下创建一个pojo包，并在该包下创建两个实体类Pet和Person

    ```java
    public class Pet {
        private String type;
        private String name;
    }
    @Component // 将person作为bean注册到spring ioc容器中
    @ConfigurationProperties(prefix = "person") // 将配置文件中以person开头的属性注入到类中
    public class Person {
        private int id;
        private String name;
        private List hobby;
        private String[] family;
        private Map map;
        private Pet pet;
    }
    ```

    @ConfigurationProperties(prefix = "person")注解的作用是将配置文件中以person开头的属性值通过setXX()方法注入到实体类对应属性中
    @Component注解的作用是将当前注入属性值的Person类对象作为Bean组件放到Spring容器中，只有这样才能被@ConfigurationProperties注解进行赋值

  - 打开项目的resources目录下的application.properties配置文件，在该配置文件中编写需要对Person类设置的配置属性

    ```properties
    person.id=1
    person.name=tom
    person.hobby=吃饭,睡觉,打六花
    person.family=father,mother
    person.map.k1=v1
    person.map.k2=v2
    person.pet.type=dog
    person.pet.name=旺财
    ```

    编写application.properties配置文件时，由于要配置的Person对象属性是我们自定义的，Spring Boot无法自动识别，所以不会有任何书写提示。在实际开发中，为了出现代码提示的效果来方便配置，在使用@ConfigurationProperties注解进行配置文件属性值注入时，可以在pom.xml文件中添加一个Spring Boot提供的配置处理器依赖:

    ```xml
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-configuration-processor</artifactId>
            </dependency>
    ```

  - 编写测试代码及测试结果

    ```java
        @Autowired
        private Person person;
        @Test
        public void test02(){
            // Person{id=1, name='tom', hobby=[??, ??, ???], family=[father, mother], map={k1=v1, k2=v2}, pet=Pet{type='dog', name='??'}}
            // Person{id=1, name='tom', hobby=[吃饭, 睡觉, 打六花], family=[father, mother], map={k1=v1, k2=v2}, pet=Pet{type='dog', name='旺财'}}
    
            System.out.println(person.toString());
        }
    ```

    编码问题解决方法：

    file->Settings->Editor->File Encodings,设置Project Encoding,Default encoding properties files为uft8,并勾选Transparent native-to-ascii conversion,保存退出。

##### application.yaml配置文件

YAML文件格式是Spring Boot支持的一种JSON超集文件格式，相较于传统的Properties配置文件，YAML文件以数据为核心，是一种更为直观且容易被电脑识别的数据序列化格式。

application.yaml配置文件的工作原理和application.properties是一样的，只不过yaml格式配置文件看起来更简洁一些。

- application.yaml配置文件
  - YAML文件的扩展名可以使用.yml或者.yaml。
  - application.yml文件使用“key:(空格) value"格式配置属性，使用缩进控制层级关系。

- 针对不同数据类型的属性值，介绍一下YAML

  - (1) value值为普通数据类型（例如数字、字符串、布尔等)
    当YAML配置文件中配置的属性值为普通数据类型时，可以直接配置对应的属性值，同时对于字符串类型的属性值，不需要额外添加引号，示例代码如下

    ```yaml
    server:
    port: 8081path : /hello
    ```

    上述代码用于配置server的port和path属性，port和path属于一个级别

  - (2) value值为数组和单列集合
    当YAML配置文件中配置的属性值为数组或单列集合类型时，主要有两种书写方式︰缩进式写法和行内式写法。

- 在Properties配置文件演示案例基础上，使用yaml文件进行开发

  - yaml文件

    ```yaml
    person:
      id: 2
      name: tom
      hobby: [吃饭,睡觉,打六花]
      family: [father,mother]
      map:
        k1: v1
        k2: v2
    #  map: (k1:v1,k2:v2)
      pet:
        name: 旺财
        type: dog
    ```

  - 运行结果

    ```java
    // Person{id=2, name='tom', hobby=[吃饭, 睡觉, 打六花], family=[father, mother], map={k1=v1, k2=v2}, pet=Pet{type='dog', name='旺财'}}
        @Test
        public void test02(){
            System.out.println(person.toString());
        }
    
    ```

    可以看出，测试方法test02()同样运行成功，并正确打印出了Person实体类对象。
    需要说明的是，本次使用application.yaml配置文件进行测试时需要提前将application.properties配置文件编写的配置注释，这是因为application.properties配置文件会覆盖application.yaml配置文件

#### 配置文件属性值的注入

- 使用Spring Boot全局配置文件设置属性时:
  - 如果配置属性是Spring Boot已有属性，例如服务端口server.port，那么Spring Boot内部会自动扫描并读取这些配置文件中的属性值并覆盖默认属性。
  - 如果配置的属性是用户自定义属性，例如刚刚自定义的Person实体类属性，还必须在程序中注入这些配置属性方可生效。
  - Spring Boot支持多种注入配置文件属性的方式，下面来介绍如何使用注解@ConfigurationProperties和@value注入属性

##### 使用@ConfigurationProperties注入属性
Spring Boot提供的@ConfigurationProperties注解用来快速、方便地将配置文件中的自定义属性值批量注入到某个Bean对象的多个对应属性中。假设现在有一个配置文件，如果使用@ConfigurationProperties注入配置文件的属性，示例代码如下:

```java
@component
@configurationProperties(prefix ="person")
public class Person {
    private int id;/属性的setxx()方法
    public void setId(int id) i
    this.id = id;
}
```

上述代码使用@Component和@ConfigurationProperties(prefix = "person")将配置文件中的每个属性映射到person类组件中。
需要注意的是，使用@ConfigurationProperties

##### 使用@Value注入属性

@Value注解是Spring框架提供的，用来读取配置文件中的属性值并逐个注入到Bean对象的对应属性中，Spring Boot框架从Spring框架中对@Value注解进行了默认继承，所以在Spring Boot框架中还可以使用该注解读取和注入配置文件属性值。

使用@Value注入属性的示例代码如下

```java
@component
public class Person{
    @value("${person.id}")
	private int id;
)
```

上述代码中，使用@Component和@value注入Person实体类的id属性。其中，@Value不仅可以将配置文件的属性注入Person的id属性，还可以直接给id属性赋值，这点是@ConfigurationProperties不支持的

- 演示@Value注解读取并注入配置文件属性的使用:

  - 创建一个实体类Student，并使用@value注解注入属性

    ```java
    @Component
    public class Student {
        @Value("3")
        private int id;
        @Value("${person.name}")
        private String name;
        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    ```

  - 打开测试类进行测试及测试结果

    ```java
        @Autowired
        private Student student;
        @Test
        public void test03(){
            // Student{id=3, name='tom'}
            System.out.println(student.toString());
        }
    ```

    可以看出，测试方法test03()运行成功，同时正确打印出了Student实体类对象。

    需要说明的是，本示例中只是使用@Value注解对实例中Student对象的普通类型属性进行了赋值演示，而**@Value注解对于包含Map集合、对象以及YAML文件格式的行内式写法的配置文件的属性**注入都不支持，如果赋值会出现错误

#### 自定义配置

​    spring Boot免除了项目中大部分的手动配置，对于一些特定情况，我们可以通过修改全局配置文件以适应具体生产环境，可以说，几乎所有的配置都可以写在application.peroperties文件中，Spring Boot会自动加载全局配置文件从而免除我们手动加载的烦恼。

但是，如果我们自定义配置文件，Spring Boot是无法识别这些配置文件的，此时就需要我们手动加载。接下来，将针对Spring Boot的自定义配置文件及其加载方式进行讲解

##### 使用@Propertysource加载配置文件

​    对于这种加载自定义配置文件的需求，可以使用@PropertySource注解结合@Configuration注解配置类的方式来实现。@PropertySource注解用于指定自定义配置文件的具体位置和名称。同时，为了保证Spring Boot能够扫描该注解，还需要类上添加@Configuration注解将实体类作为自定义配置类。

​     当然，如果需要将自定义配置文件中的属性值注入到对应类的属性中，可以使用@ConfigurationProperties或者@Value注解进行属性值注入

- 演示:

  - (1)打开Spring Boot项目的resources目录，在项目的类路径下新建一个test.properties自定义配置文件，在该配置文件中编写需要设置的配置属性

    ```properties
    #对实体类对象MyProperties进行属性配置
    test.id=110
    test.name=test
    ```

  - (2）在pojo包下新创建一个配置类MyProperties，提供test.properties自定义配置文件中对应的属性,并根据@PropertySource注解的使用进行相关配置

    ```java
    @configuration //自定义配置类
    @PropertySource ("classpath:test.properties")//指定自定义配置文件位置和名称
    @EnableConfigurationProperties(MyProperties.class)//开启对应配置类的属性注入功能
    @ConfigurationProperties(prefix = "test")//指定配置文件注入属性前缀
    public class MyProperties {
        private int id;
        private String name ;
        //省略属性getxx()和setxx()方法
        //省略toString()方法
    }
    ```

  - 代码测试及其结果

    ```java
    @Autowired
    private MyProperties myProperties;
    @Test
        public void test04(){
            // MyProperties{id=110, name='test'}
            System.out.println(myProperties);
        }
    public class Myservice i)
    ```

##### 使用@Configuration编写自定义配置类

​     在Spring Boot框架中，推荐使用配置类的方式向容器中添加和配置组件

​     在Spring Boot框架中，通常使用@Configuration注解定义一个配置类，Spring Boot会自动扫描和识别配置类，从而替换传统Spring框架中的XML配置文件。

​     当定义一个配置类后，还需要在类中的方法上使用@Bean注解进行组件配置，将方法的返回对象注入到Spring容器中，并且组件名称默认使用的是方法名，当然也可以使用@Bean注解的name或value属性自定义组件的名称

- 演示：

  - 在项目下新建一个config包，并在该包下新创建一个类MyService，该类中不需要编写任何代码

    ```java
    public class MyService{
    }
    ```

    创建了一个空的MyService类，而该类目前没有添加任何配置和注解，因此还无法正常被Spring Boot扫描和识别

  - 在项目的config包下，新建一个类MyConfig，并使用@Configuration注解将该类声明一个配置类，内容如下:

    ```java
    @configuration //定义该类是一个配置类
    public class Myconfig {
         //将返回的值对象作为组件添加到Spring容器中，该组件id默认为方法名
        @Bean(name = "iService")
        public MyService myservice( ){
        	return new MyService();
        }
    }
    ```

    MyConfig是@Configuration注解声明的配置类（类似于声明了一个XML配置文件)，该配置类会被Spring Boot自动扫描识别;使用@Bean注解的myService()方法，其返回值对象会作为组件添加到了Spring容器中(类似于XML配置文件中的<bean>标签配置)，并且该组件的id默认是方法名myService

  - 测试及其结果

    ```java
    	@Autowired
        private MyService myService;
        @Autowired
        private ApplicationContext context;
    
        @Test
        public void test05(){
            // com.pyip.springboot01.config.MyService@776802b0
            System.out.println(myService);
        }
        @Test
        public void test06(){
            // true
            System.out.println(context.containsBean("iService"));
        }
    ```

    

#### 随机数设置及参数间引用

​    在Spring Boot配置文件中设置属性时，除了可以像前面示例中显示的配置属性值外，还可以使用随机值和参数间引用对属性值进行设置。

​	下面，针对配置文件中这两种属性值的设置方式进行讲解
##### 随机值设置

​	在Spring Boot配置文件中，随机值设置使用到了Spring Boot内嵌的RandomValuePropertySource类，对一些隐秘属性值或者测试用例属性值进行随机值注入

​	随机值设置的语法格式为${random.xx}，xx表示需要指定生成的随机数类型和范围，它可以生成随机的整数、uuid或字符串,示例代码如下

```properties
my.secret=${random.value}//配置随机值
my.number=${random.int} //配置随机整数
my.bignumber=${random.long)/配置随机long类型数my.uuid=${random.uuid} //配置随机uuid类型数
my.number.less.than.ten=${random.int(10)} //配置小于10的随机整数
my . number.in.range=${random.int [1024,65536]} #配置范围在[1024,65536]之间的随机整数
```

​	上述代码中，使用RandomValuePropertySource类中random提供的随机数类型，分别展示了不同类型随机值的设置示例
##### 参数间引用

​	在Spring Boot配置文件中，配置文件的属性值还可以进行参数间的引用，也就是在后一个配置的属性值中直接引用先前已经定义过的属性，这样可以直接解析其中的属性值了。
​	使用参数间引用的好处就是，在多个具有相互关联的配置属性中，只需要对其中一处属性预先配置，其他地方都可以引用,省去了后续多处修改的麻烦
​	参数间引用的语法格式为${xx}，xx表示先前在配置文件中已经配置过的属性名，示例代码如下

参数间引用的语法格式为${xx}，xx表示先前在配置文件中已经配置过的属性名，示例代码如下

```properties
app.name=MyApp
app.description=${app.name} is a spring Boot application
```

​	上述参数间引用设置示例中，先设置了"app.name=MyApp"，将app.name属性的属性值设置为了MyApp;接着，在app.description属性配置中，使用${app.name}对前一个属性值进行了引用。
​	接下来，通过一个案例来演示使用随机值设置以及参数间引用的方式进行属性设置的具体使用和效果，具体步骤如下

- 演示

  - (1)打开Spring Boot项目resources目录下的application.properties配置文件，在该配置文件中分别通过随机值设置和参数间引用来配置两个测试属性，示例代码如下

    ```properties
    #随机值设置以及参数间引用配置
    tom.age=${random.int[10,20]}
    tom.description=tom的年龄可能是${tom.age}
    ```

    在上述application.properties配置文件中，先使用随机值设置了tom.age属性的属性值，该属性值设置在了[10,20]之间，随后使用参数间引用配置了tom.description属性

  - 打开\项目的测试类，在该测试类中新增字符串类型的description属性，并将配置文件中的tom.description属性进行注入，然后新增一个测试方法进行输出测试，示例代码如下

    ```java
        @Value("${tom.description}")
        private String description;
        @Test
        public void test07(){
            // tom的年龄可能是15
            System.out.println(description);
        }
    ```

    上述代码中，通过@Value("$tom.description}")注解将配置文件中的tom.description属性值注入到了对应的description属性中，在测试方法placeholderTest()中对该属性值进行了输出打印。

    

  - 




(2）



### SpringBoot原理深入及源码剖析
#### 依赖管理
#### 自动配置（启动流程）
#### 自定义Starter
#### 执行原理

### SpringBoot数据访问
#### SpringBoot整合MyBatis
#### SpringBoot整合JPA
#### SpringBoot整合Redis

### SpringBoot视图技术
#### 支持的视图技术
#### Thymeleaf
##### Thymeleaf语法
##### 基本使用
##### 完成数据的页面展示 
##### 配置国际化页面

### SpringBoot缓存管理
#### 默认缓存管理
#### 自定义Redis缓存序列化机制
##### 自定义RedisTemplate
##### 自定义RedisCacheManager