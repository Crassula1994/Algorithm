package silver2.num30804;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 과일의 개수를 변수 fruitNum에 할당
		int fruitNum = Integer.parseInt(in.readLine());
		
		// 과일의 개수가 가장 많은 탕후루의 개수, 탕후루의 왼쪽 끝과 오른쪽 끝을 저장할 각 변수 초기화
		int maxCount = 1;
		int left = 0;
		int right = 1;
		
		// 탕후루에 꽂힌 과일을 저장할 배열 fruits 초기화
		int[] fruits = new int[fruitNum + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 탕후루에 꽂힌 과일을 배열 fruits에 저장
		for (int idx = 1; idx < fruits.length; idx++)
			fruits[idx] = Integer.parseInt(st.nextToken());
		
		// 현재 탕후루에 꽂혀 있는 과일과 그 과일이 등장한 마지막 인덱스를 저장할 Map 객체 tanghulu 초기화
		Map<Integer, Integer> tanghulu = new HashMap<>();
		
		// put() 메서드를 사용해 첫 번째 과일을 tanghulu에 추가
		tanghulu.put(fruits[1], 1);
		
		// while 반복문을 사용해 모든 가능한 탕후루를 순회
		while (left < right) {
			
			// 탕후루의 오른쪽 끝이 마지막 과일에 도달한 경우 반복문 탈출
			if (right == fruitNum)
				break;
			
			// 탕후루에 꽂힌 과일의 수가 2개를 초과한 경우
			if (tanghulu.size() > 2) {
				
				// 탕후루의 왼쪽 끝을 갱신
				left++;
				
				// 제거할 과일이 탕후루에 꽂힌 마지막 과일인 경우 해당 과일을 tanghulu에서 제거
				if (tanghulu.get(fruits[left]) == left)
					tanghulu.remove(fruits[left]);
			
			// 탕후루에 꽂힌 과일의 수가 2개 이하인 경우
			} else {
			
				// 탕후루의 오른쪽 끝을 갱신
				right++;
				
				// put() 메서드를 사용해 해당 과일을 tanghulu에 추가
				tanghulu.put(fruits[right], right);
			}
			
			// 탕후루에 꽂힌 과일의 수가 2개 이하인 경우 과일의 개수가 가장 많은 탕후루의 개수를 갱신
			if (tanghulu.size() <= 2)
				maxCount = Math.max(right - left, maxCount);
		}
		
		// valueOf() 및 write() 메서드를 사용해 과일의 개수가 가장 많은 탕후루의 개수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}