import java.util.*;

class HuffmanNode implements Comparable<HuffmanNode> {
    char character;
    int frequency;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}

public class huffman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the message to encode: ");
        String message = scanner.nextLine();
        scanner.close();

        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : message.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            minHeap.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (minHeap.size() > 1) {
            HuffmanNode left = minHeap.poll();
            HuffmanNode right = minHeap.poll();
            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            minHeap.add(parent);
        }

        HuffmanNode root = minHeap.poll();
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateHuffmanCodes(root, "", huffmanCodes);

        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        String encodedMessage = encodeMessage(message, huffmanCodes);
        System.out.println("Encoded Message: " + encodedMessage);
    }

    private static void generateHuffmanCodes(HuffmanNode node, String code, Map<Character, String> huffmanCodes) {
        if (node == null) {
            return;
        }
        if (node.character != '\0') {
            huffmanCodes.put(node.character, code);
        }
        generateHuffmanCodes(node.left, code + "0", huffmanCodes);
        generateHuffmanCodes(node.right, code + "1", huffmanCodes);
    }

    private static String encodeMessage(String message, Map<Character, String> huffmanCodes) {
        StringBuilder encodedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            encodedMessage.append(huffmanCodes.get(c));
        }
        return encodedMessage.toString();
    }
}
