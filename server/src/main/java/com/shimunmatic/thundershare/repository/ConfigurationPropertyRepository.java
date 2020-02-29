package com.shimunmatic.thundershare.repository;

import com.shimunmatic.thundershare.model.ConfigurationProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationPropertyRepository extends JpaRepository<ConfigurationProperty, Long> {
    ConfigurationProperty findOneByKey(String key);
}
