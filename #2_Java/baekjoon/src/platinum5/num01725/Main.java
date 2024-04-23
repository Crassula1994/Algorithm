package platinum5.num01725;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 히스토그램의 가로 칸 수를 변수 width에 할당
		int width = Integer.parseInt(in.readLine());
		
		// 히스토그램에서 가장 넓이가 큰 직사각형의 넓이를 저장할 변수 maxArea 초기화
		int maxArea = 0;
		
		// 히스토그램의 각 칸의 높이를 저장할 배열 histogram 초기화
		int[] histogram = new int[width + 2];
		
		// for 반복문을 사용해 각 칸의 높이를 배열 histogram에 저장
		for (int idx = 1; idx <= width; idx++)
			histogram[idx] = Integer.parseInt(in.readLine());
		
		// 히스토그램의 각 직사각형의 넓이를 계산할 Stack 객체 areaMeasurer 초기화
		Stack<Integer> areaMeasurer = new Stack<>();
		
		// push() 메서드를 사용해 가장 앞의 빈 칸을 areaMeasurer에 추가
		areaMeasurer.push(0);
		
		// for 반복문을 사용해 각 칸의 높이를 순회
		for (int idx = 1; idx < histogram.length; idx++) {
			
			// while 반복문을 사용해 areaMeasurer가 빌 때까지 순회
			while (!areaMeasurer.isEmpty()) {
				
				// 현재 직사각형의 높이가 이전 직사각형의 높이보다 더 높거나 같은 경우 반복문 탈출
				if (histogram[idx] >= histogram[areaMeasurer.peek()])
					break;
				
				// pop() 메서드를 사용해 이전 직사각형의 칸을 변수 prevIdx에 할당
				int prevIdx = areaMeasurer.pop();
				
				// max() 메서드를 사용해 가장 넓이가 큰 직사각형의 넓이를 갱신
				maxArea = Math.max(histogram[prevIdx] * (idx - areaMeasurer.peek() - 1), maxArea);
			}
			
			// push() 메서드를 사용해 해당 직사각형의 칸을 areaMeasurer에 추가
			areaMeasurer.push(idx);
		}
		
		// valueOf() 및 write() 메서드를 사용해 히스토그램에서 가장 넓이가 큰 직사각형의 넓이를 출력
		out.write(String.valueOf(maxArea));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}