package vip.epss.domain;

public class Admin {
    public Admin(Integer id, Integer cardid, String name, Integer age, String password, String sex, String secretquestion) {
        this.id = id;
        this.cardid = cardid;
        this.name = name;
        this.age = age;
        this.password = password;
        this.sex = sex;
        this.secretquestion = secretquestion;
    }

    private Integer id;

    private Integer cardid;

    private String name;

    private Integer age;

    private String password;

    private String sex;

    private String secretquestion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardid() {
        return cardid;
    }

    public void setCardid(Integer cardid) {
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

    public String getSecretquestion() {
        return secretquestion;
    }

    public void setSecretquestion(String secretquestion) {
        this.secretquestion = secretquestion;
    }
}