package com.stone.springboot.control;

import com.stone.springboot.Service.EmpService;
import com.stone.springboot.bean.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author stone
 * @date 2019/7/11 14:24
 * description
 */
@RestController
public class EmpControl {

    @Autowired
    EmpService empService;

    @GetMapping("/emp/{id}")
    public Emp selectEmp(@PathVariable("id") Integer id){
        return empService.selectEmp(id);
    }

    @GetMapping("/emp")
    public Emp updateEmp(Emp emp){
        return empService.updateEmp(emp);
    }

    @GetMapping("/delemp")
    public String deleteEmp(Integer id){
        empService.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/lastname/{lastName}")
    public Emp selectEmpByLastName(@PathVariable("lastName") String lastName){
        return empService.selectEmpByLastName(lastName);
    }
}
