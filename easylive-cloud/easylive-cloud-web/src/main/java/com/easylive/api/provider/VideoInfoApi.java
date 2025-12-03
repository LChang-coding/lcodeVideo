package com.easylive.api.provider;

import com.easylive.component.EsSearchComponent;
import com.easylive.entity.constants.Constants;
import com.easylive.entity.po.VideoInfo;
import com.easylive.entity.po.VideoInfoFile;
import com.easylive.entity.po.VideoInfoPost;
import com.easylive.entity.query.VideoInfoQuery;
import com.easylive.service.VideoInfoFilePostService;
import com.easylive.service.VideoInfoFileService;
import com.easylive.service.VideoInfoPostService;
import com.easylive.service.VideoInfoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(Constants.INNER_API_PREFIX + "/video")
@Validated
public class VideoInfoApi {
    @Resource
    private VideoInfoService videoInfoService;

    @Resource
    private VideoInfoPostService videoInfoPostService;

    @Resource
    private VideoInfoFileService videoInfoFileService;

    @Resource
    private VideoInfoFilePostService videoInfoFilePostService;

    @Resource
    private EsSearchComponent esSearchComponent;
    @RequestMapping("/getVideoInfoByVideoId")
    public VideoInfo getVideoInfo(@NotEmpty String videoId) {
        return videoInfoService.getVideoInfoByVideoId(videoId);
    }

    @RequestMapping("/getVideoInfoPostByVideoId")
    public VideoInfoPost getVideoInfoPost(@NotEmpty String videoId) {
        return videoInfoPostService.getVideoInfoPostByVideoId(videoId);
    }

    @RequestMapping("/updateCountInfo")
    public void updateCountInfo(@NotEmpty String videoId, @NotEmpty String field, @NotNull Integer changeCount) {
        videoInfoService.updateCountInfo(videoId, field, changeCount);
    }

    @RequestMapping("/getVideoCount")
    public Integer getVideoCount(@RequestBody VideoInfoQuery videoInfoQuery) {
        return videoInfoService.findCountByParam(videoInfoQuery);
    }
    @RequestMapping("/getVideoInfoFileByFileId")
    public VideoInfoFile getVideoInfoFileByFileId(@NotEmpty String fileId) {
        VideoInfoFile videoInfoFile = videoInfoFileService.getVideoInfoFileByFileId(fileId);
        return videoInfoFile;
    }

}
