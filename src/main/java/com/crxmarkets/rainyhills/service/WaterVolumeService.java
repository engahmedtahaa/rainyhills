/**
 * 
 */
package com.crxmarkets.rainyhills.service;

import org.springframework.stereotype.Service;

import com.crxmarkets.rainyhills.request.model.SurfaceProfileRequestModel;

/**
 * This contains all available Method to MainServicable 
 * @author AhmedTaha
 *
 */
@Service
public interface WaterVolumeService {
	public int getWaterVolumesNumber(SurfaceProfileRequestModel surfaceProfileRequestModel);
}
