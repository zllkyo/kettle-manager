# kettle-manager
将kettle集成值web应用中，不再需打开kettle窗口运行，采用springmvc+beetlsql框架实现，并通过quartz自动任务进行数据抽取。配置简单方便。（之前需要kettle打开其运行环境，并配置数据库连接的相关信息）

支持kettle8.0.0.0.28版本

> 1. 下载项目
2. 导入idea
3. 等待maven下载完包
4. 等
5. 等
6. 一直等到项目不报错了
7. 导入数据库文件(mysql)
8. 配置数据库连接（resource目录下面）
9. 扔到Tomcat里面进行启动


[项目一些代码，参考了这位大神开发的管理平台。万分感谢，我只是做了个升级的工作（从4.4支持到了8.0）][1],修复了一些BUG


  [1]: https://github.com/uKettle/kettle