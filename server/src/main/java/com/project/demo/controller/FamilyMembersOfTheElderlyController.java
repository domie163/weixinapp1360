package com.project.demo.controller;

import com.project.demo.entity.FamilyMembersOfTheElderly;
import com.project.demo.service.FamilyMembersOfTheElderlyService;
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
 * 老人家属：(FamilyMembersOfTheElderly)表控制层
 *
 */
@RestController
@RequestMapping("/family_members_of_the_elderly")
public class FamilyMembersOfTheElderlyController extends BaseController<FamilyMembersOfTheElderly, FamilyMembersOfTheElderlyService> {

    /**
     * 老人家属对象
     */
    @Autowired
    public FamilyMembersOfTheElderlyController(FamilyMembersOfTheElderlyService service) {
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
