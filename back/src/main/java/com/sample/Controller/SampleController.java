package com.sample.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.Service.SampleService;

import lombok.RequiredArgsConstructor;

/**
 * 2022.08.01 / 오승현
 * 첫 문자는 반드시 RequestMethod 방식으로 작성한다.
 */
@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SampleController {

    private final SampleService sampleService;

    /**
     * SELECT 방식인 경우 반드시 GET 방식으로 호출한다.
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sample", method = RequestMethod.GET)
    public String getSample() throws Exception {
        return sampleService.getTimeString();
    }

    /**
     * INSERT(MERGE) 방식인 경우 반드시 POST 방식으로 호출한다.
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sample", method = RequestMethod.POST)
    public String postSample() throws Exception {
        return sampleService.getTimeString();
    }

    /**
     * DELETE 방식인 경우 반드시 DELETE 방식으로 호출한다.
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sample", method = RequestMethod.DELETE)
    public String deleteSample() throws Exception {
        return sampleService.getTimeString();
    }

    /**
     * UPDATE 방식인 경우 반드시 PUT 방식으로 호출한다.
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sample", method = RequestMethod.PUT)
    public String putSample() throws Exception {
        return sampleService.getTimeString();
    }

}