##最理想的架构图
![](https://raw.githubusercontent.com/lzggsimida123/picture/master/jiagou.png)
由于云服务器的限制nginx反向代理没有实现。其他均已实现。
##实例访问
门户访问:http://123.206.13.239:8082/
后台访问:http://123.206.13.239:8080/
##说明
用三台腾讯云服务器实现,刚好可以达到Redis集群的标准,在同一台服务器中可以部署6个tomcat服务器，搭建6个不同的服务。