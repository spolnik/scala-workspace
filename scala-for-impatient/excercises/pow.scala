def pow(x: Double, n: Int): Double = {
	if (n == 0) 1.0
	else if (n % 2 == 0 && n > 0) pow(x, n/2) * pow(x, n/2)
	else if (n > 0) x * pow(x, n-1)
	else 1.0 / pow(x, -n)
}

println("pow(2, 1) =>" + pow(2, 1))
println("pow(3, 2) =>" + pow(3, 2))
println("pow(3, 3) =>" + pow(3, 3))
println("pow(3, 4) =>" + pow(3, 4))
println("pow(2, -1) =>" + pow(2, -1))