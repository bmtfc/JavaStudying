
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MST{
    public void findMST(int[][] wtMat, int matrixSize, int src, int threadNumber) {
        List<Node> forest = new ArrayList<>(); //ліста ребер остовного дерева
        List<Node> edges = new ArrayList<>(); //ліста ребер
        int count = 1;
        int div = 5;
        int segSize, lim, threadCount, min;
        Node minNode;

        // опорний вузол графа
        Node srcNode = new Node();
        srcNode.start = src;
        srcNode.end = src;
        srcNode.value = 0;
        forest.add(srcNode);
        //заповняємо ліст ребер
        for (int i = 0; i < matrixSize; i++) {
            if (i != src) {
                Node node = new Node();
                node.end = i;
                node.value = wtMat[src][i];
                edges.add(node);
            }
        }
        //для кожного потоку додаємо ліст ребер
        List<MinThread> threads = new ArrayList<>();
        for (int i = 0; i < threadNumber; i++) {
            threads.add(new MinThread(edges));
        }

        ThreadMonitor monitor = new ThreadMonitor(threads);
        monitor.startDisplaying(Main.textArea, 1);

        System.out.println("Do you wanna use executor service? (1-yes,2-no)");
        Scanner sc = new Scanner(System.in);
        int res = sc.nextInt();
        long startTime = System.nanoTime();
        if (res == 1) {
            ExecutorService executor = Executors.newFixedThreadPool(threadNumber);
            while (count < matrixSize) {
                segSize = edges.size() / div;
                if (segSize == 0) segSize = edges.size();
                threadCount = 0;

                for (int i = 0; i < edges.size(); i += segSize) {
                    lim = Math.min(i + segSize, edges.size());
                    threads.set(i / segSize, new MinThread(edges.subList(i, lim)));

                    threads.get(i / segSize).start();
                    threadCount++;
                }
                try {
                    for (int i = 0; i < threadCount; i++) {
                        threads.get(i).join();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                min = Integer.MAX_VALUE;
                minNode = null;
                for (int i = 0; i < threadCount; i++) {
                    Node node = threads.get(i).getMin();
                    if (node != null && node.value < min) {
                        min = node.value;
                        minNode = node;
                    }
                }

                if (minNode != null) {
                    forest.add(minNode);
                    edges.remove(minNode);
                }

                for (Node node : edges) {
                    if (wtMat[minNode.end][node.end] < node.value) {
                        node.start = minNode.end;
                        node.value = wtMat[minNode.end][node.end];
                    }
                }
                count++;
            }
            executor.shutdown();
            long endTime = System.nanoTime();
            double timeElapsed = (endTime - startTime) / 1E6;
            System.out.println("\nIt took " + timeElapsed + " ns");
            System.out.println("\nMST: ");
            System.out.println("Edge\tDistance");
            for (int i = 0; i < forest.size(); i++) {
                if (i != src)
                    System.out.println(forest.get(i).start + " - " + forest.get(i).end + "\t" + forest.get(i).value);
            }
        }
        else{
                while (count < matrixSize) {
                    segSize = edges.size() / div;
                    if (segSize == 0) segSize = edges.size();
                    threadCount = 0;

                    for (int i = 0; i < edges.size(); i += segSize) {
                        lim = Math.min(i + segSize, edges.size());
                        threads.set(i / segSize, new MinThread(edges.subList(i, lim)));

                        threads.get(i / segSize).start();
                        threadCount++;
                    }
                    try {
                        for (int i = 0; i < threadCount; i++) {
                            threads.get(i).join();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    min = Integer.MAX_VALUE;
                    minNode = null;
                    for (int i = 0; i < threadCount; i++) {
                        Node node = threads.get(i).getMin();
                        if (node != null && node.value < min) {
                            min = node.value;
                            minNode = node;
                        }
                    }

                    if (minNode != null) {
                        forest.add(minNode);
                        edges.remove(minNode);
                    }

                    for (Node node : edges) {
                        if (wtMat[minNode.end][node.end] < node.value) {
                            node.start = minNode.end;
                            node.value = wtMat[minNode.end][node.end];
                        }
                    }
                    count++;
                }


                forest.sort(Comparator.comparingInt(n -> n.end));
                long endTime = System.nanoTime();
                double timeElapsed = (endTime - startTime) / 1E6;
                System.out.println("\nIt took " + timeElapsed + " ns");
                System.out.println("\nMST: ");
                System.out.println("Edge\tDistance");
                for (int i = 0; i < forest.size(); i++) {
                    if (i != src)
                        System.out.println(forest.get(i).start + " - " + forest.get(i).end + "\t" + forest.get(i).value);
                }
            }
            monitor.stopDisplaying();
        }

}
