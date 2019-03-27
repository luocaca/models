package me.luocaca.model.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduledService {

    // 表示周一到周六当秒为0时执行一次
    @Scheduled(cron = "0 * * * * MON-SAT")
    public void hello() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        System.out.println(date + "  hello...");
    }



}
