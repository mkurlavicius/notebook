package lt.codeAcademy.spring.notebook.payload.response;

import lt.codeAcademy.spring.notebook.entities.User;

public class UserResponse {

    private String createdAt;

    private String updatedAt;

    private String username;

    private String email;

    private String role;

    public UserResponse(User user) {
        this.createdAt = user.getCreatedAtFormatted();
        this.updatedAt = user.getUpdatedAtFormatted();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.role = user.getRole().getName().name();
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }



    public void setRole(String role) {
        this.role = role;
    }
}
