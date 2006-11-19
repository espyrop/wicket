/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package wicket.markup.html.form.validation;

import java.util.Collections;

import wicket.markup.html.form.Form;
import wicket.markup.html.form.FormComponent;
import wicket.util.lang.Objects;

/**
 * Validates that the input of two form components is identical. Errors are
 * reported on the second form component with key 'EqualInputValidator' and
 * the variables:
 * <ul>
 * <li>${input(n)}: the user's input</li>
 * <li>${name}: the name of the component</li>
 * <li>${label(n)}: the label of the component - either comes from
 * FormComponent.labelModel or resource key [form-id].[form-component-id] in
 * that order</li>
 * </ul>
 * 
 * @author Igor Vaynberg (ivaynberg)
 */
public class EqualInputValidator extends AbstractFormValidator
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** form components to be checked. */
	private final FormComponent[] components;

	/**
	 * Construct.
	 * 
	 * @param formComponent1
	 *            a form component
	 * @param formComponent2
	 *            a form component
	 */
	public EqualInputValidator(FormComponent formComponent1, FormComponent formComponent2)
	{
		if (formComponent1 == null)
		{
			throw new IllegalArgumentException("argument formComponent1 cannot be null");
		}
		if (formComponent2 == null)
		{
			throw new IllegalArgumentException("argument formComponent2 cannot be null");
		}
		components = new FormComponent[] { formComponent1, formComponent2 };
	}

	/**
	 * @see wicket.markup.html.form.validation.IFormValidator#getDependentFormComponents()
	 */
	public FormComponent[] getDependentFormComponents()
	{
		return components;
	}

	/**
	 * @see wicket.markup.html.form.validation.IFormValidator#validate(wicket.markup.html.form.Form)
	 */
	public void validate(Form form)
	{
		// we have a choice to validate the type converted values or the raw
		// input values, we validate the raw input
		final FormComponent formComponent1 = components[0];
		final FormComponent formComponent2 = components[1];

		if (!Objects.equal(formComponent1.getInput(), formComponent2.getInput()))
		{
			final String key = resourceKey(components);
			formComponent2.error(Collections.singletonList(key), messageModel());
		}
	}
	
}