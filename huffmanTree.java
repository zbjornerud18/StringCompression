import java.util.ArrayList;
import java.util.PriorityQueue;

public class huffmanTree <Key extends Comparable <Key>, Value> {

    public hTNode<Key, Value> root;

    public huffmanTree(String str) {

        ArrayList<Character> values = new ArrayList<>();
        ArrayList<Integer> frequency = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {

            //[a, b]
            //[2, 1] //indexof

            if (values.contains(str.charAt(i))) {
                int index = values.indexOf(str.charAt(i));
                int oldFreq = frequency.get(index);

                //find index of the char in the array
                //use that index to get the frequency
                //++ than frequency and save it back at that index

                frequency.set(index, oldFreq + 1);


            } else {
                //add char and frequency 1
                values.add(str.charAt(i));
                frequency.add(1);

            }
        }
        PriorityQueue<hTNode> queue = new PriorityQueue<>();
        for (int i = 0; i < values.size(); i++) {
            hTNode n = new hTNode(frequency.get(i), values.get(i), 0);
            queue.add(n);
        }

        while (queue.size() > 1) {
            hTNode left = queue.poll();
            hTNode right = queue.poll();
            hTNode parent = new hTNode((int) left.getKey() + (int) right.getKey(), -1, 0);
            parent.setLeft(left);
            parent.setRight(right);
            queue.add(parent);
        }
        root = queue.poll();


    }

    public String toString() {
        String binaryString = Integer.toBinaryString(32);
        binaryString = binaryString + toString(root, "");
        return binaryString;
    }


    private String toString(hTNode n, String soFar) {
        if (n.isLeaf()) {
            return "1" + soFar;
        } else {
            return "0" + toString((hTNode) n.getLeft(), soFar + '0') + toString((hTNode) n.getRight(), soFar + "1");
        }


    }

    public static void main(String[] args) {
            huffmanTree hT = new huffmanTree("apples are not oranges");
        System.out.println(hT.toString());

    }
}


