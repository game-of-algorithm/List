
const logger = {
  info: (value1, value2, value3) => {
    if (value1 && !value2 && !value3) console.log(value1)
    if (value1 && value2 && !value3) console.log(value1, value2)
    if (value1 && value2 && value3) console.log(value1, value2, value3)
  },
  error: (value1, value2, value3) => {
    if (value1 && !value2 && !value3) console.log(value1)
    if (value1 && value2 && !value3) console.log(value1, value2)
    if (value1 && value2 && value3) console.log(value1, value2, value3)
  }
}

module.exports = logger
