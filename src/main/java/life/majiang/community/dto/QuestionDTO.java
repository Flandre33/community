package life.majiang.community.dto;

import life.majiang.community.model.User;
import lombok.Data;

@Data
public class QuestionDTO {
    private Long id;
    private Long creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;

    private String title;
    private String description;
    private String tag;

    private Long GmtCreate;
    private Long GmtModified;

    private User user;

}