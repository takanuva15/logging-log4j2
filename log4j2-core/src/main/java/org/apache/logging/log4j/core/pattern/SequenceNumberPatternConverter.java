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

package org.apache.logging.log4j.core.pattern;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;

import java.util.concurrent.atomic.AtomicLong;


/**
 * Formats the event sequence number.
 */
@Plugin(name="SequenceNumberPatternConverter", type="Converter")
@ConverterKeys({"sn", "sequenceNumber"})
public class SequenceNumberPatternConverter extends LogEventPatternConverter {
    private static AtomicLong sequence = new AtomicLong();
    /**
     * Singleton.
     */
    private static final SequenceNumberPatternConverter INSTANCE =
        new SequenceNumberPatternConverter();

    /**
     * Private constructor.
     */
    private SequenceNumberPatternConverter() {
        super("Sequence Number", "sn");
    }

    /**
     * Obtains an instance of SequencePatternConverter.
     *
     * @param options options, currently ignored, may be null.
     * @return instance of SequencePatternConverter.
     */
    public static SequenceNumberPatternConverter newInstance(
        final String[] options) {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    public void format(final LogEvent event, final StringBuilder toAppendTo) {
        toAppendTo.append(Long.toString(sequence.incrementAndGet()));
    }
}
