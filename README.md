# java-streams

Overview of stream implementation in Java (incl. some lambda expressions).

## Stream(s) ...

1. ... make heavy use of lambda expressions.
2. ... pipelines consists of:
     1. a source
     2. followed by zero or more intermediate operations
     3. terminal operation

Generic sample: ```[ Source ] -> [[Filter]] => [[Sort]] => [[Map]] -> [[[Collect]]]```

#### `[Source]`

Collections (Lists, Sets, Queue), ints, longs, doubles, arrays, lines of a file

#### `[[Intermediate Operations]]`

anyMatch(), distinct(), filter(), findFirst(), map(), flatmap(), skip(), sort()
     
#### `[[[Terminal Operations]]]` 

forEach() - applies the same function to each element.                                  
collect() - saves the elements into a collection.

count(), max(), min(), reduce(), summaryStatistics() - reduce the stream to a single summary element.

## Sources & Links
- In-depth tutorial with examples: https://stackify.com/streams-guide-java-8/
- Strongly example-driven tutorial: https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
