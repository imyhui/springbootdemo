package com.hui.service;

import com.hui.domain.Girl;
import com.hui.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by yz on 18/5/6.
 */
@Service
public class GirlService {


    @Autowired
    private GirlRepository girlRepository;

    @org.springframework.transaction.annotation.Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(17);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(18);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findById(id).orElse(null);
        Integer age = girl.getAge();
        if(age < 10) {
            //返回"小学"
            throw new Exception("小学");
        } else if (age > 10 && age < 16) {
            //返回"初中"
            throw new Exception("初中");
        }

        // 大于16 加钱

    }
}
