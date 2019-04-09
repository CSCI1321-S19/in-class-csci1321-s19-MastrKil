package basics

object RecursiveKnapsack {
  
  def knapsack(items: List[(Double,Double)], weightLeft: Double): Double = items match{
    
    case Nil => 0.0
    case (value, weight) :: t => 
      knapsack(t, weightLeft) max (if(weight > weightLeft) 0.0 else value + knapsack(t, weightLeft - weight))
  }
  
}