package com.crxmarkets.rainyhills.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.crxmarkets.rainyhills.exception.RainyHillsException;
import com.crxmarkets.rainyhills.request.model.SurfaceProfileRequestModel;
import com.crxmarkets.rainyhills.util.Defines;

import io.swagger.annotations.Api;

/**
 * This our Main Controller of our APP where you can request getVolumes and give
 * it input array it will return the numbers of volumes  
 * it extends {@link BaseController}
 * @author AhmedTaha
 *
 */

@RestController
@Api(value = "/WaterVolumeController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequestMapping("/WaterVolumeController")
public class WaterVolumeController extends BaseController {

	@RequestMapping(value = "/get-volumes-number", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Integer> getVolumesNumber(@Valid @NotNull @RequestBody SurfaceProfileRequestModel surfaceProfileRequestModel)
			throws RainyHillsException {
		if (surfaceProfileRequestModel.getSurfaceProfileList().length != 0) {
			return new ResponseEntity<>(mainService.getWaterVolumesNumber(surfaceProfileRequestModel), HttpStatus.OK);
		} else {
			throw new RainyHillsException(Defines.BAD_REQUEST, Defines.REQUIRED_MSG);
		}

	}
}
