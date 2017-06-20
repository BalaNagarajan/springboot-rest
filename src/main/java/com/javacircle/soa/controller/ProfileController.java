package com.javacircle.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javacircle.soa.model.Profile;
import com.javacircle.soa.service.ProfileService;

@RestController
public class ProfileController {

	public static final String URL = "/profiles";

	@Autowired
	private ProfileService profileService;

	/**
	 * TO get all the profiles Noun based URI's - /profiles
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/profiles")
	public List<Profile> getCompanyProfiles() {

		System.out.println("----------TEST------------");
		return profileService.getAllProfiles();

	}

	/**
	 * TO get all the profiles Noun based URI's - /profiles
	 * 
	 * @return
	 */
	@RequestMapping(URL)
	public List<Profile> getProfiles() {

		String tenantId = null;
		return profileService.getAllProfiles();

	}

	/**
	 * TO get all the profile details based on input id Noun based URI's -
	 * /profiles/id
	 * 
	 * @return
	 */
	@RequestMapping("/profiles/{id}")
	public Profile getProfileDetails(@PathVariable String id) {

		String tenantId = null;
		return profileService.getProfileDetails(id, tenantId);

	}

	/**
	 * To create new Profile during Self registration
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/profiles")
	public void addProfile(@RequestBody Profile profileObj) {
		String tenantId = null;
		profileService.insertProfile(profileObj, tenantId);

	}

	/**
	 * To update the existing Profile during Self registration
	 * 
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/profiles/{id}")
	public void updateProfile(@RequestBody Profile profileObj, @PathVariable String id) {
		String tenantId = null;
		profileService.updateProfile(id, profileObj, tenantId);

	}

	/**
	 * To update the existing Profile during Self registration
	 * 
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/profiles/{id}")
	public void deleteProfile(@PathVariable String id) {
		String tenantId = null;
		profileService.deleteProfile(id, tenantId);

	}

}
