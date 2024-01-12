package Entity;

import java.util.Date;
/**
 * 奖学金实体类
 */
public class Scholarship {
    /**
     * 奖学金的ID
     */
    private Integer id;

    /**
     * 奖学金的名称
     */
    private String scholarshipName;

    /**
     * 奖学金的类型
     * 0 校内入学资助，1 勤工俭学补贴，2 中西部新生入学资助项目
     * 3 师范生公费补贴，4 基层就业学费补偿，5 服兵役高等学校学生补偿
     * 6 国家教育资助补贴，7 国家助学金
     * 8 国家励志奖学金
     * 9 研究生国家助学金
     * 10 创新创业激励金
     * 11 五好学生奖励金
     * 12 校内励志奖学金
     */
    private String scholarshipType;

    /**
     * 奖学金金额
     */
    private String bonusAmount;

    /**
     * 奖学金申请条件
     */
    private String scholarshipRequirements;

    /**
     * 奖学金介绍
     */
    private String scholarshipIntroductions;

    /**
     * 申请奖学金需要达到的总分数
     */
    private Integer scholarshipGrade;

    /**
     * 奖学金创建时间
     */
    private Date createTime;

    /**
     * 奖学金更改时间
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScholarshipName() {
        return scholarshipName;
    }

    public void setScholarshipName(String scholarshipName) {
        this.scholarshipName = scholarshipName;
    }

    public String getScholarshipType() {
        return scholarshipType;
    }

    public void setScholarshipType(String scholarshipType) {
        this.scholarshipType = scholarshipType;
    }

    public String getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(String bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public String getScholarshipRequirements() {
        return scholarshipRequirements;
    }

    public void setScholarshipRequirements(String scholarshipRequirements) {
        this.scholarshipRequirements = scholarshipRequirements;
    }

    public String getScholarshipIntroductions() {
        return scholarshipIntroductions;
    }

    public void setScholarshipIntroductions(String scholarshipIntroductions) {
        this.scholarshipIntroductions = scholarshipIntroductions;
    }

    public void setScholarshipGrade(Integer scholarshipGrade) {
        this.scholarshipGrade = scholarshipGrade;
    }

    public Integer getScholarshipGrade() {
        return scholarshipGrade;
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
}
