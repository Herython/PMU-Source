package vip.epss.domain;

public class ForbidenedUser {
    public ForbidenedUser(Integer id, Integer userid) {
        this.id = id;
        this.userid = userid;
    }

    public ForbidenedUser(Integer userid) {
        this.userid = userid;
    }

    private Integer id;

    private Integer userid;

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
}