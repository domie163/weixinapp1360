package com.project.demo.controller;

import com.project.demo.entity.IndividualPayment;
import com.project.demo.service.IndividualPaymentService;
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
 * 个人缴费：(IndividualPayment)表控制层
 *
 */
@RestController
@RequestMapping("/individual_payment")
public class IndividualPaymentController extends BaseController<IndividualPayment, IndividualPaymentService> {

    /**
     * 个人缴费对象
     */
    @Autowired
    public IndividualPaymentController(IndividualPaymentService service) {
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
