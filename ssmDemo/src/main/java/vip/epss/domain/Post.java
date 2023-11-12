package vip.epss.domain;

public class Post {
    public Post(Integer id, Integer userid, String type, String title, String source, String destination, String time, String count, String imgurl, String content) {
        this.id = id;
        this.userid = userid;
        this.type = type;
        this.title = title;
        this.source = source;
        this.destination = destination;
        this.time = time;
        this.count = count;
        this.imgurl = imgurl;
        this.content = content;
    }

    public Post(Integer userid, String type, String title, String source, String destination, String time, String count, String imgurl, String content) {
        this.userid = userid;
        this.type = type;
        this.title = title;
        this.source = source;
        this.destination = destination;
        this.time = time;
        this.count = count;
        this.imgurl = imgurl;
        this.content = content;
    }

    private Integer id;

    private Integer userid;

    private String type;

    private String title;

    private String source;

    private String destination;

    private String time;

    private String count;

    private String imgurl;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}