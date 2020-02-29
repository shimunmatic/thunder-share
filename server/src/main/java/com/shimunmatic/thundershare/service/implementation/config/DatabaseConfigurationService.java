package com.shimunmatic.thundershare.service.implementation.config;

import com.shimunmatic.thundershare.model.ConfigurationProperty;
import com.shimunmatic.thundershare.repository.ConfigurationPropertyRepository;
import com.shimunmatic.thundershare.service.definition.config.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@Qualifier("db")
public class DatabaseConfigurationService implements ConfigurationService {
    private ConfigurationPropertyRepository configurationPropertyRepository;

    @Autowired
    public DatabaseConfigurationService(ConfigurationPropertyRepository configurationPropertyRepository) {
        this.configurationPropertyRepository = configurationPropertyRepository;
    }

    @Override
    public String getConfigurationValue(String key) {
        ConfigurationProperty property = configurationPropertyRepository.findOneByKey(key);
        if (property != null) {
            return new String(Base64.getDecoder().decode(property.getValue()));
        }
        return null;
    }
}
