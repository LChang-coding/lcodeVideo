package com.easylive.entity.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    // 交换机名称
    public static final String EXCHANGE_NAME = "video_exchange";
    // 队列名称
    public static final String QUEUE_NAME = "video_queue";

    /**
     * 1. 配置消息转换器 (关键步骤)
     * 使用 Jackson 将消息序列化为 JSON。
     * 传入 ObjectMapper 是为了复用 Spring Boot 的全局配置（比如日期格式 yyyy-MM-dd HH:mm:ss）
     */
    @Bean
    public MessageConverter jackson2JsonMessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    /**
     * 声明主题交换机（Topic Exchange）
     */
    @Bean
    public Exchange orderExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }

    /**
     * 声明持久化队列
     */
    @Bean
    public Queue orderQueue() {
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    /**
     * 绑定交换机与队列
     */
    @Bean
    public Binding orderBinding(Queue queue, Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("video.#").noargs();
    }
}