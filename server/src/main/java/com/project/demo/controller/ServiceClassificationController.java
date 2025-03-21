package com.project.demo.controller;

import com.project.demo.entity.ServiceClassification;
import com.project.demo.service.ServiceClassificationService;
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
 * 服务分类：(ServiceClassification)表控制层
 *
 */
@RestController
@RequestMapping("/service_classification")
public class ServiceClassificationController extends BaseController<ServiceClassification, ServiceClassificationService> {

    /**
     * 服务分类对象
     */
    @Autowired
    public ServiceClassificationController(ServiceClassificationService service) {
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
