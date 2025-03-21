package com.project.demo.controller;

import com.project.demo.entity.ElderlyUsers;
import com.project.demo.service.ElderlyUsersService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 老人用户：(ElderlyUsers)表控制层
 *
 */
@RestController
@RequestMapping("/elderly_users")
public class ElderlyUsersController extends BaseController<ElderlyUsers, ElderlyUsersService> {

    /**
     * 老人用户对象
     */
    @Autowired
    public ElderlyUsersController(ElderlyUsersService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
