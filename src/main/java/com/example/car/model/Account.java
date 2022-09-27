package com.example.car.model;

import com.example.car.validation.EmailReg;
import com.example.car.validation.NotExistingAccount;
import com.example.car.validation.ValidationGroupOne;
import com.example.car.validation.ValidationGroupTwo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@NotExistingAccount(message = "Такой пользователь уже зарегистрирован.",
        groups = {ValidationGroupTwo.class})
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 40, message = "Минимум два символа.",
            groups = ValidationGroupOne.class)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 40, message = "Минимум два символа.",
            groups = ValidationGroupOne.class)
    @Column(name = "name")
    private String lastName;

    @NotBlank(message = "Введите Ваш email")
    @EmailReg(message = "Неверный формат email.",
            groups = ValidationGroupOne.class)
    @Column(unique = true)
    private String login;

    @NotBlank
    @Size(min = 3, max = 40, message = "Минимум три символа.",
            groups = ValidationGroupOne.class)
    private String password;

    @NotBlank
    @Pattern(regexp = "[0-9.\\-() x/+]+", message = "Неверный формат email.",
            groups = ValidationGroupOne.class)
    private String phoneNumber;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime created;

    @NotNull(message = "Выберите город", groups = ValidationGroupOne.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    public Account(final String firstName, final String lastName, final String login,
                   final String password, final String phoneNumber, final City city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.created = LocalDateTime.now();
    }
}
