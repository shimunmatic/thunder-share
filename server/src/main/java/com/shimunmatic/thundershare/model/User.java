package com.shimunmatic.thundershare.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user_info", schema = "sc_thunder")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class User extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "user_name", unique = true)
    private String userName;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "user")
    private List<UserConversation> userConversations;

}
