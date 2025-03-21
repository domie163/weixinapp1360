package com.project.demo.controller;

import com.project.demo.entity.ElderlyInsurancePayment;
import com.project.demo.service.ElderlyInsurancePaymentService;
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
 * 老人保险缴费：(ElderlyInsurancePayment)表控制层
 *
 */
@RestController
@RequestMapping("/elderly_insurance_payment")
public class ElderlyInsurancePaymentController extends BaseController<ElderlyInsurancePayment, ElderlyInsurancePaymentService> {

    /**
     * 老人保险缴费对象
     */
    @Autowired
    public ElderlyInsurancePaymentController(ElderlyInsurancePaymentService service) {
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
