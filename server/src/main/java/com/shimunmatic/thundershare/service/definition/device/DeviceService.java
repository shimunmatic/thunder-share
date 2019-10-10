package com.shimunmatic.thundershare.service.definition.device;

import com.shimunmatic.thundershare.model.Device;
import com.shimunmatic.thundershare.service.definition.CrudService;

import java.util.List;

public interface DeviceService extends CrudService<Device, Long> {
	List<Device> getAllForUser(Long userId);

	Device registerDevice(Long userId, Device device);

	Device getDeviceInfo(Long deviceId, Long userId);
}
