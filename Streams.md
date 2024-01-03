# Java stream API

## Creation

Creating from given values: 

    Stream<Integer> s = Stream.of(1, 2, 3)

Specific streams for primitive types:

    IntStream s = IntStream.of(1, 2, 3)
    stream().mapToInt(e -> intFunction(e))
    double avg = s.average().orElse(0)
    IntStream range = IntStream.range(1, 10)

Creating from array:

    int[] arr = {1, 2, 3}
    Stream<Integer> s = Arrays.stream(arr)

Creating from Collections:

    List<Integer> list = List.of(1, 2, 3)
    Stream<Integer> s = list.stream()

# Intermediate operators

Skip  the first `n`elements in the stream:

    .skip(n)

Remove duplicate values in the stream:

    .distinct()

Sort the values in the stream based on the natural order or a Comparator:

    .sorted() //natural order
    .sorted(Comparator.comparing(T::getter).thenComparing(T::otherGetter))

Keep values from the stream based on some predicate:

    .filter(e -> predicate(e))


Keep values from the beginning of the stream as long as a predicate is fulfilled, then remove the rest:

    .takeWhile(e -> predicate(e))

Remove values from the beginning of the stream as long as a predicate is fulfilled, then keep the rest:

    .dropWhile(e -> predicate(e))

Create a new stream by mapping a new value for all values in the original stream.

    .map(e -> function(e))

Flatten multidimensional arrays:

    .flatMap(Collection::stream)

## Terminal operators

Return the number of elements in the stream:

    .count()

Return the first element of the stream as an Optional.

    .findFirst()

Get the min/max value in the stream as an Optional (ORDER NOT GUARANTEED):

    .min(Comparator.comparing(T::getter))

    .max(Comparator.comparing(T::getter))

Matchers for a boolean condition, returning a boolean:

    .anyMatch(e -> predicate(e))
    .allMatch(e -> predicate(e))
    .noneMatch(e -> predicate(e))

Combine elements in the stream pairwise:

    .reduce(initValue, (initValue, value) -> binaryOperator)
    

## Collectors

Extract the result from the stream into a Collection:

    .collect(Collectors.toList())
    .collect(Collectors.toSet())
    .collect(Collectors.toList())
    .collect(Collectors.toMap(e -> keyFunction(e), e -> valueFunction(e), KeyConflictFunction))

Return the number of elements in the stream as a `long`:

    Collectors.counting()

Return a rolling sum applied on each element on the stream through an intFunction:

    Collectors.summingInt(e -> intFunction(e))


Join the String representation of all elements in the stream by a String separator:

    Collectors.joining(separatorString)


Group elements in the stream into two categories based on a boolean predicate.
Returns a `Map<Boolean, List<T>>` where the keys are `true` and `false`.

    Collectors.partitioningBy(e -> predicate(e))

Group elements in the stream into several categories based on some property of the elements. Returns a` Map<P, List<T>>` where the keys are the all the different values of the property:

    Collectors.groupingBy(T::getP)


Group elements in the stream into several categories based on some property of the elements. Also takes a second collector, to process the resulting groups into a colleciton. Returns a` Map<P, Collection<T>>` where the keys are the all the different values of the property:

    Collectors.groupingBy(T::getP, Collectors.toCollection())


Group some mapping of the elements in the stream into several categories based on some property of the elements. Returns a` Map<P, List<function(T)>>` where the keys are the all the different values of the property:

    Collectors.groupingBy(T::getP, Collectors.mapping(e -> function(e), Collectors.toCollection()))







    