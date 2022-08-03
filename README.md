# KotlinCoroutines

1)What is coroutine ?.

  * "suspend" means this function needs coroutine to execute.
  * "suspend" means the function can suspend and start.
  * We can not call suspend function ditectly.
  * We need coroutine to call suspend function.
  
2)How to launch Suspend function?.
 A)Suspend function can be launch another suspend function or Lifecycle scope.
	Ex. lifecycleScope.launch{
            callSuspendingFunction()
        }
3)What is builtin scopes in android.
	a)LifecycleScope.
	b)ViewmodelScope.
4)What is global scope.
	*Global scope is a predefind scope.
	*Global scope is lifecycle of whole aplication.
	*That's why we should not use Global scope.Bacause it may 
       cause memory leakes.
	*Global scope is close when our application is destoyed.
	*We can use this scope for quick debugging things.
5)What is Dispachers.
   Dispatchers id three types
  *Dispatchers.IO = Network requests or disk read write.
  *Dispatchers.Main = Main thread safety.
  *Dispatchers.Default -> CPU Intensive task

6)We alredy have Coroutine Scope defind in android lifecycle related things.
  so we don't need to create own Coroutine Scope.

7)we can use to launch suspend function use "lifecycleScope.launch". 
  This is pre defind and it will automatically canceled when out activity or fragment 
  is destroyed. we dont't need to worry about mamory leakes.
	

8)What is difference between launch and async.

	a)Async returns a value.launch does's not returns a value.
	b)launch is just launches the coroutine and forget.
	c)Async it returns Differ.
	d)To get value from the differ use "await()" function.

         Ex.  val response = async { callSuspendingFunction() }
              news.value =  response.await()
	e)Launch executes sequentially.
	f)async it calls the function concurrent manner.

	Whenever you want to make the calls concurrently you can use "Async".
      else use launch.

9)What is RunBloking.
	*)We should never use RunBloking() function.
      *)it blocks the current (or) Main thread.
