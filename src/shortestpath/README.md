## 최단경로
* 가장 짧은 경로를 찾는 알고리즘
* 학부 수준에서는 다이제크스트라 최단 경로 알고리즘, 플로이드 워셜, 벨멘 포드 알고리즘이 있음
* 더불어 앞서 공부한 그리디 알고리즘과 다이나믹 프로그래밍 알고리즘이 최단 경로 알고리즘에 그대로 적용

## 다이제크스트라 알고리즘(Dijkstra algorithm)
* 그래프에서 여러 개의 노드가 있을 때, 특정한 노드에서 출발하여 다른 노드로 가는 각각의 최단 경로를 구해주는 알고리즘
  * 음의 간선이 없을 때 정상적으로 동작
* 그리디 알고리즘으로 분류되며 매번 가장 비용이 적은 노드를 선택해서 임의의 과정을 반복
```aidl
1. 출발 노드를 설정한다.
2. 최단 거리 테이블을 초기화한다.
3. 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택한다.
4. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블을 갱신한다.
5. 위 과정에서 3, 4번을 반복한다.
```
* 다이제크스트라 알고리즘은 최단 경로를 구하는 과정에서 각 노드에 대한 현재까지 최단 거리 정보를 항상 1차원 리스트에 저장하며 리스트를 계속 갱신한다는 특징이 있음

### 방법 1. 간단한 다이제크스트라 알고리즘
* 시간복잡도 O(V^2), 여기서 V란 노드의 개수
* 처음에 각 노드에 대한 최단 거리를 담는 1차원 리스트를 선언한다.
    * 이후에 단계마다 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택하기 위해 매 단계마다 1차원 리스트의 모든 원소를 순차 탐색한다.

### 방법 2. 개선된 다이제크스트라 알고리즘
* 최악의 경우 시간 복잡도 O(ElogV), 여기서 E란 간선의 개수
* Heap 자료구조를 사용, 힙 자료구조를 이용하게 되면 특정 노드까지의 최단 거리에 대한 정보를 힙에 담아서 처리하므로 출발 노드로부터 가장 거리가 짧은 노드를
    더욱 빠르게 찾을 수 있음
  * 이 과정에서 선형 시간이 아닌 로그 시간이 걸림
* java에서는 Priority Queue를 사용
    * 높은 우선순위를 가진 요소를 먼저 꺼내서 처리하는 자료구조
    * 내부 요소는 힙으로 구성되어 이진트리 구조로 이루어져 있음
    * 내부구조가 힙으로 구성되어 있기 때문에 시간 복잡도는 O(NlogN)
```aidl
import java.util.PriorityQueue;

//int형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

//int형 priorityQueue 선언 (우선순위가 높은 숫자 순)
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

priorityQueue.add(1);     // priorityQueue 값 1 추가
priorityQueue.add(2);     // priorityQueue 값 2 추가
priorityQueue.offer(3);   // priorityQueue 값 3 추가

priorityQueue.poll();       // priorityQueue에 첫번째 값을 반환하고 제거 비어있다면 null
priorityQueue.remove();     // priorityQueue에 첫번째 값 제거
priorityQueue.clear();      // priorityQueue에 초기화

class Node implements Comparable<Node> {

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

PriorityQueue<Node> pq = new PriorityQueue<>();
```    
    
## 플로이드 워셜 알고리즘
* 모든 지점에서 다른 모든 지점까지의 최단 경로를 모두 구해야 하는 경우에 사용
* 매 단계마다 거쳐 가는 노드를 기준으로 알고리즘을 수행
    * 하지만 다이제크스트라 알고리즘과 다르게 매번 방문하지 않은 노드 중에서 최단 거리를 갖는 노드를 찾을 필요가 없다는 점이 다름
* 노드의 개수가 N일 때 알고리즘상으로 N번의 단계를 수행하며, 단계마다 O(N^2)의 연산을 통해 현재 노드를 거쳐 가는 모든 경로를 고려
    * 따라서 플로이드 워셜 알고리즘의 시간 복잡도는 O(N^3)
* 2차원 리스트에 최단 거리 정보를 저장한다는 특징이 있음
    * 모든 노드에 대하여 다른 모든 노드로 가는 최단 거리 정보를 담아야 하기 때문
* 다이나믹 프로그래밍 특징을 지니고 있음    
```aidl
for (int k = 1; k <= n; k++) {
    for (int a = 1; a <= n; a++) {
        for (int b = 1; b <= n; b++) {
            graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
        }
    }
}
```