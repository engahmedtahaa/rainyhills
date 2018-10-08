package com.crxmarkets.rainyhills.request.model;

import java.util.Arrays;

import javax.validation.constraints.NotNull;

/**
 * @desc This our Request Model Holder which holds our input Array
 * @author AhmedTaha
 *
 */
public class SurfaceProfileRequestModel implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@NotNull
	private Integer [] surfaceProfileList;
	
	
	public Integer[] getSurfaceProfileList() {
		return surfaceProfileList;
	}
	public void setSurfaceProfileList(Integer[] surfaceProfileList) {
		this.surfaceProfileList = surfaceProfileList;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SurfaceProfileRequestModel [surfaceProfileList=");
		builder.append(Arrays.toString(surfaceProfileList));
		builder.append(", getSurfaceProfileList()=");
		builder.append(Arrays.toString(getSurfaceProfileList()));
		builder.append("]");
		return builder.toString();
	}
	
	
}
