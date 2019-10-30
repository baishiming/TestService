# Service 例子

* 参考: https://blog.csdn.net/javazejian/article/details/52709857#t9
* 关于Android Service真正的完全详解，你需要知道的一切

* 1. startService sopService 生命周期

    onCreate:
    onStartCommand:
    onDestroy:

* 2. bindService unBindService 生命周期

    onCreate:
    onBind:
    onUnbind:
    onDestroy:

* 3. startService bindService unbindService stopService

    onCreate
    onStartCommand
    onBind
    onUnbind
    onDestroy
* 4. startService bindService stopService unbindService
    注; stopService 没有执行任何生命周期
    onCreate
    onStartCommand
    onBind
    onUnbind
    onDestroy

* 5. bindService startService stopService unbindService
    同： 4

* 6. bindService startService unbindService stopService
    同： 3

* 3. 传递数据