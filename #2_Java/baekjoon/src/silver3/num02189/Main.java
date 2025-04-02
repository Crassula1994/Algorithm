package silver3.num02189;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 현재 사각형의 번호를 저장할 변수 squareNum 초기화
		int squareNum = 0;
		
		// while 반복문을 사용해 각 사각형을 순회
		outer: while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 사각형의 크기를 변수 size에 할당
			int size = Integer.parseInt(in.readLine());
			
			// 모든 사각형을 순회한 경우 반복문 탈출
			if (size == 0)
				break;
			
			// write() 메서드를 사용해 사각형의 번호를 출력
			out.write("Square " + ++squareNum + ": ");
			
			// 각 사각형의 행과 열, 대각선의 합을 저장할 각 배열 초기화
			int[] rowSum = new int[size];
			int[] colSum = new int[size];
			int[] diagSum = new int[2];
			
			// 사각형의 각 숫자가 중복되는지 확인할 Set 객체 numberChecker 초기화
			Set<Integer> numberChecker = new TreeSet<>();
			
			// for 반복문을 사용해 각 행을 순회
			for (int r = 0; r < size; r++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// for 반복문을 사용해 각 열을 순회
				for (int c = 0; c < size; c++) {
					
					// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
					int number = Integer.parseInt(st.nextToken());
					
					// 해당 행과 열의 합을 갱신
					rowSum[r] += number;
					colSum[c] += number;
					
					// 좌측 상단에서 우측 하단으로 이어지는 대각선인 경우 해당 합을 갱신
					if (r == c)
						diagSum[0] += number;
						
					// 우측 상단에서 좌측 하단으로 이어지는 대각선인 경우 해당 합을 갱신
					if (r == size - c - 1)
						diagSum[1] += number;
						
					// add() 메서드를 사용해 해당 숫자를 numberChecker에 추가
					numberChecker.add(number);
				}
			}
			
			// for 반복문을 사용해 각 행과 열을 순회
			for (int idx = 0; idx < size; idx++) {
				
				// 해당 행과 열의 합 중에서 기준 합과 일치하지 않는 것이 있는 경우
				if (rowSum[idx] != colSum[0] || colSum[idx] != colSum[0]) {
					
					// write() 메서드를 사용해 'Not a Magick Square' 출력 후 다음 사각형을 순회
					out.write("Not a Magick Square\n");
					continue outer;
				}
			}
			
			// 대각선 합 중에서 기준 합과 일치하지 않는 것이 있는 경우
			if (diagSum[0] != colSum[0] || diagSum[1] != colSum[0]) {
				
				// write() 메서드를 사용해 'Semi-Magick Square' 출력 후 다음 사각형을 순회
				out.write("Semi-Magick Square\n");
				continue;
			}
			
			// 각 숫자 중에서 중복되는 것이 있는 경우
			if (numberChecker.size() != size * size) {
				
				// write() 메서드를 사용해 'Weakly-Magick Square' 출력 후 다음 사각형을 순회
				out.write("Weakly-Magick Square\n");
				continue;
			}
			
			// iterator() 메서드를 사용해 각 숫자를 접근하기 위한 Iterator 객체를 변수 iterator에 할당
			Iterator<Integer> iterator = numberChecker.iterator();
			
			// next() 메서드를 사용해 첫 번째 숫자를 변수 prevNumber에 할당
			int prevNumber = iterator.next();
			
			// while 반복문을 사용해 각 숫자를 순회
			while (iterator.hasNext()) {
				
				// next() 메서드를 사용해 현재 숫자를 변수 curNumber에 할당
				int curNumber = iterator.next();
				
				// 연속된 숫자가 아닌 경우
				if (curNumber != prevNumber + 1) {
					
					// write() 메서드를 사용해 'Strongly-Magick Square' 출력 후 다음 사각형을 순회
					out.write("Strongly-Magick Square\n");
					continue outer;
				}
				
				// 이전의 숫자를 갱신
				prevNumber = curNumber;
			}
			
			// write() 메서드를 사용해 'Magically-Magick Square' 출력
			out.write("Magically-Magick Square\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}