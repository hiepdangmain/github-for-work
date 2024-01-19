/**
 * 
 */
package com.msb.ibs.common.base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Command
 *
 * @author binhnt26
 * @date 07/10/2021
 *
 */
public interface Command<I, O, E, U> {

	int thread = 1;

	void validate(I request);

	O process(I request, U principle);

	E build();

	Object event(E event);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	default O execute(I request, U principal) {
		validate(request);
		O result = process(request, principal);
		E e = build();
		if (thread != 0 && e != null) {
			ExecutorService executor = Executors.newFixedThreadPool(thread);
			Callable callable = new Callable() {
				@Override
				public Object call() throws Exception {
					Object response = event(e);
					return response;
				}
			};
			executor.submit(callable);
		}

		return result;
	}

}
