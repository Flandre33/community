package life.majiang.community.model;

import lombok.Data;

@Data
public class Question {
    private Integer id;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;

    private String title;
    private String description;
    private String tag;

    private Long GmtCreate;
    private Long GmtModified;

}
