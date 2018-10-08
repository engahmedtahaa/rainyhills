package com.crxmarkets.rainyhills.service;

import org.springframework.stereotype.Service;

import com.crxmarkets.rainyhills.request.model.SurfaceProfileRequestModel;

/**
 * This Interface shows all allowed methods to Controllers
 * @author AhmedTaha
 *
 */
@Service
public interface MainServiceable {

	public int getWaterVolumesNumber(SurfaceProfileRequestModel surfaceProfileRequestModel);

}
