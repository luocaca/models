package me.luocaca.model.controller;

import org.springframework.stereotype.Controller;

@Controller
public class AmqpController {

//    @Autowired
//    RabbitTemplate rabbitTemplate;
//
//    @Autowired
//    AmqpAdmin amqpAdmin;
//
//
//    @RequestMapping("/sendAmqp")
//    @ResponseBody
//    public void sendAmqp() {
//
//// Message需要自己构建一个；定义消息体内容和消息头
//        // rabbitTemplate.send(exchange, routingKey, message);
//        // Object 默认当成消息体，只需要传入要发送的对象，自动化序列发送给rabbitmq；
//        Map<String, Object> map = new HashMap<>();
//        map.put("msg", "这是第一个信息");
//        map.put("data", Arrays.asList("HelloWorld", 123, true));
//        //对象被默认序列以后发送出去
//        rabbitTemplate.convertAndSend("exchange.direct", "luocaca.news", map);
//
//    }
//
//    @RequestMapping("/test1")
//    public void test1() {
//        // 对象被默认序列以后发送出去
//        rabbitTemplate.convertAndSend("exchange.direct", "cuzz.news", new BigBook("Effect java", "Joshua Bloch"));
//    }
//
//
//    @RequestMapping("/receiveAndConvert")
//    public void receiveAndConvert() {
//        Object o = rabbitTemplate.receiveAndConvert("luocaca.news");
//        System.out.println(o.getClass());
//        System.out.println(o);
//    }
//
//    @RequestMapping("/createExchange")
//    public void createExchange() {
//        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.direct"));
//        System.out.println("Create Finish");
//    }
//
//    @RequestMapping("/createQueue")
//    public void createQueue() {
//        amqpAdmin.declareQueue(new Queue("amqpadmin.queue", true));
//        System.out.println("Create Queue Finish");
//    }
//
//    @RequestMapping("/createBind")
//    public void createBind() {
//        amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE, "amqpadmin.direct", "amqp.haha", null));
//    }
//
//    @RequestMapping("/deleteExchange")
//    public void deleteExchange() {
//        amqpAdmin.deleteExchange("amqpadmin.direct");
//        System.out.println("delete Finish");
//    }

}
