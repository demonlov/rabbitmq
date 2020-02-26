package com.wuchao.rabbitmq_pro;
import com.wuchao.rabbitmq_pro.provider.ApiCreditSender;
import com.wuchao.rabbitmq_pro.provider.FanoutSender;
import com.wuchao.rabbitmq_pro.provider.HelloSender;
import com.wuchao.rabbitmq_pro.provider.TopicSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class RabbitmqProApplicationTests {


    @Autowired
    private TopicSender topicSender;
    @Autowired
    private HelloSender helloSender;

    @Test
    void contextLoads() {
        helloSender.send();
    }

//topic
    @Test
    public void send1() {
        topicSender.send1();
    }
    @Test
    public void send2() {
        topicSender.send2();
    }



    //headers


    @Autowired
    private ApiCreditSender sender;

    @Test
    public void test_creditBank_type() {
        Map<String,Object> head = new HashMap<>();
        head.put("type", "cash");
        sender.creditBank(head, "银行授信(部分匹配)");
    }

    @Test
    public void test_creditBank_all() {
        Map<String,Object> head = new HashMap<>();
        head.put("type", "cash");
        head.put("aging", "fast");
        sender.creditBank(head, "银行授信(全部匹配)");
    }

    @Test
    public void test_creditFinance_type() {
        Map<String,Object> head = new HashMap<>();
        head.put("type", "cash");
        sender.creditFinance(head, "金融公司授信(部分匹配)");
    }

    @Test
    public void test_creditFinance_all() {
        Map<String,Object> head = new HashMap<>();
        head.put("type", "cash");
        head.put("aging", "fast");
        sender.creditFinance(head, "金融公司授信(全部匹配)");
    }


    //fanout
    @Autowired
    private FanoutSender fanoutSender;
    @Test
    public  void fanout() {

        fanoutSender.send();

    }

}
