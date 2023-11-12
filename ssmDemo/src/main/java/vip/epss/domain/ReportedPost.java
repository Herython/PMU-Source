package vip.epss.domain;

public class ReportedPost {
    public ReportedPost(Integer id, Integer postid) {
        this.id = id;
        this.postid = postid;
    }

    public ReportedPost(Integer postid) {
        this.postid = postid;
    }

    private Integer id;

    private Integer postid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }
}