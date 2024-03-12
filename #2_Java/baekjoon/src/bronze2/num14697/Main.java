package bronze2.num14697;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 방의 정원 및 전체 학생 수를 각 변수에 할당
		int capacityA = Integer.parseInt(st.nextToken());
		int capacityB = Integer.parseInt(st.nextToken());
		int capacityC = Integer.parseInt(st.nextToken());
		int studentNum = Integer.parseInt(st.nextToken());
		
		// 빈 침대 없이 배정이 가능한지 여부를 나타낼 변수 noVacancy 초기화
		boolean noVacancy = false;
		
		// for 반복문을 사용해 각 방의 개수를 순회
		outer: for (int a = 0; a <= studentNum / capacityA; a++) {
			for (int b = 0; b <= studentNum / capacityB; b++) {
				for (int c = 0; c <= studentNum / capacityC; c++) {
					
					// 해당 방의 총 정원이 전체 학생 수와 동일한 경우 빈 침대 없이 배정이 가능한지 여부를 갱신 후 반복문 탈출
					if (capacityA * a + capacityB * b + capacityC * c == studentNum) {
						noVacancy = true;
						break outer;
					}
				}
			}
		}
		
		// 빈 침대 없이 배정이 가능한 경우 1을 출력
		if (noVacancy) {
			out.write(String.valueOf(1));
			
		// 빈 침대 없이 배정이 불가능한 경우 0을 출력
		} else {
			out.write(String.valueOf(0));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}