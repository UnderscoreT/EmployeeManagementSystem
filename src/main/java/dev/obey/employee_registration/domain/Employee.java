package dev.obey.employee_registration.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
    @Table(name="employees")
    public class Employee {




        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private long id;

        @Column(name= "first_name")
        private String firstName;
        @Column(name= "last_name")
        private String lastName;
        @Column(name= "emal")
        private String email;


}
