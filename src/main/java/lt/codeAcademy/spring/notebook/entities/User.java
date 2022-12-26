package lt.codeAcademy.spring.notebook.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    private String password;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String username;

    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TodoList> todoLists;

    @ManyToOne
    @JoinColumn(name = "administrator_id", referencedColumnName = "id")
    private Administrator administrator;

    public Set<Role> getRoles() {
        return new HashSet<Role>(Arrays.asList(this.role));
    }

    public void setRoles(Set<Role> roles) {
        System.out.println("Cia");
        System.out.println(roles.toString());
        this.role = roles.iterator().next();
    }

    public User(String username, String email, String password) {
        this.password = password;
        this.email = email;
        this.username = username;
    }

    public String getCreatedAtFormatted() {
        return this.getFormattedDate(this.createdAt);
    }

    public String getUpdatedAtFormatted() {
        return this.getFormattedDate(this.updatedAt);
    }

    private String getFormattedDate(LocalDateTime date) {
        if(date == null) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }
}
