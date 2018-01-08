## 项目介绍
- payment是一系列基于Java实现的支付类库，包含支付宝、微信、翼支付等，其目的是以最简单的方式完成各种支付方式接入。

## 支付类库
- [https://gitee.com/thlws/payment-alipay](https://gitee.com/thlws/payment-alipay)
- [https://gitee.com/thlws/payment-wechat](https://gitee.com/thlws/payment-wechat)
- [https://gitee.com/thlws/payment-bestpay](https://gitee.com/thlws/payment-bestpay)


## 详细教程
- 文档：准备中

## 功能说明
1. 用于天翼支付，基于Java语言实现的依赖库；
2. 接口参数全部封装，使用者仅需创建对象并设置参数；
3. 项目极少依赖，接口简单清晰，日志详细且输出格式友好；
4. 示例详细且简单易懂，文档全面，大大降低天翼支付接入门槛；
5. 依赖库实现基础支付相关接口,若需异步通知或退款回调请参考文档自行实现；

## 依赖安装
- Maven
```
<dependency>
    <groupId>org.thlws</groupId>
    <artifactId>payment-bestpay</artifactId>
    <version>1.0.0</version>
</dependency>
```
- Gradle
```
compile 'org.thlws:payment-bestpay:1.0.0'
```

## 源码测试
1. ```git clone https://github.com/thlws/payment-bestpay.git```
2. 导入到 Eclipse 或 Intellij IDEA
3. 运行 Junit Class BestpayTest (天翼支付相关接口)

## 项目依赖
- [http://www.hutool.cn](http://www.hutool.cn)

## 更新日志
- v1.0.0 天翼支付依赖库发布;

## FAQ
- 能不能直接 dependency 添加依赖?<br>
_已发布至共有仓库,添加方式如上._

- 项目对JDK版本是否有特定要求?<br>
_是的，仅支持 JDK >= 1.7 ._

- 有没有天翼支付相关文档？<br>
_[天翼支付](https://gitee.com/thlws/payment-bestpay/raw/master/docs/%E7%94%B5%E4%BF%A1%E7%BF%BC%E6%94%AF%E4%BB%98.pdf)_ <br>

- 天翼支付官方网站 ？<br>
_中国电信.翼支付,官方网站[https://www.bestpay.com.cn](https://www.bestpay.com.cn)_

## 打赏一下
![](imgs/award.png)
