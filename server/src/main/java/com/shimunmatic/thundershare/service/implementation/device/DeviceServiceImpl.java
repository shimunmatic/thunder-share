package com.shimunmatic.thundershare.service.implementation.device;

import com.shimunmatic.thundershare.model.Device;
import com.shimunmatic.thundershare.repository.DeviceRepository;
import com.shimunmatic.thundershare.service.definition.device.DeviceService;
import com.shimunmatic.thundershare.service.implementation.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceServiceImpl extends AbstractService<Device, Long> implements DeviceService {
	private DeviceRepository deviceRepository;

	public DeviceServiceImpl(DeviceRepository repository) {
		super(repository);
		deviceRepository = repository;
	}

	@Override
	public List<Device> getAllForUser(Long userId) {
		return deviceRepository.findAllByUserIdEquals(userId);
	}

	@Override
	public Device registerDevice(Long userId, Device device) {
		device.setUserId(userId);
		return deviceRepository.save(device);
	}

	@Override
	public Device getDeviceInfo(Long deviceId, Long userId) {
		Optional<Device> optionalDevice = getById(deviceId);
		if (optionalDevice.isEmpty()) { return null; }
		Device device = optionalDevice.get();

		if (!device.getUserId().equals(userId)) {
			return null;
		}
		return device;
	}
}
