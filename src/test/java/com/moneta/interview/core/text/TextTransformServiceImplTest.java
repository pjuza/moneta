/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.moneta.interview.core.text;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


/**
 * Test suite for {@link TextTransformServiceImpl}.
 *
 * @author Petr Juza
 */
@RunWith(Parameterized.class)
public class TextTransformServiceImplTest {

    private TextTransformService service = new TextTransformServiceImpl();

    private final String input;
    private final String output;

    /**
     * Create parametrized classes.
     *
     * @param input The input text
     * @param output The expected text
     */
    public TextTransformServiceImplTest(String input, String output) {
        this.input = input;
        this.output = output;
    }

    /**
     * Data for parametrized test.
     *
     * @return the data for constructor
     */
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "", "" },
                { "ab", "Ba" },
                { "    a b", "B a" },
                { "Ahoj, jak se máš?", "?šÁm es kaj ,jOha" },
                { "Je     mi   fajn.", ".NjaF iM ej" },
        });
    }

    @Test
    public void testTransformation() {
        String res = service.transform(input);
        assertEquals(output, res);
    }
}
