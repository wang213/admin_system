# 后台管理系统-vue2

## 一、创建项目

### 1.npm&yarn包管理工具

| 命令对比                        | npm                         | yarn（速度快、安装版本统一、打印日志简洁） |
| ------------------------------- | --------------------------- | ------------------------------------------ |
| 安装项目依赖                    | npm install                 | yarn                                       |
| 从npm仓库下载React库            | npm install react--save     | yarn add react                             |
| 移除react库                     | npm uninstall react--save   | yarn remove react                          |
| 项目中安装 React 库作为开发依赖 | npm install react--save-dev | yarn add react --dev                       |
| 更新项目的依赖项                | npm update --save           | yarn upgrade                               |

### 2.安装node&安装npm(node自带)

官网下载，配置环境变量

```shell
node -v 查看node.js版本
npm -v 查看npm版本
npm i -g yarn 下载yarn包管理工具
yarn -v 查看yarn版本
```

### 4.配置淘宝镜像

```shell
npm config get registry 查看镜像配置,默认是国外的

https://npmmirror.com/ 阿里提供国内的镜像地址

npm config set registry https://registry.npmmirror.com 设置为国内镜像地址，提升下载速度
```

### 5.安装vuecli(脚手架)

```shell
yarn global add @vue/cli  安装cli
vue -V 查看安装版本
```

### 6.创建项目

```shell
vue create my-app
```

![](E:\培训资料\前台资料\vue后台管理系统\images\Snipaste_2023-06-01_17-57-39.png)

**创建完成**

![](E:\培训资料\前台资料\vue后台管理系统\images\Snipaste_2023-06-01_18-01-08.png)

### 7.启动项目

![](E:\培训资料\前台资料\vue后台管理系统\images\Snipaste_2023-06-01_18-02-48.png)

```shell
npm run serve 启动项目
npm run build 打包项目为dist目录
npm run lint 代码风格检查
```

- `*serve：用于启动开发服务器。*`
  `*build：用于构建生产环境的代码。*`
  `*lint：用于执行代码风格检查。`
- `当你在终端中运行npm run serve，*``*实际上是运行了vue-cli-service serve命令。同样地，npm run build和npm run lint分别对应了vue-cli-service build和vue-cli-service lint命令*`

## 二、element-UI

### 1.https://cdnjs.com/libraries/vue  javascript类库

 `*提供了许多常用的JavaScript库、CSS库、字体库等资源，供开发者在网页中使用。通过使用cdnjs，开发者可以从它的服务器上加载所需的库，而无需将这些库存储在自己的服务器上*` 

页面使用：

```javascript
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
```

### 2.引入element-ui

完整引入

```shell
npm i element-ui -S 下载element-ui
app引入element-ui包
Vue.use(element-ui)
```

按需引入 https://element.eleme.cn/#/zh-CN/component/quickstart

```shell
npm install babel-plugin-component -D
```

项目中一般会使用按需引入，在打包时体积较小

## 三、router路由

https://v3.router.vuejs.org/zh/  vue-router官网

https://www.oschina.net/p/npm?hmsr=aladdin1e1  npm引入vue版本

```
引入指定版本路由
npm i vue-router@3.1.1
```

## 四、less

https://less.bootcss.com/   css样式

脚手架引入

查看下载的库版本对应关系 https://www.npmjs.com/package/less-loader?activeTab=versions

```shell
npm i less@4.1.2 less-loader@6.0.0
```

lang="less" 指定当前语言为less  scoped 作用域为当前页面

![](E:\培训资料\前台资料\vue后台管理系统\images\Snipaste_2023-06-02_18-07-44.png)



## 五、vuex

```
npm i vuex@3.6.2
```

## 六、flex布局

```
display: flex; 元素内容整行显示
flex-wrap: wrap; 内容分配
justify-content: space-between; 间隔元素内容
```

## 七、axios 

http://www.axios-js.com/zh-cn/docs/

vue引入

```
npm install axios
```

## 八、mock 生成模拟数据

http://mockjs.com/

```
npm i mockjs
```

## 九、echarts

https://echarts.apache.org/zh/index.html

```
npm i echarts@5.1.2
```

 `在JavaScript中需要通过document.querySelector("#demo")来获取dom节点，然后再获取这个节点的值。在Vue中，我们不用获取dom节点，元素绑定ref之后，直接通过this.$refs即可调用，这样可以减少获取dom节点的消耗` 

