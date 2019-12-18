package com.aaa.lee.rule;

import com.netflix.loadbalancer.AbstractLoadBalancerRule;

import java.util.concurrent.ThreadLocalRandom;
/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/5 14:12
 * @Description
 *      在RandomRule中其实有两个choose方法
 *          1.重写IRule接口的方法(只有一个参数)--->调用了所重载的choose方法
 *          2.是重载了choose方法--->choose方法就是实现随机算法的地方
 **/
/*public class TestRule implements AbstractLoadBalancerRule {

    *//**
     * Randomly choose from all living servers
     * 从所有的存活的服务器上进行随机的选择
     *//*
    @edu.umd.cs.findbugs.annotations.SuppressWarnings(value = "RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE")
    public Server choose(ILoadBalancer lb, Object key) {
        *//**
         * ILoadBalancer接口就是对server做增删改查
         * 1.判断负载均衡器是否为null，如果为null说明根据就没有server
         *//*
        if (lb == null) {
            return null;
        }
        *//**
         * 2.声明server对象(就是最终根据算法所选择出的服务器对象)
         *//*
        Server server = null;

        *//**
         * 3.选出server服务器，直到选择出为止，如果没有选择出则一直选
         *//*
        while (server == null) {
            *//**
             * interrupted:打断--->线程中断(标识了线程是否中断的状态)
             *      如果该线程中断，则直接return null
             *//*
            if (Thread.interrupted()) {
                return null;
            }
            *//**
             * getReachableServers():获取所有存活的服务器列表
             *      5台
             *//*
            List<Server> upList = lb.getReachableServers();
            *//**
             * getAllServers():获取了所有的服务器列表
             *      8台
             *//*
            List<Server> allList = lb.getAllServers();
            *//**
             * 所有服务器的数量
             *//*
            int serverCount = allList.size();
            *//**
             * 判断服务器数量是否为0，如果数量为0说明没有服务器，直接return null
             *//*
            if (serverCount == 0) {
                *//*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 *//*
                return null;
            }
            *//**
             * chooseRandomInt(8)--->0到8进行随机
             *      TODO 其实真正的随机计算在这
             *//*
            int index = chooseRandomInt(serverCount);
            *//**
             * 根据服务器索引获取服务器对象
             *//*
            server = upList.get(index);

            if (server == null) {
                *//*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 *//*
                *//**
                 * yield():线程谦让
                 *      所谓的线程谦让也只是在并发的阶段会存在
                 *      如果多个线程进行抢夺资源的时候会出现死锁，一旦出现死锁，也就是说后来的线程一直在处于等待状态
                 *      容易造成服务的雪崩
                 *      一旦调用了yield方法就会让该线程处于等待就绪状态，等待下一次请求
                 *      yield并不是非得线程处于阻塞的情况下才可以使用，当线程处于正常的状态依然可以使用，但是正常运行的线程就会放弃当前所做的操作
                 *      直接处于等待状态，然后等待下一次请求
                 *//*
                Thread.yield();
                *//**
                 * 跳出本次循环进入下次循环
                 *//*
                continue;
            }
            *//**
             * isAlive():再次判断获取到的server是否处于存活状态
             *//*
            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        *//**
         * nextInt(8)--->0到8进行随机获取到一个随机数
         * 为什么不用Random？
         *      Random是线程安全的,其实Random的效率低并且Random可以被预测
         *      因为Random的底层是当前系统时间的微秒数
         *      ThreadLocalRandom是根据线程的id进行随机的,是没有规律的，但是Random是有规律的
         *
         *      ThreadLocalRandom:是非线程安全的-->效率快
         *          所谓的线程安全就是坐飞机需要过安检，线程非安全直接可以上飞机不需要安检
         *
         *//*
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

}*/
