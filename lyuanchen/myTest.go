package main
import (
	"fmt"
	"os"
)
func main() {

	println("(0 + 15) / 2: ", (0 + 15) / 2)
	println("(2.0e-6 * 100000000.1):", (2.0e-6 * 100000000.1))
	println("true && true || true && false:", true && true || true && false)
	const f = "%T(%v)\n"
	v := (1 + 2.26)/2
	fmt.Printf(f, v, v)
	v2 := (1 + 2 + 3 + 4.0)
	fmt.Printf(f, v2, v2)
	v3 := 4.1 >= 4
	fmt.Printf(f, v3, v3)
	//v4 := 1 + 2 + "3"
	//fmt.Printf(f, v4, v4)
	if (len(os.Args)>=2) {
		fmt.Println(os.Args)
		v5 := os.Args[1]
		v6 := os.Args[2]
		v7 := os.Args[3]
		if (v5 == v6 && v5 == v7) {
			println("equal")
		} else {
			println("not equal")
		}
	}
	var s string = ""
	var N int = 45454545
	for n:= N; n > 0; n/=2 {
		s1 := string((n % 2))
		s = s1 + s
	}
	println("s:", s)
}
