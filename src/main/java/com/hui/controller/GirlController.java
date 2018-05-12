package com.hui.controller;

import com.hui.domain.Girl;
import com.hui.domain.Result;
import com.hui.repository.GirlRepository;
import com.hui.service.GirlService;
import com.hui.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by yz on 18/5/5.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultUtil.success(girlRepository.save(girl));
    }

    //查询一个女生
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOnd(@PathVariable("id") Integer id)
    {
        return girlRepository.findById(id).orElse(null);
    }

    //更新
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);

    }

    //删除
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id)
    {
        girlRepository.deleteById(id);
    }

    //通过年龄查询
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age)
    {
        return girlRepository.findByAge(age);
    }


    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

}
