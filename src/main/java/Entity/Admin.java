package Entity;

/**
 * 管理员实体类
 * @author 13425
 *
 */
public class Admin {

    /**
     * 管理员ID
     */
    private String id;

    /**
     * 管理员的用户名
     */
    private String username;

    /**
     * 管理员的名称
     */
    private String nickname;

    /**
     * 管理员的登录密码
     */
    private String password;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getNickname() {
        return nickname;
    }


    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }
}
