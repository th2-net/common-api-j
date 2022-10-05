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


/**
 * <p>
 * This is the key interface for working with modules.
 * It allows you to dynamically load objects of specific module class.
 * After passing the desired class, the factory will instantiate it using the passed {@link ConfigurationProvider}.
 * </p>
 * <p>
 * To understand what class is supported, method
 * {@link #getModuleClass()} is used
 * </p>
 */
public interface ModuleFactory {
    /**
     * @return Class of supported module class.
     */
    Class<?> getModuleClass();

    /**
     * Creates an object of desirable module class
     *
     * @param configurationProvider the provider that will be used to read the configurations needed to instantiate the module
     * @return instance of desirable class
     */
    <M extends Module> M loadModule(ConfigurationProvider configurationProvider);

}
