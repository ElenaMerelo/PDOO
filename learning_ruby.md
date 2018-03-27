> Easily coint occurrences of array elements

`Hash.new` takes an argument that will be returned when a key that doesn’t correspond to a hash entry is accessed. Basically, a default value for all hash keys.

With that knowledge in hand, we can take our array of elements and easily get occurrence counts for each unique element. We just need to initialize each key to 0 and then increment the count each time the element appears:

~~~ruby
words = %w(how much wood would a wood chuck chuck)

counts = Hash.new 0

words.each do |word|
  counts[word] += 1
end

# {"how"=>1, "much"=>1, "wood"=>2, "could"=>1, "a"=>1, "chuck"=>2}
~~~

If we use each_with_object we can turn that baby into a one-liner:
~~~ruby
words.each_with_object(Hash.new(0)) { |word,counts| counts[word] += 1 }

# {"how"=>1, "much"=>1, "wood"=>2, "could"=>1, "a"=>1, "chuck"=>2}
~~~
