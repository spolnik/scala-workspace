def product1(s: String) = {
	var sum = 1L
	for (char <- s) sum *= char
	sum
}

def product2(s: String) = {
	var sum = 1L
	s.foreach(sum *= _)
	sum
}

def product3(s: String) = {
	s.foldLeft(1L)((a,b) => a*b)
}

def productRec(s: String): Long = {
	if (s.isEmpty) 1L
	else s.head * productRec(s.tail)
}

println("1: " + product1("Hello"))
println("2: " + product2("Hello"))
println("3: " + product3("Hello"))
println("Rec: " + productRec("Hello"))