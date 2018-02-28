/**
 * saurabh
 * git: Saurabh Sirdeshmukh saurabh.cse2@gmail.com
 */
package com.ridecell.parkingassistant;

import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author saurabh
 * git: Saurabh Sirdeshmukh saurabh.cse2@gmail.com
 *
 */
public class AppResourceConfig extends ResourceConfig {
	private static final String REST_BASE_PACKAGE = "com.ridecell.parkingassistant.restapi";
	 
	public AppResourceConfig(){
		//Base package suffices as it scans all the subpackages recursively.
		packages(REST_BASE_PACKAGE)
		.register(MoxyJsonFeature.class);
	} 
}
