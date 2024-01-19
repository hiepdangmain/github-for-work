/**
 * 
 */
package com.msb.ibs.common.base;

/**
 * Query
 *
 * @author binhnt26
 * @date 07/10/2021
 *
 */
public interface Query<I, O> {

	void validate(I request);

	O process(I request);

	default O execute(I request) {
		validate(request);
		return process(request);
	}

}
