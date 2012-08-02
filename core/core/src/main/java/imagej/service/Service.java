/*
 * #%L
 * ImageJ software for multidimensional image processing and analysis.
 * %%
 * Copyright (C) 2009 - 2012 Board of Regents of the University of
 * Wisconsin-Madison, Broad Institute of MIT and Harvard, and Max Planck
 * Institute of Molecular Cell Biology and Genetics.
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 * The views and conclusions contained in the software and documentation are
 * those of the authors and should not be interpreted as representing official
 * policies, either expressed or implied, of any organization.
 * #L%
 */

package imagej.service;

import imagej.Priority;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.java.sezpoz.Indexable;

/**
 * Annotation indicating a discoverable service. ImageJ discovers available
 * services at runtime by looking for classes that implement the
 * {@link IService} interface and are annotated with this annotation.
 * 
 * @author Curtis Rueden
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
@Indexable(type = IService.class)
public @interface Service {

	/**
	 * Services are selected for instantiation based on priority. This is useful
	 * to control which service implementation is chosen when multiple
	 * implementations are present in the classpath, as well as to force
	 * instantiation of one service over another when the dependency hierarchy
	 * does not dictate otherwise.
	 * <p>
	 * Any double value is allowed, but for convenience, there are some presets:
	 * </p>
	 * <ul>
	 * <li>{@link Priority#FIRST_PRIORITY}</li>
	 * <li>{@link Priority#VERY_HIGH_PRIORITY}</li>
	 * <li>{@link Priority#HIGH_PRIORITY}</li>
	 * <li>{@link Priority#NORMAL_PRIORITY}</li>
	 * <li>{@link Priority#LOW_PRIORITY}</li>
	 * <li>{@link Priority#VERY_LOW_PRIORITY}</li>
	 * <li>{@link Priority#LAST_PRIORITY}</li>
	 * </ul>
	 */
	double priority() default Priority.NORMAL_PRIORITY;

}
