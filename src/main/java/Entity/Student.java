package Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 学生实体类
 */
public class Student implements Serializable{
    /**
     * 学生学号
     */
    private String id;

    /**
     * 学生班级
     */
    private String classNumber;

    /**
     * 学生登录账号
     */
    private String username;

    /**
     * 学生登录密码
     */
    private String password;

    /**
     * 学生姓名
     */
    private String nickname;

    /**
     * 学生性别
     * 0男，1女
     */
    private Integer sex;

    /**
     * 出生年月日
     */
    private String birthday;

    /**
     * 学生电话号码
     */
    private String telephone;

    /**
     * 学生的邮箱
     */
    private String email;

    /**
     * 学生的专业
     */
    private String profession;

    /**
     *学生是否家境贫困
     * 0贫困，1良好
     */
    private Integer ifPool;

    /**
     * 学生的专业课程成绩
     */
    private Integer proClassGrade;

    /**
     * 学生的体测成绩
     */
    private Integer peClassGrade;

    /**
     * 学生的思想文化成绩
     */
    private Integer cultureClassGrade;

    /**
     * 学生的综测成绩
     */
    private Integer comprehensiveTestGrade;

    /**
     * 学生的总成绩
     */
    private Integer totalClassGrade;

    /**
     * 是否有违纪情况
     * 0为没有，1为有
     */
    private Integer ifViolationOfDiscipline;

    /**
     * 学生账号添加时间
     */
    private Date createTime;

    /**
     * 学生账号修改时间
     */
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getIfPool() {
        return ifPool;
    }

    public void setIfPool(Integer ifPool) {
        this.ifPool = ifPool;
    }

    public Integer getProClassGrade() {
        return proClassGrade;
    }

    public void setProClassGrade(Integer proClassGrade) {
        this.proClassGrade = proClassGrade;
    }

    public Integer getPeClassGrade() {
        return peClassGrade;
    }

    public void setPeClassGrade(Integer peClassGrade) {
        this.peClassGrade = peClassGrade;
    }

    public Integer getCultureClassGrade() {
        return cultureClassGrade;
    }

    public void setCultureClassGrade(Integer cultureClassGrade) {
        this.cultureClassGrade = cultureClassGrade;
    }

    public Integer getComprehensiveTestGrade() {
        return comprehensiveTestGrade;
    }

    public void setComprehensiveTestGrade(Integer comprehensiveTestGrade) {
        this.comprehensiveTestGrade = comprehensiveTestGrade;
    }

    public Integer getTotalClassGrade() {
        return totalClassGrade;
    }

    public void setTotalClassGrade(Integer totalClassGrade) {
        this.totalClassGrade = totalClassGrade;
    }

    public Integer getIfViolationOfDiscipline() {
        return ifViolationOfDiscipline;
    }

    public void setIfViolationOfDiscipline(Integer ifViolationOfDiscipline) {
        this.ifViolationOfDiscipline = ifViolationOfDiscipline;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return nickname;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Student student = (Student) obj;
        return Objects.equals(this.id, student.getId()) && this.nickname.equals(student.getNickname());
    }
}
