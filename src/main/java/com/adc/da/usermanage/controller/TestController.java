package com.adc.da.usermanage.controller;

import com.adc.da.usermanage.service.DataSynchronizationBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
public class TestController {

	@Autowired
	private DataSynchronizationBatchService dataSynchronizationBatchService;


    @GetMapping("/test")
    public String test() {
    	dataSynchronizationBatchService.dataSynchronization();
    	return "成功";
    }
}
