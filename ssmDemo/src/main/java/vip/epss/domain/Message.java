package vip.epss.domain;


import java.util.Date;
import java.sql.Timestamp;

public class Message {
    public Message(Integer id, String content, Integer userid, Integer postid) {
        this.id = id;
        this.content = content;
        this.userid = userid;
        this.postid = postid;
        this.time=new Date(System.currentTimeMillis());
    }

    public Message(String content, Integer userid, Integer postid) {
        this.content = content;
        this.userid = userid;
        this.postid = postid;
        this.time=new Date(System.currentTimeMillis());
    }

    public Message(Integer id, String content, Integer userid, Integer postid, Timestamp time) {
        this.id = id;
        this.content = content;
        this.userid = userid;
        this.postid = postid;
        long timeInMillis = time.getTime();
        Date date = new Date(timeInMillis);
        this.time = date;
    }

    private Integer id;

    private String content;

    private Integer userid;

    private Integer postid;


    private Date time;

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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}