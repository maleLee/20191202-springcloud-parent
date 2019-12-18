package com.aaa.lee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/2 15:44
 * @Description
 *      springcloud的任何组件都必须要经过以下三个步骤:
 *          1.添加jar包
 *          2.添加注解
 *              启动eureka注册中心
 *              @EnableEurekaServer
 *          3.编写配置
 *      eureka是独立运行在Linux上面的和所有的项目都没有任何关系
 *      注册中心是独立存在的，不和其他的任何项目绑定
 *
 *
 *      EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE.
 *      eureka的自我保护机制(就是因为eureka的自我保护机制才成就了AP性)
 *      1.eureka长时间不访问的情况下，就会进入自我保护，说明eureka用不到，但是虽然没有使用到仍然在占用资源，eureka会认为自己没有用了(eureka会认为自己已经宕机),
 *      !!!保护eureka中的资源数据
 *          eureka如果认为自己已经宕机，就会认为不应该有新的服务再注册进来，但是实际上没有宕机
 *          这个时候突然有一个新的注册进来了，eureka并不知道自己没有宕机，会认为该数据是脏数据，为了不污染自己的资源数据，会把这些新的数据存放在不同的空间中
 *          所以仍然会正常的显示在页面上，如果eureka一直不重启，就会一直持续自我保护机制，也就是说所有新注册数据都会和老数据分开存放
 *          但是当eureka重启以后，eureka自我保护机制消除，会认为自己是一个存活状态，会把分开存放的数据合并在一起，如果在合并的时候发现两条数据一致
 *          根据注册时间进行覆盖(最新的时间覆盖之前的时间)
 *     2.eureka也会和zookeeper一样一直在检测provider的心跳，当eureka发现provider没有心跳了之后会继续等待，
 *          一般情况下30s秒接收一次(会等待60秒)，如果仍然没有心跳，则直接剔除
 *          !!!假设网络故障(eureka在上海部署，但是所有的provider在武汉部署，但是武汉突然地震，网络中断(3分钟))，eureka会大面积接收不到心跳
 *          eureka不会再剔除任何provider，为了保证数据的AP性
 *     3.eureka为什么不会剔除大面积宕机的provider？
 *          因为eureka一旦剔除了大面积的provider会造成consumer无法获取数据的影响，这样就违背了AP性，为了保证AP，最终才有这种设计
 *     4.其实eureka可以直接关闭自我保护机制，可以进行配置
 *          eureka.server.enable-self-preservation=false
 *          THE SELF PRESERVATION MODE IS TURNED OFF. THIS MAY NOT PROTECT INSTANCE EXPIRY IN CASE OF NETWORK/OTHER PROBLEMS.
 *       !!!!在真实开发环境中，不允许关闭eureka的自我保护!!!!
 *       可以自己配置失效自我保护
 *          当大面积接收不到心跳的时候就不再剔除
 *              1.把eureka接收provider心跳的时间给缩短
 *              2.规定provider告诉eureka我每隔多久发送一次心跳
 *                  provider每30s向eureka发送一次心跳，eureka也会30s去接收一次provider的心跳
 *                  规定eureka每10s接收一次provider的心跳，但是provider仍然30s发一次
 *
 *
 **/
@SpringBootApplication
@EnableEurekaServer
public class ApplicationRun7081 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun7081.class, args);
    }

}
