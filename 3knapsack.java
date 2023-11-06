
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Item implements Comparable<Item> {
    private int value;
    private int weight;
    private double valuePerWeight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.valuePerWeight = (double) value / weight;
    }

    @Override
    public int compareTo(Item other) {
        return Double.compare(this.valuePerWeight, other.valuePerWeight);
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public double getValuePerWeight() {
        return valuePerWeight;
    }
}

public class knapsack {
    public static double fractionalKnapsack(List<Item> items, int capacity) {
        items.sort(Comparator.reverseOrder());

        double totalValue = 0;
        int totalWeight = 0;

        for (Item item : items) {
            if (totalWeight + item.getWeight() <= capacity) {
                totalValue += item.getValue();
                totalWeight += item.getWeight();
            } else {
                int remainingCapacity = capacity - totalWeight;
                double fraction = (double) remainingCapacity / item.getWeight();
                totalValue += fraction * item.getValue();
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        // Create a list of Item objects.
        List<Item> items = new ArrayList<>();
        items.add(new Item(60, 10));
        items.add(new Item(100, 20));
        items.add(new Item(120, 30));

        // Set the capacity of the knapsack.
        int capacity = 50;

        // Solve the fractional Knapsack problem.
        double maxValue = fractionalKnapsack(items, capacity);

        // Print the maximum value.
        System.out.println("The maximum value that can be placed in the knapsack is: " + maxValue);
    }
}
