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

/**
 * Contract for core with text transformations.
 *
 * @author Petr Juza
 */
public interface TextTransformService {

    /**
     * Transforms input text according to the following rules:
     * <ul>
     *     <li>the text will be reverted: abc -> cba
     *     <li>two and mores spaces join to only one space
     *     <li>characters a,e,i,o,u (also diacritics variants such as í, Á, ů, Ě)
     *      will be replaced by uppercase characters
     * </ul>
     *
     * @param inputText The input text
     * @return transformed rules
     */
    String transform(String inputText);
}
