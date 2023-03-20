package bronze3.num05073;

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
		
		// while 반복문을 사용해 각 삼각형의 변의 길이를 모두 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 삼각형의 변을 각 변수에 할당
			int sideA = Integer.parseInt(st.nextToken());
			int sideB = Integer.parseInt(st.nextToken());
			int sideC = Integer.parseInt(st.nextToken());
			
			// 가장 긴 변의 길이를 변수 maxSide에 할당
			int maxSide = Math.max(Math.max(sideA, sideB), sideC);
			
			// 세 변의 길이의 합을 저장할 변수 sideSum 초기화
			int sideSum = sideA + sideB + sideC;
			
			// 0이 입력된 경우 반복문 탈출
			if (sideA == 0 && sideB == 0 && sideC == 0)
				break;
			
			// 해당 삼각형이 정삼각형일 경우 'Equilateral' 출력
			if (sideA == sideB && sideB == sideC) {
				out.write("Equilateral\n");
				
			// 삼각형이 아닌 경우 'Invalid' 출력
			} else if (sideSum - maxSide <= maxSide) {
				out.write("Invalid\n");
				
			// 해당 삼각형이 이등변삼각형일 경우 'Isosceles' 출력
			} else if (sideA == sideB || sideA == sideC || sideB == sideC) {
				out.write("Isosceles\n");
				
			// 해당 삼각형의 세 변의 길이가 모두 다른 경우 'Scalene' 출력
			} else {
				out.write("Scalene\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
    }
}