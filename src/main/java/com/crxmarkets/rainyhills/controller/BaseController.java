/**
 * 
 */
package com.crxmarkets.rainyhills.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.crxmarkets.rainyhills.service.MainServiceable;

/**
 *This Base Controller where i can used most common property i got object form 
 *MainServiceable interface where i can used it in all controllers
 *@author AhmedTaha
 */
public class BaseController {

	@Autowired
	MainServiceable mainService;

}
