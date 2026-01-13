package com.easylive.task;

import com.easylive.entity.config.RabbitMQConfig;
import com.easylive.entity.po.VideoInfoFilePost;
import com.easylive.service.VideoInfoPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
// 监听转码队列。RabbitMQ 内部会自动管理线程，并发处理任务。
@RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
public class VideoTransferConsumer {

    @Autowired
    private VideoInfoPostService videoInfoPostService;

    /**
     * 该方法替代了原来的 while(true) 轮询逻辑
     */
    @RabbitHandler
    public void handleVideoTransfer(VideoInfoFilePost videoInfoFile) {
        log.info("【MQ消费者】接收到转码任务: videoId={}, fileName={}",
                videoInfoFile.getVideoId(), videoInfoFile.getFileName());

        try {
            // 直接调用原来的核心业务逻辑：下载→转码→切片→上传OSS→回调
            videoInfoPostService.transferVideoFile(videoInfoFile);

            log.info("【MQ消费者】任务处理成功: {}", videoInfoFile.getFileName());
        } catch (Exception e) {
            // 记录异常日志
            log.error("【MQ消费者】处理转码任务失败: {}", videoInfoFile.getFileName(), e);

            // 抛出异常。
            // 配合 application.yml 里的重试配置，Spring 会自动进行任务重试。
            throw new RuntimeException("转码失败，触发重试机制", e);
        }
    }
}