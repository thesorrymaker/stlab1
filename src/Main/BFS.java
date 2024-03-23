package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    private final List<List<Integer>> adjacencyList;
    private final int startVertex;
    private final List<LogItem> breadthFirstSearchLogs = new ArrayList<>();

    public BFS(List<List<Integer>> adjacencyList, int startVertex) {
        this.adjacencyList = adjacencyList;
        this.startVertex = startVertex;
    }

    public boolean[] run() {
        breadthFirstSearchLogs.clear();
        boolean[] visited = new boolean[adjacencyList.size()];
        Queue<Integer> visitQueue = new LinkedList<>();
        visitQueue.add(startVertex);

        while (!visitQueue.isEmpty()) {
            Integer vertex = visitQueue.poll();
            visited[vertex] = true;

            List<Integer> neighbors = adjacencyList.get(vertex);
            for (Integer neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visitQueue.add(neighbor);
                }
            }
            logStep(vertex, visited);
        }
        return visited;
    }

    private void logStep(int visitedVertex, boolean[] curResult) {
        System.out.println(Arrays.toString(curResult) + ": visited vertex " + visitedVertex);
        breadthFirstSearchLogs.add(new LogItem(visitedVertex, curResult));
    }

    public Collection<LogItem> getLogs() {
        return breadthFirstSearchLogs;
    }

    public static class LogItem {
        final boolean[] currentResult;
        final int visitedVertex;

        public LogItem(int visitedVertex, boolean[] currentResult) {
            this.currentResult = currentResult;
            this.visitedVertex = visitedVertex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LogItem logItem = (LogItem) o;
            return visitedVertex == logItem.visitedVertex && Arrays.equals(currentResult, logItem.currentResult);
        }

        @Override
        public String toString() {
            return "LogItem{" + "currentResult=" + Arrays.toString(currentResult) + ", visitedVertex=" + visitedVertex + '}';
        }
    }
}