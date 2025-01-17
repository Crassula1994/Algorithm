package bronze3.num02985;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 세 정수를 각 변수에 할당
		int numberA = Integer.parseInt(st.nextToken());
		int numberB = Integer.parseInt(st.nextToken());
		int numberC = Integer.parseInt(st.nextToken());
		
		// equationFinder() 및 write() 메서드를 사용해 등식을 출력
		out.write(equationFinder(numberA, numberB, numberC));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// equationFinder() 메서드 정의
	public static String equationFinder(int numberA, int numberB, int numberC) {
		
		// valueOf() 메서드를 사용해 등식을 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder(String.valueOf(numberA));
		
		// 첫 번째와 두 번째 숫자를 더해 세 번째 숫자가 되는 경우 등식을 반환
		if (numberA + numberB == numberC)
			return sb.append("+").append(numberB).append("=").append(numberC).toString();
		
		// 첫 번째 숫자에서 두 번째 숫자를 빼 세 번째 숫자가 되는 경우 등식을 반환
		if (numberA - numberB == numberC)
			return sb.append("-").append(numberB).append("=").append(numberC).toString();
		
		// 첫 번째와 두 번째 숫자를 곱해 세 번째 숫자가 되는 경우 등식을 반환
		if (numberA * numberB == numberC)
			return sb.append("*").append(numberB).append("=").append(numberC).toString();
		
		// 첫 번째 숫자를 두 번째 숫자로 나눠 세 번째 숫자가 되는 경우 등식을 반환
		if (numberA % numberB == 0 && numberA / numberB == numberC)
			return sb.append("/").append(numberB).append("=").append(numberC).toString();
		
		// 두 번째와 세 번째 숫자를 더해 첫 번째 숫자가 되는 경우 등식을 반환
		if (numberB + numberC == numberA)
			return sb.append("=").append(numberB).append("+").append(numberC).toString();
		
		// 두 번째 숫자에서 세 번째 숫자를 빼 첫 번째 숫자가 되는 경우 등식을 반환
		if (numberB - numberC == numberA)
			return sb.append("=").append(numberB).append("-").append(numberC).toString();
		
		// 두 번째와 세 번째 숫자를 곱해 첫 번째 숫자가 되는 경우 등식을 반환
		if (numberB * numberC == numberA)
			return sb.append("=").append(numberB).append("*").append(numberC).toString();
		
		// 두 번째 숫자를 세 번째 숫자로 나눠 첫 번째 숫자가 되는 경우 등식을 반환
		return sb.append("=").append(numberB).append("/").append(numberC).toString();
	}
}