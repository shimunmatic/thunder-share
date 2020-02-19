package com.shimunmatic.thundershare.model;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "message", schema = "sc_thunder")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Message extends BaseEntity {
    @Column(name = "message")
    private String message;

    @JoinColumn(name = "user_id")
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "conversation_id")
    @ManyToOne(targetEntity = Conversation.class, fetch = FetchType.LAZY)
    private Conversation conversation;

}
