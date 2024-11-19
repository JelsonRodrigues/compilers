main do:
  Int num;
  Int counter;
  num <- readNumber()
  counter <- 1
  while (counter <= num)
    if num % counter == 0
      print(counter)
    counter <- counter + 1
  end