```javascript
<div ref="echarts1"></div>
this.$ref.echarts1
```

## 十、存储token

```shell
npm i cookie@3.0.1   下载cookie存储token localStore(本地缓存也可以)
cookie.set('token')
cookie.gei('token')
cookie.remove('token')
```

## 十一、用户角色权限控制

1.不同的账号登录,会有不同的菜单权限

2.通过url输入地址来显示页面

3.对于菜单的数据在不同的页面之间的数据通信

```vue
用户菜单
 // menuData: [
      //   {
      //     path: "/",
      //     name: "home",
      //     label: "首页",
      //     icon: "s-home",
      //     url: "Home/Home",
      //   },
      //   {
      //     path: "/mall",
      //     name: "mall",
      //     label: "商品管理",
      //     icon: "video-play",
      //     url: "MallManage/MallManage",
      //   },
      //   {
      //     path: "/user",
      //     name: "user",
      //     label: "用户管理",
      //     icon: "user",
      //     url: "UserManage/UserManage",
      //   },
      //   {
      //     label: "其他",
      //     icon: "location",
      //     children: [
      //       {
      //         path: "/page1",
      //         name: "page1",
      //         label: "页面1",
      //         icon: "setting",
      //         url: "Other/PageOne",
      //       },
      //       {
      //         path: "/page2",
      //         name: "page2",
      //         label: "页面2",
      //         icon: "setting",
      //         url: "Other/PageTwo",
      //       },
      //     ],
      //   },
      // ],

```

## 十二、前台调用后台接口

1.vue.config.js配置代理地址

```js
const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,//关闭eslint校验
  //配置跨域
  devServer:{
    proxy:{
      '/api':{
        target: '',
        changeOrign:true
      }
    }
  }
})

```

2.main.js去掉mock模拟数据

```js
import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import router from '../src/router/index'
import store from './store'
// import './api/mock'
import cookie from 'js-cookie'

Vue.config.productionTip = false
Vue.use(ElementUI)


/**
to: Route: 即将要进入的目标 路由对象
from: Route: 当前导航正要离开的路由
next: Function: 一定要调用该方法来 resolve 这个钩子。执行效果依赖 next 方法的调用参数
 */

//添加全局前置导航守卫
router.beforeEach((to, from, next) => {

  //获取token
  const token = cookie.get('token');
  //判断token存不存在
  if (!token && to.name !== 'login') {
    //不存在 用户未登录 跳转登录页面
    next({ name: 'login' })

  }else if(token && to.name === 'login'){ //token存在 说明用户登录，此时跳转首页
    next({name: 'home'})
  }else{
    next()
  }

})

new Vue({
  router,
  store,
  render: h => h(App),
  created() {
    store.commit("addMenu",router);
  },
}).$mount('#app')

```





# 后台管理系统-vue3+vite

![](E:\培训资料\前台资料\vue后台管理系统\images\Snipaste_2023-06-13_14-58-08.png)

## 一、vite快速构建vue项目

vite官网  https://cn.vitejs.dev/guide/

element-plus官网   https://element-plus.gitee.io/zh-CN/

构建vite项目

```shell
yarn create vite my-vue-app --template vue
```

启动项目

```
cd my-vue-app
yarn install
yarn vite
```

## 二、安装element-plus

```shell
yarn add element-plus -s
```

### a.全量引入

main.js引入element-plus

```js
import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

const app = createApp(App)
app.use(ElementPlus)
app.mount('#app')

```

### b.按需引入

 https://element-plus.gitee.io/zh-CN/guide/quickstart.html#%E6%8C%89%E9%9C%80%E5%AF%BC%E5%85%A5

```
npm install  unplugin-element-plus -s
```

vite.config.js

```js
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import ElementPlus from 'unplugin-element-plus/vite'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    ElementPlus()
  ],
})

```

页面使用

```vue
<script>
import { ref,defineComponent } from 'vue'
import { ElButton } from 'element-plus'
// defineProps({
//   msg: String,
// })
// const count = ref(2)
export default defineComponent({
  components:{ElButton},
  setup(){
    const count=ref(0)
    return {
      count,
    };
  }
})
</script>

<template>
  <h1>{{ msg }}</h1>

  <div class="card">
    <el-button type="button" @click="count++">count is {{ count }}</el-button>

  </div>
</template>

<style scoped>
.read-the-docs {
  color: #888;
}
</style>

```

## 三、vue-router使用

安装router

```shell
cnpm install vue-router
```

