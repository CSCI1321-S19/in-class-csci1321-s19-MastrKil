package basics

object RecursiveFactorial extends App{
   
  def factorial(n: BigInt): BigInt = if(n == 0) 1 else factorial(n - 1) * n

  def fibinacci(n: BigInt): BigInt = if(n < 2) 1 else fibinacci(n-1) + fibinacci(n-2)        

   println(factorial(5))
   println(factorial(200))
   println(fibinacci(5))
   println(fibinacci(8))
}