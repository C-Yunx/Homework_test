package Entity;
import java.util.Date;
/**
 * 奖学金申请实体类
 */
public class Apply {
    /**
     * 奖学金申请事件ID
     */
    private Integer id;

    /**
     * 申请人学号
     */
    private String userId;

    /**
     * 申请人姓名
     */
    private String applyNickName;

    /**
     * 申请人班级
     */
    private String applyClass;

    /**
     * 申请的奖学金的ID
     */
    private Integer scholarshipId;

    /**
     * 申请的奖学金的名称
     */
    private String scholarshipName;

    /**
     * 申请奖学金的理由
     */
    private String reason;

    /**
     * 审核辅导员工号
     */
    private String teacherId;

    /**
     * 辅导员审核状态：yes或者no或者null
     */
    private String teacherState;

    /**
     * 审核管理员ID
     */
    private String adminId;

    /**
     * 管理员审核状态：yes或者no或者null
     */
    private String adminState;

    /**
     * 申请添加时间
     */
    private Date createTime;

    /**
     * 申请更新时间
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getApplyNickName() {
        return applyNickName;
    }

    public void setApplyNickName(String applyNickName) {
        this.applyNickName = applyNickName;
    }

    public String getApplyClass() {
        return applyClass;
    }

    public void setApplyClass(String applyClass) {
        this.applyClass = applyClass;
    }

    public Integer getScholarshipId() {
        return scholarshipId;
    }

    public void setScholarshipId(Integer scholarshipId) {
        this.scholarshipId = scholarshipId;
    }

    public String getScholarshipName() {
        return scholarshipName;
    }

    public void setScholarshipName(String scholarshipName) {
        this.scholarshipName = scholarshipName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherState() {
        return teacherState;
    }

    public void setTeacherState(String teacherState) {
        this.teacherState = teacherState;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminState() {
        return adminState;
    }

    public void setAdminState(String adminState) {
        this.adminState = adminState;
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
