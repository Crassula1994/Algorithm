package gold2.num10722;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 모빌의 왼쪽 끝과 오른쪽 끝의 위치를 나타낼 각 변수 초기화
	static double leftLimit;
	static double rightLimit;
	
	// 나무 막대의 정보를 저장할 배열 sticks 초기화
	static Stick[] sticks;
	
	// 각 나무 막대 좌우 무게를 저장할 2차원 배열 weights 초기화
	static long[][] weights;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Stick 클래스 정의
	static class Stick {
		
		// 나무 막대의 길이, 왼쪽과 오른쪽에 매달린 물체의 정보를 저장할 각 변수 초기화
		int length;
		int left;
		int right;
		
		// 매개변수를 입력 받는 생성자 정의
		public Stick(int length, int left, int right) {
			this.length = length;
			this.left = left;
			this.right = right;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// gc() 메서드를 사용해 메모리 초기화
			System.gc();
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 나무 막대의 수를 변수 stickNum에 할당
			int stickNum = Integer.parseInt(in.readLine());
			
			// 모빌의 왼쪽 끝과 오른쪽 끝의 위치를 나타낼 각 변수 초기화
			leftLimit = 0;
			rightLimit = 0;
			
			// 나무 막대의 정보를 저장할 배열 sticks 초기화
			sticks = new Stick[stickNum + 1];
			
			// 각 나무 막대 좌우 무게를 저장할 2차원 배열 weights 초기화
			weights = new long[stickNum + 1][2];
			
			// for 반복문을 사용해 각 나무 막대를 순회
			for (int idx = 1; idx <= stickNum; idx++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 나무 막대의 정보를 각 변수에 할당
				int length = Integer.parseInt(st.nextToken());
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				
				// 해당 나무 막대의 정보를 배열 sticks에 저장
				sticks[idx] = new Stick(length, left, right);
			}
			
			// weightFinder() 메서드를 호출해 나무 막대의 좌우 무게를 갱신
			weightFinder(-1);
			
			// lengthCalculator() 메서드를 호출해 모빌의 왼쪽 끝과 오른쪽 끝의 위치를 갱신
			lengthCalculator(-1, 0);
			
			// format() 및 write() 메서드를 사용해 모빌의 폭을 출력
			out.write(String.format("%.11f\n", rightLimit - leftLimit));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// weightFinder() 메서드 정의
	public static long weightFinder(int curLocation) {
		
		// 현재 위치가 막대가 아닌 구슬인 경우 구슬의 무게를 반환
		if (curLocation > 0)
			return curLocation;
		
		// abs() 메서드를 사용해 해당 막대의 번호를 변수 number에 할당
		int number = Math.abs(curLocation);
		
		// weightFinder() 메서드를 호출해 왼쪽과 오른쪽의 무게를 각 변수에 할당
		long leftWeight = weightFinder(sticks[number].left);
		long rightWeight = weightFinder(sticks[number].right);
		
		// 해당 나무 막대 좌우 무게를 2차원 배열 weights에 저장
		weights[number][0] = leftWeight;
		weights[number][1] = rightWeight;
		
		// 현재 막대의 무게를 반환
		return leftWeight + rightWeight;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// lengthCalculator() 메서드 정의
	public static void lengthCalculator(int curLocation, double centerPos) {
		
		// 현재 위치가 막대가 아닌 구슬인 경우 메서드 종료
		if (curLocation > 0)
			return;
		
		// abs() 메서드를 사용해 해당 막대의 번호를 변수 number에 할당
		int number = Math.abs(curLocation);
		
		// 해당 나무 막대의 좌우 무게를 각 변수에 할당
		long leftWeight = weights[number][0];
		long rightWeight = weights[number][1];
		
		// 막대가 연결된 실에서 각 막대 끝이 떨어진 거리, 위치를 각각 계산해 각 변수에 할당
		double leftDist = (double) rightWeight * sticks[number].length / (leftWeight + rightWeight);
		double rightDist = (double) sticks[number].length - leftDist;
		double leftPos = centerPos - leftDist;
		double rightPos = centerPos + rightDist;
		
		// min() 및 max() 메서드를 사용해 모빌의 왼쪽 끝과 오른쪽 끝의 위치를 갱신
		leftLimit = Math.min(leftPos, leftLimit);
		rightLimit = Math.max(rightPos, rightLimit);
		
		// lengthCalculator() 메서드 재귀 호출
		lengthCalculator(sticks[number].left, leftPos);
		lengthCalculator(sticks[number].right, rightPos);
	}
}