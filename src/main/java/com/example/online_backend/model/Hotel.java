package com.example.online_backend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int hotel_id;
    private String hotel_name;
    private String hotel_address;
    private String hotel_owner;
    private String phone;
    private String email;

}
