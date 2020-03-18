package life.majiang.community.dto;

import lombok.Data;

@Data
public class NotificationDTO {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private Long notifier;
    private String outerTitle;
    private Integer type;
    private Long outerId;
    private String notifierName;
    private String typeName;
}
