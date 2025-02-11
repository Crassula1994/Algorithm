package silver2.num04019;

// 필요한 패키지 불러오기
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// Scanner 및 BufferedWriter 객체를 불러와 각 변수에 할당
		Scanner in = new Scanner(System.in);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 테스트 케이스 번호를 저장할 변수 testCase 초기화
		int testCase = 0;

		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// nextInt() 메서드를 사용해 입력 받은 플래시 몹 구성원의 수를 변수 memberNum에 할당
			int memberNum = in.nextInt();
			
			// 마지막 테스트 케이스인 경우 반복문 탈출
			if (memberNum == 0)
				break;
			
			// 각 구성원의 동서 거리와 남북 거리 좌표를 저장할 각 배열 초기화
			int[] coordinatesX = new int[memberNum];
			int[] coordinatesY = new int[memberNum];
			
			// for 반복문을 사용해 각 구성원의 동서 거리와 남북 거리 좌표를 각 배열에 저장
			for (int idx = 0; idx < memberNum; idx++) {
				coordinatesX[idx] = in.nextInt();
				coordinatesY[idx] = in.nextInt();
			}
			
			// sort() 메서드를 사용해 각 좌표를 오름차순으로 정렬
			Arrays.sort(coordinatesX);
			Arrays.sort(coordinatesY);
			
			// 각 구성원이 이동해야 하는 좌표 및 최소 거리를 저장할 각 변수 초기화
			int bestCoordinateX = coordinatesX[(memberNum - 1) / 2];
			int bestCoordinateY = coordinatesY[(memberNum - 1) / 2];
			int minDistance = 0;
			
			// for 반복문을 사용해 각 구성원이 이동해야 하는 최소 거리를 갱신
			for (int idx = 0; idx < memberNum; idx++) {
				minDistance += Math.abs(coordinatesX[idx] - bestCoordinateX);
				minDistance += Math.abs(coordinatesY[idx] - bestCoordinateY);
			}
			
			// format() 및 write() 메서드를 사용해 테스트 케이스 번호, 각 구성원이 이동해야 하는 좌표 및 최소 거리를 출력
			out.write(String.format("Case %d: (%d,%d) %d\n", ++testCase, bestCoordinateX, bestCoordinateY, minDistance));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}