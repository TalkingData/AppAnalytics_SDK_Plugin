# 安装指南

1. 下载最新的插件二进制文件并解压；
2. 拖动TalkingDataSDKExtension.app到你的应用程序下；
3. 双击TalkingDataSDKExtension.app，然后退出；
4. 系统设置->扩展程序->Xcode Source Editor->开启插件；
5. 重启Xcode，此时在Xcode的编辑菜单中，将显示插件的具体内容。

# 使用指南

## 使用方法一：手动选择使用

手动选择的方式使用是指每次需要进行某个业务代码插入的时候，在Xcode的菜单栏中进行手动选择，如下图：

![](resource/demo1.png)

## 使用方法二：通过设置快捷键使用

你也可以通过设置快捷键的方式，为每一个动作设定自己喜欢的快捷键，设置好之后，可以直接使用快捷键的方式使用插件。设置快键键的方式如下：

1. 在Xcode的Preferences中选择Key Bindings，然后在搜索栏中键入TalkingData或者AppAnalytics，将会搜索到和本插件相关的所有指令；

![](resource/demo2.png)

2. 为指令设置快捷键（快捷键的设置需要避免重复）；

![](resource/demo3.png)

3. 设置好快捷键后，就可以直接使用快捷键进行指令调用了。
