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

package com.exactpro.th2.common

import com.exactpro.th2.common.schema.configuration.ConfigurationProviderConfig

/**
 * The factory creates an instance of the [ConfigurationProvider] with the specified parameters.
 *
 * Often the command line is used to specify these options,
 * so the factory has methods for parsing the command line
 */
interface ConfigurationProviderFactory {

    /**
     * Class that the factory is responsible for instantiating
     */
    val type: Class<out ConfigurationProvider>

    /**
     * Class that holds configuration for the provider implementation.
     */
    val configClass: Class<out ConfigurationProviderConfig>

    /**
     * Method for instantiating a [ConfigurationProvider] using config.
     * Each factory implementation can have its own settings.
     */
    fun create(config: ConfigurationProviderConfig): ConfigurationProvider

}