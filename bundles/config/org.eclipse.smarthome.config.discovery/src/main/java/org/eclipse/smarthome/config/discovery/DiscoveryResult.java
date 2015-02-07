/**
 * Copyright (c) 2014-2015 openHAB UG (haftungsbeschraenkt) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.config.discovery;

import java.util.Map;

import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.ThingUID;

/**
 * The {@link DiscoveryResult} is a container for one result of a discovery process.
 * The discovery process can lead to <i>0..N</i> {@link DiscoveryResult} objects
 * which are fired as an event to registered {@link DiscoveryListener}s.
 *
 * @author Kai Kreuzer - Initial API
 *
 * @see DiscoveryService
 * @see DiscoveryListener
 */
public interface DiscoveryResult {

    /**
     * Returns the unique {@code Thing} ID of this result object.
     * <p>
     * A {@link ThingUID} must be a unique identifier of a concrete {@code Thing} which <i>must not</i> consist of data
     * which could change (e.g. configuration data such as an IP address). If a {@code Thing} disappears and is
     * discovered again, the same {@code Thing} ID must be created. A typical {@code Thing} ID could be the serial
     * number. It's usually <i>not</i> a product number.
     *
     * @return the Thing ID of this result object (not null, not empty)
     */
    public ThingUID getThingUID();

    /**
     * Returns the unique {@code Thing} type ID of this result object.
     * <p>
     * A {@code Thing} type ID could be a product number which identifies the same type of {@link Thing}s. It's usually
     * <i>not</i> a serial number.
     *
     * @return the unique Thing type of this result object (not null, not empty)
     */
    public ThingTypeUID getThingTypeUID();

    /**
     * Returns the binding ID of this result object.
     * <p>
     * The binding ID is extracted from the unique {@code Thing} ID.
     *
     * @return the binding ID of this result object (not null, not empty)
     */
    public String getBindingId();

    /**
     * Returns the properties of this result object.<br>
     * The properties contain information which become part of a {@code Thing}.
     * <p>
     * <b>Hint:</b> The returned properties are immutable.
     *
     * @return the properties of this result object (not null, could be empty)
     */
    public Map<String, Object> getProperties();

    /**
     * Returns the flag of this result object.<br>
     * The flag signals e.g. if the result is {@link DiscoveryResultFlag#NEW} or has been marked as
     * {@link DiscoveryResultFlag#IGNORED}. In the latter
     * case the result object should be regarded as known by the system so that
     * further processing should be skipped.
     *
     * @return the flag of this result object (not null)
     */
    public DiscoveryResultFlag getFlag();

    /**
     * Returns the human readable label for this result object.
     *
     * @return the human readable label for this result object (not null, could be empty)
     */
    public String getLabel();

    /**
     * Returns the unique bridge ID of the {@link DiscoveryResult}.
     *
     * @return the unique bridge ID (could be null)
     */
    public ThingUID getBridgeUID();

}
