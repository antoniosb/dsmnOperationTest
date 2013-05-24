package br.com.teltools.dsmn.envelope;

import java.util.LinkedHashMap;
import java.util.Map;

/** 
 * Structured representation the <strong>Subscriber Element</strong> of an DSMN SOAP Envelop
 * For detailed information about the overall structure see {@link br.com.teltools.dsmn.envelope.EnvRoot}.
 * 
 * This class represents the Subscriber, so it has a set of (key->value) tuples,
 * representing detailed information about this subscriber/operation
 *
 */
public class EnvSubscriber {
	private final Map<String, String> map;

	public EnvSubscriber() {
		this.map = new LinkedHashMap<String, String>();
	}

	/**
	 * Adds a key->value tuple to this subscriber
	 * 
	 * @param key Key of this tuple
	 * @param value Value of this tuple
	 */
	public void putVar(String key, String value) {
		map.put(key, value);
	}

	/**
	 * Gets the map representing all key->value tuples in
	 * this subscriber
	 * 
	 * @return Map<String,String> representing the tuples
	 */
	public Map<String, String> getMap() {
		return this.map;
	}
}