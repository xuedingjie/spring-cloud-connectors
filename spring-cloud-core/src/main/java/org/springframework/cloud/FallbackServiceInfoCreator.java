package org.springframework.cloud;

import org.springframework.cloud.service.ServiceInfo;

/**
 * Fallback service info creator to deal with situations there is no {@link ServiceInfoCreator} that can
 * accept service data.
 *
 * A fallback mechanism is needed, for example, when a services is bound to an app, but there is no {@link ServiceInfoCreator}
 * implemented to handle it or the {@link ServiceInfoCreator} implementation
 * for it isn't placed properly to be picked up by scanning. By having a fallback mechanism, we can
 * extract as much info from the service data as possible (minimally, the service id) and issue a warning.
 *
 * @param <SI> the type of {@link ServiceInfo} that this fallback creator will return
 * @param <SD> the type of service definition data that this creator will consume
 * @author Ramnivas Laddad
 */
public abstract class FallbackServiceInfoCreator<SI extends ServiceInfo, SD> implements ServiceInfoCreator<SI, SD> {

	/*
	 * Override to ensure that it accepts all service data
	 */
	@Override
	public final boolean accept(SD serviceData) {
		return true;
	}
}
