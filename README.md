### Java 大二上学期的一次课设作业

### 高校奖学金管理系统

## 注意
- GUI界面的文字样式我采用了我自己电脑上下载的喜欢的字体，我没有测试过在其他未安装同字体的系统下是否能正常显示，如果显示有误请自行在View文件中修改对应的类（有些是直接用Unicode标注的，因为我的Swing界面是用GUI设计工具做的，所以效果还是可以的，不过中文是直接用Unicode标注的）。
- 这个系统有三个用户，管理员、辅导员和学生。其中管理员可以实现对学生和辅导员以及奖学金信息的增删查改操作，还可以终审等。
- 具体的实现情况请自行clone项目到本地，用IDEA或者其他IDE打开后运行查看结果。程序的主方法在src/test/java/test.java中。
- 我自己使用的时候是没有任何报错的，用的 JDK 版本为 20.0.2, vendor: Oracle Corporation，IDEA 版本号为 IntelliJ IDEA 2023.3.2 (Ultimate Edition)，系统为 Windows11 22H2，Maven 版本为 Apache Maven 3.9.6。
- 数据库是MySQL，数据库名称需要自行去 src/main/java/Util/JDBCUtils.java 中获取和修改。
- 数据表名称已在建表语句中，直接在对应的数据库中执行即可完成建表，然后再执行给的数据表即可。