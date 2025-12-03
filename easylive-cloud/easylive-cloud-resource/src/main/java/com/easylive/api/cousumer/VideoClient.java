package com.easylive.api.cousumer;

import com.easylive.entity.constants.Constants;
import com.easylive.entity.po.VideoInfoFile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = Constants.SERVER_NAME_WEB,contextId = "webClientA")
public interface VideoClient {
    @RequestMapping(Constants.INNER_API_PREFIX+"/video/getVideoInfoFileByFileId")
    public VideoInfoFile getVideoInfoFileByFileId(@RequestParam String fileId);
}
