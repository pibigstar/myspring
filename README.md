# spring框架核心

### SpringMVC的运行流程
      
1.用户发送请求至前端控制器DispatcherServlet

2.DispatcherServlet收到请求调用HandlerMapping处理器映射器。

3.处理器映射器根据请求url找到具体的处理器，生成处理器对象及处理器拦截器(如果有则生成)一并返回给DispatcherServlet。

4.DispatcherServlet通过HandlerAdapter处理器适配器调用处理器

5.执行处理器(Controller，也叫后端控制器)。

6.Controller执行完成返回ModelAndView

7.HandlerAdapter将controller执行结果ModelAndView返回给DispatcherServlet

8.DispatcherServlet将ModelAndView传给ViewReslover视图解析器

9.ViewReslover解析后返回具体View

10.DispatcherServlet对View进行渲染视图（即将模型数据填充至视图中）。

11.DispatcherServlet响应用户。

### spring运行原理

1.读取配置文件
> 为了读取web.xml中的配置，我们用到ServletConfig这个类，它代表当前Servlet在web.xml中的配置信息。通过web.xml中加载我们自己写的MyDispatcherServlet和读取配置文件。

2.初始化阶段
> 在前面我们提到DispatcherServlet的initStrategies方法会初始化9大组件，但是这里将实现一些SpringMVC的最基本的组件而不是全部，按顺序包括：
- 加载配置文件
- 扫描用户配置包下面所有的类
- 拿到扫描到的类，通过反射机制，实例化。并且放到ioc容器中(Map的键值对  beanName-bean) - beanName默认是首字母小写
- 初始化HandlerMapping，这里其实就是把url和method对应起来放在一个k-v的Map中,在运行阶段取出

3.运行阶段
>每一次请求将会调用doGet或doPost方法，所以统一运行阶段都放在doDispatch方法里处理，它会根据url请求去HandlerMapping中匹配到对应的Method，然后利用反射机制调用Controller中的url对应的方法，并得到结果返回。按顺序包括以下功能：
- 异常的拦截
- 获取请求传入的参数并处理参数
- 通过初始化好的handlerMapping中拿出url对应的方法名，反射调用