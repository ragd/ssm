package cn.ragd.service;

import cn.ragd.domain.User;
import cn.ragd.exception.UserExistException;

public interface BusinessService {

	//对web层提供注册服务
	void register(User user) throws UserExistException;

	//对web层提供登陆服务
	User login(String username, String password);

}