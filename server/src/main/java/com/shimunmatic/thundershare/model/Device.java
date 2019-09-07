package com.shimunmatic.thundershare.model;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "device", schema = "sc_thunder")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Device extends BaseEntity
{
	@Column(name = "name") private String name;
	@Column(name = "device_id") private String deviceId;
	@Column(name = "notification_id") private String notificationId;
	@Column(name = "nick_name") private String nickName;
	@Column(name = "user_id") private Long userId;
	@ManyToOne @JoinColumn(name = "user_id", insertable = false, updatable = false) private User user;
}
