package cn.ragd.dao;

import cn.ragd.domain.User;

public interface UserDao {

	//�����ݿ��������û�
	void add(User user);

	//�����ݿ��У������û��������룬�����û�
	User find(String username, String password);

	//����ע����û��Ƿ������ݿ��д���
	boolean find(String username);

}