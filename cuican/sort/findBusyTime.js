const findTheBusyTime = (array) => {
    if (!array || array.length === 0) return
    const sortArray = [{value: array[0].startTime, isStart: true},
        {value: array[0].endTime, isStart: false}]
    const sortItem = null
    for(let i = 1; i < array.length; i++) {
        for (let j = 0; j < sortArray.length; j++) {

        }
    }
}
