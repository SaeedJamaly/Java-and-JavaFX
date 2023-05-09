package SetDemo;

/**
 * @author Xiaoyu Cheng
 * @student_ID 40254110
 * @description
 */
import java.util.ArrayList;


public class Set<E extends Element>{

    /**
     * Initiate the data structure, to fulfill the requirement of: no specific order, unique id;
     * We use a Hashmap to implement this
     */
    private ArrayList<E> elements;
    private int setId;

    public Set() {
        elements = new ArrayList<>();
        setId = 0;
    }


    /**
     * Implement required methods
     */

    // Add an element, check for duplication

    public void add(E element) {
        for (E current : elements) {
            if (current.getId() == element.getId()) {
                System.out.println("Duplicated item exists, element not added, please check again.");
                return;
            }
        }
        elements.add(element);
        System.out.println("Element " + element.getId() + " is successfully added!");

    }

    // Remove an element by id
    public void remove(int id) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getId() == id) {
                elements.remove(i);
                System.out.println("Element id: " + id + " is removed!");
                break;
            }
        }
    }

    public int getSetId() {
        return setId;
    }

    public void setSetId(int setId) {
        this.setId = setId;
    }

    // Take a peek at an id
    public boolean peek(int id) {
        boolean result = false;
        for (E element: elements) {
            if(element.getId() == id) {
                result = true;
                break;
            }
        }
        return result;
    }

    // Get the size of the data structure
    public int getSize() {
        return elements.size();
    }

    // Override equals to test if two sets are equal
    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return false;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Set<?> otherSet = (Set<?>) o;
        if (this.getSize() != otherSet.getSize()) {
            return false;
        }

        for (E element: elements) {
            boolean found = false;
            for (Object otherObjectElement: otherSet.elements) {
                if (otherObjectElement instanceof Element) {
                    Element otherElement = (Element) otherObjectElement;
                    if (otherElement.getId() == element.getId()) {
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    // Display all elements in the set
    public void display() {
        System.out.println("Display all elements in set " + getSetId()+": ");
        for (int i = 0; i < elements.size(); i++) {
            System.out.println("Element id: " + elements.get(i).getId());
        }
    }
}

