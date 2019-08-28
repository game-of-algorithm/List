import _ from 'lodash'

export default class minPriorityQueue {
    constructor () {
        this.pg = []
        this.n = 0
    }

    bigger (i, j) {
        return this.pg[i] > this.pg[j]
    }

    exch (i, j) {
        let t = this.pg[i]
        this.pg[i] = this.pg[j]
        this.pg[j] = t
    }

    swim (nodeIndex) {
        let getParentNodeIndex =  index => _.floor(index / 2)
        while ( nodeIndex > 1 && this.bigger(getParentNodeIndex(nodeIndex), nodeIndex)) {
            this.exch(getParentNodeIndex(nodeIndex), nodeIndex)
            nodeIndex = getParentNodeIndex(nodeIndex)
        }
    }

    sink (nodeIndex) {
        while ( 2 * nodeIndex <= this.n) {
            let j = 2 * nodeIndex
            if (j < this.n && this.bigger(j, j+1)) {
                j++
            }
            if (!this.bigger(nodeIndex, j)) {
                break
            }
            this.exch(nodeIndex, j)
            nodeIndex = j
        }

    }

    isEmpty () {
        return this.n === 0
    }

    size () {
        return this.n
    }

    insert (value) {
        this.pg[++this.n] = value
        this.swim(this.n)
    }

    delMin () {
        let min = this.pg[1]
        this.exch(1, this.n--)
        this.pg[this.n + 1] = null
        this.sink(1)
        return min
    }
}
