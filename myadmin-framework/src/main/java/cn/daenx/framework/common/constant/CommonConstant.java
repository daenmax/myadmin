package cn.daenx.framework.common.constant;

public class CommonConstant {
    public static final String MSG_200 = "操作成功";
    public static final String MSG_500 = "操作失败";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 超级管理员ID
     */
    public static final String SUPER_ADMIN = "1";

    /**
     * 异常日志截取长度
     * 针对定时任务、操作日志（异常、请求参数、响应数据）
     */
    public static final Integer SAVE_LOG_LENGTH = 2000;


    public static final String IS_HTTPS_YES = "1";
    public static final String IS_HTTPS_NO = "0";

    /**
     * 通用状态：正常
     */
    public static final String STATUS_NORMAL = "0";
    /**
     * 通用状态：禁用
     */
    public static final String STATUS_DISABLE = "1";


    /**
     * 系统时间单位
     */
    public static final String SYS_TIME_UNIT_SECOND = "0";
    public static final String SYS_TIME_UNIT_MINUTE = "1";
    public static final String SYS_TIME_UNIT_HOUR = "2";
    public static final String SYS_TIME_UNIT_DAY = "3";
}
