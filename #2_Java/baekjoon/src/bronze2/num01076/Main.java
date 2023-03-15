package bronze2.num01076;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 각 저항의 색상 정보를 저장할 Map 객체 resistance 초기화
		Map<String, Long> resistance = new HashMap<>();
		
		// put() 메서드를 사용해 각 저항의 값을 resistance에 저장
		resistance.put("black", 0L);
		resistance.put("brown", 1L);
		resistance.put("red", 2L);
		resistance.put("orange", 3L);
		resistance.put("yellow", 4L);
		resistance.put("green", 5L);
		resistance.put("blue", 6L);
		resistance.put("violet", 7L);
		resistance.put("grey", 8L);
		resistance.put("white", 9L);
		
		// readLine() 메서드를 사용해 입력 받은 저항의 값을 변수 resistanceVal에 할당
		long resistanceVal = resistance.get(in.readLine()) * 10 + resistance.get(in.readLine());
		
		// readLine() 및 pow() 메서드를 사용해 곱해야 하는 값을 resistanceVal에 곱해 갱신
		resistanceVal *= Math.pow(10, resistance.get(in.readLine()));
		
		// valueOf() 및 write() 메서드를 사용해 저항의 값을 출력
		out.write(String.valueOf(resistanceVal));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}