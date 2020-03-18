package life.majiang.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND(2001, "帖子不存在"),
    TARGET_PARAM_NOT_FOUND(2002, "回复失败"),
    NO_LOGIN(2003,  "未登录"),
    SYS_ERROR(2004, "服务器挂了"),
    TYPE_PARAM_WRONG(2005, "评论类型错误"),
    COMMENT_NOT_FOUND(2006, "问题不存在"),
    CONTENT_IS_EMPTY(2007, "输入内容不能为空"),
    NOTIFICATION_NOT_FOUND(2008, "通知无法找到"),
    READ_NOTIFICATION_FAIL(2009, "通知读取失败");


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }


    private String message;
    private Integer code;

    CustomizeErrorCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
