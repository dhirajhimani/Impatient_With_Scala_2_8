
import scala.collection.JavaConversions.mapAsScalaConcurrentMap
import java.util.concurrent.atomic.AtomicInteger

val frequencies: scala.collection.concurrent.Map[Char, AtomicInteger] = new java.util.concurrent.ConcurrentHashMap[Char, AtomicInteger]

val zero = new AtomicInteger(0)
frequencies.put('5', zero).getOrElse(zero)
frequencies.put('5', new AtomicInteger(1)).get
frequencies.put('5', new AtomicInteger(2)).get
frequencies.put('5', new AtomicInteger(3)).get
frequencies
