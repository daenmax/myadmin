package cn.daenx.myadmin.system.task;

import cn.daenx.myadmin.common.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 测试定时任务
 */
@Component("SystemTask")
@Slf4j
public class SystemTask {
    public void multipleParams(String s, Boolean b, Long l, Double d, Integer i) {
        log.info("=============================执行多参方法");
    }

    public void oneParams(String params) {
        log.info("=============================执行有参方法：" + params);
    }

    public void noParams() throws InterruptedException {
        log.info("=============================执行无参方法-开始");
        Thread.sleep(1000);
        if (true) {
            throw new MyException("执行失败");
        }
        log.info("=============================执行无参方法-结束");
    }
}
