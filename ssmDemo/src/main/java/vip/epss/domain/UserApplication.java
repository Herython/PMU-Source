package vip.epss.domain;

public class UserApplication {
    public UserApplication(Integer id,String cardid, String name, Integer age, String password, String sex, String screctquestion) {
        this.id=id;
        this.cardid = cardid;
        this.name = name;
        this.age = age;
        this.password = password;
        this.sex = sex;
        this.screctquestion = screctquestion;
    }

    public UserApplication(Integer id, String cardid, String name, Integer age, String password, String sex, String screctquestion, String imgurl) {
        this.id = id;
        this.cardid = cardid;
        this.name = name;
        this.age = age;
        this.password = password;
        this.sex = sex;
        this.screctquestion = screctquestion;
        this.imgurl = imgurl;
    }

    public UserApplication(String cardid, String name, Integer age, String password, String sex, String screctquestion) {
        this.cardid = cardid;
        this.name = name;
        this.age = age;
        this.password = password;
        this.sex = sex;
        this.screctquestion = screctquestion;
    }

    public UserApplication(String cardid, String name, Integer age, String password, String sex, String screctquestion, String imgurl) {
        this.id = id;
        this.cardid = cardid;
        this.name = name;
        this.age = age;
        this.password = password;
        this.sex = sex;
        this.screctquestion = screctquestion;
        this.imgurl = imgurl;
    }

    private Integer id;

    private String cardid;

    private String name;

    private Integer age;

    private String password;

    private String sex;

    private String screctquestion;

    private String imgurl;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}