package com.shimunmatic.thundershare.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "configuration_property", schema = "sc_thunder")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class ConfigurationProperty extends BaseEntity {
    private String key;
    private String value;
}
