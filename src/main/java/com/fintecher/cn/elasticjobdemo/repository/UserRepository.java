package com.fintecher.cn.elasticjobdemo.repository;

import com.fintecher.cn.elasticjobdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: qijigui
 * @CreateDate: 2019/4/18 14:44
 * @Description:
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
