# 面包旅行简介

标签（空格分隔）： 面包旅行url

---
##MyHearts交流群（刚开，哈哈）
群号：136471108（进群交流技术，本人技术也不是很好，但是我相信，大家一起交流，会有很好的提升）

##关于如何运行项目  关于如何运行项目  关于如何运行项目(重要的事情说三遍)

**在本页的最下面有了详细的解答。**
###界面展示：
#####主界面
![](http://ww4.sinaimg.cn/mw690/006jcGvzgw1fap6rxmcwej30u01hch45.jpg)
#####左侧侧边栏
![](http://ww1.sinaimg.cn/mw690/006jcGvzgw1fap6scyozlj30u01hcn2q.jpg)
#####轮播详情
![](http://ww3.sinaimg.cn/mw690/006jcGvzgw1fap6swdnf9j30u01hctpr.jpg)
#####设置界面
![](http://ww1.sinaimg.cn/mw690/006jcGvzgw1fap6t9ndiyj30u01hcwh1.jpg)
#####注册登录
![](http://ww4.sinaimg.cn/mw690/006jcGvzgw1fap6tr4qk6j30u01hcacw.jpg)
![](http://ww3.sinaimg.cn/mw690/006jcGvzgw1fap6tzypvcj30u01hc0vv.jpg)
#本app所用URL(抓取获得，不得用于商业用途)
###热门游记api
* 热门游记首页api  GET请求方式
```
http://api.breadtrip.com/v2/index/
```
* 热门游记item点击进入详情界面  2387246443 这个是id 在上面的请求数据中可以找到（GET方式请求）
```
http://api.breadtrip.com/trips/2387246443/waypoints/
```

* 某个item(photo)点击评论获取评论详情界面url
```
 http://api.breadtrip.com/trips/2387122390/waypoints/2355942363/replies/?count=32767
```
###面包订制
* 热门城市()
```
http://api.breadtrip.com/product/search/hot/
```

* 全部分类数据api  参数start   开始位置   count一次多少数据  country国家代码(全部这个便签是0)
```
http://web.breadtrip.com/product/topics/more/?start=0&count=10&country=0
```
* 还好机制的发现了，原本想着应该会有个接口请求回来item数据，但是找遍了也没有，哈哈，原来是网页，，，js交互。 country  对应着下面的 data-id
```
 <p>
            <a class="cur" data-id="0" href="###">全部</a>
            
            <a href="###" data-id="3649">泰国</a>
            
            <a href="###" data-id="3808">日本</a>
            
            <a href="###" data-id="3238">韩国</a>
            
            <a href="###" data-id="3803">美国</a>
            
            <a href="###" data-id="3814">香港</a>
            
            <a href="###" data-id="3660">台湾</a>
            
            <a href="###" data-id="3589">新加坡</a>
            
            <a href="###" data-id="3821">印度尼西亚</a>
            
            <a href="###" data-id="3708">越南</a>
            
            <a href="###" data-id="3720">意大利</a>
            
            <a href="###" data-id="3793">中国</a>
            
        </p>

```
###搜索界面
*  3/10052/   这个字段需要在国外热门目的地里面找   "type": 3, "id": 10052,
```
http://api.breadtrip.com/destination/place/3/10052/
```
#####搜索进入之后
*　不可错过

```
http://web.breadtrip.com/mobile/destination/3/10052/intro/
```
* 旅游景点 item  （分类all/mall/sights/hotel/restaurant/experience/）<br>分别对应全部/购物/景点/住宿/餐厅/休闲鱼类
```
http://api.breadtrip.com/destination/place/3/10052/pois/all/?start=0&count=20&sort=default&shift=false&latitude=39.959922249613754&longitude=116.45596566529844
```
* item点击
```
http://api.breadtrip.com/destination/place/5/2388521355/
```
* 主题榜单(需要抓取或者是显示webview，具体需要实际操作)http://web.breadtrip.com/mobile/destination/3/10052/top10_list/(获取下面内容)<br>   <li data-url="http://breadtrip.com/mobile/destination/496/"这个就是top的点击跳转  也是webview或者jsoup抓取一下
```
  <ul class="dest-list">
            <li data-url="http://breadtrip.com/mobile/destination/495/" style="background-image: url(http://photos.breadtrip.com/photo_2014_10_31_df0632f2c47ccbc78713f2d95181df30.jpg?imageView/2/w/640/q/85);">
                <div class="title">景点TOP5</div>
                <div class="bg"></div>
            </li>
            <li data-url="http://breadtrip.com/mobile/destination/496/" style="background-image: url(http://photos.breadtrip.com/photo_2014_03_23_ec14356642b72d6165d97343edef1fc1.jpg?imageView/2/w/640/q/85);">
                <div class="title">餐饮TOP5</div>
                <div class="bg"></div>
            </li>
            <li data-url="http://breadtrip.com/mobile/destination/497/" style="background-image: url(http://photos.breadtrip.com/photo_2014_04_02_8b4717c8a1e770255eaf5e0d86a96fe9.jpg?imageView/2/w/960/q/85);">
                <div class="title">住宿TOP5</div>
                <div class="bg"></div>
            </li>
        </ul>
```
* http://web.breadtrip.com/mobile/destination/495/（top  item点击之后）<br>这里面的data-id和data-type 是我们需要的，用于拼接跳转到具体景点<br>background-image：url是作为显示背景的图片
```
 <li data-name="奈良公园" data-id="2388363531" data-type="5" style="background-image: url(http://photos.breadtrip.com/covers_2015_10_22_d4e479f2e7aea0079c50d1e761cba0d9.jpg?imageView/2/w/960/q/85);">
            <div>
                <h3>奈良公园</h3>
                <p>奈良公园内集中了奈良大部分的名胜古迹，若草山、东大寺、春日大社、国立博物馆等都在这里，是日本现代公园的先驱之一。园内有许多嬉戏的鹿群，这些鹿被指定为国家的自然保护动物。一年四季无论何时，这里都有吸引人的景观。</p>
            </div>
            <i>1</i>
        </li>

```
* 精彩原创 （自己去做分页  当下item点击去的url <br>     http://api.breadtrip.com/trips/2387869041/waypoints/）
```
http://api.breadtrip.com/v2/destination/place/3/10052/trips/?start=0&count=20
```
* 实用须知
```
http://web.breadtrip.com/mobile/destination/3/10052/overview/
```



###搜索这个url，key值被加密了，这个应该实现不了(或者破解了可以)（你阿妈，，试了一下，直接传入地名也行。。。。）
```
http://api.breadtrip.com/v2/search/?key=%E5%8C%97%E4%BA%AC&start=0&count=20&data_type=
```


###如何导入到自己本地AndroidStudio
####方法一：
* 打开as(Android Studio)-->最上方菜单选择VCS-->Checkout from Version Control --> Github(可能会让你输入你的github密码)
* 然后输入这个网址https://github.com/wuyinlei/BreadTravel，点击确定就行。
* 当然这个需要你已经安装配置好了GIT（如果还不知道怎么配置，可以百度，如果找不到git下载，请加群：136471108）
####方法二：
*　第一步：下载此项目的zip包到本地，并进行解压
*　第二步：进入app目录(此时可以看到src和其他文件夹)，复制这个路径地址（比如我的地址：D:\AndroidCode\BreadTravel\app，~~而不是D:\AndroidCode\BreadTravel~~）
*　第三步：打开AS，新建一个功能(Project)，然后File-->New-->Import Module ，把路径复制进入到输入框，点击确定即可。
*　注意：在工程级的build.gradle文件中，输入以下代码(要不然编译不过)
```
allprojects {
    repositories {
        jcenter()
        //这里是 LeanCloud 的包仓库
        maven {
            url "http://mvn.leancloud.cn/nexus/content/repositories/public"
        }
    }
}
```
* 注意：由于项目中使用了lambda表达式，确保sdk版本在24及以上 ###最后注意 如果是有些第三方库，没有拉取下来，对于不重要的，排除网络请求、图片加载等，可以把一些无关紧要的去除，然后有关的代码注释，也是可以成功的，最后推荐翻墙的(可以用于一般的翻墙) [可以用于翻墙，点击跳转][5]，已经提供了如何翻墙，如何具体实现，看下里面的注释即可。相信你是可以看懂并且去实现的。


  [1]: !%5B%5D%28http://ww1.sinaimg.cn/large/006jcGvzgw1fap61leh8uj30u01hch45.jpg%29
  [2]: !%5B%5D%28http://ww3.sinaimg.cn/large/006jcGvzgw1fap62iv0n5j30u01hcn2q.jpg%29
  [3]: !%5B%5D%28http://ww4.sinaimg.cn/large/006jcGvzgw1fap62yvoidj30u01hctpr.jpg%29
  [4]: !%5B%5D%28http://ww4.sinaimg.cn/large/006jcGvzgw1fap63el73uj30u01hcwh1.jpg%29
  [5]: https://laod.cn/hosts/2016-google-hosts.html