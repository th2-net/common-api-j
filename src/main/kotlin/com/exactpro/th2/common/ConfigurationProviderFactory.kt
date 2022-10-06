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
     * Method for instantiating a [ConfigurationProvider] using parameters.
     * Each factory implementation can have its own arguments
     *
     * To get an array of arguments, use method [parseArguments]
     */
    fun create(args: Array<String>): ConfigurationProvider

    /**
     * The factory is responsible for selecting the required parameters from the whole list.
     * This method allows you to parse the command line object
     * to get the right parameters in the right order.
     */
    fun parseArguments(args: Array<String>): Array<String>

}