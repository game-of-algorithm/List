export class Node {
  constructor (key, val, N) {
    this.key = key
    this.val = val
    this.N = N
    this.left = null
    this.right = null
  }
}
export class BST {
  constructor () {
    this.root = null
  }

  size () {
    return this._size(root)
  }

  _size (node) {
    if (node === null) {
      return 0
    }
    return node.N
  }

  get (key) {
    return this._get(root, key)
  }

  _get (node, key) {
    if (node === null) {
      return null
    }
    if (key < node.key) {
      return this._get(node.left, key)
    }
    if (key > node.key) {
      return this._get(node.right, key)
    }
    return node.val
  }

  put(key, val) {
    this.root = this._put(this.root, key, val)
  }

  _put (node, key, val) {
    if (node === null) {
      return new Node(key, val, 1)
    }
    if (key < node.key) {
      node.left = this._put(node.left, key, val)
    } else if (key > node.key) {
      node.right = this._put(node.right, key, val)
    } else {
      node.val = val
    }
    node.N = this._size(node.left) + this._size(node.right) + 1
    return node
  }
}
