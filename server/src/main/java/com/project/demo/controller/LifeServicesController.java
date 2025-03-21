package com.project.demo.controller;

import com.project.demo.entity.LifeServices;
import com.project.demo.service.LifeServicesService;
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
 * 生活服务：(LifeServices)表控制层
 *
 */
@RestController
@RequestMapping("/life_services")
public class LifeServicesController extends BaseController<LifeServices, LifeServicesService> {

    /**
     * 生活服务对象
     */
    @Autowired
    public LifeServicesController(LifeServicesService service) {
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
