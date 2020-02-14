package top.inewbie.mq;

import org.apache.log4j.Logger;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SubSelectionDeletionConsumer {
    private Logger logger = Logger.getLogger(getClass());

    @Value("spring_consumer_group2")
    private String consumerGroupName;

    @Value("localhost:9876")
    private String nameServerAddr;

    @Value("subject_selection_deletion")
    private String topicName;

    private DefaultMQPushConsumer consumer;

    @Autowired
    private MessageListenerConcurrently messageListener;

//    public SpringConsumer(String consumerGroupName, String nameServerAddr, String topicName, MessageListenerConcurrently messageListener) {
//        this.consumerGroupName = consumerGroupName;
//        this.nameServerAddr = nameServerAddr;
//        this.topicName = topicName;
//        this.messageListener = messageListener;
//    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("开始启动消息消费者服务2...");

        //创建一个消息消费者，并设置一个消息消费者组
        consumer = new DefaultMQPushConsumer(consumerGroupName);
//        consumer.setInstanceName(RunTimeUtil.getRocketMqUniqeInstanceName());
        //指定 NameServer 地址
        consumer.setNamesrvAddr(nameServerAddr);
        //设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        //订阅指定 Topic 下的所有消息
        consumer.subscribe(topicName, "*");

        //注册消息监听器
        consumer.registerMessageListener(messageListener);

        // 消费者对象在使用之前必须要调用 start 初始化
        consumer.start();

        System.out.println("消息消费者服务启动成功2.");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("开始关闭消息消费者服务2...");

        consumer.shutdown();

        System.out.println("消息消费者服务已关闭2.");
    }

    public DefaultMQPushConsumer getConsumer() {
        return consumer;
    }

}
