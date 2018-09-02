package com.aiguibin.action;

import com.alibaba.fastjson.JSONObject;
import org.glassfish.jersey.internal.guava.ThreadFactoryBuilder;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Component
@Path("rest")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FirstRestful {


    @Path("first")
    @GET
    public JSONObject data(){
        JSONObject data=new JSONObject();
        data.put("one","hello");
        data.put("two","world");
        return data;
    }
    @Path("second")
    @GET
    public List<Thread> threadTask(){
        List<Thread> threads=new ArrayList<>();
        //创建线程工厂
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        //通过线程工厂创建线程,并传入Runnable任务
        Thread thread=threadFactory.newThread(() -> System.out.println(0));
        /**
        //创建线程池,传入线程工厂
        ExecutorService singleThreadPool = new ThreadPoolExecutor(3, 10,
                10000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024),
                threadFactory, new ThreadPoolExecutor.AbortPolicy());
        //thread.start();
        //singleThreadPool.execute(thread);
        //singleThreadPool.submit(thread);

        threads.add(thread);*/

        return threads;
    }
}
