package com.easylive.api.consumer;

import com.easylive.entity.constants.Constants;
import com.easylive.entity.enums.SearchOrderTypeEnum;
import com.easylive.entity.po.UserInfo;
import com.easylive.entity.po.VideoInfo;
import com.easylive.entity.po.VideoInfoPost;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = Constants.SERVER_NAME_WEB,contextId = "webClientB")
public interface VideoClient {

    @GetMapping(Constants.INNER_API_PREFIX + "/user/updateCoinCountInfo")
    Integer updateCoinCountInfo(@RequestParam String userId, @RequestParam Integer count);

    @GetMapping(Constants.INNER_API_PREFIX + "/user/getUserInfoByUserId")
    UserInfo getUserInfoByUserId(@RequestParam String userId);

    /**
     * 通过videoId 获取videoInfo
     *
     * @param videoId
     * @return
     */
    @RequestMapping(Constants.INNER_API_PREFIX + "/video/getVideoInfoByVideoId")
    VideoInfo getVideoInfoByVideoId(@RequestParam String videoId);


    @RequestMapping(Constants.INNER_API_PREFIX + "/video/updateCountInfo")
    Integer updateCountInfo(@RequestParam String videoId, @RequestParam String field,
                            @RequestParam Integer changeCount);


    @RequestMapping(Constants.INNER_API_PREFIX + "/video/getVideoInfoPostByVideoId")
    VideoInfoPost getVideoInfoPostByVideoId(@RequestParam String videoId);


    @RequestMapping(Constants.INNER_API_PREFIX + "/video/updateDocCount")
    void updateDocCount(@RequestParam String videoId,
                        @RequestParam SearchOrderTypeEnum searchOrderTypeEnum, @RequestParam Integer changeCOunt);
}
