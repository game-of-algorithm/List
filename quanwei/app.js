const Koa = require('koa')
const app = new Koa()
const http = require('http')
const server = http.createServer(app.callback())
server.listen(4000)

require('./链表/6-算法题-相交链表.js')
require('./链表/3-单向链表.js')
require('./链表/4-双向链表.js')
require('./链表/5-循环链表.js')
// require('./链表/7-算法题-排序链表.js')
// require('./链表/8-算法题-反转链表.js')

// console.info('listen 4000')
