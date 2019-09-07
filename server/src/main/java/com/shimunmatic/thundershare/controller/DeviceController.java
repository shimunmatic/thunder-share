package com.shimunmatic.thundershare.controller;

import com.shimunmatic.thundershare.model.Device;
import com.shimunmatic.thundershare.model.User;
import com.shimunmatic.thundershare.service.definition.device.DeviceService;
import com.shimunmatic.thundershare.service.definition.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api/device")
@Slf4j(topic = "DeviceController")
public class DeviceController extends BaseController
{
	private DeviceService deviceService;

	public DeviceController(UserService userService, DeviceService deviceService)
	{
		super(userService);
		this.deviceService = deviceService;
	}

	@GetMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Device>> getUsersDevices()
	{
		try
		{
			User currentUser = getCurrentUser();
			if (currentUser == null)
			{
				log.warn("Current user was not found");
				return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
			}
			return ResponseEntity.ok(deviceService.getAllForUser(currentUser.getId()));
		}
		catch (Exception e)
		{

			log.warn("Unknown exception was thrown during device registration.", e);
		}
		return ResponseEntity.unprocessableEntity().build();
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity registerDevice(@RequestBody Device device)
	{
		try
		{
			User currentUser = getCurrentUser();
			if (currentUser == null)
			{
				log.warn("Current user was not found");
				return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
			}
			Device createdDevice = deviceService.registerDevice(currentUser.getId(), device);
			return ResponseEntity.ok(createdDevice);
		}
		catch (Exception e)
		{
			log.warn("Unknown exception was thrown during device registration.", e);
		}
		return ResponseEntity.unprocessableEntity().build();
	}

	@GetMapping(path = "{deviceId}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Device> getDeviceInfo(@PathVariable(name = "deviceId") long deviceId)
	{
		try
		{
			User currentUser = getCurrentUser();
			if (currentUser == null)
			{
				log.warn("Current user was not found");
				return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
			}
			Device device = deviceService.getDeviceInfo(deviceId, currentUser.getId());
			return ResponseEntity.ok(device);
		}
		catch (Exception e)
		{
			log.warn("Unknown exception was thrown during device registration.", e);
		}
		return ResponseEntity.unprocessableEntity().build();
	}
}
