package bronze5.num06840;

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
		
		// 주어진 세 마리 곰의 그릇 무게를 저장할 배열 bowls 초기화
		int[] bowls = new int[3];
		
		// for 반복문을 사용해 입력 받은 그릇 무게를 배열 bowls에 저장
		for (int idx = 0; idx < bowls.length; idx++)
			bowls[idx] = Integer.parseInt(in.readLine());
		
		// sort() 메서드를 사용해 입력 받은 그릇 무게를 오름차순으로 정렬
		Arrays.sort(bowls);
		
		// valueOf() 및 write() 메서드를 사용해 엄마 곰의 그릇 무게를 출력
		out.write(String.valueOf(bowls[1]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}