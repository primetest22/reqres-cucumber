package in.reqres.model;

public class UserPojo {

    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public static UserPojo getUserPojo(String email,String first_name,String last_name,
                                       String avatar){
        UserPojo userPojo = new UserPojo();
        userPojo.setEmail(email);
        userPojo.setFirst_name(first_name);
        userPojo.setLast_name(last_name);
        userPojo.setAvatar(avatar);
        return userPojo;
    }
    public static UserPojo loginPojo(String email,String password){
        UserPojo userPojo = new UserPojo();
        userPojo.setEmail(email);
        userPojo.setPassword(password);
        return userPojo;
    }
}
