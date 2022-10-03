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

import com.exactpro.th2.common.schema.configuration.Configuration

/**
 * This interface is a *Facade* to make it easier to work
 * with a dynamic structure of configurations and modules.
 *
 * The method names speak for themselves.
 * Pass the desired class and get its instance.
 */
interface ModuleApi {

    // todo add <out Module> constraint
    /**
     * Creates an instance of module of desirable class.
     */
    fun <M> loadModule(clazz: Class<M>): M

    /**
     * Creates an instance of configuration of desirable class.
     */
    fun <C : Configuration> loadConfiguration(clazz: Class<C>): C
}