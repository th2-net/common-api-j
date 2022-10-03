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

/**
 * This interface is used to read or load configurations.
 * Each implementation of it uses a different method or data source.
 */
interface ConfigurationProvider {

    /**
     * Used to load configuration
     *
     * @param configId configuration id used to specify the configuration to be loaded
     * @param cfgClass configuration class which will contain the read data
     * @return instance of desired class with read data
     */
    fun <C> loadConfiguration(configId: String, cfgClass: Class<out C>): C
}
