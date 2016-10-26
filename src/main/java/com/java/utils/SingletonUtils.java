package com.java.utils;

/**
 * Singleton helper class for lazily initialization.
 * 
 * @author <a href="https://github.com/albertocerqueira/" target="_blank">Alberto Cerqueira</a> 2016-10-26
 * 
 * @param <T>
 */
public abstract class SingletonUtils<T> {

	private T instance;

	protected abstract T newInstance();

	public final T getInstance() {
		if (instance == null) {
			synchronized (SingletonUtils.class) {
				if (instance == null) {
					instance = newInstance();
				}
			}
		}
		return instance;
	}
}