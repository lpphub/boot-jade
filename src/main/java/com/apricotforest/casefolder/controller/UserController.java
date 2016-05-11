package com.apricotforest.casefolder.controller;

import com.apricotforest.casefolder.dao.UserDAO;
import com.apricotforest.casefolder.medical.affix.service.AffixService;
import com.apricotforest.casefolder.medical.affix.vo.AffixVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private AffixService affixService;

    @RequestMapping("{id}")
    @ResponseBody
    public List<AffixVo> getOne(@PathVariable("id") String id) {
        System.out.println("测试环境：" + id);
        int uid = userDao.findOne();
        System.out.println(uid);
        List<AffixVo> list = affixService.getAllValidByTimeline(id);
        System.out.println("结果集:" + list.size());
        return list;
    }

    @RequestMapping("/test")
    @ResponseBody
    public Map<String, String> query(String name, HttpServletRequest request) {
        System.out.println(name);
        System.out.println(request.getHeader("Authorization"));
        return new HashMap<>();
    }

}
