def countdown(n: Int): Unit = {
	println(n)
	if (n > 0) countdown(n-1)
}

def test(n: Int) = {
	println("countdown(" + n + ") => ")
	countdown(n)	
}

test(5)
test(2)
test(0)