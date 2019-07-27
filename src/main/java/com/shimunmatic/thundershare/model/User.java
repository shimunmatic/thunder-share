package com.shimunmatic.thundershare.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_info", schema = "thunder_sc")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    @Column(name = "user_name")
    private String name;
}
