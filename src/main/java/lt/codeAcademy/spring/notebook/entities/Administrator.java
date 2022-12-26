package lt.codeAcademy.spring.notebook.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "administrators")
public class Administrator
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;

    private String email;

    private String name;

    @OneToMany(mappedBy = "administrator", cascade = CascadeType.ALL)
    private List<User> users;


}
