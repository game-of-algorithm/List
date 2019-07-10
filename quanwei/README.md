# RobbStark Service

## 名字由来

TODO

## Node Version

v12.3.1

## 项目简介

  TODO
  
## cluster模式

### config修改

只需要修改`development.json`和`production.json`

### 测试环境 cluster 模式启动

```
  pm2 start processes-dev-cluster.json
```

### 测试环境 cluster 模式重启

```
  pm2 restart teacher
```

### 测试环境查看cluster日志

```
  pm2 logs teacher
```

## Assert

项目的ctx.assert是被hack过的，详细方法见[helper/assertHelper.js](./app/helper/assertHelper.js)

除`controller`外的其他模块使用，请`require('helper/assertHelper')`来代替`http-assert`

### assert示例
```
  const assert = require('./helper/assertHelper')
  assert(false, 400, 'msg', 'debug', 'type')
```
约定： `msg`必须为用户可读的信息，`debug`是给开发人员看的信息，`type`预留，可根据需求使用


## 日志输出级别

```
winston 默认日志级别
{
  error: 0,
  warn: 1,
  info: 2,
  verbose: 3,
  debug: 4,
  silly: 5
}
```
  
## Run Migration

常用：

Example:

运行Migration:

```
  NODE_ENV=development ./node_modules/.bin/sequelize db:migrate
```

列表：

```
  sequelize db:migrate

  sequelize model:generate --name ArticleSource --attributes title:string,description:string,link:string,type:string

  sequelize db:migrate:undo

  sequelize seed:create --name articleSource

  sequelize db:seed:all

  sequelize db:seed 20180824081528-articleSource.js

  sequelize db:seed:undo:all

  sequelize db:seed:undo 20180824081528-articleSource.js
```

### Migration运维

生产：

在一个节点上运行即可
```
NODE_ENV=production ./node_modules/.bin/sequelize db:migrate
```

