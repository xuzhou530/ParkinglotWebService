#智能自助式停车场管理系统——后台web管理服务器的设计

### 设计的意义
方便管理员管理整个系统，了解停车场的状态，实时管理停车场。并对用户实时动态管理。有了这个系统，停车场不需要人员值守。

### 功能
- 监控管理
 - 视频实时监控
 - 温湿度实时监控
 - 烟雾报警（此功能写到核心服务器端了）  
- 服务器管理
 - 开启服务器
 - 关闭服务器
- 用户管理
 - 用户列表
 - 在线用户
 - 用户充值管理

----

### 编码实现
采用java Web项目 符合MVC三层框架

### 界面图片展示

- 服务开启时长
![服务开启时长](http://7xj2yt.com1.z0.glb.clouddn.com/web_登录首界面.png)
- 温湿度监测【折线图】
![温湿度监测](http://7xj2yt.com1.z0.glb.clouddn.com/web_温湿度.png)
- 温湿度监测【柱形图】
![温湿度监测](http://7xj2yt.com1.z0.glb.clouddn.com/web_温湿度1.png)
- 视频监控界面
![温湿度监测](http://7xj2yt.com1.z0.glb.clouddn.com/web_视频监控界面.png)
- 充值
![充值界面](http://7xj2yt.com1.z0.glb.clouddn.com/web_充值界面.png)
- 在线用户
![在线用户](http://7xj2yt.com1.z0.glb.clouddn.com/web_查看在线用户界面.png)
- 所有用户
![所有用户](http://7xj2yt.com1.z0.glb.clouddn.com/web_查看所有用户界面.png)
