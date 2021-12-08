import java.util.List;

class MinThread extends Thread {
    List<Node> edges;
    Node minNode;

    public MinThread(List<Node> edge) {
        this.edges = edge;
    }

    public void run() {
        int min = Integer.MAX_VALUE;
        for (Node node : edges) {
            if (node.value < min) {
                min = node.value;
                minNode = node;
            }
        }
    }

    public Node getMin() {
        return minNode;
    }
}
