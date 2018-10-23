翼支付
============
[![](https://img.shields.io/badge/release-v1.0.1-green.svg)](https://github.com/thlws/payment-bestpay)   [![](https://img.shields.io/badge/license-Apache--2-yellowgreen.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)  [![](https://img.shields.io/badge/maven%20central-v1.0.1-orange.svg)](https://search.maven.org/artifact/org.thlws/payment-bestpay/1.0.1/jar) 

> 基于Java实现的 中国电信.翼支付  依赖库

### 功能说明
1. 用于天翼支付，基于Java语言实现的依赖库；
2. 接口参数全部封装，使用者仅需创建对象并设置参数；
3. 项目极少依赖，接口简单清晰，日志详细且输出格式友好；
4. 示例详细且简单易懂，文档全面，大大降低天翼支付接入门槛；
5. 依赖库实现基础支付相关接口,若需异步通知或退款回调请参考文档自行实现；

### 更新日志
- v1.0.0 天翼支付依赖库发布;
- v1.0.1 升级依赖库hutool;

### 参考文档
- [天翼支付API文档](https://gitee.com/thlws/payment-bestpay/raw/master/docs/%E7%94%B5%E4%BF%A1%E7%BF%BC%E6%94%AF%E4%BB%98.pdf)
- [https://www.bestpay.com.cn](https://www.bestpay.com.cn)


### 在线交流
- 邮箱：hanley@thlws.com 
- QQ群：  [![](https://img.shields.io/badge/chat-on%20qq-red.svg)](//shang.qq.com/wpa/qunwpa?idkey=521df1fba7ef96db15c898e48feb26b6a82f6c2a60612154181b301febb30494) 693169203



### 依赖安装
- Maven
```
<dependency>
    <groupId>org.thlws</groupId>
    <artifactId>payment-bestpay</artifactId>
    <version>1.0.1</version>
</dependency>
```
- Gradle
```
compile 'org.thlws:payment-bestpay:1.0.1'
```

### 全部支付
<b style="color:red">payment-*</b> 是一系列基于Java实现的支付类库，包含支付宝、微信、翼支付等，其目的是以最简单的方式完成各种支付方式接入。
目前支付类库各自独立，使用时需单独引用，详见“支付类库”各自主页说明，后续不排除对所有支付类库整体打包，请留意文档更新。
- [https://gitee.com/thlws/payment-alipay](https://gitee.com/thlws/payment-alipay)
- [https://gitee.com/thlws/payment-wechat](https://gitee.com/thlws/payment-wechat)
- [https://gitee.com/thlws/payment-bestpay](https://gitee.com/thlws/payment-bestpay)   

