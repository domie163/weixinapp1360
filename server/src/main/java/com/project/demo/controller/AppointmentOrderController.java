package com.project.demo.controller;

import com.project.demo.entity.AppointmentOrder;
import com.project.demo.service.AppointmentOrderService;
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
 * 预约订单：(AppointmentOrder)表控制层
 *
 */
@RestController
@RequestMapping("/appointment_order")
public class AppointmentOrderController extends BaseController<AppointmentOrder, AppointmentOrderService> {

    /**
     * 预约订单对象
     */
    @Autowired
    public AppointmentOrderController(AppointmentOrderService service) {
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
