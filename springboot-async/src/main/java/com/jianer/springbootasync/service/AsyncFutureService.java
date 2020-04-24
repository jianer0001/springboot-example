package com.jianer.springbootasync.service;

import java.util.concurrent.Future;

/**
 * @author 杨兴健
 * @Date 2020/4/24 12:06
 */
public interface AsyncFutureService {
    Future<String> fun() throws Exception;
}
