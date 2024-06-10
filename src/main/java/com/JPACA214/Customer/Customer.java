package com.JPACA214.Customer;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    private Long id;
    @Column(nullable = false) //not null
    private String name;
//    @Column(unique = true)
//    private int tel;
}
