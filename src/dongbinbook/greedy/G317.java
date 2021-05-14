package dongbinbook.greedy;

public class G317 {
    static int solution(int[] food_times, long k) {
        long sum = 0;
        for(int a: food_times) {
            sum += a;
        }
        if(sum <= k) {
            return -1;
        }
        int index = 0;

        for(int i=0; i < k; i++) {
            while(food_times[index] <= 0) {
                index++;
                if(index >= food_times.length)
                    index = 0;
            }
            if(food_times[index] > 0) {
                food_times[index++] -= 1;
            }
            if(index >= food_times.length)
                index = 0;
        }

        int answer = index+1;
        return answer;
    }

    public static void main(String[] args) {
        int[] a = {3,1,2};
        System.out.println(solution(a, (long)10));
    }
}
