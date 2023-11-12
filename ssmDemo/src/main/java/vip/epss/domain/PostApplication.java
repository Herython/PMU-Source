package vip.epss.domain;

public class PostApplication {
    public PostApplication(Integer id, String content, String title, String type, Integer userid, String messagearray, String imgurl) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.type = type;
        this.userid = userid;
        this.messagearray = messagearray;
        this.imgurl = imgurl;
    }
    public PostApplication(String content, String title, String type, Integer userid, String messagearray, String imgurl) {
        this.content = content;
        this.title = title;
        this.type = type;
        this.userid = userid;
        this.messagearray = messagearray;
        this.imgurl = imgurl;
    }

    private Integer id;

    private String content;

    private String title;

    private String type;

    private Integer userid;

    private String messagearray;

    private String imgurl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getMessagearray() {
        return messagearray;
    }

    public void setMessagearray(String messagearray) {
        this.messagearray = messagearray;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}