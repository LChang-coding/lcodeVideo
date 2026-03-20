体验地址：http://lcodevideo.lcode.top/

项目整理结构图（excalidraw作图）

<img width="4410" height="3416" alt="视频架构图-2026-02-14-1730" src="https://github.com/user-attachments/assets/3c13fb75-9000-4bea-bf01-32cd4010d7f3" />

压测情况：

在我的本机进行压测：
    机器搭载了 24 核的 i9 处理器和 32GB 内存。
    
主要是对于三个常用接口的压测：

主页加载视频接口压测：
<img width="2973" height="107" alt="download" src="https://github.com/user-attachments/assets/d4a0cc58-bc5d-4e16-8e03-9a2ced576c15" />
单机单节点成功抗住了 2500+ 的极限 QPS。在承受近 8 万次高并发冲击的过程中，系统零报错、零宕机，平均响应时间稳定在 350 毫秒左右

搜素接口测试：

<img width="2962" height="111" alt="download" src="https://github.com/user-attachments/assets/c16236fd-749e-40b9-a0bf-50880d2e5d9e" />
40个线程持续五分钟的压测单机节点抗住了300的qps 200ms的延迟 80线程压测5分钟如果是600ms延迟的话 qps到了700

播放接口测试（针对某一视频的单一ts片段的播放）：
<img width="2991" height="168" alt="download" src="https://github.com/user-attachments/assets/41337fcf-05a6-400e-bca2-151f63fd78a8" />
在针对视频平台吞吐量要求最高的 播放核心接口 进行的饱和式加压测试中，单机单节点成功突破了 5200+ 的 QPS 峰值
数据库设计图（概括）
<img width="2340" height="1739" alt="image" src="https://github.com/user-attachments/assets/07437e86-8549-4dc0-94d4-88e5b5cba65e" />
<img width="1986" height="1130" alt="image" src="https://github.com/user-attachments/assets/5db20095-570b-45e2-8319-b48e902b1ad3" />

核心链路图
<img width="1442" height="464" alt="image" src="https://github.com/user-attachments/assets/ba561567-301f-438e-b4eb-85e05bc47736" />
<img width="1525" height="1542" alt="image" src="https://github.com/user-attachments/assets/2506c81d-9339-4a5f-9d4d-280cba700eb2" />
<img width="1663" height="795" alt="image" src="https://github.com/user-attachments/assets/46eec47d-4694-48e2-ba67-25864760df28" />
<img width="1498" height="835" alt="image" src="https://github.com/user-attachments/assets/fb7cc769-9787-41f5-9a58-fab2aa4ec5de" />
<img width="2263" height="897" alt="image" src="https://github.com/user-attachments/assets/0f6c71ac-2c3d-47bb-a48c-ee001c66819f" />
<img width="2593" height="1230" alt="image" src="https://github.com/user-attachments/assets/0d94aab7-19e8-4eb1-96e8-395c0e0f4b1f" />
<img width="2119" height="1253" alt="image" src="https://github.com/user-attachments/assets/fe2a00ca-1dac-45ff-b05b-51a3fa80cb00" />





