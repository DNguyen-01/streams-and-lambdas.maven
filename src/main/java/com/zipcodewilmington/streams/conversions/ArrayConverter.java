package com.zipcodewilmington.streams.conversions;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 */
public final class ArrayConverter extends PersonConversionAgent<Person[]> {

    public ArrayConverter(Person... people) {
        super(people);
    }

    public ArrayConverter(int collectionSize) {
        this(Stream
                .generate(new PersonFactory()::createRandomPerson)
                .limit(collectionSize)
                .toArray(Person[]::new));
    }


    //TODO
    public List<Person> toList() {
        //super is reference any clasess above this one
        //this class passed objectSequence from our super class
        //to return the array as a list
       return Arrays.asList(super.objectSequence);

    }

    //TODO
    public Stream<Person> toStream() {
        //taking the method above and converting it to a stream
        return toList().stream();
    }


    @Override
    public Person[] toArray() {
        return super.objectSequence;
    }
}
