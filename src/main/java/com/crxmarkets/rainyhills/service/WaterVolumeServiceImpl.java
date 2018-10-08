/**
 * 
 */
package com.crxmarkets.rainyhills.service;

import org.springframework.stereotype.Service;

import com.crxmarkets.rainyhills.request.model.SurfaceProfileRequestModel;

/**
 * This Class the implementation of {@link}WaterVolumeService Interface
 * which will be the available to our MainService to call any method inside interface
 * @author AhmedTaha
 *
 */
@Service
public class WaterVolumeServiceImpl implements WaterVolumeService {
	
	/* @desc inside this Method i apply the Algorithm which got the numbers of volumes 
	 * we can got volume of  water  if there are higher bars on left and right.
	 * the amount of water to stored by every element by finding the heights of bars on left and right sides.
	 * and then loop over all elements and got the smallest side left and right bars and subtract it from element value  and return to my sum
	 * @parameter it takes SurfaceProfileRequestModel as Input
	 * @return number of volumes 
	 */
	@Override
	public int getWaterVolumesNumber(SurfaceProfileRequestModel surfaceProfileRequestModel) {
		int waterVolume = 0;
		int sizeOfSurfaceProfileListInput = surfaceProfileRequestModel.getSurfaceProfileList().length;
		int leftSurfaceProfile[] = new int[sizeOfSurfaceProfileListInput];
		int rightSurfaceProfile[] = new int[sizeOfSurfaceProfileListInput];


		leftSurfaceProfile[0] = surfaceProfileRequestModel.getSurfaceProfileList()[0];
		for (int i = 1; i < sizeOfSurfaceProfileListInput; i++)
			leftSurfaceProfile[i] = Math.max(leftSurfaceProfile[i - 1], surfaceProfileRequestModel.getSurfaceProfileList()[i]);
		
		rightSurfaceProfile[sizeOfSurfaceProfileListInput - 1] = surfaceProfileRequestModel.getSurfaceProfileList()[sizeOfSurfaceProfileListInput - 1];
		for (int i = sizeOfSurfaceProfileListInput - 2; i >= 0; i--)
			rightSurfaceProfile[i] = Math.max(rightSurfaceProfile[i + 1], surfaceProfileRequestModel.getSurfaceProfileList()[i]);

		for (int i = 0; i < sizeOfSurfaceProfileListInput; i++)
			waterVolume += Math.min(leftSurfaceProfile[i], rightSurfaceProfile[i]) - surfaceProfileRequestModel.getSurfaceProfileList()[i];

		return waterVolume;
	}

}
