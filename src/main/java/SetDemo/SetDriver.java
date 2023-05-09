package SetDemo;

/**
 * @author SOEN6441 team
 * @description Driver for set
 */
public class SetDriver {

    public static void main(String[] args) {

        /**
         * Make new sets, set 1 and set 2
         */
        Set<SetSample> set1 = new Set<>();
        Set<SetSample> set2 = new Set<>();

        // Set the set ID.
        set1.setSetId(1);
        set2.setSetId(2);

        // Create examples to be added into set
        SetSample sample1 = new SetSample(1, "sample1");
        SetSample sample2 = new SetSample(2, "sample2");
        SetSample sample3 = new SetSample(3, "sample3");

        /**
         * Add examples to set1, here I added sample3 twice, note the output should return an message saying the item
         * is not succesfully added.
         */
        set1.add(sample1);
        set1.add(sample2);
        set1.add(sample3);
        set1.add(sample3);

        /**
         * Take a peek at sample 1, should return: item in set, note here peek method returns boolean per request
         */
        if (set1.peek(1)) {
            System.out.println("The indexed item is in this set");
        } else {
            System.out.println("The indexed item is not in this set");
        }

        /**
         * remove sample 1, now it's sample 2 and sample 3 in Set 1
         */
        set1.remove(1);

        /**
         * Take a peek at sample 1 again after removal, here should say: not in set
         */
        if (set1.peek(1)) {
            System.out.println("The indexed item is in this set");
        } else {
            System.out.println("The indexed item is not in this set");
        }

        /**
         * Add two samples (sample 1 and sample 2) into set 2, and print sizes out.
         */
        set2.add(sample1);
        set2.add(sample2);

        System.out.println("Set 1 has " + set1.getSize() + "elements");
        System.out.println("Set 2 has " + set2.getSize() + "elements");

        /**
         * Now perform the comparison of those two sets: tho they have the same size, they are not equal because the
         * elements in two sets are not the same
         */
        if (set1.equals(set2)) {
            System.out.println("Set " + set1.getSetId() + ", and Set " + set2.getSetId()+ " are equal");
        } else {
            System.out.println("Set " + set1.getSetId() + ", and Set " + set2.getSetId()+ " are not equal");
        }

        /**
         * Display all elements in the following two sets
         */
        set1.display();
        set2.display();
    }
}
