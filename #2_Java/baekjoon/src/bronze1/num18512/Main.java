package bronze1.num18512;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
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
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 학생이 한번에 멀리뛰기를 하는 거리와
		시작 지점의 위치를 각 변수에 할당 */
		int distanceA = Integer.parseInt(st.nextToken());
		int distanceB = Integer.parseInt(st.nextToken());
		int startPosA = Integer.parseInt(st.nextToken());
		int startPosB = Integer.parseInt(st.nextToken());
		
		// commonPosFinder(), valueOf(), write() 메서드를 사용해 두 학생이 공통적으로 지나는 지점 중에서 가장 가까운 지점을 출력
		out.write(String.valueOf(commonPosFinder(distanceA, distanceB, startPosA, startPosB)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// commonPosFinder() 메서드 정의
	public static int commonPosFinder(int distanceA, int distanceB, int startPosA, int startPosB) {
		
		// 첫 번째 학생이 방문하는 지점을 저장할 Set 객체 positionA 초기화
		Set<Integer> positionA = new HashSet<>();
		
		// for 반복문을 사용해 첫 번째 학생이 방문하는 지점을 positionA에 저장
		for (int count = 0; count <= 100; count++)
			positionA.add(startPosA + count * distanceA);
		
		// for 반복문을 사용해 두 번째 학생이 방문하는 지점을 순회
		for (int count = 0; count <= 100; count++) {
			
			// 두 번째 학생이 방문하는 지점을 변수 positionB에 할당
			int positionB = startPosB + count * distanceB;
			
			// 두 번째 학생이 방문하는 지점을 첫 번째 학생도 방문한 경우 해당 지점을 반환
			if (positionA.contains(positionB))
				return positionB;
		}
		
		// 두 학생이 공통적으로 지나는 지점이 없는 경우 -1을 반환
		return -1;
	}
}