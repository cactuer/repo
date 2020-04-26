package show.cactus.ui;/*
 *@ClassName Client
 *@Author ZengZhiQiang
 *@Date 2020/4/23 21:20
 *@Description 模拟表现层，调用业务层
 */

import show.cactus.factory.BeanFactory;
import show.cactus.service.IAccountService;
import show.cactus.service.impl.AccountServiceImpl;

public class Client {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            IAccountService as = (IAccountService)BeanFactory.getBean("accountSerive");
            as.saveAccount();
            System.out.println(as);
        }
    }
}
