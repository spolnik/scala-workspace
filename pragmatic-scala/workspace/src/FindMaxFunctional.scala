def findMax(temperatures: List[Int]) = {
  temperatures.foldLeft(Int.MinValue) { Math.max }
}

println(findMax(List(23, 27, 17)))
