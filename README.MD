## 项目介绍
- 用于对接 中国电信.天翼支付 ，官方 https://www.bestpay.com.cn/



## 更新日志
- v0.0.1 天翼支付依赖库发布;



## 详细教程
- 文档：准备中

## 项目说明
1. 用于天翼支付，基于Java语言实现的依赖库；
2. 接口参数全部封装，使用者仅需创建对象并设置参数；
3. 项目极少依赖，接口简单清晰，日志详细且输出格式友好；
4. 示例详细且简单易懂，文档全面，大大降低天翼支付接入门槛；

## 依赖安装
- Maven
```
<dependency>
    <groupId>org.thlws</groupId>
    <artifactId>payment-bestpay</artifactId>
    <version>0.0.1</version>
</dependency>
```
- Gradle
```
compile 'org.thlws:payment-bestpay:0.0.1'
```

## 源码测试
1. ```git clone https://github.com/thlws/payment-bestpay.git```
2. 导入到 Eclipse 或 Intellij IDEA
3. 运行 Junit Class BestpayTest (天翼支付相关接口)


## FAQ
- 能不能直接 dependency 添加依赖?<br>
_暂时还不能(如上添加方式暂不可用)._

- 项目对JDK版本是否有特定要求?<br>
_是的，仅支持 JDK >= 1.7 ._

- 有没有天翼支付相关文档？<br>
_[天翼支付](https://gitee.com/thlws/payment-bestpay/raw/master/docs/%E7%94%B5%E4%BF%A1%E7%BF%BC%E6%94%AF%E4%BB%98.pdf)_ <br>


## 打赏一下
![](imgs/award.png)
