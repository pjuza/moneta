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

package com.moneta.interview.web.text.rest;

import com.moneta.interview.core.text.TextTransformService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * REST controller with operations for text transformations.
 *
 * @author Petr Juza
 */
@RestController
@RequestMapping(value = TextController.URI)
public class TextController {

    public static final String URI = "/api/text";

    private static final Logger LOG = LoggerFactory.getLogger(TextController.class);

    @Autowired
    private TextTransformService textTransformService;

    /**
     * Transforms input text.
     *
     * @param inputText The input text
     * @return transformed text
     */
    @RequestMapping(value = "/transform", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String transformText(@RequestBody String inputText) {
        String res = textTransformService.transform(inputText);
        
        LOG.trace("Input text '{}' transformed to '{}'", inputText, res);

        return res;
    }
}
