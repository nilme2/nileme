#!/bin/bash

java -XX:+UnlockDiagnosticVMOptions -XX:+LogCompilation me.nilme.exercise.jvm.Test


#  HotSpot JVM 提供给了两个新的参数，在 JVM 启动后，在命令行中可以输出所有 XX 参数和值

java -XX:+PrintFlagsFinal -XX:+PrintFlagsInitial
java -client -XX:+PrintFlagsFinal

java -server -XX:+UnlockExperimentalVMOptions -XX:+UnlockDiagnosticVMOptions -XX:+PrintFlagsFinal
#“:=” 表明了参数被用户或者 JVM 赋值
java -server -XX:+UnlockExperimentalVMOptions -XX:+UnlockDiagnosticVMOptions -XX:+PrintFlagsFinal Benchmark | grep ":"

#列举出 -XX:+PrintFlagsFinal的结果中第三列有“:=”的参数，已经被用户或者 JVM 设置过的详细的 XX 参数的名称和值
java -server -XX:+PrintCommandLineFlags

#启动一个初始化堆内存为 128M，最大堆内存为 2G
java -Xms128m -Xmx2g me.nilme.exercise.jvm.Test
#等价
java -XX:InitialHeapSize=128m -XX:MaxHeapSize=2g

#让 JVM 在发生内存溢出时自动的生成堆内存快照
#默认情况下，堆内存快照会保存在 JVM 的启动目录下名为 java_pid.hprof 的文件里（在这里 就是 JVM 进程的进程号）。
-XX:+HeapDumpOnOutOfMemoryError

# 也可以通过改变默认的堆内存快照生成路径，可以是相对或者绝对路径。
-XX:HeapDumpPath=

# 当内存溢出错误发生的时候，我们会将堆内存快照写到 /tmp/heapdump.hprof 文件并且在 JVM 的运行目录执行脚本 cleanup.sh
java -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp/heapdump.hprof -XX:OnOutOfMemoryError =


# 用于设置永久代大小的最大值，
-XX:MaxPermSize
# 用于设置永久代初始大小
-XX:PermSize
#设置的堆内存以外的更多的一些堆内存。
-XX:MaxHeapSize


#代码缓存的大小
-XX:InitialCodeCacheSize
-XX:ReservedCodeCacheSize

#当代码缓存被填满时让 JVM 放弃一些编译代码。
-XX:+UseCodeCacheFlushing

# -XX:MaxNewSize 最大可以设置为 - Xmx/2。
-XX:NewSize
-XX:MaxNewSize

#指定老年代 / 新生代为 3/1。 老年代占堆大小的 3/4，新生代占 1/4 。
-XX:NewRatio=3

#如果针对新生代，同时定义绝对值和相对值，绝对值将起作用
#以下设置，JVM 会尝试为新生代分配四分之一的堆大小，但不会小于 32MB 或大于 521MB
java -XX:NewSize=32m -XX:MaxNewSize=512m -XX:NewRatio=3


#如果对应用的内存使用一无所知，正确的做法是不要设置任何参数，如果应用运行良好。
# 很好，我们不用做任何额外动作。如果遇到性能或 OutOfMemoryErrors，在调优之前，首先需要进行一系列有目的的监控测试，缩小问题的根源。


#表示伊甸园区 (Eden) 是 幸存区 To 大小的 10 倍 (也是幸存区 From 的 10 倍)。
# 所以， 伊甸园区 (Eden) 占新生代大小的 10/12， 幸存区 From 和幸存区 To 每个占新生代的 1/12 。
# 注意， 两个幸存区永远是一样大的。
-XX:SurvivorRatio=10

#总之， 我们希望最小化短命对象晋升到老年代的数量，同时也希望最小化新生代 GC 的次数和持续时间。
#我们需要找到针对当前应用的折中方案， 寻找适合方案的起点是 了解当前应用中对象的年龄分布情况。

#指定 JVM 在每次新生代 GC 时，输出幸存区中对象的年龄分布
-XX:+PrintTenuringDistribution

#设定老年代阀值的初始值和最大值
-XX:InitialTenuringThreshold
-XX:MaxTenuringThreshold

#设定幸存区的目标使用率
XX:TargetSurvivorRatio

#对象永远不会晋升到老年代
-XX:+NeverTenure
#对象会直接晋升到老年代
-XX:+AlwaysTenure

















