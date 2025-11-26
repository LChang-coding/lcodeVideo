package com.easylive.api.provider;

import com.easylive.entity.constants.Constants;
import com.easylive.entity.po.CategoryInfo;
import com.easylive.service.CategoryInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(Constants.INNER_API_PREFIX+"/category")
public class CategoryApi {

    @Resource
    private CategoryInfoService categoryInfoService;
    @RequestMapping("/loadAllCategory")
    public List<CategoryInfo> loadAllCategory() {

        return categoryInfoService.getAllCategoryList();
    }
}
