package basics

object RecursiveBinPacking {
  
  def binPack(bins: Array[Double], objs: List[Double]): Boolean = objs match {
    case Nil => true
    case obj :: t =>
      bins.indices.exists{ i =>
         obj <= bins(i) && {
           bins(i) -= obj
           val ret = binPack(bins, t)
           bins(i) += obj
           ret
         }
      }
  }
 
}