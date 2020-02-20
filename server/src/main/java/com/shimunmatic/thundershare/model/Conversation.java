package com.shimunmatic.thundershare.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "conversation", schema = "sc_thunder")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Conversation extends BaseEntity {
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "profile_image_path", nullable = false)
    private String profileImagePath;
    @OneToMany(mappedBy = "conversation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserConversation> userConversations;
}
