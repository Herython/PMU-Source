package vip.epss.domain;

public class User {
    public User(Integer id, String cardid, String nickname, String realname, Integer age, String password, String sex, String screctquestion, String avaurl, String cardurl, String introduction) {
        this.id = id;
        this.cardid = cardid;
        this.nickname = nickname;
        this.realname = realname;
        this.age = age;
        this.password = password;
        this.sex = sex;
        this.screctquestion = screctquestion;
        this.avaurl = avaurl;
        this.cardurl = cardurl;
        this.introduction = introduction;
    }

    public User(String cardid, String nickname, String realname, Integer age, String password, String sex, String screctquestion, String avaurl, String cardurl, String introduction) {
        this.cardid = cardid;
        this.nickname = nickname;
        this.realname = realname;
        this.age = age;
        this.password = password;
        this.sex = sex;
        this.screctquestion = screctquestion;
        this.avaurl = avaurl;
        this.cardurl = cardurl;
        this.introduction = introduction;
    }

    private Integer id;

    private String cardid;

    private String nickname;

    private String realname;

    private Integer age;

    private String password;

    private String sex;

    private String screctquestion;

    private String avaurl;

    private String cardurl;

    private String introduction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getScrectquestion() {
        return screctquestion;
    }

    public void setScrectquestion(String screctquestion) {
        this.screctquestion = screctquestion;
    }

    public String getAvaurl() {
        return avaurl;
    }

    public void setAvaurl(String avaurl) {
        this.avaurl = avaurl;
    }

    public String getCardurl() {
        return cardurl;
    }

    public void setCardurl(String cardurl) {
        this.cardurl = cardurl;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}