package cn.ragd.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.ragd.dao.UserDao;
import cn.ragd.domain.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
	
	//向数据库中增加用户
	@Override
	public void add(User user) {
		//继承SqlSessionDaoSupport，通过this.getSqlSession()得到sqlSession
		SqlSession sqlSession = this.getSqlSession();
		try {
			sqlSession.insert("mybatis.insertUser", user);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//从数据库中，根据用户名和密码，查找用户
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

	//查找注册的用户是否在数据库中存在
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
