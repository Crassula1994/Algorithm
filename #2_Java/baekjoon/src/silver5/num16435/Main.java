package silver5.num16435;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 과일의 개수 및 스네이크버드의 초기 길이를 각 변수에 할당
		int fruitNum = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
		
		// 과일의 높이를 저장할 배열 fruits 초기화
		int[] fruits = new int[fruitNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 과일의 높이를 배열 fruits에 저장
		for (int idx = 0; idx < fruitNum; idx++)
			fruits[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 과일의 높이를 오름차순으로 정렬
		Arrays.sort(fruits);
		
		// for 반복문을 사용해 각 과일의 높이를 순회
		for (int idx = 0; idx < fruitNum; idx++) {
			
			// 해당 과일을 스네이크버드가 먹을 수 없는 경우 반복문 탈출
			if (length < fruits[idx])
				break;
			
		 	// 스네이크버드의 길이를 증가
			length++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 스네이크버드의 최대 길이를 출력
		out.write(String.valueOf(length));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}