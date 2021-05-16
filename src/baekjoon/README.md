
이중 우선순위 큐
--------------
우선 두 개의 힙을 써서 중간 값 삭제가 가능한 힙을 만들 수 있습니다. 각각을 (value heap) / (deleted heap) 이라고 합시다.

- 삽입: value heap에만 추가

- 삭제: deleted heap에 삭제할 원소 추가

- 최상위 값 꺼낼 때: value heap의 top과 deleted heap의 top이 일치하는 경우 두 heap에서 모두 해당 원소를 꺼내는 것을 계속 
  반복한 다음 최상위 값 꺼내기

이렇게 만들면 임의의 중간 값 삭제를 하면서 amortized O(logN)이 보장되는 삭제 가능한 힙을 만들 수 있습니다.

이제, 삭제 가능한 min heap 하나, max heap을 하나 만든 다음 원소가 추가될 때는 min heap / max heap에 모두 추가해주고, 
삭제할 때는 min heap의 최상단 값을 양쪽 힙에서 모두 지우거나 max heap의 최상단 값을 양쪽 힙에서 모두 지우는 것으로 주어진 
연산을 모두 구할 수 있습니다. 좀 느리지만 BST 구현 없이 기본적인 heap 구현 +a 정도에서 할 수 있는 상대적으로 간단한 구현일 것 같네요.