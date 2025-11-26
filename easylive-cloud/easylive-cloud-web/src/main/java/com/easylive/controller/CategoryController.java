package com.easylive.controller;

import com.easylive.api.consumer.CategoryClient;
import com.easylive.entity.constants.Constants;
import com.easylive.entity.vo.ResponseVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Validated
@RestController
@RequestMapping("/category")
public class CategoryController extends ABaseController {
    @Resource
    private CategoryClient categoryClient;

    @RequestMapping("/loadAllCategory")
     public ResponseVO loadAllCategory() {
      return getSuccessResponseVO(categoryClient.loadAllCategory());

    }

}
