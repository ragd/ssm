package cn.ragd.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.ragd.dao.UserDao;
import cn.ragd.domain.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
	
	//�����ݿ��������û�
	@Override
	public void add(User user) {
		//�̳�SqlSessionDaoSupport��ͨ��this.getSqlSession()�õ�sqlSession
		SqlSession sqlSession = this.getSqlSession();
		try {
			sqlSession.insert("mybatis.insertUser", user);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//�����ݿ��У������û��������룬�����û�
	@Override
	public User find(String username, String password) {
		SqlSession sqlSession = this.getSqlSession();
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		try {
			User user = sqlSession.selectOne("mybatis.findUser2", u);
			if (user == null) {
				return null;
			}
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//����ע����û��Ƿ������ݿ��д���
	@Override
	public boolean find(String username) {
		SqlSession sqlSession = this.getSqlSession();
		try {
			User user = sqlSession.selectOne("mybatis.findUser1", username);
			if (user == null) {
				return false;
			}
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
