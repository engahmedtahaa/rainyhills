package com.crxmarkets.rainyhills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crxmarkets.rainyhills.request.model.SurfaceProfileRequestModel;

/**
 * This Class the implementation of {@link}MainServiceable Interface
 * which will be the available to our Controllers to call any method inside interface
 * @author AhmedTaha
 *
 */
@Service
public class MainService implements MainServiceable{
	
	@Autowired
	WaterVolumeService waterVolumeService;
	
	@Override
	public int getWaterVolumesNumber(SurfaceProfileRequestModel surfaceProfileRequestModel) {
		return waterVolumeService.getWaterVolumesNumber(surfaceProfileRequestModel);
	}

}
