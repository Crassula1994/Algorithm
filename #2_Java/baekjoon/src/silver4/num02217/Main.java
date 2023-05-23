package silver4.num02217;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
	    
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 로프의 개수를 변수 ropeNum에 할당
		int ropeNum = Integer.parseInt(in.readLine());
		
		// 각 로프의 중량을 저장할 배열 weights 초기화
		int[] weights = new int[ropeNum];
		
		// for 반복문을 사용해 입력 받은 각 로프가 버틸 수 있는 최대 중량을 배열 weights에 저장
		for (int idx = 0; idx < weights.length; idx++)
			weights[idx] = Integer.parseInt(in.readLine());
	    
		// sort() 메서드를 사용해 각 로프가 버틸 수 있는 최대 중량을 오름차순으로 정렬
		Arrays.sort(weights);
	    
		// 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량을 저장할 변수 maxWeight 초기화
		int maxWeight = 0;

		// for 반복문을 사용해 각 로프를 순회
		for (int idx = 0; idx < weights.length; idx++) {
      
			// 해당 로프를 사용했을 때 들어올릴 수 있는 물체의 최대 중량을 계산해 변수 currentWeight에 저장
			int currentWeight = weights[idx] * (weights.length - idx);
			
			// max() 메서드를 사용해 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량을 갱신
			maxWeight = Math.max(currentWeight, maxWeight);
		}

		// valueOf() 및 write() 메서드를 사용해 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량를 출력
		out.write(String.valueOf(maxWeight));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}