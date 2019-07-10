class LinkNode<T> {
    private _data: T;
    private _next:  LinkNode<T>;
    private _prev:  LinkNode<T>;
    constructor(data: T) {
        this._data = data;
        this._next = null;
        this._prev = null;
    }
    set data(data: T) {
        this._data = data
    }
    get data(): T {
        return this._data
    }
    set prev(node: LinkNode<T>) {
        this._prev = node
    }
    get prev(): LinkNode<T> {
        return this._prev
    }
    set next(node: LinkNode<T>) {
        this._next = node
    }
    get next(): LinkNode<T> {
        return this._next
    }
}

class DLinkedList<T> {
    private _count: number = 0;
    private _head: LinkNode<T>;
    private _tail: LinkNode<T>;
    constructor() {
        this._head = new LinkNode<T>(null);
        this._tail = new LinkNode<T>(null);
        this._head.prev = this._head.next = this._tail;
        this._tail.next = this._tail.prev = this._head;
    }

    add(value: T) {
        let node = new LinkNode<T>(value);
        node.prev = this._tail.prev;
        node.next = this._tail;
        this._tail.prev = node;
        node.prev.next = node;
        this._count++;
    }

    insert(item: T, value: T) {
        let indexItem = this._head.next;
        while(indexItem !== this._tail) {
            if (indexItem.data == item) {
                let node = new LinkNode<T>(value);
                node.prev = indexItem;
                node.next = indexItem.next;
                indexItem.next.prev = node;
                indexItem.next = node;
                this._count++;
                break;
            }
            indexItem = indexItem.next;
        }
    }

    remove(value: T): T {
        if (this.empty()) {
            return;
        }
        let indexItem = this._head.next;
        while (indexItem != this._tail) {
            if (indexItem.data === value) {
                indexItem.prev.next = indexItem.next;
                indexItem.next.prev = indexItem.prev;
                indexItem.next = null;
                indexItem.prev = null;
                let value = indexItem.data;
                indexItem.data = null;
                this._count--;
                return value;
            }
            indexItem = indexItem.next;
        }
    }

    find(value: T): T {
        if (this.empty()) {
            return;
        }
        let indexItem = this._head.next;
        while (indexItem != this._tail) {
            if (indexItem.data === value) {
                return indexItem.data;
            }
            indexItem = indexItem.next;
        }
        return null;
    }

    empty(): boolean {
        return this._count === 0;
    }

    clear(): void {
        let node = this._head.next;
        while (node != this._tail) {
            node.prev = null;
            node.data = null;
            node = node.next;
            node.prev.next = null;
        }
        this._head.next = this._tail;
        this._tail.prev = this._head;
        this._count = 0;
    }

    size(): number {
        return this._count;
    }

    console() {
        let node = this._head.next;
        while (node != this._tail) {
            console.log(node);
            node = node.next;
        }
    }
}

let list = new DLinkedList<number>();
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


