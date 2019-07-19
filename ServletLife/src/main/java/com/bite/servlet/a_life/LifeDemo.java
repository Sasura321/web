package com.bite.servlet.a_life;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet的生命周期
 * service(ServletRequest req, ServletResponse res)
 * init(ServletConfig config)：初始化
 * void destroy()：销毁
 */
@WebServlet(name = "LifeDemo")
public class LifeDemo extends HttpServlet {
    // 无参构造
    public LifeDemo() {
        System.out.println("servlet对象被调用了...");
    }

    /*
     * 用户登录成功之前，应该先初始化一下用户登录次数
     * @throws ServletException
     */
    /*@Override
    public void init() throws ServletException {
        super.init();
    }*/

    /**
     * 初始化
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("servlet被初始化了...");
    }

    /**
     * 服务方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet的业务服务方法被调用了...");
    }

    /**
     * 销毁
     */
    @Override
    public void destroy() {
        System.out.println("servlet被销毁了...");
    }

    /*
    * servlet对象被创建的过程中----其实是一种反射机制
    * 1）tomcat服务器启动的时候---- web.xml中先找到url-pattern:/life
    * 2）再去servlet-mapping-----  servlet-name：life
    * 3）在servlet的配置信息中寻找LifeDemo
    * 4）通过Class的forName("com.bite.servlet.servlet_life.LifeDemo"):字节码文件对象
    */

    /*
    * 伪代码：
    *       // 创建了当前的类对象
    *       Class class = Class.forName("com.bite.servlet.servlet_life.LifeDemo");
    *       // 通过 Constructor 对象：
    *       public Constructor<T> getDeclareConstructor(Class<?>... parameterTypes)
    *       Constructor con = class.getDeclaredConstructor();
    *       Object obj = con.newInstace();
    *
    *       // 加载init方法
    *       public Method getDeclaredMethod(String name, Class<?>... parameterTypes)
    *       Methos m1 = class.getDeclaredMethod("init",ServletConfig.class)
    *       m1.invoke(obj, config);
    *
    *       // 调用服务方法
    *       Method m2 = class.getDeclaredMethod("service", HttpServletRequest.class, HttpServletResponse.class)
    *       m2.invoke(obj, request, response);
    *
    *       ...destory
    *
    *       System.exit(0); //jvm停止运行了
    */

    /*
    * 获取字节码文件对象的方式：
    * 1）Class.forName("包名.类名...")  推荐使用第一种，记载的一种字符串（配置文件中）
    * 2）数据类型的class属性 String.class...
    * 3）Object类中getClass() ----> Class对象
    */
}
