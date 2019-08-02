package com.gaohwangh.consumer.client;

import com.gaohwangh.api.feignClient.StudentClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author: GH
 * @Date: 2019/8/1 23:53
 * @Version 1.0
 */
@FeignClient("${feign-client.ourlove-server-plus}")
public interface StudentFeignClient extends StudentClient {

}
