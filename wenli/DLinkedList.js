var LinkNode = /** @class */ (function () {
    function LinkNode(data) {
        this._data = data;
        this._next = null;
        this._prev = null;
    }
    Object.defineProperty(LinkNode.prototype, "data", {
        get: function () {
            return this._data;
        },
        set: function (data) {
            this._data = data;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(LinkNode.prototype, "prev", {
        get: function () {
            return this._prev;
        },
        set: function (node) {
            this._prev = node;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(LinkNode.prototype, "next", {
        get: function () {
            return this._next;
        },
        set: function (node) {
            this._next = node;
        },
        enumerable: true,
        configurable: true
    });
    return LinkNode;
}());
var DLinkedList = /** @class */ (function () {
    function DLinkedList() {
        this._count = 0;
        this._head = new LinkNode(null);
        this._tail = new LinkNode(null);
        this._head.prev = this._head.next = this._tail;
        this._tail.next = this._tail.prev = this._head;
    }
    DLinkedList.prototype.add = function (value) {
        var node = new LinkNode(value);
        node.prev = this._tail.prev;
        node.next = this._tail;
        this._tail.prev = node;
        node.prev.next = node;
        this._count++;
    };
    DLinkedList.prototype.insert = function (item, value) {
        var indexItem = this._head.next;
        while (indexItem !== this._tail) {
            if (indexItem.data == item) {
                var node = new LinkNode(value);
                node.prev = indexItem;
                node.next = indexItem.next;
                indexItem.next.prev = node;
                indexItem.next = node;
                this._count++;
                break;
            }
            indexItem = indexItem.next;
        }
    };
    DLinkedList.prototype.remove = function (value) {
        if (this.empty()) {
            return;
        }
        var indexItem = this._head.next;
        while (indexItem != this._tail) {
            if (indexItem.data === value) {
                indexItem.prev.next = indexItem.next;
                indexItem.next.prev = indexItem.prev;
                indexItem.next = null;
                indexItem.prev = null;
                var value_1 = indexItem.data;
                indexItem.data = null;
                this._count--;
                return value_1;
            }
            indexItem = indexItem.next;
        }
    };
    DLinkedList.prototype.find = function (value) {
        if (this.empty()) {
            return;
        }
        var indexItem = this._head.next;
        while (indexItem != this._tail) {
            if (indexItem.data === value) {
                return indexItem.data;
            }
            indexItem = indexItem.next;
        }
        return null;
    };
    DLinkedList.prototype.empty = function () {
        return this._count === 0;
    };
    DLinkedList.prototype.clear = function () {
        var node = this._head.next;
        while (node != this._tail) {
            node.prev = null;
            node.data = null;
            node = node.next;
            node.prev.next = null;
        }
        this._head.next = this._tail;
        this._tail.prev = this._head;
        this._count = 0;
    };
    DLinkedList.prototype.size = function () {
        return this._count;
    };
    DLinkedList.prototype.console = function () {
        var node = this._head.next;
        while (node != this._tail) {
            console.log(node);
            node = node.next;
        }
    };
    return DLinkedList;
}());
var list = new DLinkedList();
list.add(3);
list.add(5);
console.log('~~~~~~~~~~~~~~~~~');
list.console();
console.log('长度》》》》', list.size());
console.log('~~~~~~~~~~~~~~~~~');
list.insert(3, 1);
console.log('~~~~~~~~~~~~~~~~~');
list.console();
console.log('长度》》》》', list.size());
console.log('~~~~~~~~~~~~~~~~~');
console.log('~~~~~~~~~~~~~~~~~');
console.log('list.find(5)>>>>>', list.find(5));
console.log('~~~~~~~~~~~~~~~~~');
list.remove(3);
console.log('~~~~~~~~~~~~~~~~~');
list.console();
console.log('~~~~~~~~~~~~~~~~~');
list.clear();
console.log('~~~~~~~~~~~~~~~~~');
list.console();
console.log('长度》》》》', list.size());
console.log('~~~~~~~~~~~~~~~~~');
