package deque;

import java.util.Comparator;

/**
 * The MaxArrayDeque can either tell you the max element in itself by using the Comparator<T> given to it in the constructor,
 * or an arbitrary Comparator<T> that is different from the one given in the constructor.
 * @param <T>
 */
public class MaxArrayDeque<T> extends ArrayDeque<T> {

    Comparator<T> currcomparator;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        currcomparator = c;
    }


    /**
     * returns the maximum element in the deque as governed by the previously given Comparator. If the MaxArrayDeque is empty, simply return null.
     * @return
     */
    public T max() {
        if (this.isEmpty()) {
            return null;
        }
        T currMax = this.get(0);
        for (int i = 0; i < this.size(); i++) {
            int key = currcomparator.compare(this.get(i), currMax);
            if (key > 0 ) {
                currMax = this.get(i);
            }
        }
        return currMax;
    }

    /**
     *  returns the maximum element in the deque as governed by the parameter Comparator c. If the MaxArrayDeque is empty, simply return null.
     * @param c
     * @return
     */
    public T max(Comparator<T> c) {
        T currMax = this.get(0);
        for (int i = 0; i < this.size(); i++) {
            int key = c.compare(this.get(i), currMax);
            if (key > 0 ) {
                currMax = this.get(i);
            }
        }
        return currMax;
    }

    public static void main(String[] args) {
        Comparator<Dog> nd = Dog.getNameComparator();
        MaxArrayDeque<Dog> mad = new MaxArrayDeque<Dog>(nd);

        Dog dog1 = new Dog("Rex", "Large");
        Dog dog2 = new Dog("Bella", "Small");
        Dog dog3 = new Dog("Con", "Medium");
        Dog dog4 = new Dog("Zinger", "Medium");

        mad.addLast(dog1);
        mad.addLast(dog2);
        mad.addLast(dog3);
        mad.addLast(dog4);

        System.out.println(mad.max().getName());

        if (nd.compare(dog1, dog2) >  0) {
            System.out.println("sucess");
        }
    }
}
