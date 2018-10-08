package com.crxmarkets.rainyhills.service.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.crxmarkets.rainyhills.request.model.SurfaceProfileRequestModel;
import com.crxmarkets.rainyhills.service.WaterVolumeServiceImpl;

public class WaterVolumeServiceImplTests {
	private WaterVolumeServiceImpl waterVolumeServiceImpl;
	private SurfaceProfileRequestModel surfaceProfileRequestModel;

	@Before
	public void init() {
		waterVolumeServiceImpl = new WaterVolumeServiceImpl();
		surfaceProfileRequestModel = new SurfaceProfileRequestModel();

	}

	@Test
	public void firstTestCase() {
		Integer arr[] = { 4, 1, 1, 0, 2, 3 };
		surfaceProfileRequestModel.setSurfaceProfileList(arr);
		assertEquals(8, waterVolumeServiceImpl.getWaterVolumesNumber(surfaceProfileRequestModel));

	}
	@Test
	public void secondTestCase() {
		Integer arr[] = { 3, 2, 4, 1, 2};
		surfaceProfileRequestModel.setSurfaceProfileList(arr);
		assertEquals(2, waterVolumeServiceImpl.getWaterVolumesNumber(surfaceProfileRequestModel));

	}
	@Test
	public void thirdTestCase() {
		Integer arr[] = { 1,5,5,6,9};
		surfaceProfileRequestModel.setSurfaceProfileList(arr);
		assertEquals(0, waterVolumeServiceImpl.getWaterVolumesNumber(surfaceProfileRequestModel));

	}
	

}
