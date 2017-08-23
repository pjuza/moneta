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

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


/**
 * Default implementation of {@link TextTransformService} interface.
 *
 * @author Petr Juza
 */
@Service
public class TextTransformServiceImpl implements TextTransformService {

    private final List<String> SPECIAL_CHARS = Arrays.asList("a", "e", "i", "o", "u");

    @Override
    public String transform(String inputText) {
        if (inputText == null) {
            return "";
        }

        // trim spaces
        String tmp = inputText.trim().replaceAll("\\s{2,}", " ");

        // replace special characters (also with accents) and reverse characters order
        char[] chars = tmp.toCharArray();
        StringBuffer resChars = new StringBuffer(tmp).reverse();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];

            // is special character? if yes then upper case it at same position as in original text
            if (SPECIAL_CHARS.contains(StringUtils.stripAccents(String.valueOf(ch)).toLowerCase())) {
                resChars.setCharAt(i, Character.toUpperCase(resChars.charAt(i)));
            } else {
                // if not special character then lower case it
                resChars.setCharAt(i, Character.toLowerCase(resChars.charAt(i)));
            }
        }

        return resChars.toString();
    }
}
