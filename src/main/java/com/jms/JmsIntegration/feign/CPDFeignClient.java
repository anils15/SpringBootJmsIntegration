package com.jms.JmsIntegration.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.jms.JmsIntegration.model.User;

@FeignClient(name = "crud-app", url= "http://localhost:9191")
public interface CPDFeignClient {

	@GetMapping(value = "/user/getUser", consumes = "application/json")
	List<User> getAllUser();
}