package me.luocaca.model.service;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步服务
 */
@Service
public class AsynService {

    @Async
    public void hello() {
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中......");
    }


}
