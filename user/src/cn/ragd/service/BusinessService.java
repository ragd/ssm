package cn.ragd.service;

import cn.ragd.domain.User;
import cn.ragd.exception.UserExistException;

public interface BusinessService {

	//��web���ṩע�����
	void register(User user) throws UserExistException;

	//��web���ṩ��½����
	User login(String username, String password);

}