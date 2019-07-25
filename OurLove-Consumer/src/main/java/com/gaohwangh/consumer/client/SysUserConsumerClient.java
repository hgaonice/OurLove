package com.gaohwangh.consumer.client;

import com.gaohwangh.api.feignClient.SysUserClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author: GH
 * @Date: 2019/7/25 22:16
 * @Version 1.0
 */
@FeignClient(name = "${feign-client.ourlove-server}")
public interface SysUserConsumerClient extends SysUserClient {

}
