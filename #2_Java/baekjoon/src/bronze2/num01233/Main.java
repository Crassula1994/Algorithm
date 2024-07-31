package bronze2.num01233;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 주사위의 면의 수를 각 변수에 할당
		int side1 = Integer.parseInt(st.nextToken());
		int side2 = Integer.parseInt(st.nextToken());
		int side3 = Integer.parseInt(st.nextToken());
		
		// 가장 많은 빈도와 해당 빈도로 나오는 세 주사위 합을 저장할 각 변수 초기화
		int maxCount = 0;
		int maxFrequency = 0;
		
		// 세 주사위 합의 빈도 수를 저장할 배열 frequency 초기화
		int[] frequency = new int[side1 + side2 + side3 + 1];
		
		// for 반복문을 사용해 세 주사위 합의 빈도 수를 갱신
		for (int s1 = 1; s1 <= side1; s1++) {
			for (int s2 = 1; s2 <= side2; s2++) {
				for (int s3 = 1; s3 <= side3; s3++)
					frequency[s1 + s2 + s3]++;
			}
		}
		
		// for 반복문을 사용해 각 주사위 합을 순회
		for (int idx = 0; idx < frequency.length; idx++) {
			
			// 해당 빈도 수가 저장된 가장 많은 빈도보다 많은 경우 가장 많은 빈도와 해당 빈도로 나오는 세 주사위 합을 갱신
			if (frequency[idx] > maxCount) {
				maxCount = frequency[idx];
				maxFrequency = idx;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 가장 많은 빈도로 나오는 세 주사위 합을 출력
		out.write(String.valueOf(maxFrequency));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}