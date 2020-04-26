package show.cactus.factory;/*
 *@ClassName BeanFactory
 *@Author ZengZhiQiang
 *@Date 2020/4/23 21:24
 *@Description 创建Bean对象的工厂
 Bean 在计算机英语中表示可重用组件
 Java Bean >> 实体类
 JavaBean 用java语言编写的可重用组件
 第一步：需要一个配置文件(xml或者properties)
            配置的内容：唯一标识=全限定类名（key=value）
 第二步：读取配置文件中的配置内容,反射创建对象
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    //定义一个properties对象
    private static Properties props;

    //定义一个Map，用于存放对象,我们称之为容器
    private static Map<String,Object> beans;

    //使用静态代码块为properties对象赋值
    static {
        try {
            props = new Properties();
            InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("Bean.properties");
            props.load(is);

            //实例化容器
            beans = new HashMap<String, Object>();
            Enumeration keys = props.keys();
            //遍历枚举类型
            while (keys.hasMoreElements()){
                String key = keys.nextElement().toString();
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存进容器
                beans.put(key,value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }

    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }

    /*
     * @Param getBean
     * @Description 根据Bean名称获取Bean对象
     * */
   /* public static Object getBean(String beanName){
        Object bean =null;
        try{
            String beanPath = props.getProperty(beanName);
            //System.out.println(beanPath);
        bean = Class.forName(beanPath).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }*/
}
