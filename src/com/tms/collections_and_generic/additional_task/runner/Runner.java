package com.tms.collections_and_generic.additional_task.runner;

import com.tms.collections_and_generic.additional_task.models.CustomArrayList;

/**
 * Task:
 *
 * Let's imagine that there is no collection of type ArrayList in Java.
 * Create your own class that simulates the work of a dynamic collection class - i.e. create your custom collection.
 * The collection will be based on an array.
 * A custom collection must store elements of different classes (i.e. it is generic).
 * Provide operations for adding an element, deleting an element, getting an element by index,
 *  checking whether an element is in a collection, a method for clearing all collections.
 * Provide a parameterless constructor - creates an array of default size.
 * Provide a constructor with a specified size of the internal array.
 * Provide the ability to automatically expand the collection when adding an element in the case when the collection is already full.
 */


public class Runner {

    public static void main(String[] args) {
        CustomArrayList<Integer> myCollection = new CustomArrayList<>();

        myCollection.add(2);
        myCollection.add(3);
        myCollection.add(1);
        myCollection.add(7);
        myCollection.add(4);

        System.out.println(myCollection);

        myCollection.delete(3);

        System.out.println(myCollection);

        myCollection.add(6);
        myCollection.add(2);
        myCollection.add(4);
        myCollection.add(9);
        myCollection.add(2);
        myCollection.add(1);

        System.out.println(myCollection);

        myCollection.add(2);
        myCollection.add(4);
        myCollection.add(9);
        myCollection.add(2);
        myCollection.add(1);

        System.out.println(myCollection);

        int checkElement = 19;
        if (myCollection.contains(checkElement)) {
            System.out.println("Collection contains the element " + checkElement);
        } else {
            System.out.println("Collection does`nt contain the element " + checkElement);
        }

        myCollection.clear();

        System.out.println(myCollection);
    }

}
