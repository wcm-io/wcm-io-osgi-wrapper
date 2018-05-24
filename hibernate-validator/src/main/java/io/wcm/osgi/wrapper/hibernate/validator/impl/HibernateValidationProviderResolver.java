/*
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2018 wcm.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package io.wcm.osgi.wrapper.hibernate.validator.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationProviderResolver;
import javax.validation.spi.ValidationProvider;

import org.hibernate.validator.HibernateValidator;
import org.osgi.service.component.annotations.Component;

@Component(service = ValidationProviderResolver.class)
public class HibernateValidationProviderResolver implements ValidationProviderResolver {

  @Override
  public List<ValidationProvider<?>> getValidationProviders() {
    List<ValidationProvider<?>> providers = new ArrayList<ValidationProvider<?>>(1);
    providers.add(new HibernateValidator());
    return providers;
  }

}
