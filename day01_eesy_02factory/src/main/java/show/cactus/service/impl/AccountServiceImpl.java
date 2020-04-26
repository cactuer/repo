package show.cactus.service.impl;/*
 *@ClassName AccountServiceImpl
 *@Author ZengZhiQiang
 *@Date 2020/4/23 21:15
 *@Description 账户的业务层实现类
 */

import show.cactus.dao.IAccountDao;
import show.cactus.dao.impl.AccountDaoImpl;

import show.cactus.factory.BeanFactory;
import show.cactus.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = (IAccountDao)BeanFactory.getBean("accountDao");
    //private int i=1;
    public void saveAccount() {
        int i =1;
        accountDao.saveAccount();
        System.out.println("i="+i);
        i++;
    }
}
