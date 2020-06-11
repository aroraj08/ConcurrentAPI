package com.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

    int v;
    LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i=0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int vertex, int value) {
        adj[vertex].add(value);
    }
    public void bfs(int v) {

        boolean[] visited = new boolean[adj.length];
        LinkedList<Integer> queue= new LinkedList<>();

        visited[v] = true;
        queue.add(v);

        while(!queue.isEmpty()) {

            Integer vertex = queue.poll();
            System.out.println(vertex);

            Iterator<Integer> it = adj[vertex].iterator();
            while (it.hasNext()) {
                Integer r = it.next();
                if (visited[r] == false) {
                    visited[r] = true;
                    queue.add(r);
                }
            }
        }
    }

    void dfs(int source) {

        boolean[] visited = new boolean[v];
        visited[source] = true;

        dfsUtil(source, visited);

    }

    void dfsUtil(int vertex, boolean[] visited) {

        System.out.println(vertex);

        Iterator<Integer> it = adj[vertex].iterator();
        while (it.hasNext()) {
            Integer neighbour = it.next();
            if (visited[neighbour] == false) {
                visited[neighbour] = true;
                dfsUtil(neighbour, visited);
            }
        }
    }
}
