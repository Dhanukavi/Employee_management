package com.example.Employee_Management.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")
public class Employee {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

@Column(name="first_name")
private String firstname;

@Column(name="last_name")
private String lastname;

@Column(name="email_id")
private String emailId;

@Column(name="phone_no")
private String phoneNo;


@Column(name="Address")
private String address;
}