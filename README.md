# mybatis-enum-type-handler
mybatis提供的TypeHandler接口，可用于解决数据库数字映射到内存中枚举类型的问题

主要有以下两种方法：

## 针对每一个枚举类写一个TypeHandler，放在同一个包下面
- 参考`com.majian.mybatis.typehandler.GenderEnumTypeHandler`
- 重复代码，工作量
- 枚举实现比较自由
## 写一个公共的枚举类TypeHandler
- 参考`com.majian.mybatis.CommonEnumTypeHandler`
- 需要每个枚举实现特定接口，对代码有侵入
- 减少工作量