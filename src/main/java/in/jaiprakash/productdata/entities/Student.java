package in.jaiprakash.productdata.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="fname")
    private String firstName;

    @Column(name="lname")
    private String lastName;
    private int score;

    public Student(String firstName, String lastName, int score) {
        this.firstName=firstName;
        this.lastName = lastName;
        this.score = score;
    }
}
