module.exports = print = (head) => {
    while (head) {
        console.log(head.val)
        head = head.next
    }
}
