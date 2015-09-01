/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */
package org.apache.logging.log4j.core.config.builder.impl;

import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.FilterComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.LayoutComponentBuilder;

/**
 * Holds the Appender Component attributes and subcomponents.
 */
class DefaultAppenderComponentBuilder extends DefaultComponentBuilder<AppenderComponentBuilder> implements
        AppenderComponentBuilder {

    public DefaultAppenderComponentBuilder(DefaultConfigurationBuilder<? extends Configuration> builder, String name,
            String type) {
        super(builder, name, type);
    }

    @Override
    public AppenderComponentBuilder add(LayoutComponentBuilder builder) {
        addComponent(builder);
        return this;
    }

    @Override
    public AppenderComponentBuilder add(FilterComponentBuilder builder) {
        addComponent(builder);
        return this;
    }
}
