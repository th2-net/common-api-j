/*
 * Copyright 2020-2022 Exactpro (Exactpro Systems Limited)
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.exactpro.th2.common;

import com.exactpro.th2.common.schema.configuration.Configuration;

import java.util.Set;

/**
 * <p>
 * This is the key interface for working with modules.
 * It allows you to dynamically load objects of specified classes: modules or configurations.
 * After passing the desired class, the factory will instantiate it using the passed {@link ConfigurationProvider}.
 * </p>
 * <p>
 * Each factory supports a limited number of classes.
 * To understand which classes are supported, methods
 * {@link #getModuleClasses()} and {@link #getConfigurationClasses()} are used
 * </p>
 */
public interface ModuleFactory {
    /**
     * @return Set of supported module classes.
     */
    Set<Class<?>> getModuleClasses();

    /**
     * @return Set of supported configuration classes.
     */
    Set<Class<? extends Configuration>> getConfigurationClasses();

    /**
     * Creates an object of desirable module class
     *
     * @param configurationProvider the provider that will be used to read the configurations needed to instantiate the module
     * @param aClass                class that the factory going to instantiate
     * @param <M>                   desirable class template parameter
     * @return instance of desirable class
     */
    <M> M loadModule(ConfigurationProvider configurationProvider, Class<M> aClass);

    /**
     * Creates an object of desirable configuration class
     *
     * @param configurationProvider the provider that will be used to read the configuration
     * @param aClass                class that the factory going to instantiate
     * @param <C>                   desirable class template parameter
     * @return instance of desirable class
     */
    <C extends Configuration> C loadConfiguration(ConfigurationProvider configurationProvider, Class<C> aClass);
}
