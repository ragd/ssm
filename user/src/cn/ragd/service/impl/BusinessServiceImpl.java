package cn.ragd.service.impl;

import cn.ragd.dao.UserDao;
import cn.ragd.domain.User;
import cn.ragd.exception.UserExistException;
import cn.ragd.service.BusinessService;
import cn.ragd.utils.ServiceUtils;

//��web���ṩ���е�ҵ�����
public class BusinessServiceImpl implements BusinessService {

	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	//��web���ṩע�����
	public void register(User user) throws UserExistException {
		
		//����UserDaoImpl�е�find�������������û��Ƿ��Ѵ���
		boolean b = userDao.find(user.getUsername());
		if(b) {
			throw new UserExistException();
		} else {
			user.setPassword(ServiceUtils.md5(user.getPassword()));
			//����UserDaoImpl�е�add�����������û�
			userDao.add(user);
		}
	}
	
	//��web���ṩ��½����
	public User login(String username, String password) {
		
		password = ServiceUtils.md5(password);
		//����UserDaoImpl�е�find���������û��Ƿ���ע��
		return userDao.find(username, password);
	}
}
