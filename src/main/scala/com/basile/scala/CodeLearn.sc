def until(condition: => Boolean)(block: => Unit) = {
  if (!condition) {
    block
  }
}