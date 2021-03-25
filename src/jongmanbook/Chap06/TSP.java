package jongmanbook.Chap06;

import java.util.List;

public class TSP {
    static int N; // 도시의 수
    static double[][] dist; // 두 도시 간의 거리를 저장하는 배열
    // path: 지금까지 만든 경로
    // visited: 각 도시의 방문 여부
    // currentLength: 지금까지 만든 경로의 길이
    // 나머지 도시들을 모두 방문하는 경로들 중 가장 짧은 것의 길이를 반환한다.

    static double shortestPath(List<Integer> path, List<Boolean> visited, double currentLength){
        //기저 사례: 모든 도시를 다 방문했을 때는 시작 도시로 돌아가고 종료한다.
        if(path.size() == N)
            return currentLength + dist[path.get(0)][path.get(path.size()-1)];
        double ret = Double.MAX_VALUE; // 매우 큰 값으로 초기화
        //다음 방문할 도시를 전부 시도해 돈다.
        for(int next = 0; next < N; ++next) {
            if(visited.get(next))
                continue;
            int here = path.get(path.size()-1);
            path.add(next);
            visited.set(next, true);
            // 나머지 경로를 재귀 호출을 통해 완성하고 가장 짧은 경로의 길이를 얻는다.
            double cand = shortestPath(path, visited, currentLength + dist[here][next]);

            ret = Math.min(ret, cand);
            visited.set(next, false);
            path.remove(path.size() - 1);
        }
        return ret;
    }
}
