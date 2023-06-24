package gold3.num20366;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 눈덩이의 수를 변수 snowballNum에 할당
		int snowballNum = Integer.parseInt(in.readLine());
		
		// 각 눈덩이의 지름를 저장할 배열 snowballs 초기화
		int[] snowballs = new int[snowballNum];

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 눈덩이의 지름을 배열 snowballs에 저장
		for (int idx = 0; idx < snowballs.length; idx++)
			snowballs[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 배열 snowballs를 오름차순으로 정렬
		Arrays.sort(snowballs);
		
		// 두 눈사람의 키 차이 중 최솟값을 저장할 변수 minDifference 초기화
		int minDifference = Integer.MAX_VALUE;
		
		// for 반복문을 사용해 엘자가 선택한 두 눈덩이를 순회
		outer: for (int e1 = 0; e1 < snowballs.length - 3; e1++) {
			for (int e2 = e1 + 3; e2 < snowballs.length; e2++) {
				
				// 엘자가 만든 눈사람의 크기를 계산해 변수 snowmanElza에 할당
				int snowmanElza = snowballs[e1] + snowballs[e2];
				
				// 안나가 선택한 두 눈덩이를 나타낼 각 변수 초기화
				int a1 = e1 + 1;
				int a2 = e2 - 1;
				
				// while 반복문을 사용해 안나가 선택한 두 눈덩이를 순회
				while (a1 < a2) {
					
					// 안나가 만든 눈사람의 크기를 계산해 변수 snowmanAnna에 할당
					int snowmanAnna = snowballs[a1] + snowballs[a2];
					
					// abs() 메서드를 사용해 두 눈사람의 차이를 계산하고 변수 difference에 할당
					int difference = Math.abs(snowmanElza - snowmanAnna);
					
					// min() 메서드를 사용해 두 눈사람의 키 차이 중 최솟값을 갱신
					minDifference = Math.min(difference, minDifference);
					
					// 안나가 만든 눈사람이 더 큰 경우 눈덩이의 크기를 감소
					if (snowmanAnna > snowmanElza) {
						a2--;
						
					// 안나가 만든 눈사람이 더 작은 경우 눈덩이의 크기를 증가
					} else if (snowmanAnna < snowmanElza) {
						a1++;
					
					// 두 눈사람의 차이가 없는 경우 반복문 탈출
					} else {
						break outer;
					}
				}
			}
		}

		// valueOf() 및 write() 메서드를 사용해 두 눈사람의 키 차이 중 최솟값을 출력
		out.write(String.valueOf(minDifference));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}