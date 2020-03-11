package leetcode.study.week179.t04;

import java.util.*;

/**
 * @Author : josan
 * @Date : 2020/3/8 10:20
 * @Package : leetcode.study.week179.t04
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if (n < 1 || n > 100 || t < 1 || t > 50 || target < 1 || target > n) {
            throw new IllegalArgumentException("n , t, target is wrong");
        } else if (edges.length == 0 && target == 1) {
            return 1.0;
        }

        normalize(edges);

        Map<Integer, List<List<Integer>>> edgeMap = getEdgeMapFromEdges(edges);

        List<Integer> path = new ArrayList<>();
        List<Integer> targetPath = new ArrayList<>();
        findTarget(edgeMap, 1, target, path, targetPath, t);
        double result = 0.0;
        if (!targetPath.isEmpty() && targetPath.size() <= t) {
            if (targetPath.size() != 1 || targetPath.get(0) != -1) {
                result = getResult(edgeMap, targetPath, 1);
            }
        }

        return result;
    }

    private void normalize(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] > edges[i][1]) {
                int tmp = edges[i][1];
                edges[i][1] = edges[i][0];
                edges[i][0] = tmp;
            }
        }
    }

    private double getResult(Map<Integer, List<List<Integer>>> edgeMap, List<Integer> targetPath, int t) {
        double result = 1;

        result *= 1.0 / edgeMap.get(t).size();
        for (int i = 0; i < targetPath.size() - 1; i++) {
            result *= 1.0 / edgeMap.get(targetPath.get(i)).size();
        }
        return result;
    }

    private void findTarget(Map<Integer, List<List<Integer>>> edgeMap,
                                     int t, int target,
                            List<Integer> curPath, List<Integer> targetPath, int time) {
        if (edgeMap.get(t) == null || !targetPath.isEmpty()) {
            return ;
        }

        List<List<Integer>> nodes = edgeMap.get(t);
        for (int i = 0; i < nodes.size(); i++) {
            List<Integer> edge = nodes.get(i);
            int anotherVector = edge.get(1);
            if (anotherVector == target) {
                if (edgeMap.get(target) != null && (time == curPath.size() + 1)
                    || edgeMap.get(target) == null) {
                    for (int j = 0; j < curPath.size(); j++) {
                        targetPath.add(curPath.get(j));
                    }
                    targetPath.add(target);
                } else {
                    targetPath.add(-1);
                }
                return ;
            } else {
                curPath.add(anotherVector);
                findTarget(edgeMap, anotherVector, target, curPath, targetPath, time);
                curPath.remove(curPath.size() - 1);
            }
        }
    }



    private Map<Integer, List<List<Integer>>> getEdgeMapFromEdges(int[][] edges) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] oneEdge = edges[i];
            int vector = oneEdge[0];
            if (map.get(vector) == null) {
                List<List<Integer>> list = new ArrayList<>();
                list.add(Arrays.asList(oneEdge[0], oneEdge[1]));
                map.put(vector, list);
            } else {
                map.get(vector).add(Arrays.asList(oneEdge[0], oneEdge[1]));
            }
        }
        return map;
    }
}
