package com.project.demo.controller;

import com.project.demo.entity.ServiceProvider;
import com.project.demo.service.ServiceProviderService;
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
 * 服务商：(ServiceProvider)表控制层
 *
 */
@RestController
@RequestMapping("/service_provider")
public class ServiceProviderController extends BaseController<ServiceProvider, ServiceProviderService> {

    /**
     * 服务商对象
     */
    @Autowired
    public ServiceProviderController(ServiceProviderService service) {
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
