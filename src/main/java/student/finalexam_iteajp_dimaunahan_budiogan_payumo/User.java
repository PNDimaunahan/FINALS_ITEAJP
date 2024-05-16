package student.finalexam_iteajp_dimaunahan_budiogan_payumo;

public class User {
    private String username;
    private String password;
    private String email;
    private String fullname;
    private String role;
    private boolean active;
    
    
    public User(String username, String email, String fullname, String role) {
        this.username = username;
        this.email = email;
        this.fullname = fullname;
        this.role = role;
    }

    public User(String username, String email, String fullname, String role, String password) {
        this.username = username;
        this.email = email;
        this.fullname = fullname;
        this.role = role;
        this.password = password;
    }

    public User(String username, String email, String fullname, String role, boolean active) {
        this.username = username;
        this.email = email;
        this.fullname = fullname;
        this.role = role;
        this.active = active;
    }

    // Getters and setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
