public class User {
    private String userId;
    private String password;
    private String profileInfo;
    private boolean loggedIn;

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
        this.profileInfo = "";
        this.loggedIn = false;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public String getProfileInfo() {
        return profileInfo;
    }

    public void setProfileInfo(String profileInfo) {
        this.profileInfo = profileInfo;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
