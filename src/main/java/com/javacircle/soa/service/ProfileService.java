package com.javacircle.soa.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import com.javacircle.soa.model.Profile;

@Service
public class ProfileService {

	public static List<Profile> profiles = new ArrayList<>(Arrays.asList(
			new Profile("SD5656565", "Tom", "Richard", "Tom@test.com"),
			new Profile("AP123", "Phil", "Hanks", "Phil@test.com"), 
			new Profile("AP456", "Jim", "Venice", "Jim@test.com"),
			new Profile("AP789", "Judy", "Syl", "Judy@test.com")));

	public List<Profile> getAllProfiles() {
		
		return this.profiles;
	}

	public Profile getProfileDetails(String profileId, String tenantId) {

		return profiles.stream().filter(t -> t.getProfileId().equals(profileId)).findFirst().get();
	}

	public void insertProfile(Profile profileObj, String tenantId) {

		profiles.add(profileObj);
	}

	public void updateProfile(String profileId, Profile profileObj, String tenantId) {

		if (profiles != null && profiles.size() > 0) {
			for (int i = 0; i < profiles.size(); i++) {
				Profile profile = profiles.get(i);
				if (profile.getProfileId().equalsIgnoreCase(profileId)) {
					profiles.set(i, profileObj);
				}
			}
		}
	}

	public void deleteProfile(String profileId, String tenantId) {

		if (profiles != null && profiles.size() > 0) {
			for (int i = 0; i < profiles.size(); i++) {
				Profile profile = profiles.get(i);
				if (profile.getProfileId().equalsIgnoreCase(profileId)) {
					profiles.remove(i);
				}
			}
		}
	}

}
