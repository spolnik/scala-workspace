def signum(x: Int) = if (x == 0) 0 else if (x > 0) 1 else -1

println("signum(3) => " + signum(3))
println("signum(-2) => " + signum(-2))
println("signum(0) => " + signum(0))