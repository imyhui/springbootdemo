package com.hui.repository;

import com.hui.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by yz on 18/5/5.
 */
public interface GirlRepository extends JpaRepository<Girl, Integer>{

    //通过年龄查询
    public List<Girl> findByAge(Integer age);
}
