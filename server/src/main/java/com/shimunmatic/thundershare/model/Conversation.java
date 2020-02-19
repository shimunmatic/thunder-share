package com.shimunmatic.thundershare.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "conversation", schema = "sc_thunder")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Conversation extends BaseEntity {
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "profile_image_path", nullable = false)
    private String profileImagePath;
}
